import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DuanYu extends JFrame {

	private static JTextArea text01=new JTextArea("");
	private int size=20;
	private String style="宋体";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			"1. face to face 面对面、2. far away 遥远、\n3. far behind 落后、"
					+ "4. far from 远离、5. fall asleep 入睡、\n6. fall down 倒下;跌倒;从……落下、　"
					+ "7. fall ill/sick 生病、　　8. fall in 在……失败，(考试)不及格、\n9. fall on top of 掉到了……上面、　"
					+ "10. fall off 从……掉下来/摔下来、\n11. fall one’s exam 考试不及格、12. fall over 滑倒，摔倒、\n13. family name 姓"
					+ "14. family tree 家谱、\n15. feel afraid 觉得害怕、16. feel at home 像在家里一样舒适\n17. feel proud 感到自豪、　"
					+ "18. feel lonely 感到寂寞、\n19. feel like doing sth 想要做某事"
					+ "20. feel tired 感到疲劳、\n21. feel well 觉得舒服、22. feel worried 感到忧虑、\n23. field trip 野外旅游、"
					+ "24. fight against 为反对……而斗争\n25. fill with 装满、26. fill in the blanks 填空、\n27. finish doing sth. 完成/结束……"
					+ "28. find out 查出，查明，发现，了解、\n29. find it difficult to do sth 发现很难做某事、30. (sth)fit(sb)well 非常合身",

			"  31. fly a kite 好风筝、　　32. follow one’s example 仿照……的榜样、　　\n33. follow one’s 、nstruction 听从某人的指导、　　34. for a moment 一会儿、"
					+ "　　\n35. for a walk 散步、　　36. for ever 永远、　　\n37. for example 例如、　　38. for long 很长，很长时间、　　\n39. forget doing sth 忘记做过某事、　　40. four times as…as…是……的四倍、"
					+ "　　\n41. form now on 从此以后，今后、42. from then on 从那时起、\n43. from…to… 从……到……、　　44. full name 全名、　　\n45. full of 装满"
					+ "　46. get back 返回，取回、　　\n47. get down 下来，落下、　　48. get dressed 穿衣服、　　\n49. get home 到家、　　50. get in 收集，进入、　　\n51. get into 搭乘(出租车)、　　52. get lost 迷路，丢失"
					+ "\n53. get long/short 变长/短、54. get off 下车，取下，离开、\n55. get on 上车、56. get on…with sb 与某人相处……、　　\n57. get on well with sb与某人相处融洽、58. get married 结婚",

			" 59. get more exercise做更多运动、　　60. get out of 从……出来，把……拿出来， 从出租车(轿车)下来"
					+ "\n61. get out of bed 起床、62. get ready for sth 为……作准备\n63. get ready to do sth 准备做某事、"
					+ "64. get up 起床，起立、\n65. get warm 变暖和、　　66. get well 痊愈、　　\n67. get together 团聚、"
					+ "　　68. get to 到达(某地)、　　\n69. get to know 逐渐认识到、70. get to work 开始工作(学习)"
					+ "\n71. give advice to 给……提建议、　　72. give sb 、a call 给某人打电话、　　\n73. give back 归还，送回、"
					+ "　　74. give first aid 进行急救、\n75. give sb. a push 推某人一下",

			"76. give sb. a talk 给某人做报告，发表讲话、　　\n77. give…a big hug 热情拥抱…、　　78. give… a hand 给予……帮助、　　\n79. give a warm welcome to… 热烈欢迎、　　80. give an operation 做手术"
					+ "\n81. give up 放弃、　　82. give up doing sth. 放弃做某事、\n83. give up smoking 戒烟、　　84. given name 名字、　　\n85. go abroad 出国;在国外、　　86. go away 走开，离开、　　\n87. go extinct 灭绝、　　88. go back 回去、　　\n89. go past/by 走(路)过、　　90. go for a walk 去散步、　　\n91. go for walks去散步、　　92. go home 回家、　　\n93. go on 继续、　　94. go on doing sth.。 继续做某事"

	};
	
	private JPanel panel01=new JPanel();
	private JButton btn_last=new JButton("上一页");
	private JButton btn_next=new JButton("下一页");
	private JButton fanhui=new JButton("返回");

	
	private JMenu jm01=new JMenu("字号");
	private JMenuItem item01=new JMenuItem("12");
	private JMenuItem item02=new JMenuItem("15");
	private JMenuItem item03=new JMenuItem("18");
	private JMenuItem item04=new JMenuItem("20");
	private JMenu jm02=new JMenu("字体");
	private JMenuItem item05=new JMenuItem("宋体");
	private JMenuItem item06=new JMenuItem("黑体");
	private JMenuItem item07=new JMenuItem("楷体");
	private JMenu jm03=new JMenu("字形");
	private JMenuItem item08=new JMenuItem("常规");
	private JMenuItem item09=new JMenuItem("加粗");
	private JMenuItem item10=new JMenuItem("倾斜");
	private JMenu jm04=new JMenu("颜色");
	private JMenuItem item11=new JMenuItem("红色");
	private JMenuItem item12=new JMenuItem("绿色");
	private JMenuItem item13=new JMenuItem("蓝色");
	private JMenu jm05=new JMenu("设置");
	private JMenuItem item14=new JMenuItem("换壁纸");
	private JMenuBar mb =new JMenuBar();
	
	private int photoNum=1;
	private JPanel imagepanel;
	private ImageIcon bg=new ImageIcon("photo//photo"+photoNum+".jpg");//背景图
	private JLabel label=new JLabel(bg);//把背景图显示在标签内
	
	private int pageNum=1;//页码
	
	DuanYu(){  //构造函数，初始化
		text01.setText(str[0]);
		text01.setLineWrap(true);//自动换行
		text01.setFont(new Font(style,pattern,size));
		text01.setOpaque(false);  //设为透明
		this.add(text01,BorderLayout.CENTER);
		
		btn_last.setEnabled(false);
		btn_next.setEnabled(true);
		panel01.add(btn_last);
		panel01.add(btn_next);
		panel01.add(fanhui);
		panel01.setOpaque(false); //设为透明
		this.add(panel01,BorderLayout.SOUTH);
		
		
		jm01.add(item01);jm01.add(item02);jm01.add(item03);	jm01.add(item04);
		jm02.add(item05);jm02.add(item06);jm02.add(item07);	
		jm03.add(item08);jm03.add(item09);jm03.add(item10);	
		jm04.add(item11);jm04.add(item12);jm04.add(item13);	
		jm05.add(item14);

		mb.add(jm01);
		mb.add(jm02);
		mb.add(jm03);
		mb.add(jm04);
		mb.add(jm05);
		this.setJMenuBar(mb);
		
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight()); //设置边界
		imagepanel=(JPanel)this.getContentPane();//把整个窗格转化为面板
		imagepanel.setOpaque(false);//设为透明
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图添加到分层最底层
		
		
		MyList my=new MyList();
		btn_last.addActionListener(my);
		btn_next.addActionListener(my);
		item01.addActionListener(my);
		item02.addActionListener(my);
		item03.addActionListener(my);
		item04.addActionListener(my);
		item05.addActionListener(my);
		item06.addActionListener(my);
		item07.addActionListener(my);
		item08.addActionListener(my);
		item09.addActionListener(my);
		item10.addActionListener(my);
		item11.addActionListener(my);
		item12.addActionListener(my);
		item13.addActionListener(my);
		item14.addActionListener(my);
		fanhui.addActionListener(my);

		
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
		class MyList implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//此处添加事件处理代码
				if(e.getSource()==fanhui){//
					dispose();
					ChooseEnglish g=new ChooseEnglish();
					g.setTitle("英语学习系统");
					g.setSize(500, 300);
					g.setVisible(true);
					g.setResizable(false);//窗口不可设置大小
					}

				if(e.getSource()==btn_last){//上一页
					if(pageNum>1){//当前不是第一页
						pageNum--;
						btn_last.setEnabled(true);
						btn_next.setEnabled(true);
					}
					if(pageNum==1){//当前是第一页
						btn_last.setEnabled(false);
						btn_next.setEnabled(true);

					}
				}
	            if(e.getSource()==btn_next){//下一页
	            	if(pageNum<str.length){//当前不为最后一页
	            		pageNum++;
	            		btn_last.setEnabled(true);
	            		btn_next.setEnabled(true);	            		
	            	}
	            	if(pageNum==str.length){//当前为最后一页
	            		btn_last.setEnabled(true);
	            		btn_next.setEnabled(false);	            		
	            	}
	            }
				text01.setText(str[pageNum-1]);
				
				if(e.getSource()==item01){					
					size = 10;
				}
				if(e.getSource()==item02){					
					size = 12;
				}
				if(e.getSource()==item03){					
					size = 15;
				}
				if(e.getSource()==item04){					
					size = 18;
				}
				if(e.getSource()==item05){					
					style="宋体";
				}
				if(e.getSource()==item06){					
					style="黑体";
				}
				if(e.getSource()==item07){					
					style="楷体";
				}
				if(e.getSource()==item08){					
					pattern=Font.PLAIN;
				}
				if(e.getSource()==item09){					
					pattern=Font.BOLD;
				}
				if(e.getSource()==item10){					
					pattern=Font.ITALIC;
				}
				text01.setFont(new Font(style,pattern,size));
				
				
				if(e.getSource()==item11){
					text01.setForeground(Color.red);
				}
				if(e.getSource()==item12){
					text01.setForeground(Color.green);
				}
				if(e.getSource()==item13){
					text01.setForeground(Color.blue);
				}
				if(e.getSource() == item14){
					photoNum++;				
					if(photoNum>6) {
						photoNum=1;
					}
					label.setIcon(new ImageIcon("photo//photo"+photoNum+".jpg"));
								
				}
			}
			
		}		
}
