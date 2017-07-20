import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MyClock extends JFrame {
	 private JPanel panel01=new JPanel();
	 private JLabel label01,label02,label03,label04,label05,label06;  //ʱ  ��  ��
	 private JLabel douhao01=new JLabel(new ImageIcon("image//douhao.png"));
	 private JLabel douhao02=new JLabel(new ImageIcon("image//douhao.png"));
	 private ImageIcon icon[]=new ImageIcon[10];//����ͼƬ
	 
	 private Calendar c=Calendar.getInstance();
	 private int hour,minute,second;
	 
	 private JPanel panel02=new JPanel();
	 private JLabel dateLabel=new JLabel();
	 private int year,month,date;  //��  ��  �� 
	 
	 private JLabel weekLabel=new JLabel();
	 private int week;
	 
	 private JPanel imagePanel;
	 private ImageIcon bg=new ImageIcon("image//bg.jpg");
	 private JLabel label=new JLabel(bg);
	 private Timer timer;
	 
	 
	 MyClock(){  
		 for(int i=0;i<=9;i++){
			 icon[i]=new ImageIcon("image//num"+i+".png");
		 }
		 hour=c.get(Calendar.HOUR_OF_DAY);
		 minute=c.get(Calendar.MINUTE);
		 second=c.get(Calendar.SECOND);
		 
		 label01=new JLabel(icon[hour/10]);
		 label02=new JLabel(icon[hour%10]);
		 label03=new JLabel(icon[minute/10]);
		 label04=new JLabel(icon[minute%10]);
		 label05=new JLabel(icon[second/10]);
		 label06=new JLabel(icon[second%10]);
		 
		 panel01.add(label01);   
		 panel01.add(label02);
		 panel01.add(douhao01);
		 panel01.add(label03);
		 panel01.add(label04);
		 panel01.add(douhao02);
		 panel01.add(label05);
		 panel01.add(label06);
		 
		 this.setLayout(new BorderLayout());
		 this.add(panel01,BorderLayout.NORTH);
		 
		 year=c.get(Calendar.YEAR);
		 month=c.get(Calendar.MONTH)+1;
		 date=c.get(Calendar.DATE);
		 dateLabel.setFont(new Font("����",Font.BOLD,30));
		 dateLabel.setForeground(Color.MAGENTA);
		 dateLabel.setText(year+"��"+month+"��"+date+"��");
		 panel02.add(dateLabel);
		 this.add(panel02,BorderLayout.CENTER);
		 
		 
		 week=c.get(Calendar.DAY_OF_WEEK);
		 weekLabel.setFont(new Font("����",Font.BOLD,30));
		 weekLabel.setForeground(Color.ORANGE);
		 switch (week) {
		case 1:
			weekLabel.setText("������");
			break;
        case 2:
        	weekLabel.setText("����һ");
			break;
       case 3:
    	   weekLabel.setText("���ڶ�");	
	        break;
       case 4:
    	   weekLabel.setText("������");	
	        break;
       case 5:
    	   weekLabel.setText("������");	
	      break;
      case 6:
    	  weekLabel.setText("������");	
	     break;
      case 7:
    	  weekLabel.setText("������");	
	    break;

		
		}
		 panel02.add(weekLabel);
		 
		panel01.setOpaque(false);
		 panel02.setOpaque(false);
		 label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		 imagePanel=(JPanel)this.getContentPane();
		 imagePanel.setOpaque(false);
		 this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
	 
		 //panel01.setBackground(Color.WHITE);
		 //panel02.setBackground(Color.WHITE);
		 
		 timer=new Timer(1000,new TimerListener());
		 timer.start();
		 
	  }
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClock m=new MyClock();
		m.setTitle("��ʱ��");
		m.setSize(420, 420);
		m.setVisible(true);
		m.setResizable(false);
		

	}
	class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//��ʱʱ��1sҪ����������
			TimerUpdate();
			
		}
		
	}
	public void TimerUpdate(){  //����ʱ��
		paintComp01((Graphics2D)getGraphics());
		second++;
		if(second==60){
			second=0;
			minute++;
			if(minute==60){
				minute=0;
				hour++;
				if(hour==24){
					hour=0;
				}
			}
		}
		label01.setIcon(icon[hour/10]);
		label02.setIcon(icon[hour%10]);
		label03.setIcon(icon[minute/10]);
		label04.setIcon(icon[minute%10]);
		label05.setIcon(icon[second/10]);
		label06.setIcon(icon[second%10]);
		
		paintComp((Graphics2D)getGraphics());
		
	}
	public void paintComp(Graphics2D g){
		int clockRadius=(int)(Math.min(getWidth(), getHeight())*0.6*0.5);  //Բ�İ뾶
		int x=getWidth()/2;    //Բ�ĵĺ�����
		int y=getHeight()/2+60;    //Բ�ĵ�������
		
		g.setColor(Color.DARK_GRAY);     //��������ɫ
		g.setStroke(new BasicStroke(3));    //�����Ĵ�ϸ
		g.drawOval(x-clockRadius, y-clockRadius, 2*clockRadius, 2*clockRadius);     //
	    
		
		g.setColor(Color.BLUE);
		g.drawString("3", x+clockRadius-10, y+3);
		g.drawString("6", x-3, y+clockRadius-3);
		g.drawString("9", x-clockRadius+3, y+5);
		g.drawString("12", x-5, y-clockRadius+12);
		
		int sLength=(int)(clockRadius*0.9);   //���������ĳ���
		int xSecond=(int)(x+sLength*Math.sin(second*2*Math.PI/60));// �����յ�x
		int ySecond=(int)(y-sLength*Math.cos(second*2*Math.PI/60));// �����յ�x
		g.setColor(Color.RED);
		g.drawLine(x, y, xSecond, ySecond);
		
		int mLength=(int)(clockRadius*0.65);   //���������ĳ���
		int xminute=(int)(x+mLength*Math.sin(minute*2*Math.PI/60));// �����յ�x
		int yminute=(int)(y-mLength*Math.cos(minute*2*Math.PI/60));// �����յ�x
		g.setColor(Color.GREEN);
		g.drawLine(x, y, xminute, yminute);
		
		
		int hLength=(int)(clockRadius*0.5);   //ʱ�������ĳ���
		int xHour=(int)(x+hLength*Math.sin((hour%12+minute/60.0)*2*Math.PI/12));// ʱ���յ�x
		int yHour=(int)(y-hLength*Math.cos((hour%12+minute/60.0)*2*Math.PI/12));// ʱ���յ�x
		g.setColor(Color.BLUE);
		g.drawLine(x, y, xHour, yHour);
		
	
	
	
	}
	public void paintComp01(Graphics2D g){
		int clockRadius=(int)(Math.min(getWidth(), getHeight())*0.6*0.5);  //Բ�İ뾶
		int x=getWidth()/2;    //Բ�ĵĺ�����
		int y=getHeight()/2+60;    //Բ�ĵ�������
		
		g.setColor(Color.WHITE);     //��������ɫ
		g.setStroke(new BasicStroke(3));    //�����Ĵ�ϸ
		//g.drawOval(x-clockRadius, y-clockRadius, 2*clockRadius, 2*clockRadius);     //
	    g.fillOval(x-clockRadius, y-clockRadius,2*clockRadius, 2*clockRadius);
		
		/*g.setColor(Color.BLUE);
		g.drawString("3", x+clockRadius-10, y+3);
		g.drawString("6", x-3, y+clockRadius-3);
		g.drawString("9", x-clockRadius+3, y+5);
		g.drawString("12", x-5, y-clockRadius+12);
		
		int sLength=(int)(clockRadius*0.9);   //���������ĳ���
		int xSecond=(int)(x+sLength*Math.sin(second*2*Math.PI/60));// �����յ�x
		int ySecond=(int)(y-sLength*Math.cos(second*2*Math.PI/60));// �����յ�x
		g.setColor(Color.WHITE);
		g.drawLine(x, y, xSecond, ySecond);
		
		int mLength=(int)(clockRadius*0.65);   //���������ĳ���
		int xminute=(int)(x+mLength*Math.sin(minute*2*Math.PI/60));// �����յ�x
		int yminute=(int)(y-mLength*Math.cos(minute*2*Math.PI/60));// �����յ�x
		g.setColor(Color.white);
		g.drawLine(x, y, xminute, yminute);
		
		
		int hLength=(int)(clockRadius*0.5);   //ʱ�������ĳ���
		int xHour=(int)(x+hLength*Math.sin((hour%12+minute/60.0)*2*Math.PI/12));// ʱ���յ�x
		int yHour=(int)(y-hLength*Math.cos((hour%12+minute/60.0)*2*Math.PI/12));// ʱ���յ�x
		g.setColor(Color.WHITE);
		g.drawLine(x, y, xHour, yHour);*/
		
	
	
	
	}
}






