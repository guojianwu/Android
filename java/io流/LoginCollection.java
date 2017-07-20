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


public class LoginCollection {
	JFrame f=new JFrame("登录");
	JLabel l1=new JLabel("帐号");
	JLabel l2=new JLabel("密码");
	JButton b1 =new JButton("登录");
    JButton b2 =new JButton("注册");
    JTextField t1=new JTextField(20);
	JTextField t2=new JTextField(20);
	
	

	
	private String user,pass;  //储存用户在文本框中输入的帐号和密码
	private RandomAccessFile rm=null;
	
	//private Map<String,String>user_pass=new HashMap<String,String>();
    //泛型   集合user_pass（帐号，密码）
	
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
    	    
    	    
    	    try{
    	    	rm=new RandomAccessFile("user_pass.txt","rw"); 
    	    	if(e.getActionCommand().equals("注册")){
    	    		//应该把帐号密码串联起来，并追加到文件的最后
    	    		rm.seek(rm.length()); //把文件指钟移到文档最后
    	    		rm.write((user+","+pass+"\r\n").getBytes());
    	    		JOptionPane.showMessageDialog(null,"恭喜！注册成功，可以登录","注册成功",JOptionPane.ERROR_MESSAGE);
    	    	}
    	    	if(e.getActionCommand().equals("登录")){
    	    		//读文件中的每一行，然后与user和pass串联的结果比较，若有匹配，则登录成功。否则，登录失败
    	    		rm.seek(0);
    	    		String tmp=null;//保存文件中的每一行
    	    		String[] tmparray=new String[2];
    	    		while((tmp=rm.readLine()) !=null){
    	    			tmparray=tmp.split(",");
    	    			if(tmparray[0].equals(user)&& tmparray[1].equals(pass)){
    	    				JOptionPane.showMessageDialog(null,"恭喜！输入正确","登录成功",JOptionPane.INFORMATION_MESSAGE);
    	    				return;
    	    			}
    	    		}
    	    	}
    	    	
    	    	
    	    }catch(Exception ex){
    	    	JOptionPane.showMessageDialog(null,"有异常","出错",JOptionPane.ERROR_MESSAGE);
    	    }finally{
    	    	if(rm!=null){
    	    		try{
    	    			rm.close();
    	    		}catch(IOException e1){
    	    			e1.printStackTrace();
    	    		}
    	    	}
    	    }
    	    
			
		    //如果单击登录按钮，取得用户输入的帐号密码，跟集合里面的帐号密码比对
			//若有匹配的，则弹出登录成功，否则弹出错误
			/*if(e.getActionCommand().equals("登录")){
				for(String str:user_pass.keySet()){
					if(str.equals(user) && user_pass.get(str).equals(pass)){
						//显示对话框
						JOptionPane.showMessageDialog(null,"恭喜！输入正确","登录成功",JOptionPane.INFORMATION_MESSAGE);
						
						return;  //结束方法
						
					}
				}
				JOptionPane.showMessageDialog(null,"错误！输入不正确","登录失败",JOptionPane.ERROR_MESSAGE);
				
			}
			
			//如果单击注册按钮，直接把帐号密码添加到集合里面
            if(e.getActionCommand().equals("注册")){
            	//该进：如果相同帐号与注册，则拒绝注册
				user_pass.put(user, pass);
				JOptionPane.showMessageDialog(null,"错误！注册成功,可以登录","登录成功",JOptionPane.INFORMATION_MESSAGE);
			}*/	
		}
	};
    
    
    
    public static void main(String[] args) throws Exception{
		new LoginCollection().init();
	}
}
