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
	private JTextField photoName=new JTextField(15);   //ͼƬ��
	public static JTextField text_step=new JTextField(15);   //����
 
	private JPanel panel_right=new JPanel();
	private ButtonGroup group=new ButtonGroup();
	private JRadioButton radio01=new JRadioButton("������ʾ");
	private JRadioButton radio02=new JRadioButton("������ʾ");
	private JLabel label01=new JLabel("    ѡ��ͼƬ   ");
	private String items[]=new String[]{"С����","����A��","���","���౦��","��ŭ��С��"};
	private JComboBox comboBox=new JComboBox(items);
	private JButton btn_start=new JButton("��ʼ");
	
	private JPanel panel02=new JPanel();
	private PhotoPreview panel_preview=new PhotoPreview();
	
	private PhotoCanvas panel_game=new PhotoCanvas();
	
	private MyListener my=new MyListener();
	
	private MyItemListener myListener=new MyItemListener();
	
	
	PuzzleGame(){
		panel01.setLayout(new GridLayout(1,2));
		this.setLayout(new BorderLayout());
		this.add(panel01,BorderLayout.NORTH);
		
		photoName.setText("ͼƬ��:С����");
		photoName.setBackground(new Color(255,250,205));
		photoName.setEditable(false);
		text_step.setText("���߲���:0");
		text_step.setBackground(new Color(255,250,205));
		text_step.setEditable(false);
		panel_left.add(photoName);
		panel_left.add(text_step);
		panel_left.setBorder(new TitledBorder("״̬��"));
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
		panel_right.setBorder(new TitledBorder("������"));
		panel01.add(panel_right);
		
		
		panel02.setLayout(new GridLayout(1,2));
		this.add(panel02,BorderLayout.CENTER);
		panel_preview.setBorder(new TitledBorder("Ԥ����"));
		panel02.add(panel_preview);
		
		panel_game.setBorder(new TitledBorder("ƴͼ��"));
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
		g.setTitle("ƴͼ��Ϸ");
		g.setSize(900, 550);
		g.setVisible(true);
		g.setResizable(false);//���ڲ������ô�С
		//g.setLocationRelativeTo(null);//������ʾ��Ļ�м�	
	}
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(radio01.isSelected()){ //������ʾ
				panel_game.reLoadPhotoAddNumber();	
			}
			if(radio02.isSelected()){
				panel_game.reLoadPotoClearNumber();
			}
			if(e.getSource()==btn_start){
				PhotoCanvas.stepNum=0;
				text_step.setText("���߲���:"+PhotoCanvas.stepNum);
				panel_game.startGame();
			}
		}
		
	}
	private class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			int num=comboBox.getSelectedIndex()+1;   //1 2 3 4 5 
			//����Ԥ����
			PhotoCanvas.phtotID=num;
			panel_preview.repaint();
			
			//����ƴͼ��
			panel_game.reLoadPotoClearNumber();
			
			//����״̬�� 
			photoName.setText("ͼƬ��:"+comboBox.getSelectedItem());
			PhotoCanvas.stepNum=0;
			text_step.setText("���߲���:"+PhotoCanvas.stepNum);
			
			//����������
			radio01.setSelected(false);
			radio02.setSelected(true);
			
			
			
		}	
	}

}
