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


public class JuZi extends JFrame {

	private static JTextArea text01=new JTextArea("");
	private int size=20;
	private String style="宋体";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			      "  1、英文：You have to believe in yourself . That's the secret of success.\n"+
                  "  译文：人必须相信自己，这是成功的秘诀。\n"
					+ "  2、英文：You can’t have a better tomorrow if you don’t stop thinking about yesterday.\n"
					+ "  译文：如果你无法忘掉昨天，就不会有一个更好的明天。\n"
					+ "  3、英文：While there is life there is hope.\n"
					+ "  译文：一息若存，希望不灭。\n"
					+ "  4、英文：When there’s no expectation, losing won’t bring hurt, gaining makes you surprised.\n"
					+ "  译文：不去期望。失去了不会伤心，得到了便是惊喜。\n"
					+ "  5、英文：What today will be like is up to me , I get to choose what kind of day I will have.\n"
					+ "  译文：今天什么样，完全由我决定，今天怎样度过，由我选择。\n",

			       "   1、英文：The road of life is like a large river,because of the power of the currents,river courses appear unexpectedly where there is no flowing water.\n"
					+ "  译文：人生的道路就像一条大河，由于急流本身的冲击力，在从前没有水流的地方，冲刷出崭新的意料不到的河道。\n"
					+"  2、英文：There will be no regret and sorrow if you fight with all your strength.\n"
					+ "  译文：只要全力地拼搏，就不会有遗憾，没有后悔。\n"
					+"  3、英文：Time is a bird for ever on the wing.\n"
					+ "  译文：时间是一只永远在飞翔的鸟。\n"
					+"  4、英文：Time will never change and stop for any person.\n"
					+ "  译文：时间不给任何人情面，也不会为谁而停留。\n"
					+"  5、英文：Today, give a stranger one of your smiles. It might be the only sunshine he sees all day.\n"
					+ "  译文：今天，给一个陌生人送上你的微笑吧。很可能，这是他一天中见到的唯一的阳光。\n"
					+"  6、英文：Victory won't come to me unless I go to it.\n"
					+ "  译文：胜利是不会向我们走来的，我必须自己走向胜利。\n",
			
			       "  英文：Walk the road you want to walk and do what you want to do , keep moving ahead and that’s not the silence of failure.\n"
					+ "  译文：走自己想走的路，干自己想干的事，勇敢向前，这就是你不败的沉默。\n"
					+

					"  英文：We all have moments of desperation. But if we can face them head on, that’s when we find out just how strong we really are.\n"
					+ "  译文：我们都有绝望的时候，只有在勇敢面对时，我们才知道我们有多坚强。\n"
					+

					"  英文：We must accept finite disappointment, but we must never lose infinite hope.\n"
					+ "  译文：我们必须接受失望，因为它是有限的，但千万不可失去希望，因为它是无穷的。\n"
					+

					"  英文：The future is scary but you can’t just run to the past cause it’s familiar.\n"
					+ "  译文：未来会让人心生畏惧，但是我们却不能因为习惯了过去，就逃回过去。\n"
					+

					"  英文：The first step is as good as half over.\n"
					+ "  译文：第一步是最关键的一步。\n"

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
	
	
	
	JuZi(){  //构造函数，初始化
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
