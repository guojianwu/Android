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


public class ZuoWen extends JFrame {

	private static JTextArea text01=new JTextArea("");
	private int size=20;
	private String style="宋体";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			          "    Dear Sir,\nI’m writing to complain about the poor quality of the trolley case. I"
					+ " bought it from your department on May 18 which cost me 800 yuan. Unfortunately, when I got home and had a careful check, I found that one wheel of the case is broken and I could not carry too much luggage in it. It cost me so much money that it should be one of good quality. But the result was really dissatisfactory."
					+ "Could you make a refund to me or have it repaired? Hope to receive your reply as soon as possible.\n "
					+ "  Yours truly,\n" + "   Li Li\n               (翻译请查看下一页)",
					"亲爱的先生\n    我写信是想抱怨电车案件的质量太差。我在5月18日从你的部门买的它，花了我800元。不幸的是，当我回到家一仔细检查我发现一个轮子坏了。我不能带太多的行李"+
                    "他花了我那么多钱应该是良好的质量。但结果很不满意。\n    你能让我退款或者修理吗？希望尽快收到你的回复。\n敬启\n丽丽",
			
		            	"  June 9\n  Dear Joanna,\n"
					+ "  I have two tickets for the recent movie at Nanjing Peace Cinema on Sunday, June 9. I heard it was a really wonderful film and I made great effort to get the tickets. Will you join me? I’ll be waiting for you at eight sharp Sunday night in front of the cinema, so please don’t disappoint me! Hope to hear from you soon!\n"
					+ "  Warmest regards,\n" + "  Alice\n              (翻译请查看下一页)",
					"6月9日\n亲爱的乔安娜\n    我有两张最近在南京和平电影院上映的电影票。时间在6月9号的周日。我听说那是一个很精彩的电影。我做出了巨大努力拿到了电影票。你愿意加入我吗？我会在周日的晚上八点在在电影院门后等你。"+
                    "所以不要让我失望。希望您尽快回复。\n最热情的问候\n爱丽丝",
			
			          "  10th December, 2010\n  Dear Sir/Madam,\n"
					+ "  I bought a MP3 player at your place on December 10th , but lately, I found it making noises when playing. Since it's still under warranty, I'd like to ask for free-of-charge repair. Please inform me matters in relation to postage.  Yours sincerely\n  XXX \n              (翻译请查看下一页)",
					
					"2010年12月10日\n亲爱的先生/女士\n我买的一个mp3播放器12月10日在你的地方。但最近。我发现我玩的时候会制造噪音。因为它仍在保修期内，我想要求免费维修。请通知我事情与邮资\n真诚的问候\nxxx",
					
					"  NOTICE\n  December 18th, 2010To improve the students' interests in learning English, the English Department will host language competition in March. All"
					+ "the students are eligible to signup and participate in it. Contest winner will sent to the municipal competitions. The Preliminary Entry Form must reach the English Department in 2010 December 21-25th.\n  English Association\n              (翻译请查看下一页)",
	                   
					"请注意\n    2010年12月18日，来提高学生的学习英语兴趣，英语系将在三月宿主语言的竞赛。所有学生有资格注册并参与。比赛冠军将发送到市级比赛。初步的的"+
                    "报名表格必须在2010年12月21日到25日教到英语系。\n英语协会"
	
	
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
	
	ZuoWen(){  //构造函数，初始化
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
