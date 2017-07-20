import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class TakeOut extends JFrame {
	//�����Ա����
     private JPanel panel01 =new JPanel();
     private JLabel label01=new JLabel("��ӭ�����żұ�����ϵͳ!");
     private JLabel label03=new JLabel("       ��50Ԫ�����ͷ�,��100Ԫ��10Ԫ!");
     
     private JPanel panel02=new JPanel();
     private JCheckBox check[]=new JCheckBox[9];  //����
     private JButton amount[]=new JButton[9];  //��ť
     private JLabel food[]=new JLabel[9];  //ͼƬ
     private int num[]=new int[9];   //�������� 
        
     
     private JTextArea list=new JTextArea(10,10);     
     private String str="";
     
     private JPanel panel03=new JPanel();
     private JButton bnt_ok=new JButton("����");
     private JButton bnt_cancel=new JButton("���");
     private JLabel label02=new JLabel("�ܼ�:");
     private JTextField text01=new JTextField(10);
     private double a[]=new double[9];//ʳ��ĵ���
     private double total=0;  //�ܼ�
     private JTextArea text02=new JTextArea(1,15);
     
     private final int FEE=5;
     
     private Color color[]=new Color[]{
    		Color.black,Color.red,Color.blue,Color.LIGHT_GRAY,
    		Color.yellow,Color.magenta    		
     };
     
     private Timer timer;
     private int colorIndex=0;
     
     
     //��Ա����
      TakeOut() {     //���캯������ʼ������
    	  label01.setFont(new Font("����",Font.PLAIN,30));
    	  label01.setForeground(Color.BLUE);
    	  //panel01.add(label01);
    	  label01.setFont(new Font("����",Font.PLAIN,20));
    	  label03.setForeground(Color.RED);
    	  //panel01.add(label03);
    	  panel01.setOpaque(false);  //����͸��
    	  Box box=Box.createVerticalBox();
    	  box.add(label01);
    	  box.add(label03);
    	  panel01.add(box);
    	  
    	  this.setLayout(new BorderLayout());
    	  this.add(panel01,BorderLayout.NORTH);
    	  this.getContentPane().setBackground(Color.PINK);  //������ɫ
    	  
    	  check[0]=new JCheckBox("  ѩ��   5.0Ԫ",false);
    	  check[1]=new JCheckBox("  ����   8.0Ԫ",false);
    	  check[2]=new JCheckBox("���׻�  8.0Ԫ",false);
    	  check[3]=new JCheckBox("  �ȹ�11.0Ԫ",false);
    	  check[4]=new JCheckBox("������12.0Ԫ",false);
    	  check[5]=new JCheckBox("���ް�15.0Ԫ",false);
    	  check[6]=new JCheckBox("  ���� 6.0Ԫ",false);
    	  check[7]=new JCheckBox("  ��֭    7.0Ԫ",false);
    	  check[8]=new JCheckBox("  ơ��    6.0Ԫ",false);
    	  
    	  MyListener myListener=new MyListener();
    	  
    	  for(int i=0;i<9;i++){
    		  amount[i]=new JButton("1��");
    		  food[i]=new JLabel(new ImageIcon("image//food"+(i+1)+".jpg"));
    		  check[i].setOpaque(false);//����͸��
    		  panel02.add(check[i]);
    		  panel02.add(amount[i]);
    		  panel02.add(food[i]);
    		  num[i]=1;
    		  
    		  amount[i].addActionListener(myListener);//����������
    		  
    		  
    	  }
    	  panel02.setOpaque(false);//����͸��
    	  this.add(panel02,BorderLayout.CENTER);
    	  
    	  list.setText("״̬:δѡ��");
    	  list.setBackground(Color.PINK);
    	  list.setEditable(false);
    	  panel02.add(list);
    	  
    	
    	  panel03.add(bnt_ok);
    	  panel03.add(bnt_cancel);
    	  panel03.add(label02);
    	  panel03.add(text01);
    	  panel03.add(text02);
    	  text02.setEditable(false);
    	  text02.setOpaque(false);
    	  text02.setBackground(Color.PINK);
    	  text01.setEditable(false);
    	  panel03.setOpaque(false);
    	  this.add(panel03,BorderLayout.SOUTH);
    	  
    	  a[0]=5.0;
    	  a[1]=8.0;
    	  a[2]=8.0;    	  
    	  a[3]=11.0;
    	  a[4]=12.0;
    	  a[5]=15.0;
    	  a[6]=6.0;
    	  a[7]=7.0;
    	  a[8]=6.0;
    	  
    	  bnt_ok.addActionListener(myListener);  //���������
    	  bnt_cancel.addActionListener(myListener);//��ռ�����
    	  
    	  
    	  timer=new Timer(1000,new timerListener());
    	  timer.start();
    	  
   
    	  
    	  
	}
     
     

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TakeOut t=new TakeOut();
		t.setTitle("����ϵͳ");
		t.setSize(720, 550);
		t.setVisible(true);

	}
	
	
	
	
	
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//����¼��������
			for(int i=0;i<9;i++){
				if(e.getSource()==amount[i]){
					if(num[i]<9)
						num[i]++;
					else
						num[i]=1;
					amount[i].setText(num[i]+"��");
				}
			}
			if(e.getSource()==bnt_ok){ //��������¼�
				total=0;
				str="";
				for(int i=0;i<9;i++){
					if(check[i].isSelected()==true){
						total=total+a[i]*num[i];
						str=str+check[i].getText()+"    "+amount[i].getText()+"\n";
						
					}				
				}
				
				if(total<50 && total>0){					
					total=total+FEE;													
					text02.setText("����"+(50-total)+"�������ͷ�,����"+(100-total)+"����100��10");
				    str=str+"���ͷ�  5Ԫ";
				    list.setText("״̬:��ѡ�� �� \n"+ str+"\n");
				
				}else if(total<100){									
					text02.setText("����"+(100-total)+"����100��10");	
					list.setText("״̬:��ѡ�� �� \n"+ str+"\n");
				}
				else{									
					text02.setText("�����ͷ�,��100��10,�Ѳ���"+total+"-10");
				    total=total-10;		
				    list.setText("״̬:��ѡ�� �� \n"+ str+"\n");
				}
			}
			if(total==0){
				list.setText("״̬:δѡ��!");
			}
			text01.setText(""+total);
			//list.setText("״̬:��ѡ�� �� \n"+ str+"\n");
			if(e.getSource()==bnt_cancel){//��ռ����¼�
				for(int i=0;i<9;i++){
					check[i].setSelected(false);
					amount[i].setText("1��");
					num[i]=1;
				}
				total=0;
				str="";
				text01.setText(""+total);
				list.setText("״̬:δѡ�ͣ�");
			}
			
		}
		
	}
	
	class timerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			colorIndex++;  //12%7=5
			label01.setForeground(color[colorIndex%color.length]);
			
			String tem=label01.getText();
			label01.setText(tem.substring(1,tem.length())+tem.substring(0,1));
			
			
		}
		
	}

}
