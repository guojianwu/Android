import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class PuzzleGame extends JFrame {
	private JPanel panel01=new JPanel();
	private JPanel panel_left=new JPanel();
	private JTextField photoName=new JTextField(15);   //图片名
	public static JTextField text_step=new JTextField(15);   //步数
 
	private JPanel panel_right=new JPanel();
	private ButtonGroup group=new ButtonGroup();
	private JRadioButton radio01=new JRadioButton("数字提示");
	private JRadioButton radio02=new JRadioButton("隐藏提示");
	private JLabel label01=new JLabel("    选择图片   ");
	private String items[]=new String[]{"小黄人","多啦A梦","大白","海绵宝宝","愤怒的小鸟"};
	private JComboBox comboBox=new JComboBox(items);
	private JButton btn_start=new JButton("开始");
	
	private JPanel panel02=new JPanel();
	private PhotoPreview panel_preview=new PhotoPreview();
	
	private PhotoCanvas panel_game=new PhotoCanvas();
	
	private MyListener my=new MyListener();
	
	private MyItemListener myListener=new MyItemListener();
	
	
	PuzzleGame(){
		panel01.setLayout(new GridLayout(1,2));
		this.setLayout(new BorderLayout());
		this.add(panel01,BorderLayout.NORTH);
		
		photoName.setText("图片名:小黄人");
		photoName.setBackground(new Color(255,250,205));
		photoName.setEditable(false);
		text_step.setText("已走步数:0");
		text_step.setBackground(new Color(255,250,205));
		text_step.setEditable(false);
		panel_left.add(photoName);
		panel_left.add(text_step);
		panel_left.setBorder(new TitledBorder("状态区"));
		panel01.add(panel_left);
		
		radio01.setForeground(new Color(28,134,238));
		radio02.setForeground(new Color(28,134,238));
		label01.setForeground(new Color(125,38,205));
		btn_start.setForeground(new Color(238,64,0));
		group.add(radio01);
		group.add(radio02);
		panel_right.add(radio01);
		panel_right.add(radio02);
		panel_right.add(label01);
		panel_right.add(comboBox);
		panel_right.add(btn_start);
		panel_right.setBorder(new TitledBorder("设置区"));
		panel01.add(panel_right);
		
		
		panel02.setLayout(new GridLayout(1,2));
		this.add(panel02,BorderLayout.CENTER);
		panel_preview.setBorder(new TitledBorder("预览区"));
		panel02.add(panel_preview);
		
		panel_game.setBorder(new TitledBorder("拼图区"));
		panel02.add(panel_game);
		
		this.getContentPane().setBackground(new Color(191,239,255));
		radio01.setOpaque(false);
		radio02.setOpaque(false);
		panel_left.setOpaque(false);
		panel_right.setOpaque(false);
		panel_preview.setOpaque(false);
		panel_game.setOpaque(false);
		panel01.setOpaque(false);
		panel02.setOpaque(false);
		
		radio01.addActionListener(my);
		radio02.addActionListener(my);
		btn_start.addActionListener(my);
		
		
		comboBox.addItemListener(myListener);
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PuzzleGame g=new PuzzleGame();
		g.setTitle("拼图游戏");
		g.setSize(900, 550);
		g.setVisible(true);
		g.setResizable(false);//窗口不可设置大小
		//g.setLocationRelativeTo(null);//窗口显示屏幕中间	
	}
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(radio01.isSelected()){ //数字提示
				panel_game.reLoadPhotoAddNumber();	
			}
			if(radio02.isSelected()){
				panel_game.reLoadPotoClearNumber();
			}
			if(e.getSource()==btn_start){
				PhotoCanvas.stepNum=0;
				text_step.setText("已走步数:"+PhotoCanvas.stepNum);
				panel_game.startGame();
			}
		}
		
	}
	private class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			int num=comboBox.getSelectedIndex()+1;   //1 2 3 4 5 
			//更新预览区
			PhotoCanvas.phtotID=num;
			panel_preview.repaint();
			
			//更新拼图区
			panel_game.reLoadPotoClearNumber();
			
			//更新状态区 
			photoName.setText("图片名:"+comboBox.getSelectedItem());
			PhotoCanvas.stepNum=0;
			text_step.setText("已走步数:"+PhotoCanvas.stepNum);
			
			//更新设置区
			radio01.setSelected(false);
			radio02.setSelected(true);
			
			
			
		}	
	}

}
