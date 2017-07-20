import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginCollection {
	JFrame f=new JFrame("µÇÂ½");
	JLabel a1=new JLabel("ÕÊºÅ");
	JLabel a2=new JLabel("ÃÜÂë");
	JButton b1 =new JButton("µÇÂ¼");
    JButton b2 =new JButton("×¢²á");
    JTextField c1=new JTextField(20);
	JTextField c2=new JTextField(20);
    
    public void init(){
    	JPanel p1 = new JPanel();
    	p1.add(a1);
    	p1.add(c1);
    	
    	f.add(p1 , BorderLayout.NORTH);
    	
    	JPanel p2 = new JPanel();
    	p2.add(a2);
    	p2.add(c2);
    	
    	f.add(p2 , BorderLayout.CENTER);
    	
    	JPanel p3 = new JPanel();
    	p3.add(b1);
    	p3.add(b2);
    	
    	f.add(p3 , BorderLayout.SOUTH);
    	f.setVisible(true);
		f.pack();

    }  
    
    public static void main(String[] args){
		new LoginCollection().init();
	}
}
