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
	private JButton btn_start=new JButton("��ʼ��Ϸ");
	private JLabel label01=new JLabel("   ����  ");
	private JTextField text_score=new JTextField(10);
	private JLabel label02=new JLabel("   ʱ��");
	private JProgressBar progress=new JProgressBar();
	private JButton btn_exit=new JButton("�˳�");

	private JPanel panel02=new JPanel();
	private JButton button[][]=new JButton[8][8];
	private int animal[][]=new int [8][8]; //��¼��������״̬
	private ImageIcon icon[]=new ImageIcon[]{
		new ImageIcon("image//cat.png"),	
		new ImageIcon("image//cattle.png"),
		new ImageIcon("image//chicken.png"),
		new ImageIcon("image//fox.png"),
		new ImageIcon("image//frog.png"),
		new ImageIcon("image//monkey.png"),
		new ImageIcon("image//panda.png")
	};//7�ֶ���
	
	private MyListener my=new MyListener();
	
	private Timer timer;
	private int score=0;  //�ܷ�
	private int jindu=0;   //����
	
	private int x1,y1;   //��һ�ε���İ�ť����
	private int x2,y2;   //�ڶ��ε���İ�ť����
	private final int EMPTY=-1;
	private boolean isDobleClicked=false;
	
	
    DuiDuiPeng() {
    	text_score.setText("0");         
    	text_score.setEditable(false);     //���÷���Ϊ���ɵ��
    	progress.setMinimum(0);            //��������СֵΪ0
    	progress.setMaximum(100);          //���������ֵΪ100
    	progress.setStringPainted(true);   //��ʾ������

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
    			int temp=(int)(Math.random()*7);  //�������ֵΪ0---6
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
		g.setTitle("�Զ�����Ϸ");
		g.setSize(700, 500);
		g.setVisible(true);
		g.setResizable(false);//���ڲ������ô�С
		//g.setLocationRelativeTo(null);//������ʾ��Ļ�м�	

	}
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btn_start){   //��ʼ��Ϸ
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
						//System.out.println((i+1)+"��"+(j+1)+"��");
						//����ͼ��
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
	
	private void initAllAnimals(){  //��ʼ������ľ���
	     for(int i=0;i<8;i++){
	    	 for(int j=0;j<8;j++){
	    		 int temp=(int)(Math.random()*7);   //0--7
	    		 button[i][j].setIcon(icon[temp]);
	    		 animal[i][j]=temp;
	    	 }
	     }
	}
	
	public boolean isThreeLinked(int x,int y){    //��ѯ�Ƿ������������ϵ���ͬͼ������
		int temp;
		//�ж�ˮƽ�������Ƿ������������ϵ���ͬͼ������
		int linked=1;   //��ͬ�ĸ���
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
		//�жϴ�ֱ�������Ƿ������������ϵ���ͬͼ������
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
	
	public void removeThreeLinked(int x,int y){   //��������������������ͬ����ͼ�Σ�EMPTY
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
		//����ˮƽ��������������������ͬ����ͼ�Σ���ΪEMPTY
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
		//������ֱ��������������������ͬ����ͼ�Σ���ΪEMPTY
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
	
	public boolean searchAinamls(int flag){  //1Ϊ��ѯ���ӣ�2Ϊ��������
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(flag==1){   //��ѯ����
					if(isThreeLinked(x, y)){
						return true;
					}
				}
				if(flag==2){   //��������
					removeThreeLinked(x, y);
				}
			}
		}
		return false;
	}
	public void downAnimal(){  //����������
		int temp;
		for(int y=7;y>=0;y--){
			for(int x=0;x<8;x++){
				THIS:
				if(animal[y][x]==EMPTY){  //�ҵ�һ��Ϊ��
					for(int k=y-1;k>=0;k--){
						if(animal[k][x]!=EMPTY){//�ҵ���������ķǿ�
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
	public void updateAnimal(){ //Ϊ�յ����������������ͼ��
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(animal[y][x]==EMPTY){
					animal[y][x]=(int)(Math.random()*7);   //����һ�������
				}
			}
		}
		
	}
	
	public void showAllAnimals(){  //������ʾ���ж���ͼ��
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				button[y][x].setIcon(icon[animal[y][x]]); 
			}
		}
		
	}
	public void swapAnimal(int y,int x){  //yΪ�� ��xΪ��
		if((y>=0 && y<8) && (x>=0 && x<8)){
			if(!isDobleClicked){  //��һ�ε��
				x1=x;
				y1=y;
				isDobleClicked=true;
				System.out.println("��һ�ε��������:"+(y1+1)+"��"+(x1+1)+"��");
			}else{  //�ڶ��ε��
				x2=x;
				y2=y;
				isDobleClicked=false;
				System.out.println("�ڶ��ε��������:"+(y2+1)+"��"+(x2+1)+"��");
			
				//����ͼ��  ���ж�����������.....
				if(((x1==x2)&&Math.abs(y1-y2)==1)
						|| ((y1==y2)&&Math.abs(x1-x2)==1)  ){  //�Ƿ�����
					int temp;
					temp=animal[y2][x2];  //����
					animal[y2][x2]=animal[y1][x1];
					animal[y1][x1]=temp;
					
					if(isThreeLinked(x1, y1)|| isThreeLinked(x2, y2)){  //�����������ϵ�����
						if(isThreeLinked(x1, y1)){
							removeThreeLinked(x1, y1);
						}
						if(isThreeLinked(x2, y2)){
							removeThreeLinked(x2, y2);
						}
						downAnimal();   //���������ƶ�
						updateAnimal();  //�յ�λ����������µĶ���
						showAllAnimals();  //������ʾ���Զ���
						while (searchAinamls(1)) {    //��ѯ����������
							searchAinamls(2);   //��������
							downAnimal();   //���������ƶ�
							updateAnimal();  //�յ�λ����������µĶ���
							showAllAnimals();  //������ʾ���Զ���
						}
						
						
					}else{   //û������������   ��������
						temp=animal[y2][x2];
						animal[y2][x2]=animal[y1][x1];
						animal[y1][x1]=temp;
						 
					}
				}
			}
		}
	}
	
	
}
