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
			"1、在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂哪种标志？",
			"2、初次申领的机动车驾驶证的有效期为多少年？",
			"3、夜间道路环境对安全行车的主要影响是什么？",
			"4、路中心双黄实线是何含义？",
			"5、驾驶车辆行至道路急转弯处，应怎样做？"
			
	};
	private String[] answer_a=new String[]{//5道题A选项
			"A、注意新手标志",
			"A、3年",
			"A、能见度低、不利于观察道路交通情况",
			"A、可跨越对向车道分界线",
			"A、借对向车道行驶"			
	};
	private String[] answer_b=new String[]{//5道题B选项
			"B、注意避让标志",
			"B、5年",
			"B、路面复杂多变",
			"B、禁止跨越对向车行道分界线",
			"B、急剧制动低速通过"			
	};	
	private String[] answer_c=new String[]{//5道题C选项
			"C、统一式样的实习标志",
			"C、6年",
			"C、驾驶人体力下降",
			"C、双侧可跨越同向车道分界线",
			"C、靠弯道外侧行驶"
			
	};
	private String[] answer_d=new String[]{//5道题D选项
			"D、注意车距标注",
			"D、12年",
			"D、驾驶人易产生冲动、幻觉",
			"C、双侧可跨越同向车道分界线",
			"D、充分减速并靠右侧行驶"
			
	};
	private int num=0;//当前题号
	private JPanel panel02=new JPanel();
	private JButton btn_index[]=new JButton[5];
	
	private JPanel panel03=new JPanel();
	private JButton btn_last=new JButton("上一题");
	private JButton btn_next=new JButton("下一题");
	private JButton btn_finish=new JButton("交卷");
	private JLabel label01=new JLabel("剩余时间");
	private JLabel label_time=new JLabel("5：00");//计时倒数
	
	private JPanel panel04=new JPanel();
	private JLabel label_score=new JLabel();
	private JLabel image=new JLabel();
	
	private JPanel imagePanel;
	private ImageIcon bg=new ImageIcon("image//bg.jpg");
	private JLabel label=new JLabel(bg);
	
	private int score=0;    //总分
	private int right[]=new int[]{3,3,1,2,4};    //正确答案
	private int my_answer[]=new int[]{0,0,0,0,0};   //用户的选项
	
	private Timer timer;
	private int minute=4,second=60;
	
	
	TestSystem(){
		problem.setFont(new Font("宋体",Font.BOLD,18));//设置文字字体，字形，大小
		buttona.setFont(new Font("宋体",Font.BOLD,18));
		buttonb.setFont(new Font("宋体",Font.BOLD,18));
		buttonc.setFont(new Font("宋体",Font.BOLD,18));
		buttond.setFont(new Font("宋体",Font.BOLD,18));
		
		problem.setText(str_problem[num]);//设置文字内容
		buttona.setText(answer_a[num]);
		buttonb.setText(answer_b[num]);
		buttonc.setText(answer_c[num]);
		buttond.setText(answer_d[num]);
		
		Group.add(buttona);//组内选项单选
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
		
		MyListener my=new MyListener();//监听器
		
		for(int i=0;i<5;i++){
			btn_index[i]=new JButton(""+(i+1));
			btn_index[i].setBackground(Color.RED);
			panel02.add(btn_index[i]);	
			btn_index[i].addActionListener(my);//监听器
		}
		this.add(panel02,BorderLayout.CENTER);
		btn_last.setEnabled(false);//不可点击
		label_time.setFont(new Font("黑体",Font.BOLD,30));
		label_time.setForeground(Color.RED);
		panel03.add(btn_last);
		panel03.add(btn_next);
		panel03.add(btn_finish);
		panel03.add(label01);
		panel03.add(label_time);
		this.add(panel03,BorderLayout.SOUTH);
		
		
		label_score.setFont(new Font("黑体",Font.PLAIN,30));
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
		
		label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());//设置边界
		imagePanel=(JPanel)this.getContentPane();//把窗口转化为面板
		imagePanel.setOpaque(false);//设置透明
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//背景图添加在分层最底层
	
		btn_last.addActionListener(my);
		btn_next.addActionListener(my);
		btn_finish.addActionListener(my);
		buttona.addActionListener(my);
		buttonb.addActionListener(my);
		buttonc.addActionListener(my);
		buttond.addActionListener(my);
		
		
		timer =new Timer(1000,new TimerListener());
		timer.start();//启动定时器
	
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSystem t=new TestSystem();
		t.setTitle("驾照考试");
		t.setSize(650, 420);
		t.setVisible(true);
		t.setResizable(false);
	
	}
	

	
	
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//此处添加事件处理代码
			for(int i=0;i<5;i++){
				if(e.getSource()==btn_index[i]){   //按钮1----5
					//System.out.println(""+(i+1));
					//切换到相应的题目和选项
					num=i;
					showItem(num);      //显示到相应的题目和选项
					showButton(num);  	//显示按钮		
					showMyChoice(num);  //显示已经选择的选项		
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
			if(e.getSource()==btn_last){  //上一题    ，当前题号num=01234
				if(num>0){
					num--;
				}
				showItem(num);
				showButton(num);
				showMyChoice(num);
			}
			if(e.getSource()==btn_next){  //下一题
				if(num<str_problem.length-1){
					num++;
				}
				showItem(num);
				showButton(num);
				showMyChoice(num);
			}
			
			if(e.getSource()==btn_finish){  //交卷
				TestFinish();
				timer.stop();//停止计时
	
			}
			
		}
	}
	
	public void showItem(int i){  //判断显示哪个题目及选项，i为当前题号
		problem.setText(str_problem[i]);
		buttona.setText(answer_a[i]);
		buttonb.setText(answer_b[i]);
		buttonc.setText(answer_c[i]);
		buttond.setText(answer_d[i]);
		Group.clearSelection();
	}
	public void showButton (int i){   //判断显示那些按钮，i为当前题号
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
	public void showMyChoice(int i){  //显示已经选择的选项，i为当前题号
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
		label_score.setText("总成绩:"+score);
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
			//定时时间1s到了，要完成的事情
			second--;
			if(second<0){
				second=59;
				minute--;
			}
			label_time.setText(minute+":"+second);
			if(minute==0&&second==0){
				timer.stop();
				label_time.setText("考试结束!");
				TestFinish();
			}
		}
		
	}

}







