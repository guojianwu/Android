
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;




public class LightGame extends JFrame {
	 private static int level=6;
	 private JProgressBar progress=new JProgressBar();
	 private JPanel panel01=new JPanel();
	 private JLabel label01=new JLabel("目前进度:0/"+level*level+"。    ");
	 private JLabel label02=new JLabel("已走步数:"+0);
	 
	 private JPanel panel02=new JPanel();
	 private JButton btn[][]=new JButton[level][level];  //n*n 
	 private ImageIcon icon_state[]=new ImageIcon[2];  //灯灭、灯亮的图片
	 
	 private JMenu jm01=new JMenu("游戏");
	 private JMenuItem item01=new JMenuItem("重新开始");
	 private JMenuItem item02=new JMenuItem("退出游戏");
	 
	 private JMenu jm02 =new JMenu("设置");
	 private JMenu item03 =new JMenu("选择级别");
	 private String str_level[]=new String[]{"入门","6*6","7*7","8*8"};
	 private ButtonGroup group=new ButtonGroup();
	 private JRadioButtonMenuItem radio_level[]=new JRadioButtonMenuItem[str_level.length];
	 
	 private JMenu jm03 =new JMenu("帮助");
	 private JMenuItem item04=new JMenuItem("游戏规则");
	 private JMenuItem item05=new JMenuItem("关于");
	 
	 private JMenuBar mb=new JMenuBar();
	 
	 private ImageIcon icon_menu[]=new ImageIcon[]{
			 new ImageIcon("image//icon008.png"),
			 new ImageIcon("image//icon007.png"),
			 new ImageIcon("image//icon005.png"),
			 new ImageIcon("image//icon020.png"),
			 new ImageIcon("image//icon034.png"),
			 new ImageIcon("image//icon052.png")
	 };
	 
	 private MyListener my=new MyListener();
	 
	 private int click=0; //已经点击次数
	 private int num=0;  //已经点亮灯的数量
	 private boolean light[][]=new boolean[level][level];  //每盏灯的状态，false灭，true亮
	 
	 
	 LightGame(){
		 initComponent();   //初始化组件
		 setMyMenu();//设置菜单
		 
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightGame g=new LightGame();
		g.setTitle("点灯游戏。尝试把所有灯点亮");
		g.setSize(80*level, 80*level);
		g.setVisible(true);
		g.setResizable(false);//窗口不可设置大小
		//g.setLocationRelativeTo(null);//窗口显示屏幕中间	
	}
	public void initComponent(){  //初始化组件
		progress.setMinimum(0);
		progress.setMaximum(100);
		progress.setPreferredSize(new Dimension(800,30));
		progress.setStringPainted(true);
		this.setLayout(new BorderLayout());
		this.add(progress,BorderLayout.NORTH);
		//progress.setValue(50);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		label01.setForeground(Color.WHITE);
		label02.setForeground(Color.WHITE);
		panel01.add(label01);
		panel01.add(label02);
		panel01.setOpaque(false);
		this.add(panel01,BorderLayout.CENTER);
		
		icon_state[0]=new ImageIcon("image//light_off.png");  //灯灭图片
		icon_state[1]=new ImageIcon("image//light_on.png");  //灯亮图片
		for(int i=0;i<level;i++){
			for(int j=0;j<level;j++){
				btn[i][j]=new JButton(icon_state[0]);
			    btn[i][j].setBackground(Color.DARK_GRAY);
			    panel02.add(btn[i][j]);
			    btn[i][j].addActionListener(my);
			    
			    light[i][j]=false; 
			    
			    
		    }
		}
		panel02.setOpaque(false);
		panel02.setLayout(new GridLayout(level,level,0,0));
		this.add(panel02,BorderLayout.SOUTH);
     }
	
