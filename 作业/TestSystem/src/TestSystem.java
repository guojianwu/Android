import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;


public class TestSystem extends JFrame {
	private JPanel panel01=new JPanel();	
	private JLabel problem=new JLabel();	
	private ButtonGroup Group =new ButtonGroup();	
	private JRadioButton buttona=new JRadioButton();
	private JRadioButton buttonb=new JRadioButton();
	private JRadioButton buttonc=new JRadioButton();
	private JRadioButton buttond=new JRadioButton();
	
	private String[] str_problem=new String[]{
			"1����ʵϰ���ڼ�ʻ�������ģ�Ӧ���ڳ����ճ�������������ֱ�־��",
			"2����������Ļ�������ʻ֤����Ч��Ϊ�����ꣿ",
			"3��ҹ���·�����԰�ȫ�г�����ҪӰ����ʲô��",
			"4��·����˫��ʵ���Ǻκ��壿",
			"5����ʻ����������·��ת�䴦��Ӧ��������"
			
	};
	private String[] answer_a=new String[]{//5����Aѡ��
			"A��ע�����ֱ�־",
			"A��3��",
			"A���ܼ��ȵ͡������ڹ۲��·��ͨ���",
			"A���ɿ�Խ���򳵵��ֽ���",
			"A������򳵵���ʻ"			
	};
	private String[] answer_b=new String[]{//5����Bѡ��
			"B��ע����ñ�־",
			"B��5��",
			"B��·�渴�Ӷ��",
			"B����ֹ��Խ�����е��ֽ���",
			"B�������ƶ�����ͨ��"			
	};	
	private String[] answer_c=new String[]{//5����Cѡ��
			"C��ͳһʽ����ʵϰ��־",
			"C��6��",
			"C����ʻ�������½�",
			"C��˫��ɿ�Խͬ�򳵵��ֽ���",
			"C������������ʻ"
			
	};
	private String[] answer_d=new String[]{//5����Dѡ��
			"D��ע�⳵���ע",
			"D��12��",
			"D����ʻ���ײ����嶯���þ�",
			"C��˫��ɿ�Խͬ�򳵵��ֽ���",
			"D����ּ��ٲ����Ҳ���ʻ"
			
	};
	private int num=0;//��ǰ���
	private JPanel panel02=new JPanel();
	private JButton btn_index[]=new JButton[5];
	
	private JPanel panel03=new JPanel();
	private JButton btn_last=new JButton("��һ��");
	private JButton btn_next=new JButton("��һ��");
	private JButton btn_finish=new JButton("����");
	private JLabel label01=new JLabel("ʣ��ʱ��");
	private JLabel label_time=new JLabel("5��00");//��ʱ����
	
	private JPanel panel04=new JPanel();
	private JLabel label_score=new JLabel();
	private JLabel image=new JLabel();
	
	private JPanel imagePanel;
	private ImageIcon bg=new ImageIcon("image//bg.jpg");
	private JLabel label=new JLabel(bg);
	
	private int score=0;    //�ܷ�
	private int right[]=new int[]{3,3,1,2,4};    //��ȷ��
	private int my_answer[]=new int[]{0,0,0,0,0};   //�û���ѡ��
	
	private Timer timer;
	private int minute=4,second=60;
	
	
	TestSystem(){
		problem.setFont(new Font("����",Font.BOLD,18));//�����������壬���Σ���С
		buttona.setFont(new Font("����",Font.BOLD,18));
		buttonb.setFont(new Font("����",Font.BOLD,18));
		buttonc.setFont(new Font("����",Font.BOLD,18));
		buttond.setFont(new Font("����",Font.BOLD,18));
		
		problem.setText(str_problem[num]);//������������
		buttona.setText(answer_a[num]);
		buttonb.setText(answer_b[num]);
		buttonc.setText(answer_c[num]);
		buttond.setText(answer_d[num]);
		
		Group.add(buttona);//����ѡ�ѡ
		Group.add(buttonb);
		Group.add(buttonc);
		Group.add(buttond);
		
		panel01.setLayout(new GridLayout(5, 1, 0, 30));
		panel01.add(problem);
		panel01.add(buttona);
		panel01.add(buttonb);
		panel01.add(buttonc);
		panel01.add(buttond);
		this.setLayout(new BorderLayout());
		this.add(panel01,BorderLayout.NORTH);
		
		MyListener my=new MyListener();//������
		
		for(int i=0;i<5;i++){
			btn_index[i]=new JButton(""+(i+1));
			btn_index[i].setBackground(Color.RED);
			panel02.add(btn_index[i]);	
			btn_index[i].addActionListener(my);//������
		}
		this.add(panel02,BorderLayout.CENTER);
		btn_last.setEnabled(false);//���ɵ��
		label_time.setFont(new Font("����",Font.BOLD,30));
		label_time.setForeground(Color.RED);
		panel03.add(btn_last);
		panel03.add(btn_next);
		panel03.add(btn_finish);
		panel03.add(label01);
		panel03.add(label_time);
		this.add(panel03,BorderLayout.SOUTH);
		
		
		label_score.setFont(new Font("����",Font.PLAIN,30));
		label_time.setForeground(Color.RED);
		panel04.add(label_score);
		panel04.add(image);
		this.add(panel04,BorderLayout.EAST);
		
		panel01.setOpaque(false);
		panel02.setOpaque(false);
		panel03.setOpaque(false);
		panel04.setOpaque(false);
		
		buttona.setOpaque(false);
		buttonb.setOpaque(false);
		buttonc.setOpaque(false);
		buttond.setOpaque(false);
		
		label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());//���ñ߽�
		imagePanel=(JPanel)this.getContentPane();//�Ѵ���ת��Ϊ���
		imagePanel.setOpaque(false);//����͸��
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//����ͼ����ڷֲ���ײ�
	
