import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;


public class GUI_2 extends Frame implements AdjustmentListener{
	TextArea ta=new TextArea("��������",10,30);
	Scrollbar red,green,blue;
	Panel p=new Panel();   //���ڴ������������
	
	public GUI_2(){   //	�ù��췽����ɳ�ʼ��
		red=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,255);
		green=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,255);
		blue=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,255);
		
		p.setLayout(new GridLayout(3,1,5,5));  //3*1�����񲼾�
		p.add(red);
		p.add(green);
		p.add(blue);
		
		ta.setBackground(new Color(0,0,0));
		
		add(ta);
		add(p,BorderLayout.SOUTH);
		
		red.addAdjustmentListener(this);
		green.addAdjustmentListener(this);
		blue.addAdjustmentListener(this);
		setVisible(true);
		setSize(400,300);
	}
	
	
	 
	public void adjustmentValueChanged(AdjustmentEvent e) {
		//���ݻ�������ǰ��λ�����ı��ı���ı�����ɫ
	    int r=red.getValue();
	    int g=green.getValue();
	    int b=blue.getValue();
	    ta.setBackground(new Color(r,g,b));
	    
		
	}


	public static void main(String[] args) {
			new GUI_2();
		}
}