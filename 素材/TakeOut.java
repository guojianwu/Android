import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TakeOut extends JFrame {
	//�����Ա����
     private JPanel panel01 =new JPanel();
     private JLabel label01=new JLabel("��ӭ�����żұ�����ϵͳ");
     
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
     
     
     //��Ա����
      TakeOut() {     //���캯������ʼ������
    	  label01.setFont(new Font("����",Font.PLAIN,30));
    	  label01.setForeground(Color.BLUE);
    	  panel01.add(label01);
    	  panel01.setOpaque(false);  //����͸��
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
    	  
    	  for(int i=0;i<9;i++){
    		  amount[i]=new JButton("1��");
    		  food[i]=new JLabel(new ImageIcon("image//food"+(i+1)+".jpg"));
    		  check[i].setOpaque(false);//����͸��
    		  panel02.add(check[i]);
    		  panel02.add(amount[i]);
    		  panel02.add(food[i]);
    		  num[i]=1;
    	  }
    	  panel02.setOpaque(false);//����͸��
    	  this.add(panel02,BorderLayout.CENTER);
    	  
    	  list.setText("״̬:δѡ��");
    	  list.setBackground(Color.PINK);
    	  panel02.add(list);
    	  
    	
    	  panel03.add(bnt_ok);
    	  panel03.add(bnt_cancel);
    	  panel03.add(label02);
    	  panel03.add(text01);
    	  panel03.setOpaque(false);
    	  this.add(panel03,BorderLayout.SOUTH);
    	  
    	  
    	  
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

}