		btn_last.addActionListener(my);
		btn_next.addActionListener(my);
		btn_finish.addActionListener(my);
		buttona.addActionListener(my);
		buttonb.addActionListener(my);
		buttonc.addActionListener(my);
		buttond.addActionListener(my);
		
		
		timer =new Timer(1000,new TimerListener());
		timer.start();//������ʱ��
	
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSystem t=new TestSystem();
		t.setTitle("���տ���");
		t.setSize(650, 420);
		t.setVisible(true);
		t.setResizable(false);
	
	}
	

	
	
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//�˴�����¼��������
			for(int i=0;i<5;i++){
				if(e.getSource()==btn_index[i]){   //��ť1----5
					//System.out.println(""+(i+1));
					//�л�����Ӧ����Ŀ��ѡ��
					num=i;
					showItem(num);      //��ʾ����Ӧ����Ŀ��ѡ��
					showButton(num);  	//��ʾ��ť		
					showMyChoice(num);  //��ʾ�Ѿ�ѡ���ѡ��		
				}
			}
			if(e.getSource()==buttona){
				my_answer[num]=1;
				btn_index[num].setBackground(Color.GREEN);
			}
			if(e.getSource()==buttonb){
				my_answer[num]=2;
				btn_index[num].setBackground(Color.GREEN);
			}
			if(e.getSource()==buttonc){
				my_answer[num]=3;
				btn_index[num].setBackground(Color.GREEN);
			}
			if(e.getSource()==buttond){
				my_answer[num]=4;
				btn_index[num].setBackground(Color.GREEN);
			}
			if(e.getSource()==btn_last){  //��һ��    ����ǰ���num=01234
				if(num>0){
					num--;
				}
				showItem(num);
				showButton(num);
				showMyChoice(num);
			}
			if(e.getSource()==btn_next){  //��һ��
				if(num<str_problem.length-1){
					num++;
				}
				showItem(num);
				showButton(num);
				showMyChoice(num);
			}
			
			if(e.getSource()==btn_finish){  //����
				TestFinish();
				timer.stop();//ֹͣ��ʱ
	
			}
			
		}
	}
	
	public void showItem(int i){  //�ж���ʾ�ĸ���Ŀ��ѡ�iΪ��ǰ���
		problem.setText(str_problem[i]);
		buttona.setText(answer_a[i]);
		buttonb.setText(answer_b[i]);
		buttonc.setText(answer_c[i]);
		buttond.setText(answer_d[i]);
		Group.clearSelection();
	}
	public void showButton (int i){   //�ж���ʾ��Щ��ť��iΪ��ǰ���
		if(i==0){
			btn_last.setEnabled(false);
			btn_next.setEnabled(true);
		}else if (i==str_problem.length-1){
			btn_last.setEnabled(true);
			btn_next.setEnabled(false);
		}else {
			btn_last.setEnabled(true);
			btn_next.setEnabled(true);
		}
		
	}
	public void showMyChoice(int i){  //��ʾ�Ѿ�ѡ���ѡ�iΪ��ǰ���
		switch (my_answer[i]) {
		case 1:
			buttona.setSelected(true);
			break;
        case 2:
			buttonb.setSelected(true);
			break;
       case 3:
    	   buttonc.setSelected(true);	
	        break;
       case 4:
    	   buttond.setSelected(true);	
	       break;

		}
	}
	public void TestFinish(){
		btn_last.setEnabled(false);
		btn_next.setEnabled(false);
		buttona.setEnabled(false);
		buttonb.setEnabled(false);
		buttonc.setEnabled(false);
		buttond.setEnabled(false);
		btn_finish.setEnabled(false);
		for(int i=0;i<5;i++){
			btn_index[i].setEnabled(false);
			if(my_answer[i]==right[i]){
				score=score+20;
			}
		}
		label_score.setText("�ܳɼ�:"+score);
		if(score==100){
			image.setIcon(new ImageIcon("image//laugh.jpg"));
		}else {
			image.setIcon(new ImageIcon("image//cry.jpg"));
		}
		
	}
	class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//��ʱʱ��1s���ˣ�Ҫ��ɵ�����
			second--;
			if(second<0){
				second=59;
				minute--;
			}
			label_time.setText(minute+":"+second);
			if(minute==0&&second==0){
				timer.stop();
				label_time.setText("���Խ���!");
				TestFinish();
			}
		}
		
	}

}







