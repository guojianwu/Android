
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Test {
	//单击按钮，文本框显示helloworld文字
	Frame f= new Frame();
	Button b=new Button("确定");
	TextField t=new TextField(20);
	public void init(){
		Panel p=new Panel();
		p.add(t);
		p.add(b);
		
		b.addActionListener(new MyListener());
		
		f.add(p);
		f.setVisible(true);
		f.pack();
	
	}
	//MyListener作为内部类
	class MyListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		t.setText(b.getLabel());
	}
}
	
	public static void main(String[] args){
		new Test().init();
	}

}
