import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class PokerGame extends JFrame {
	private JPanel panel01=new JPanel();
	private JButton button[]=new JButton[16];
	
	private int choosedColor=0;   //0方块  ，1梅花  ，2红桃  ，3黑桃
	private ImageIcon color[][]=new ImageIcon[4][13];
	private ImageIcon blueflip=new ImageIcon("image//blueflip.png");
	
	private int randValue[]=new int[16];   //8组随机点数 1 1 5 5 7 7 8 8 .......
	private boolean isSelected[]=new boolean[16]; //16个点数的状态，false没选，true 为选中
	private int pokerValue[]=new int[16];   //16张牌的点数
	
	private JPanel panel02=new JPanel();
	private JLabel label01=new JLabel();
	
	private MyListener my=new MyListener();
	private int faceUp[]=new int[2];  //记录已经翻转的两张牌的编号
	private boolean isStart =false,isFaceUp=true;  //是否开始游戏。是否翻转牌
	private boolean flag[]=new boolean[16];  //已成功翻转的牌记录true 
	private int click=0;  //点击的次数        
	
	private Timer timer;  //游戏计时
	private int seconds=67;   //67-66   65-60翻转所有牌    5s记忆  60-0游戏时间
	private Timer time01;  //翻牌定时器
	
	PokerGame(int choosedColor){
		this.choosedColor=choosedColor;
		
		for(int i=0;i<13;i++){
			color[0][i]=new ImageIcon("image//diamonds"+(i+1)+".png");
			color[1][i]=new ImageIcon("image//clubs"+(i+1)+".png");
			color[2][i]=new ImageIcon("image//hearts"+(i+1)+".png");
			color[3][i]=new ImageIcon("image//spades"+(i+1)+".png");
		}
		for(int i=0;i<16;i++){
			button[i]=new JButton();
			panel01.add(button[i]);
			button[i].setIcon(blueflip);
			//button[i].setIcon(color[choosedColor][7]);   //调试代码
			button[i].setBackground(Color.BLACK);
			
			isSelected[i]=false;
			
			flag[i]=false;
			button[i].addActionListener(my);
			
		}
		panel01.setLayout(new GridLayout(4, 4, 0, 0));
		this.setLayout(new BorderLayout());
		this.add(panel01,BorderLayout.NORTH);
		panel01.setOpaque(false);
		this.getContentPane().setBackground(Color.BLACK);
		
		for(int i=0;i<16;i=i+2){
			randValue[i]=(int)(Math.random()*13);   //0---12	
			randValue[i+1]=randValue[i];
			System.out.print(randValue[i]+"、"+randValue[i+1]+"、");		
		}
		System.out.println();
		for(int i=0;i<16;i++){
			ALL:
			do {
				int temp=(int)(Math.random()*16);  //随机选择1个点数
				if(!isSelected[temp]){  //false，此随机点数未选，可用，否则重新再选
					isSelected[temp]=true;
					pokerValue[i]=randValue[temp];
					break ALL;
					
				}
			} while (true);
		     System.out.print(pokerValue[i]+"、");
		}
		/*
		for(int i=0;i<16;i++){
			button[i].setIcon(color[choosedColor][pokerValue[i]]);
		}
		*/
		switch (choosedColor) {
		case 0:
			label01.setText("你选择的是方块！");
			break;
		case 1:
			label01.setText("你选择的是梅花！");
			break;
		case 2:
			label01.setText("你选择的是红桃！");
			break;
		case 3:
			label01.setText("你选择的是黑桃！");
			break;
		}
		label01.setFont(new Font("黑体",Font.PLAIN,30));
		label01.setForeground(Color.RED);
		panel02.add(label01);
		panel02.setOpaque(false);
		this.add(panel02,BorderLayout.SOUTH);
		
		faceUp[0]=-1;
		faceUp[1]=-1;  //等于负一没什么意义
		
		timer=new Timer(1000,new TimerListener());
		timer.start();
		time01=new Timer(700, new TimerListener01());    
		
		
	}
	public class MyListener implements ActionListener{   //事件监听器

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*for(int i=0;i<16;i++){
				if(e.getSource()==button[i]){
				button[i].setIcon(color[choosedColor][pokerValue[i]]);
				}
			}*/
			
			if(isStart && isFaceUp){  //游戏开始
				click++;   //123456
				for(int i=0;i<16;i++){
					if(e.getSource()==button[i]){  //翻开纸牌
						button[i].setIcon(color[choosedColor][pokerValue[i]]);
						faceUp[click%2]=i;
					}
				}
				if(click%2==0&&click>0){
					time01.start();
					isFaceUp=false;
				}
			}
		}
		
	}
	
	private class TimerListener implements ActionListener{  //整个游戏计时器

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//67-66   65-60翻转所有牌    5s记忆  60-0游戏时间
			seconds--;
			if(seconds>60&& seconds<=65){
				//显示所有牌的点数
				label01.setText("游戏即将开始"+(seconds-60));
				showAllPoker();  //显示所有牌的点数
			}else if(seconds<=60){
				label01.setText("游戏开始！计时："+seconds+"s");
				if(isStart==false){
					isStart=true;
					for(int i=0;i<16;i++){
						button[i].setIcon(blueflip);
					}
				}
			}
			if(seconds==0){
				timer.stop();
				label01.setText("时间到！游戏结束！");
				for(int i=0;i<16;i++){
					button[i].setEnabled(false);
				}
			}
		}
		
	}
	private class TimerListener01 implements ActionListener{  //点击翻牌后启动的定时器

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(click%2==0&&click>0){
				if(pokerValue[faceUp[0]]==pokerValue[faceUp[1]]){
					button[faceUp[0]].setEnabled(false);
					button[faceUp[1]].setEnabled(false);
					flag[faceUp[0]]=true;
					flag[faceUp[1]]=true;
				}
				else {
					button[faceUp[0]].setIcon(blueflip);
					button[faceUp[1]].setIcon(blueflip);
				}
				time01.stop();
				isFaceUp=true;
				checkFinish();
			}
		}
		
	}
	private void showAllPoker(){ //显示所有牌的点数
		for(int i=0;i<16;i++){
			button[i].setIcon(color[choosedColor][pokerValue[i]]);
		}
	}
	public void checkFinish() {
		int num=0;
		for(int i=0;i<16;i++){
			if(flag[i]==true){
				num++;
				
			}
		}System.out.println("..."+num+"...");
		if(num>=16){
			label01.setText("这么快就翻完了，香菇，蓝瘦！！！");
			timer.stop();
		}

	}

}
