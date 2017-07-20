
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
	 private JLabel label01=new JLabel("Ŀǰ����:0/"+level*level+"��    ");
	 private JLabel label02=new JLabel("���߲���:"+0);
	 
	 private JPanel panel02=new JPanel();
	 private JButton btn[][]=new JButton[level][level];  //n*n 
	 private ImageIcon icon_state[]=new ImageIcon[2];  //���𡢵�����ͼƬ
	 
	 private JMenu jm01=new JMenu("��Ϸ");
	 private JMenuItem item01=new JMenuItem("���¿�ʼ");
	 private JMenuItem item02=new JMenuItem("�˳���Ϸ");
	 
	 private JMenu jm02 =new JMenu("����");
	 private JMenu item03 =new JMenu("ѡ�񼶱�");
	 private String str_level[]=new String[]{"����","6*6","7*7","8*8"};
	 private ButtonGroup group=new ButtonGroup();
	 private JRadioButtonMenuItem radio_level[]=new JRadioButtonMenuItem[str_level.length];
	 
	 private JMenu jm03 =new JMenu("����");
	 private JMenuItem item04=new JMenuItem("��Ϸ����");
	 private JMenuItem item05=new JMenuItem("����");
	 
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
	 
	 private int click=0; //�Ѿ��������
	 private int num=0;  //�Ѿ������Ƶ�����
	 private boolean light[][]=new boolean[level][level];  //ÿյ�Ƶ�״̬��false��true��
	 
	 
	 LightGame(){
		 initComponent();   //��ʼ�����
		 setMyMenu();//���ò˵�
		 
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightGame g=new LightGame();
		g.setTitle("�����Ϸ�����԰����еƵ���");
		g.setSize(80*level, 80*level);
		g.setVisible(true);
		g.setResizable(false);//���ڲ������ô�С
		//g.setLocationRelativeTo(null);//������ʾ��Ļ�м�	
	}
	public void initComponent(){  //��ʼ�����
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
		
		icon_state[0]=new ImageIcon("image//light_off.png");  //����ͼƬ
		icon_state[1]=new ImageIcon("image//light_on.png");  //����ͼƬ
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
	
	public void setMyMenu(){   //���ò˵�
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
			//����¼��������
			for(int i=0;i<level;i++){
				for(int j=0;j<level;j++ ){
					if(e.getSource()==btn[i][j]){
						click++;
						label02.setText("���߲���:"+click);
						//�ı�����״̬
						if(light[i][j]==false){  //ԭ����ĵ��� 
							btn[i][j].setIcon(icon_state[1]);
							light[i][j]=true;
						}else{    //ԭ������Ϩ��
							btn[i][j].setIcon(icon_state[0]);
							light[i][j]=false;
						}
						//�ı������ϱߵƵ�״̬
						if(i>0){
							if(light[i-1][j]==false){   //ԭ����ĵ���
								btn[i-1][j].setIcon(icon_state[1]);
								light[i-1][j]=true;
							}else {  //ԭ��������Ϩ��
								btn[i-1][j].setIcon(icon_state[0]);
								light[i-1][j]=false;
							}
						}
						
						if(i<level-1){   //�ı������±ߵ�״̬
							if(light[i+1][j]==false){  //ԭ����ĵ���
								btn[i+1][j].setIcon(icon_state[1]);
								light[i+1][j]=true;
							}else {  //ԭ��������Ϩ��
								btn[i+1][j].setIcon(icon_state[0]);
								light[i+1][j]=false;
							}
						}						
						if(j>0){  //�ı�������ߵ�״̬
							if(light[i][j-1]==false){   //ԭ����ĵ���
								btn[i][j-1].setIcon(icon_state[1]);
								light[i][j-1]=true;
							}else {  //ԭ��������Ϩ��
								btn[i][j-1].setIcon(icon_state[0]);
								light[i][j-1]=false;
							}
						}
						if(j<level-1){  //�ı������ұߵ�״̬
							if(light[i][j+1]==false){   //ԭ����ĵ���
								btn[i][j+1].setIcon(icon_state[1]);
								light[i][j+1]=true;
							}else {  //ԭ��������Ϩ��
								btn[i][j+1].setIcon(icon_state[0]);
								light[i][j+1]=false;
							}
						}
					}	
					checkFinish();				
				}
			}
			if(e.getSource()==item01){   //���¿�ʼ
				initGame();
			}
			if(e.getSource()==item02){    //�˳���Ϸ
				dispose();
			}
			if(e.getSource()==radio_level[0]){   //����
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
			if(e.getSource()==item04){   //��Ϸ����
				JOptionPane.showMessageDialog(getContentPane(), "������ص�ĳһյ�ƣ���Ӱ��õƼ��������ҵ�\n�����������","��Ϸ����",JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource()==item05){   //����
				JOptionPane.showMessageDialog(getContentPane(), "�������ʣ����ѯhttp��//www.baidu.com\nлл����","����",JOptionPane.QUESTION_MESSAGE);
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
		label01.setText("Ŀǰ����:"+num+"/"+level*level+"��    ");
		progress.setValue(num*100/level/level);
		if(num>=level*level){
			label01.setText("�ɹ�����Ϸ������");
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
		label01.setText("Ŀǰ����:"+num+"/"+level*level+"��    ");
		progress.setValue(num*100/level/level);
		label02.setText("���߲���:"+click);
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
		label01.setText("Ŀǰ����:"+num+"/"+level*level+"��    ");
		progress.setValue(num*100/level/level);
		label02.setText("���߲���:"+click);
	}
	
	public void setLavel(int i){
		level=i;
		Point p=this.getLocation();
		dispose();
		LightGame g=new LightGame();
		g.setTitle("�����Ϸ�����԰����еƵ���");
		g.setSize(80*level, 80*level);
		g.setVisible(true);
		g.setResizable(false);
		g.setLocation(p);
	}

}
