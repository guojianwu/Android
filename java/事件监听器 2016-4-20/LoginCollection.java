import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginCollection {
	JFrame f=new JFrame("��¼");
	JLabel l1=new JLabel("�ʺ�");
	JLabel l2=new JLabel("����");
	JButton b1 =new JButton("��¼");
    JButton b2 =new JButton("ע��");
    JTextField t1=new JTextField(20);
	JTextField t2=new JTextField(20);
	
	private String user,pass;  //�����û����ı�����������ʺź�����
	private Map<String,String>user_pass=new HashMap<String,String>();
    //����   ����user_pass���ʺţ����룩
	
    public void init()throws Exception{
    	JPanel p1 = new JPanel();
    	p1.add(l1);
    	p1.add(t1);
    	
    	f.add(p1 , BorderLayout.NORTH);
    	
    	JPanel p2 = new JPanel();
    	p2.add(l2);
    	p2.add(t2);
    	
    	f.add(p2 , BorderLayout.CENTER);
    	
    	JPanel p3 = new JPanel();
    	p3.add(b1);
    	p3.add(b2);
    	
    	f.add(p3 , BorderLayout.SOUTH);
    	f.setVisible(true);
		f.pack();
		
		b1.addActionListener(ls);
		b2.addActionListener(ls);

    }  
    
    ActionListener ls=new ActionListener() {
    	
    	
    	
		public void actionPerformed(ActionEvent e) {
			
			user = t1.getText().toString();
    	    pass = t2.getText().toString();
			
		    //���������¼��ť��ȡ���û�������ʺ����룬������������ʺ�����ȶ�
			//����ƥ��ģ��򵯳���¼�ɹ������򵯳�����
			if(e.getActionCommand().equals("��¼")){
				for(String str:user_pass.keySet()){
					if(str.equals(user) && user_pass.get(str).equals(pass)){
						//��ʾ�Ի���
						JOptionPane.showMessageDialog(null,"��ϲ��������ȷ","��¼�ɹ�",JOptionPane.INFORMATION_MESSAGE);
						
						return;  //��������
						
					}
				}
				JOptionPane.showMessageDialog(null,"�������벻��ȷ","��¼ʧ��",JOptionPane.ERROR_MESSAGE);
				
			}
			
			//�������ע�ᰴť��ֱ�Ӱ��ʺ�������ӵ���������
            if(e.getActionCommand().equals("ע��")){
            	//�ý��������ͬ�ʺ���ע�ᣬ��ܾ�ע��
				user_pass.put(user, pass);
				JOptionPane.showMessageDialog(null,"��ϲ��ע��ɹ�,���Ե�¼","��¼�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				
            	
			}	
		}
	};
    
    
    
    public static void main(String[] args) throws Exception{
		new LoginCollection().init();
	}
}
