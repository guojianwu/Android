import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;


public class Test {
	public static void main(String[] args){
		//��һ��AWT����
		Frame f= new Frame("QQ");
		f.setSize(300,200);
		f.setResizable(false);
		f.setTitle("��һ������");
		f.setLocation(500,500);
	    f.setVisible(true);
	
	    TextField t =new TextField(20);
	    Button b1= new Button("ȷ��");
	    //Button b2=new Button("ȡ��");
	    
	    Panel p=new Panel();
	    p.add(t);
	    p.add(b1);
	    f.add(p);
	    f.pack();
	}
}
