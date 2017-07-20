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
	private JLabel label01=new JLabel("请选择您要学习的英语类别！！！");
	private JPanel panel01=new JPanel();
	private JButton button[]=new JButton[4];
	private ImageIcon color[]=new ImageIcon[4];
	
	private MyListener my=new MyListener();  //监听器
	
	ChooseEnglish(){
		label01.setFont(new Font("黑体", Font.PLAIN, 30));
		label01.setForeground(new Color(160,30,240));
		this.setLayout(new BorderLayout());
		this.add(label01,BorderLayout.NORTH);
		
		for(int i=0;i<4;i++){
			color[i]=new ImageIcon("image//p"+(i+1)+".png");
			button[i]=new JButton(color[i]);
			panel01.add(button[i]);
			button[i].addActionListener(my);//监听器
			
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
		g.setTitle("英语学习系统");
		g.setSize(500, 300);
		g.setVisible(true);
		g.setResizable(false);//窗口不可设置大小
		//g.setLocationRelativeTo(null);//窗口显示屏幕中间	

	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				if(e.getSource()==button[0]){
					//choosedColor=i;
					dispose();
					DanCi p=new DanCi();
					p.setTitle("英语学习系统");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//窗口不可设置大小
					
				}
				if(e.getSource()==button[1]){
					//choosedColor=i;
					dispose();
					DuanYu p=new DuanYu();
					p.setTitle("英语学习系统");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//窗口不可设置大小
					
				}
				if(e.getSource()==button[2]){
					//choosedColor=i;
					dispose();
					JuZi p=new JuZi();
					p.setTitle("英语学习系统");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//窗口不可设置大小
					
				}
				if(e.getSource()==button[3]){
					//choosedColor=i;
					dispose();
					ZuoWen p=new ZuoWen();
					p.setTitle("英语学习系统");
					p.setSize(600, 500);
					p.setVisible(true);
					p.setResizable(false);//窗口不可设置大小
					
				}
		}
		
	}

}
