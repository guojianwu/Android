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

//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;


public class Stroy extends JFrame {

	private static JTextArea text01=new JTextArea("");
	private int size=20;
	private String style="宋体";
	private int pattern=Font.PLAIN;
	/*private String str[]=new String[]{
			"    小故事：\n四个字有一位精神病学家，执业多年，获得了很大的成功，" +
			"在精神病学界享有很高的声誉。他数年前将要退休时，发现在帮助自己改变生活方面最有用的老师，" +
			"是他所谓的“四个小字”.头两个字是“要是”.他说：“我有许多病人，把时间都花在缅怀既往上，" +
			"后悔当初该做而没有做的事，‘要是我在那次面试前准备得好一点……’或者‘要是我当初进了会计班……’" +
			"”在懊悔的海洋里打滚是严重的精神消耗。矫正的方法很简单：只要在你的词汇里抹掉“要是”二字，改用“下次”二字即可。" +
			"应该向自己说：“下次如有机会我应该如何做……”大道理：最浪费时间的莫过于懊悔。" +
			"千万不要老是惦念已往的过错，当你又在后悔既往时便对自己说：“下次我不会再做错。”",	
			
			"  小故事：\n机会A在合资公司做白领，觉得自己满腔抱负没有得到上级的赏识，经常想：如果有一天能见到老总" +
			"，有机会展示一下自己的才干就好了！！  A的同事B，也有同样的想法，他更进一步，" +
			"去打听老总上下班的时间，算好他大概会在何时进电梯，他也在这个时候去坐电梯，" +
			"希望能遇到老总，有机会可以打个招呼。他们的同事C更进一步。他详细了解老总的奋斗历程，" +
			"弄清老总毕业的学校，人际风格，关心的问题，精心设计了几句简单却有份量的开场白，" +
			"在算好的时间去乘坐电梯，跟老总打过几次招呼后，终于有一天跟老总长谈了一次，" +
			"不久就争取到了更好的职位。大道理：愚者错失机会，智者善抓机会，成功者创造机会。" +
			"机会只给准备好的人，这准备二字，并非说说而已。",
			
			" 小故事：\n三个金人曾经有个小国到中国来，进贡了三个一模一样的金人，" +
			"金碧辉煌，把皇帝高兴坏了。可是这小国不厚道，同时出一道题目：" +
			"这三个金人哪个最有价值?皇帝想了许多的办法，请来珠宝匠检查，称重量，" +
			"看做工，都是一模一样的。怎么办?使者还等着回去汇报呢。泱泱大国，" +
			"不会连这个小事都不懂吧?最后，有一位退位的老大臣说他有办法。" +
			"皇帝将使者请到大殿，老臣胸有成足地拿着三根稻草，插入第一个金人的耳朵里，" +
			"这稻草从另一边耳朵出来了。第二个金人的稻草从嘴巴里直接掉出来，而第三个金人，" +
			"稻草进去后掉进了肚子，什么响动也没有。老臣说：第三个金人最有价值!使者默默无语，" +
			"答案正确。 大道理：最有价值的人，不一定是最能说的人的人。老天给我们两只耳朵一个嘴巴，" +
			"本来就是让我们多听少说的。善于倾听，才是成熟的人最基本的素质。"
	};*/
	private static String str[]=new String[4];
	
	private JPanel panel01=new JPanel();
	private JButton btn_last=new JButton("上一页");
	private JButton btn_next=new JButton("下一页");
	
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
	
	
	
	Stroy(){  //构造函数，初始化
		//text01.setText(str[0]);
		text01.setLineWrap(true);//自动换行
		text01.setFont(new Font(style,pattern,size));
		text01.setOpaque(false);  //设为透明
		this.add(text01,BorderLayout.CENTER);
		
		btn_last.setEnabled(false);
		btn_next.setEnabled(true);
		panel01.add(btn_last);
		panel01.add(btn_next);
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
		;
	}
	
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Stroy s=new Stroy();
		s.setTitle("大故事小道理");
		s.setSize(600, 500);
		s.setVisible(true);
		FileInputStream in0=new FileInputStream("story//s01.txt");
		FileInputStream in1=new FileInputStream("story//s02.txt");
		FileInputStream in2=new FileInputStream("story//s03.txt");
		FileInputStream in3=new FileInputStream("story//s04.txt");
		str[0]=s.readFile(in0);
		str[1]=s.readFile(in1);
		str[2]=s.readFile(in2);
		str[3]=s.readFile(in3);
		text01.setText(str[0]);
	}
		class MyList implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//此处添加事件处理代码
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
		
		public String readFile(InputStream inStream){//读取文件中的内容
			byte[] buffer=new byte[2048];
			int hasRead=0;
			StringBuffer sBuffer=new StringBuffer();
			try {
				while((hasRead=inStream.read(buffer))!=-1){
					sBuffer.append(new String(buffer,0,hasRead,"GBK"));
				}
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
			
			return sBuffer.toString();
		}
		
}
