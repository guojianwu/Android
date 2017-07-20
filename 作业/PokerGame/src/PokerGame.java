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
	
	private int choosedColor=0;   //0����  ��1÷��  ��2����  ��3����
	private ImageIcon color[][]=new ImageIcon[4][13];
	private ImageIcon blueflip=new ImageIcon("image//blueflip.png");
	
	private int randValue[]=new int[16];   //8��������� 1 1 5 5 7 7 8 8 .......
	private boolean isSelected[]=new boolean[16]; //16��������״̬��falseûѡ��true Ϊѡ��
	private int pokerValue[]=new int[16];   //16���Ƶĵ���
	
	private JPanel panel02=new JPanel();
	private JLabel label01=new JLabel();
	
	private MyListener my=new MyListener();
	private int faceUp[]=new int[2];  //��¼�Ѿ���ת�������Ƶı��
	private boolean isStart =false,isFaceUp=true;  //�Ƿ�ʼ��Ϸ���Ƿ�ת��
	private boolean flag[]=new boolean[16];  //�ѳɹ���ת���Ƽ�¼true 
	private int click=0;  //����Ĵ���        
	
	private Timer timer;  //��Ϸ��ʱ
	private int seconds=67;   //67-66   65-60��ת������    5s����  60-0��Ϸʱ��
	private Timer time01;  //���ƶ�ʱ��
	
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
			//button[i].setIcon(color[choosedColor][7]);   //���Դ���
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
			System.out.print(randValue[i]+"��"+randValue[i+1]+"��");		
		}
		System.out.println();
		for(int i=0;i<16;i++){
			ALL:
			do {
				int temp=(int)(Math.random()*16);  //���ѡ��1������
				if(!isSelected[temp]){  //false�����������δѡ�����ã�����������ѡ
					isSelected[temp]=true;
					pokerValue[i]=randValue[temp];
					break ALL;
					
				}
			} while (true);
		     System.out.print(pokerValue[i]+"��");
		}
		/*
		for(int i=0;i<16;i++){
			button[i].setIcon(color[choosedColor][pokerValue[i]]);
		}
		*/
		switch (choosedColor) {
		case 0:
			label01.setText("��ѡ����Ƿ��飡");
			break;
		case 1:
			label01.setText("��ѡ�����÷����");
			break;
		case 2:
			label01.setText("��ѡ����Ǻ��ң�");
			break;
		case 3:
			label01.setText("��ѡ����Ǻ��ң�");
			break;
		}
		label01.setFont(new Font("����",Font.PLAIN,30));
		label01.setForeground(Color.RED);
		panel02.add(label01);
		panel02.setOpaque(false);
		this.add(panel02,BorderLayout.SOUTH);
		
		faceUp[0]=-1;
		faceUp[1]=-1;  //���ڸ�һûʲô����
		
		timer=new Timer(1000,new TimerListener());
		timer.start();
		time01=new Timer(700, new TimerListener01());    
		
		
	}
	public class MyListener implements ActionListener{   //�¼�������

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*for(int i=0;i<16;i++){
				if(e.getSource()==button[i]){
				button[i].setIcon(color[choosedColor][pokerValue[i]]);
				}
			}*/
			
			if(isStart && isFaceUp){  //��Ϸ��ʼ
				click++;   //123456
				for(int i=0;i<16;i++){
					if(e.getSource()==button[i]){  //����ֽ��
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
	
	private class TimerListener implements ActionListener{  //������Ϸ��ʱ��

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//67-66   65-60��ת������    5s����  60-0��Ϸʱ��
			seconds--;
			if(seconds>60&& seconds<=65){
				//��ʾ�����Ƶĵ���
				label01.setText("��Ϸ������ʼ"+(seconds-60));
				showAllPoker();  //��ʾ�����Ƶĵ���
			}else if(seconds<=60){
				label01.setText("��Ϸ��ʼ����ʱ��"+seconds+"s");
				if(isStart==false){
					isStart=true;
					for(int i=0;i<16;i++){
						button[i].setIcon(blueflip);
					}
				}
			}
			if(seconds==0){
				timer.stop();
				label01.setText("ʱ�䵽����Ϸ������");
				for(int i=0;i<16;i++){
					button[i].setEnabled(false);
				}
			}
		}
		
	}
	private class TimerListener01 implements ActionListener{  //������ƺ������Ķ�ʱ��

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
	private void showAllPoker(){ //��ʾ�����Ƶĵ���
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
			label01.setText("��ô��ͷ����ˣ��㹽�����ݣ�����");
			timer.stop();
		}

	}

}
