import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit.BoldAction;


public class DuiDuiPeng extends JFrame {
	private JPanel panel01=new JPanel();
	private JButton btn_start=new JButton("开始游戏");
	private JLabel label01=new JLabel("   分数  ");
	private JTextField text_score=new JTextField(10);
	private JLabel label02=new JLabel("   时间");
	private JProgressBar progress=new JProgressBar();
	private JButton btn_exit=new JButton("退出");

	private JPanel panel02=new JPanel();
	private JButton button[][]=new JButton[8][8];
	private int animal[][]=new int [8][8]; //记录动物矩阵的状态
	private ImageIcon icon[]=new ImageIcon[]{
		new ImageIcon("image//cat.png"),	
		new ImageIcon("image//cattle.png"),
		new ImageIcon("image//chicken.png"),
		new ImageIcon("image//fox.png"),
		new ImageIcon("image//frog.png"),
		new ImageIcon("image//monkey.png"),
		new ImageIcon("image//panda.png")
	};//7种动物
	
	private MyListener my=new MyListener();
	
	private Timer timer;
	private int score=0;  //总分
	private int jindu=0;   //进度
	
	private int x1,y1;   //第一次点击的按钮坐标
	private int x2,y2;   //第二次点击的按钮坐标
	private final int EMPTY=-1;
	private boolean isDobleClicked=false;
	
	
    DuiDuiPeng() {
    	text_score.setText("0");         
    	text_score.setEditable(false);     //设置分数为不可点击
    	progress.setMinimum(0);            //进度条最小值为0
    	progress.setMaximum(100);          //进度条最大值为100
    	progress.setStringPainted(true);   //显示进度条

    	panel01.add(btn_start);
    	panel01.add(label01);
    	panel01.add(text_score);
    	panel01.add(label02);
    	panel01.add(progress);
    	panel01.add(btn_exit);
    	this.setLayout(new BorderLayout());
    	this.add(panel01,BorderLayout.NORTH);
    	
    	panel02.setLayout(new GridLayout(8, 8, 2, 2));
    	for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++){
    			int temp=(int)(Math.random()*7);  //随机整数值为0---6
    			button[i][j]=new JButton(icon[temp]);
    			if((i+j)%2==0){
    				button[i][j].setBackground(new Color(225,222,173));
    			}else{
    				button[i][j].setBackground(new Color(225,246,143));
    			}
    			animal[i][j]=temp;
    			panel02.add(button[i][j]);
    			button[i][j].setEnabled(false);
    			
    			button[i][j].addActionListener(my);
    		}
    	}
    	this.add(panel02,BorderLayout.CENTER);
		
    	this.getContentPane().setBackground(new Color(225,193,37));
    	panel01.setOpaque(false);
    	panel02.setOpaque(false);
    	btn_start.addActionListener(my);
    	btn_exit.addActionListener(my);
    	
    	
    	timer =new Timer(1000,new TimerListener());
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuiDuiPeng g=new DuiDuiPeng();
		g.setTitle("对对碰游戏");
		g.setSize(700, 500);
		g.setVisible(true);
		g.setResizable(false);//窗口不可设置大小
		//g.setLocationRelativeTo(null);//窗口显示屏幕中间	

	}
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btn_start){   //开始游戏
				btn_start.setEnabled(false);
				jindu=0;
				progress.setValue(jindu);
				score=0;
				text_score.setText(""+score);
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						button[i][j].setEnabled(true);
					}
				}
				timer.start();
				do{
					initAllAnimals();
				}while(searchAinamls(1));
			}
			if(e.getSource()==btn_exit){
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						button[i][j].setEnabled(false);
					}
				}
				dispose();
			}
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(e.getSource()==button[i][j]){
						//System.out.println((i+1)+"行"+(j+1)+"列");
						//交换图形
						//.....
						swapAnimal(i, j);
					}
				}
			}
		}
		
	}
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jindu++;
			progress.setValue(jindu);
			if(jindu==100){
				timer.stop();
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						button[i][j].setEnabled(false);
						
					}
					btn_start.setEnabled(true);
						
				}
			}
			
		}
		
	}
	
	private void initAllAnimals(){  //初始化动物的矩阵
	     for(int i=0;i<8;i++){
	    	 for(int j=0;j<8;j++){
	    		 int temp=(int)(Math.random()*7);   //0--7
	    		 button[i][j].setIcon(icon[temp]);
	    		 animal[i][j]=temp;
	    	 }
	     }
	}
	
	public boolean isThreeLinked(int x,int y){    //查询是否有三个或以上的相同图形连接
		int temp;
		//判断水平方向上是否有三个或以上的相同图形连接
		int linked=1;   //相同的个数
		if(x+1<8){
			temp=x+1;
			while (temp<8 && animal[y][x]==animal[y][temp]) {
				linked++;
				temp++;
			}
		}
		if(x-1>=0){
			temp=x-1;
			while (temp>=0 && animal[y][x]==animal[y][temp]) {
				linked++;
				temp--;
			}
		}
		if(linked>=3){
			return true;
		}
		//判断垂直方向上是否有三个或以上的相同图形连接
		linked=1;
		if(y+1<8){
			temp=y+1;
			while (temp<8 && animal[y][x]==animal[temp][x]) {
				linked++;
				temp++;				
			}
		}
		if(y-1>=0){
			temp=y-1;
			while (temp>=0 && animal[y][x]==animal[temp][x]) {
				linked++;
				temp--;
			}
		}
		if(linked>=3){
			return true;
		}
		return false;
	}
	
	public void removeThreeLinked(int x,int y){   //消除三个或三个以上相同连接图形，EMPTY
		if(animal[y][x]==EMPTY){
			return;
		}
		int num=0;  //
		int temp=0;
		int linked=1;
		if(x+1<8){
			temp=x+1;
			while (temp<8 && animal[y][x]==animal[y][temp]) {
				linked++;
				temp++;
			}
		}
		if(x-1>=0){
			temp=x-1;
			while (temp>=0 && animal[y][x]==animal[y][temp]) {
				linked++;
				temp--;
			}
		}
		//消除水平方向三个或三个以上相同连接图形，设为EMPTY
		if(linked>=3){
			num=num+linked;
			temp=x+1;
			while (temp<8 && animal[y][x]==animal[y][temp]) {
				animal[y][temp]=EMPTY;
				temp++;
			}
			temp=x-1;
			while (temp>=0 && animal[y][x]==animal[y][temp]) {
				animal[y][temp]=EMPTY;
				temp--;
			}
			animal[y][x]=EMPTY;
		}
		
		temp=0;
		linked=1;
		if(y+1<8){
			temp=y+1;
			while (temp<8 && animal[y][x]==animal[temp][x]) {
				linked++;
				temp++;
			}
		}
		if(y-1>=0){
			temp=y-1;
			while (temp>=0 && animal[y][x]==animal[temp][x]) {
				linked++;
				temp--;
			}
		}
		//消除垂直方向三个或三个以上相同连接图形，设为EMPTY
		if(linked>=3){
			num=num+linked;
			temp=y+1;
			while (temp<8 && animal[y][x]==animal[temp][x]) {
				animal[temp][x]=EMPTY;
				temp++;
			}
			temp=y-1;
			while (temp>=0 && animal[y][x]==animal[temp][x]) {
				animal[temp][x]=EMPTY;
				temp--;
			}
			animal[y][x]=EMPTY;
		}
		
		score=score+num*10;
		text_score.setText(""+score);
	}
	
	public boolean searchAinamls(int flag){  //1为查询连接，2为消除连接
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(flag==1){   //查询连接
					if(isThreeLinked(x, y)){
						return true;
					}
				}
				if(flag==2){   //消除连接
					removeThreeLinked(x, y);
				}
			}
		}
		return false;
	}
	public void downAnimal(){  //动物往下移
		int temp;
		for(int y=7;y>=0;y--){
			for(int x=0;x<8;x++){
				THIS:
				if(animal[y][x]==EMPTY){  //找到一个为空
					for(int k=y-1;k>=0;k--){
						if(animal[k][x]!=EMPTY){//找到上面最近的非空
							temp=animal[k][x];
							animal[k][x]=animal[y][x];
							animal[y][x]=temp;
							break THIS;
						}
					}
				}
			}
		}
		
	}
	public void updateAnimal(){ //为空的重新生成随机动物图形
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(animal[y][x]==EMPTY){
					animal[y][x]=(int)(Math.random()*7);   //生成一个随机数
				}
			}
		}
		
	}
	
	public void showAllAnimals(){  //重新显示所有动物图形
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				button[y][x].setIcon(icon[animal[y][x]]); 
			}
		}
		
	}
	public void swapAnimal(int y,int x){  //y为行 ，x为列
		if((y>=0 && y<8) && (x>=0 && x<8)){
			if(!isDobleClicked){  //第一次点击
				x1=x;
				y1=y;
				isDobleClicked=true;
				System.out.println("第一次点击的坐标:"+(y1+1)+"行"+(x1+1)+"列");
			}else{  //第二次点击
				x2=x;
				y2=y;
				isDobleClicked=false;
				System.out.println("第二次点击的坐标:"+(y2+1)+"行"+(x2+1)+"列");
			
				//交换图形  ，判断三个或以上.....
				if(((x1==x2)&&Math.abs(y1-y2)==1)
						|| ((y1==y2)&&Math.abs(x1-x2)==1)  ){  //是否相邻
					int temp;
					temp=animal[y2][x2];  //交换
					animal[y2][x2]=animal[y1][x1];
					animal[y1][x1]=temp;
					
					if(isThreeLinked(x1, y1)|| isThreeLinked(x2, y2)){  //有三个或以上的连接
						if(isThreeLinked(x1, y1)){
							removeThreeLinked(x1, y1);
						}
						if(isThreeLinked(x2, y2)){
							removeThreeLinked(x2, y2);
						}
						downAnimal();   //动物往下移动
						updateAnimal();  //空的位置随机生成新的动物
						showAllAnimals();  //重新显示所以动物
						while (searchAinamls(1)) {    //查询有三个连接
							searchAinamls(2);   //消除连接
							downAnimal();   //动物往下移动
							updateAnimal();  //空的位置随机生成新的动物
							showAllAnimals();  //重新显示所以动物
						}
						
						
					}else{   //没有三个或以上   交换回来
						temp=animal[y2][x2];
						animal[y2][x2]=animal[y1][x1];
						animal[y1][x1]=temp;
						 
					}
				}
			}
		}
	}
	
	
}
