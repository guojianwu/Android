

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class  a{
	
	Frame f= new Frame();
	Button b=new Button("确定");
	Button b2=new Button("取消");
	TextField t=new TextField(20);
	public void init(){
		Panel p=new Panel();
		p.add(t);
		p.add(b);
		p.add(b2);
		
		WindowAdapter t2=new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			    System.exit(0);
			}	
		};
		
		
		MouseAdapter t1=new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			    t.setText(e.getX()+","+e.getY());
			}
		};
		/*
		ActionListener l=new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("确定")){
					t.setText(b.getLabel());
				}
				if(e.getSource().equals(b2)){
					t.setText(" ");
				}
				//t.setText(b.getLabel());
				
			}
			
		};
		ActionListener l2=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.setText(" ");
			}	
		};
		
		b.addActionListener(l);
		b2.addActionListener(l);
		*/
		t.addMouseListener(t1);
		f.addWindowListener(t2);
		f.add(p);
		f.setVisible(true);
		f.pack();
	
	}
	/*//MyListener作为内部类
	 * 
	class MyListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		t.setText(b.getLabel());
	}
}*/
	


	public static void main(String[] args){
		new a().init();
	}

}
