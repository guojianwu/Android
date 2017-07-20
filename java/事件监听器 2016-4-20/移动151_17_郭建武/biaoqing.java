import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class biaoqing {
	Frame f=new Frame("表情");
	Button x=new Button("笑脸");
	Button k=new Button("哭脸");
	Button j=new Button("惊讶");
	MyCanvas drawArea =new MyCanvas();
	String shape="x"; 
	public void init(){
		Panel p=new Panel();
		p.add(x);
		p.add(k);
		p.add(j);
		drawArea.setPreferredSize(new Dimension(400,350)); //设置画布的大小
		f.add(drawArea);
		f.add(p,BorderLayout.SOUTH);
		
		
		ActionListener l=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(x)){
				
					shape="x";
					drawArea.repaint();
					
				}
				if(e.getSource().equals(k)){
					
					shape="k";
					drawArea.repaint();
				}
                if(e.getSource().equals(j)){
					
					shape="j";
					drawArea.repaint();
				}
				
			}
		};
		
		x.addActionListener(l);
		k.addActionListener(l);
		j.addActionListener(l);
		f.pack();
		f.setVisible(true);
		
	}
		class MyCanvas extends Canvas{
			public void paint(Graphics g) {
				if(shape.equals("x")){
					g.setColor(new Color(180,90,60));
					g.drawOval(100, 50, 200, 200);
				
					g.fillOval(155, 100, 10, 20);
					g.fillOval(230, 100, 10, 20);
					g.drawArc(150, 160, 100, 50, 180, 180);
					
				}
				if(shape.equals("k")){
					g.setColor(new Color(220,180,80));
					g.drawOval(100, 50, 200, 200);
				
					g.fillOval(155, 100, 10, 20);
					g.fillOval(230, 100, 10, 20);
					g.drawArc(155, 180, 90, 50, -180, -180);
					
				}
				if(shape.equals("j")){
					g.setColor(new Color(220,20,80));
					g.drawOval(100, 50, 200, 200);
				
					g.fillOval(155, 100, 10, 20);
					g.fillOval(230, 100, 10, 20);
					g.drawArc(155, 180, 90, 50, 360, 360);
					
				}
				
			}
			}
	  
		
			
		public static void main(String[] args) {
			new biaoqing().init();
		}
		
}
