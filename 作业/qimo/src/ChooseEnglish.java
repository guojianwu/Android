import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChooseEnglish extends JFrame {
	private JLabel label01=new JLabel("��ѡ����Ҫѧϰ��Ӣ����𣡣���");
	private JPanel panel01=new JPanel();
	private JButton button[]=new JButton[4];
	private ImageIcon color[]=new ImageIcon[4];
	
	private MyListener my=new MyListener();  //������
	
	ChooseEnglish(){
		label01.setFont(new Font("����", Font.PLAIN, 30));
		label01.setForeground(new Color(160,30,240));
		this.setLayout(new BorderLayout());
		this.add(label01,BorderLayout.NORTH);
		
		for(int i=0;i<4;i++){
			color[i]=new ImageIcon("image//p"+(i+1)+".png");
			button[i]=new JButton(color[i]);
			panel01.add(button[i]);
			button[i].addActionListener(my);//������
			
		}
		this.add(panel01,BorderLayout.CENTER);
		
		panel01.setOpaque(false);
		
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChooseEnglish g=new ChooseEnglish();
		g.setTitle("Ӣ��ѧϰϵͳ");
		g.setSize(500, 300);
		g.setVisible(true);
		g.setResizable(false);//���ڲ������ô�С
		//g.setLocationRelativeTo(null);//������ʾ��Ļ�м�	

	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				if(e.getSource()==button[0]){
					//choosedColor=i;
					dispose();
					DanCi p=new DanCi();
					p.setTitle("Ӣ��ѧϰϵͳ");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//���ڲ������ô�С
					
				}
				if(e.getSource()==button[1]){
					//choosedColor=i;
					dispose();
					DuanYu p=new DuanYu();
					p.setTitle("Ӣ��ѧϰϵͳ");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//���ڲ������ô�С
					
				}
				if(e.getSource()==button[2]){
					//choosedColor=i;
					dispose();
					JuZi p=new JuZi();
					p.setTitle("Ӣ��ѧϰϵͳ");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//���ڲ������ô�С
					
				}
				if(e.getSource()==button[3]){
					//choosedColor=i;
					dispose();
					ZuoWen p=new ZuoWen();
					p.setTitle("Ӣ��ѧϰϵͳ");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//���ڲ������ô�С
					
				}
		}
		
	}

}
