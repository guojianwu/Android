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


public class ChooseColor extends JFrame {
	private JLabel label01=new JLabel("��ѡ��ֽ�ƵĻ�ɫ��");
	private JPanel panel01=new JPanel();
	private JButton button[]=new JButton[4];
	private ImageIcon color[]=new ImageIcon[4];
	
	private JPanel panel02=new JPanel();
	private JButton btn_ok=new JButton("ȷ��");
	
	private MyListener my=new MyListener();  //������
	private int choosedColor=0;  //0123
	
	
	ChooseColor(){
		//label01.setForeground(Color.BLUE);
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
		
		btn_ok.setFont(new Font("����",Font.PLAIN,30));
		btn_ok.setForeground(new Color(118,238,0));
		panel02.add(btn_ok);
		this.add(panel02,BorderLayout.SOUTH);
		
		btn_ok.addActionListener(my); //������
		
		
		panel02.setOpaque(false);
		panel01.setOpaque(false);
		
		this.getContentPane().setBackground(Color.PINK);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChooseColor g=new ChooseColor();
		g.setTitle("������Ϸ");
		g.setSize(500, 300);
		g.setVisible(true);
		g.setResizable(false);//���ڲ������ô�С
		//g.setLocationRelativeTo(null);//������ʾ��Ļ�м�	

	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<4;i++){
				if(e.getSource()==button[i]){
					choosedColor=i;
					
					
				}
				
			}
			if(e.getSource()==btn_ok){  //ȷ��
				//��ת����Ϸ��������
				//System.out.println(""+choosedColor);
				dispose();
				PokerGame p=new PokerGame(choosedColor);
				p.setTitle("������Ϸ");
				p.setSize(480, 600);
				p.setVisible(true);
				p.setResizable(false);//���ڲ������ô�С
				//g.setLocationRelativeTo(null);//������ʾ��Ļ�м�	
			}
		}
		
	}

}