	public void setMyMenu(){   //设置菜单
		item01.setIcon(icon_menu[0]);
		item02.setIcon(icon_menu[1]);
		jm01.add(item01);
		jm01.add(item02);
		mb.add(jm01);
		
		for(int i=0;i<str_level.length;i++){
			radio_level[i]=new JRadioButtonMenuItem(str_level[i]);
			group.add(radio_level[i]);
			radio_level[i].setIcon(icon_menu[3]);
			item03.add(radio_level[i]);
			radio_level[i].addActionListener(my);
		}
		radio_level[0].setIcon(icon_menu[2]);
		jm02.add(item03);
		mb.add(jm02);
		
		item04.setIcon(icon_menu[4]);
		item05.setIcon(icon_menu[5]);
		jm03.add(item04);
		jm03.add(item05);
		mb.add(jm03);
		
		this.setJMenuBar(mb);
		
		item01.addActionListener(my);
		item02.addActionListener(my);
		item04.addActionListener(my);
		item05.addActionListener(my);
		
	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//添加事件处理代码
			for(int i=0;i<level;i++){
				for(int j=0;j<level;j++ ){
					if(e.getSource()==btn[i][j]){
						click++;
						label02.setText("已走步数:"+click);
						//改变点击的状态
						if(light[i][j]==false){  //原来灭的点亮 
							btn[i][j].setIcon(icon_state[1]);
							light[i][j]=true;
						}else{    //原来亮的熄灭
							btn[i][j].setIcon(icon_state[0]);
							light[i][j]=false;
						}
						//改变点击灯上边灯的状态
						if(i>0){
							if(light[i-1][j]==false){   //原来灭的点亮
								btn[i-1][j].setIcon(icon_state[1]);
								light[i-1][j]=true;
							}else {  //原来是亮，熄灭
								btn[i-1][j].setIcon(icon_state[0]);
								light[i-1][j]=false;
							}
						}
						
						if(i<level-1){   //改变点击灯下边的状态
							if(light[i+1][j]==false){  //原来灭的点亮
								btn[i+1][j].setIcon(icon_state[1]);
								light[i+1][j]=true;
							}else {  //原来是亮，熄灭
								btn[i+1][j].setIcon(icon_state[0]);
								light[i+1][j]=false;
							}
						}						
						if(j>0){  //改变点击灯左边的状态
							if(light[i][j-1]==false){   //原来灭的点亮
								btn[i][j-1].setIcon(icon_state[1]);
								light[i][j-1]=true;
							}else {  //原来是亮，熄灭
								btn[i][j-1].setIcon(icon_state[0]);
								light[i][j-1]=false;
							}
						}
						if(j<level-1){  //改变点击灯右边的状态
							if(light[i][j+1]==false){   //原来灭的点亮
								btn[i][j+1].setIcon(icon_state[1]);
								light[i][j+1]=true;
							}else {  //原来是亮，熄灭
								btn[i][j+1].setIcon(icon_state[0]);
								light[i][j+1]=false;
							}
						}
					}	
					checkFinish();				
				}
			}
			if(e.getSource()==item01){   //重新开始
				initGame();
			}
			if(e.getSource()==item02){    //退出游戏
				dispose();
			}
			if(e.getSource()==radio_level[0]){   //入门
				beginnerLevel();
				
			}
			if(e.getSource()==radio_level[1]){   //6*6
				setLavel(6);
			}
			if(e.getSource()==radio_level[2]){    //7*7
				setLavel(7);
			}
			if(e.getSource()==radio_level[3]){    //8*8
				setLavel(8);
			}
			if(e.getSource()==item04){   //游戏规则
				JOptionPane.showMessageDialog(getContentPane(), "点亮或关掉某一盏灯，会影响该灯及上下左右灯\n的亮灭情况！","游戏规则",JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource()==item05){   //关于
				JOptionPane.showMessageDialog(getContentPane(), "如有疑问，请查询http：//www.baidu.com\n谢谢合作","关于",JOptionPane.QUESTION_MESSAGE);
			}
		}		
	}
	
	public void checkFinish(){
		num=0;
		for(int i=0;i<level;i++){
			for(int j=0;j<level;j++){
				if(light[i][j]==true){
					num++;
				}
			}
		}
		label01.setText("目前进度:"+num+"/"+level*level+"。    ");
		progress.setValue(num*100/level/level);
		if(num>=level*level){
			label01.setText("成功！游戏结束！");
			label01.setText("");
			for(int i=0;i<level;i++){
				for(int j=0;j<level;j++){
					btn[i][j].setEnabled(false);					
				}				
			}
		}
	}
	
	public void initGame(){
		click=0;
		num=0;
		for(int i=0;i<level;i++){
			for(int j=0;j<level;j++){
				btn[i][j].setIcon(icon_state[0]);
				light[i][j]=false;
				btn[i][j].setEnabled(true);
			}
		}
		label01.setText("目前进度:"+num+"/"+level*level+"。    ");
		progress.setValue(num*100/level/level);
		label02.setText("已走步数:"+click);
	}
	
	public void beginnerLevel(){
		click=0;
		num=level*level-3;
		for(int i=0;i<level;i++){
			for(int j=0;j<level;j++){
				if(i==level-2 &&  j==0 ||i==level-1  &&j==0  ||i==level-1  &&j==1){
					btn[i][j].setIcon(icon_state[0]);
					light[i][j]=false;
				}else {
					btn[i][j].setIcon(icon_state[1]);
					light[i][j]=true;
				}
			}
		}
		label01.setText("目前进度:"+num+"/"+level*level+"。    ");
		progress.setValue(num*100/level/level);
		label02.setText("已走步数:"+click);
	}
	
	public void setLavel(int i){
		level=i;
		Point p=this.getLocation();
		dispose();
		LightGame g=new LightGame();
		g.setTitle("点灯游戏。尝试把所有灯点亮");
		g.setSize(80*level, 80*level);
		g.setVisible(true);
		g.setResizable(false);
		g.setLocation(p);
	}

}
