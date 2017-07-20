import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public class DanCi extends JFrame {

	private static JTextArea text01=new JTextArea("");
	private int size=20;
	private String style="宋体";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			"  调味料及香精：（condiment/flavoring/dressing/essences）\n "+
            " 酱油soy、双抽black soy sauce、生抽thin soy sauce、\n醋vinegar、" +
            "白醋white vinegar、盐salt、糖sugar、\n料酒rice wine、冰糖rock sugar、" +
            "花椒wild pepper、胡椒pepper\n黑胡椒black pepper、生姜ginger、" +
            "生姜丝shredded ginger、\n三明治酱sandwich spread、虾酱shrimp paste、" +
            "鱼子酱caviar、\n蟹酱crab paste、芥末mustard、味精MSG、咖喱curry、\n" +
            "香料fines herbs、丁香clove、茴香fennel、八角/大茴香aniseed\n小茴香cumin、" +
            "肉桂cinnamon、多香果allspice、马槟榔caper、\n肉豆寇nutmeg、藏红花saffron、" +
            "月桂laurel、孜然cumin 、\n欧芹parsley、太白粉starch、嫩肉粉tenderizer、" +
            "乳酪cheese、\n牛油butter、麻油sesame oil、橄榄油olive oil、\n蚝油oyster sauce、" +
            "发粉baking powder、沙茶satay、\n琼脂agar-agar、发酵粉baking powder、" ,
            
			"   水果:\n Almond 杏仁   、Apple 苹果、Apricot 杏子、Arbutus 杨梅、\nAvocado 南美梨 、Bagasse 甘蔗渣 、"+
             "Banana 香蕉 、\nBennet 水杨梅 、Bergamot 佛手柑 、erry 桨果、\nBilberry 野桑果 、" +
             "Bitter orange 苦酸橙 、Blackberry 刺梅 、\nBlueberry 越桔 、Bryony 野葡萄 、Bullace 野李子 、\n" +
             "Bush fruit 丛生果 、Cantaloupe 美国甜瓜 、\nCarambola 杨桃 、Casaba 冬季甜瓜 、\nCascara 鼠李 、Cherry 樱桃" +
             " Chestnut 栗子 、Coconut 椰子 、\nCodlin 未熟苹果 、Core 果心 、Cranberry 曼越桔 、\n" +
             "Custard apple 番荔枝 、Damson 洋李子 、Date 枣子 、\nDate palm 枣椰子 、Dew 果露 、Durian 榴裢 、Fig 无花果 ”",	
             
			" 点心及小吃：\n "+
            "中式点心dim sum（饮茶Yum Cha）、油条twisted cruller、\n豆浆bean milk、豆腐花beancurd jelly、包子bum"+
            " \n豆沙包smashed bean bun、馒头steamed bread、\n花卷twistbread、馄饨wonton、锅贴fried wontons、\n" +
            "水饺boiled dumpling、蒸虾饺steamed prawn dumpling、\n小笼包子small steamer bun、虾饺shrimp dumpling、\n" +
            "烧卖shao-mai、肠粉rice noodle roll、\n春卷spring roll、葱油饼green onion pie、\n油饼cruller、千层糕layer cake、\n" +
            "马拉糕Cantonese sponge cake、八宝饭rice pudding、\n凉粉agar-agar jelly、河粉fried rice noodles\n"+
            "干炒牛河fried rice noodles w/beef、\n年糕rice cake、炒面chow mein、杂碎Chop Suey、\n芙蓉蛋Egg Foo Yung"+
            " 刀削面sliced noodles、\n炸酱面noodles w/soybean paste、打卤面noodles w/gravy、\n芝麻糊sesame paste"+
            " 萝卜丝饼turnip strips cake、\n碗糕salty rice pudding、凤梨酥pineapple cake、\n豆沙sweet bean paste、" +
            "糯米sticky rice\n",
            "汽车：\n轿车sedan、房车limo、油门accelerator、刹车brake、\n引擎engine、离合器clutch、排档gears、汽缸cylinder、\n" +
            "遮阳板sun visor、保险带seat belt、保险杠bumper、\n方向灯blinker、尾灯tail lamp、轮胎tire\n"+
            " 轮胎花纹thread、汽化剂carburetor、底盘chassis、\n档泥板fender、方向盘steering wheel、\n" +
            "活塞piston、冷冻剂coolant、润滑油lubrication、\n仪表盘dashboard、里程表odometer、\n" +
            "速度计speedometer、油表gauge、档风玻璃windshield、\n雨刷windshield wiper、车牌number plate、\n" +
            "后门rear door、千斤顶jack、加油站gas 、tation、\n、柴油diesel、汽油废气emissions、加仑gallon、加油refuel、\n" +
            "游车河joyride、实习司机L-driver、超车overtake、\n吊销revoke、靠边停车pull over、乱穿马路jaywalk、\n高峰时间commuting hours、" +
            "车道driveway/lane、\n车库garage、停车场parking lot、最高车速speed limit、\n高速公路freeway、公路highway ",
            
            "蔬菜及豆类：\n卷心菜cabbage、椰菜/西兰花broccoli、\n甘蓝Chinese broccol/gai larn、花菜cauliflower、\n" +
            "白菜/青菜pak choi/bok choi/Chinese white cabbage、\n菜心flowering cabbage、" +
            "空心菜water spinach、\n塌棵菜Chinese flat cabbage、芥菜mustard、\n韭菜Chinese chive/leek、" +
            "韭黄leek shoot、\n莴苣/生菜lettuce、甜菜beet、菠菜spinach、芹菜celery、\n" +
            "茄子eggplant/aubergine、香菜caraway、\n胡萝卜carrot、小、红萝卜radish、萝卜turnip、\n" +
            "芋艿taro、西红柿tomato、土豆potato、\n小土豆charlotte、黄瓜cucumber、\n" +
            "丝瓜fuzzy melon/towel gourd、芦笋asparagus、\n茭白wild rice shoots、洋葱onion、\n" +
            "山芋sweet potato、山药yam、青椒green pepper、\n红辣椒chilli、豌豆pea、扁豆haricot、\n" +
            "小扁豆lentil、毛豆green soy bean、黄豆/大豆soybean、\n蚕豆fava bean、豇豆cowpea、" +
            "绿豆mung bean、豆芽bean sprout、番瓜pumpkin、\n冬瓜white gourd、苦瓜bitter gourd、大蒜garlic"
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
	
	DanCi(){  //构造函数，初始化
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
