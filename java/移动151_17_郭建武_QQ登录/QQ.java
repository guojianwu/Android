import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.Box;


public class QQ {
	Frame f=new Frame("С���򿴲���");
	Button a1 =new Button("�߼�����");
	Button a2 =new Button("��¼QQ");
	Button a3 =new Button("��¼TM");
	Button a4 =new Button("�������");
	Button a5 =new Button("�����");
	TextField b1=new TextField(50);
	TextField b2=new TextField(50);
	Label c1=new Label("QQ����");
	Label c2=new Label("QQ����");
	Checkbox d1=new Checkbox("��ס����",true);
	Checkbox d2=new Checkbox("���ε�¼",false);
	public void init(){
		//Box top=Box.createHorizontalBox();
		Panel g1 = new Panel();
		g1.add(c1);
		g1.add(b1);
		g1.add(a4);
		f.add(g1 , BorderLayout.NORTH);
		
	   Panel g2 = new Panel();
	       g2.add(a1);
	       g2.add(a2);
	       g2.add(a3);
	f.add(g2 , BorderLayout.SOUTH);
	  Panel g3 = new Panel();
	  g3.add(c2);
	  g3.add(b2);
	  g3.add(a5);
	f.add(g3 , BorderLayout.CENTER);
	
	 Panel g4=new Panel();
	 g4.add(d1);
	 g4.add(d2);
	 f.add(g4 , BorderLayout.CENTER);
	 f.setVisible(true);
		f.pack();

	}
	public static void main(String[] args){
		new QQ().init();
	}

}
