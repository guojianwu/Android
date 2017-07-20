import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class GUI_1 {
	Frame f=new Frame("聊天窗口");
	TextArea ta=new TextArea(6,40);
	TextField t =new TextField(30);
	Button b=new Button("发送");
	

public void init(){
	Panel p1=new Panel();
    Panel p2=new Panel();
    
	p1.add(ta);
	f.add(p1 , BorderLayout.NORTH);
	p2.add(t);
	p2.add(b);
	f.add(p2 , BorderLayout.SOUTH);
	ActionListener a=new ActionListener() {

		
		public void actionPerformed(ActionEvent e) {
			if(t.getText().equals(""));
			else{
			ta.append("郭建武："+t.getText()+"\n");
			t.setText("");
			}
		}
	};
	KeyAdapter k=new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{   if(t.getText().equals(""));
			else{
				ta.append("郭建武："+t.getText()+"\n");
				t.setText("");
				}
			}
		}
	};
	
	
	
	WindowAdapter w=new WindowAdapter(){
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		    System.exit(0);
		}	
	};
	
	t.addKeyListener(k);
    b.addActionListener(a);
    f.addWindowListener(w);
	f.pack();
    f.setVisible(true);
	
	
  }
public static void main(String[] args){
	new GUI_1().init();
}




}