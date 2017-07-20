

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Test {

	JFrame jf = new JFrame("小故事大道理");
    JTextArea tf = new JTextArea(20,40);
    JButton bt1 = new JButton("上一页");
    JButton bt2 = new JButton("下一页");
    JPanel p2 = new JPanel();
    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    
    
    int size = 10;
    String style = "宋体";
    int pattern = Font.PLAIN;
  
    
    JMenuBar mb = new JMenuBar();
    JMenu zihao = new JMenu("字号");
    JMenu ziti = new JMenu("字体");
    JMenu zixing = new JMenu("字形");
    JMenu yanse = new JMenu("颜色");
    JMenu shezhi = new JMenu("设置");
    
    JMenuItem seventeen = new JMenuItem("17");
    JMenuItem eighteen = new JMenuItem("18");
    JMenuItem nineteen = new JMenuItem("19");
    JMenuItem Twenty = new JMenuItem("20");
    
    JMenuItem songti = new JMenuItem("宋体");
    JMenuItem heiti = new JMenuItem("黑体");
    JMenuItem kaiti = new JMenuItem("楷体");
    
    JMenuItem changgui = new JMenuItem("常规");
    JMenuItem jiacu = new JMenuItem("加粗");
    JMenuItem qingxie = new JMenuItem("倾斜");
    
    JMenuItem hongse = new JMenuItem("红色");
    JMenuItem lvse = new JMenuItem("绿色");
    JMenuItem lanse = new JMenuItem("蓝色");
    
    JMenuItem bizhi = new JMenuItem("壁纸");
    
    String str[] = new String[]{"小故事：四个字\n有一位精神病学家，执业多年，获得了很大的成功，在精神病学界享有很高的声誉。他数年前将要退休时，发现在帮助自己改变生活方面最有用的老师，是他所谓的“四个小字”.头两个字是“要是”.他说：“我有许多病人，把时间都花在缅怀既往上，后悔当初该做而没有做的事，‘要是我在那次面试前准备得好一点……’或者‘要是我当初进了会计班……’”在懊悔的海洋里打滚是严重的精神消耗。矫正的方法很简单：只要在你的词汇里抹掉“要是”二字，改用“下次”二字即可。应该向自己说：“下次如有机会我应该如何做……”大道理：最浪费时间的莫过于懊悔。千万不要老是惦念已往的过错，当你又在后悔既往时便对自己说：“下次我不会再做错。”" ,
			" 小故事：机会\nA在合资公司做白领，觉得自己满腔抱负没有得到上级的赏识，经常想：如果有一天能见到老总，有机会展示一下自己的才干就好了！！  A的同事B，也有同样的想法，他更进一步，去打听老总上下班的时间，算好他大概会在何时进电梯，他也在这个时候去坐电梯，希望能遇到老总，有机会可以打个招呼。他们的同事C更进一步。他详细了解老总的奋斗历程，弄清老总毕业的学校，人际风格，关心的问题，精心设计了几句简单却有份量的开场白，在算好的时间去乘坐电梯，跟老总打过几次招呼后，终于有一天跟老总长谈了一次，不久就争取到了更好的职位。大道理：愚者错失机会，智者善抓机会，成功者创造机会。机会只给准备好的人，这准备二字，并非说说而已。",
			"小故事：三个金人\n曾经有个小国到中国来，进贡了三个一模一样的金人，金碧辉煌，把皇帝高兴坏了。可是这小国不厚道，同时出一道题目：这三个金人哪个最有价值?皇帝想了许多的办法，请来珠宝匠检查，称重量，看做工，都是一模一样的。怎么办?使者还等着回去汇报呢。泱泱大国，不会连这个小事都不懂吧?最后，有一位退位的老大臣说他有办法。皇帝将使者请到大殿，老臣胸有成足地拿着三根稻草，插入第一个金人的耳朵里，这稻草从另一边耳朵出来了。第二个金人的稻草从嘴巴里直接掉出来，而第三个金人，稻草进去后掉进了肚子，什么响动也没有。老臣说：第三个金人最有价值!使者默默无语，答案正确。 大道理：最有价值的人，不一定是最能说的人的人。老天给我们两只耳朵一个嘴巴，本来就是让我们多听少说的。善于倾听，才是成熟的人最基本的素质。"
			};
    
    int photoNum = 1;
    JPanel imagePanel;
    ImageIcon bg = new ImageIcon("photo//photo"+photoNum+".jpg");
	JLabel label = new JLabel(bg);
	int i = 1;
	
	int num = 1;
    
    public void init(){
		zihao.add(seventeen);  zihao.add(eighteen);
		zihao.add(nineteen); zihao.add(Twenty);
		mb.add(zihao);
		
		ziti.add(songti); ziti.add(heiti);
		ziti.add(kaiti); mb.add(ziti);
		
		zixing.add(changgui); zixing.add(jiacu);
		zixing.add(qingxie); mb.add(zixing);
		
		yanse.add(hongse); yanse.add(lvse);
		yanse.add(lanse); mb.add(yanse);
		
		shezhi.add(bizhi); mb.add(shezhi);
		
		jf.setJMenuBar(mb);
		
		tf.setLineWrap(true);
		tf.setText(str[0]);
		tf.setFont(new Font(style,pattern,size));
		tf.setOpaque(false);
		jf.add(tf);
		
		jl2.setText("第"+num+"页");
		p2.add(bt1);
		p2.add(jl2);
		p2.add(bt2);
		p2.setOpaque(false);
		bt1.setEnabled(false);
		jf.add(p2,BorderLayout.SOUTH);
		
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		imagePanel = (JPanel)jf.getContentPane();
		imagePanel.setOpaque(false);
		//把背景图添加到分层的最低层
		jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));	
		
		
		jf.setSize(600, 500);
		jf.setVisible(true);
		
		bt1.addActionListener(l);
		bt2.addActionListener(l);
		seventeen.addActionListener(l);
		eighteen.addActionListener(l);
		nineteen.addActionListener(l);
		Twenty.addActionListener(l);
		songti.addActionListener(l);
		heiti.addActionListener(l);
		kaiti.addActionListener(l);
		changgui.addActionListener(l);
		jiacu.addActionListener(l);
		qingxie.addActionListener(l);
		hongse.addActionListener(l);
		lvse.addActionListener(l);
		lanse.addActionListener(l);
		bizhi.addActionListener(l);
		
	}
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt2){
					num++;
					tf.setText(str[num-1]);
					bt1.setEnabled(true);
					jl2.setText("第"+num+"页");
					if(num>2)
						bt2.setEnabled(false);
				}
				if(e.getSource() == bt1){
					num--;
					tf.setText(str[num-1]);
					bt2.setEnabled(true);
					jl2.setText("第"+num+"页");
					if(num<2)
						bt1.setEnabled(false);
				}
				if(e.getSource() == seventeen){
					tf.setFont(new Font(style,pattern,17));
					size = 17;
				}
				if(e.getSource() == eighteen){
					tf.setFont(new Font(style,pattern,18));
					size = 18;
				}
				if(e.getSource() == nineteen){
					tf.setFont(new Font(style,pattern,19));
					size = 19;
				}
				if(e.getSource() == Twenty){
					tf.setFont(new Font(style,pattern,20));
					size = 20;
				}
				if(e.getSource() == songti){
					tf.setFont(new Font("宋体",pattern,size));
					style = "宋体";
				}
				if(e.getSource() == heiti){
					tf.setFont(new Font("黑体",pattern,size));
					style = "黑体";
				}
				if(e.getSource() == kaiti){
					tf.setFont(new Font("楷体",pattern,size));
					style = "楷体";
				}
				if(e.getSource() == changgui){
					tf.setFont(new Font(style,Font.PLAIN,size));
					pattern = Font.PLAIN;
				}
				if(e.getSource() == jiacu){
					tf.setFont(new Font(style,Font.BOLD,size));
					pattern = Font.BOLD;
				}
				if(e.getSource() == qingxie){
					tf.setFont(new Font(style,Font.ITALIC,size));
					pattern = Font.ITALIC;
				}
				if(e.getSource() == hongse){
					 tf.setForeground(Color.red);
				}
				if(e.getSource() == lvse){
					 tf.setForeground(Color.green);
				}
				if(e.getSource() == lanse){
					 tf.setForeground(Color.blue);
				}
				if(e.getSource() == bizhi){
					photoNum++;
					i++;
					if(i>5) i=i%5;
					
					
					ImageIcon bg = new ImageIcon("photo//photo"+i+".jpg");
					JLabel label = new JLabel(bg);
					label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
					imagePanel = (JPanel)jf.getContentPane();
					imagePanel.setOpaque(false);
					//把背景图添加到分层的最低层
					jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE+photoNum-1));
					
				}
			}
		};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Test().init();
		
		
	}
}
