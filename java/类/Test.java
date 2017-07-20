import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;


public class Test {
	public static void main(String[] args){
		//第一个AWT程序
		Frame f= new Frame("QQ");
		f.setSize(300,200);
		f.setResizable(false);
		f.setTitle("第一个程序");
		f.setLocation(500,500);
	    f.setVisible(true);
	
	    TextField t =new TextField(20);
	    Button b1= new Button("确定");
	    //Button b2=new Button("取消");
	    
	    Panel p=new Panel();
	    p.add(t);
	    p.add(b1);
	    f.add(p);
	    f.pack();
	}
}
