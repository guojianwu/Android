import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFile {
	JFrame f =new JFrame("��¼");
	JLabel l1 =new JLabel("�ʺ�:");
	JLabel l2 =new JLabel("����:");
	JButton b1 = new JButton("��¼");
	JButton b2 = new JButton("ע��");
	JButton b3 = new JButton("�˳�");
	JTextField t1=new JTextField(20);
	JTextField t2=new JTextField(20);
	String user,pass;
	Map<String,String> user_pass = new HashMap<String,String>();
	 //����   ����user_pass���ʺţ����룩
	public void init() throws IOException{
        final RandomAccessFile raf = new RandomAccessFile("user_pass.txt", "rw");
        String line,u = null,p=null;
        while((line = raf.readLine())!=null){
        	String[] temp = line.split(",");
        	for(int i=0;i<temp.length;i++){
        		if(i%2==0){
        			u=temp[i];
        		}else{
        			p=temp[i];
        		}
        		user_pass.put(u, p);
        	}
        }
        
		JPanel bei =new JPanel();
		bei.add(l1);
		bei.add(t1);
		f.add(bei,BorderLayout.NORTH);
		
		JPanel zhong =new JPanel();
		zhong.add(l2);
		zhong.add(t2);
		f.add(zhong);
		
		JPanel nan =new JPanel();
		nan.add(b1);
		nan.add(b2); 
		nan.add(b3);
		f.add(nan,BorderLayout.SOUTH);
		

		f.setVisible(true);
		f.pack();
	ActionListener ls = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			user = t1.getText().toString();
			pass = t2.getText().toString();
			if(e.getSource()==b1)
			{
				for(String str:user_pass.keySet())
				{
					if(str.equals(user) && user_pass.get(str).equals(pass))
					{
						JOptionPane.showMessageDialog(null,"��ϲ��������ȷ��","��¼�ɹ�",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				JOptionPane.showMessageDialog(null,"�������벻��ȷ��","��¼ʧ��",JOptionPane.ERROR_MESSAGE);
			}
			if(e.getSource()==b2){
				if(user.equals("")||pass.equals(""))
				{
					JOptionPane.showMessageDialog(null,"ע����ʺŻ����벻��Ϊ��","ע��ʧ��",JOptionPane.ERROR_MESSAGE);
					return;
				}
				for(String str:user_pass.keySet())
				{
					if(user.equals(str))
					{
						JOptionPane.showMessageDialog(null,"��ע����ʺ��Ѵ���","ע��ʧ��",JOptionPane.ERROR_MESSAGE);
						return;
					}			
				}
				user_pass.put(user, pass);
				String s=user+","+pass;
                try {
					raf.seek(raf.length());
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
                try {
					raf.write((s+"\r\n").getBytes());
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"��ϲ��ע��ɹ������Ե�¼��","ע��ɹ�",JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource()==b3){
				System.exit(0);
			}
		}	
	};
	b1.addActionListener(ls);
	b2.addActionListener(ls);
	b3.addActionListener(ls);
}
	
public static void main(String[] args) throws IOException {
	new LoginFile().init();
	}	
}	

