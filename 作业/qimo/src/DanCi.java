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
	private String style="����";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			"  ��ζ�ϼ��㾫����condiment/flavoring/dressing/essences��\n "+
            " ����soy��˫��black soy sauce������thin soy sauce��\n��vinegar��" +
            "�״�white vinegar����salt����sugar��\n�Ͼ�rice wine������rock sugar��" +
            "����wild pepper������pepper\n�ں���black pepper������ginger��" +
            "����˿shredded ginger��\n�����ν�sandwich spread��Ϻ��shrimp paste��" +
            "���ӽ�caviar��\nз��crab paste����ĩmustard��ζ��MSG�����curry��\n" +
            "����fines herbs������clove������fennel���˽�/������aniseed\nС����cumin��" +
            "���cinnamon�������allspice��������caper��\n�ⶹ��nutmeg���غ컨saffron��" +
            "�¹�laurel����Ȼcumin ��\nŷ��parsley��̫�׷�starch�������tenderizer��" +
            "����cheese��\nţ��butter������sesame oil�������olive oil��\n���oyster sauce��" +
            "����baking powder��ɳ��satay��\n��֬agar-agar�����ͷ�baking powder��" ,
            
			"   ˮ��:\n Almond ����   ��Apple ƻ����Apricot ���ӡ�Arbutus ��÷��\nAvocado ������ ��Bagasse ������ ��"+
             "Banana �㽶 ��\nBennet ˮ��÷ ��Bergamot ���ָ� ��erry ������\nBilberry Ұɣ�� ��" +
             "Bitter orange ����� ��Blackberry ��÷ ��\nBlueberry Խ�� ��Bryony Ұ���� ��Bullace Ұ���� ��\n" +
             "Bush fruit ������ ��Cantaloupe ������� ��\nCarambola ���� ��Casaba ������� ��\nCascara ���� ��Cherry ӣ��" +
             " Chestnut ���� ��Coconut Ҭ�� ��\nCodlin δ��ƻ�� ��Core ���� ��Cranberry ��Խ�� ��\n" +
             "Custard apple ����֦ ��Damson ������ ��Date ���� ��\nDate palm ��Ҭ�� ��Dew ��¶ ��Durian ���� ��Fig �޻��� ��",	
             
			" ���ļ�С�ԣ�\n "+
            "��ʽ����dim sum������Yum Cha��������twisted cruller��\n����bean milk��������beancurd jelly������bum"+
            " \n��ɳ��smashed bean bun����ͷsteamed bread��\n����twistbread�����wonton������fried wontons��\n" +
            "ˮ��boiled dumpling����Ϻ��steamed prawn dumpling��\nС������small steamer bun��Ϻ��shrimp dumpling��\n" +
            "����shao-mai������rice noodle roll��\n����spring roll�����ͱ�green onion pie��\n�ͱ�cruller��ǧ���layer cake��\n" +
            "������Cantonese sponge cake���˱���rice pudding��\n����agar-agar jelly���ӷ�fried rice noodles\n"+
            "�ɳ�ţ��fried rice noodles w/beef��\n���rice cake������chow mein������Chop Suey��\nܽ�ص�Egg Foo Yung"+
            " ������sliced noodles��\nը����noodles w/soybean paste����±��noodles w/gravy��\n֥���sesame paste"+
            " �ܲ�˿��turnip strips cake��\n���salty rice pudding��������pineapple cake��\n��ɳsweet bean paste��" +
            "Ŵ��sticky rice\n",
            "������\n�γ�sedan������limo������accelerator��ɲ��brake��\n����engine�������clutch���ŵ�gears������cylinder��\n" +
            "������sun visor�����մ�seat belt�����ո�bumper��\n�����blinker��β��tail lamp����̥tire\n"+
            " ��̥����thread��������carburetor������chassis��\n�����fender��������steering wheel��\n" +
            "����piston���䶳��coolant������lubrication��\n�Ǳ���dashboard����̱�odometer��\n" +
            "�ٶȼ�speedometer���ͱ�gauge�����粣��windshield��\n��ˢwindshield wiper������number plate��\n" +
            "����rear door��ǧ�ﶥjack������վgas ��tation��\n������diesel�����ͷ���emissions������gallon������refuel��\n" +
            "�γ���joyride��ʵϰ˾��L-driver������overtake��\n����revoke������ͣ��pull over���Ҵ���·jaywalk��\n�߷�ʱ��commuting hours��" +
            "����driveway/lane��\n����garage��ͣ����parking lot����߳���speed limit��\n���ٹ�·freeway����·highway ",
            
            "�߲˼����ࣺ\n���Ĳ�cabbage��Ҭ��/������broccoli��\n����Chinese broccol/gai larn������cauliflower��\n" +
            "�ײ�/���pak choi/bok choi/Chinese white cabbage��\n����flowering cabbage��" +
            "���Ĳ�water spinach��\n���ò�Chinese flat cabbage�����mustard��\n�²�Chinese chive/leek��" +
            "�»�leek shoot��\nݫ��/����lettuce�����beet������spinach���۲�celery��\n" +
            "����eggplant/aubergine�����caraway��\n���ܲ�carrot��С�����ܲ�radish���ܲ�turnip��\n" +
            "��ܵtaro��������tomato������potato��\nС����charlotte���ƹ�cucumber��\n" +
            "˿��fuzzy melon/towel gourd��«��asparagus��\n����wild rice shoots�����onion��\n" +
            "ɽ��sweet potato��ɽҩyam���ཷgreen pepper��\n������chilli���㶹pea���ⶹharicot��\n" +
            "С�ⶹlentil��ë��green soy bean���ƶ�/��soybean��\n�϶�fava bean������cowpea��" +
            "�̶�mung bean����ѿbean sprout������pumpkin��\n����white gourd�����bitter gourd������garlic"
	};
	
	private JPanel panel01=new JPanel();
	private JButton btn_last=new JButton("��һҳ");
	private JButton btn_next=new JButton("��һҳ");
	private JButton fanhui=new JButton("����");
	
	
	private JMenu jm01=new JMenu("�ֺ�");
	private JMenuItem item01=new JMenuItem("12");
	private JMenuItem item02=new JMenuItem("15");
	private JMenuItem item03=new JMenuItem("18");
	private JMenuItem item04=new JMenuItem("20");
	private JMenu jm02=new JMenu("����");
	private JMenuItem item05=new JMenuItem("����");
	private JMenuItem item06=new JMenuItem("����");
	private JMenuItem item07=new JMenuItem("����");
	private JMenu jm03=new JMenu("����");
	private JMenuItem item08=new JMenuItem("����");
	private JMenuItem item09=new JMenuItem("�Ӵ�");
	private JMenuItem item10=new JMenuItem("��б");
	private JMenu jm04=new JMenu("��ɫ");
	private JMenuItem item11=new JMenuItem("��ɫ");
	private JMenuItem item12=new JMenuItem("��ɫ");
	private JMenuItem item13=new JMenuItem("��ɫ");
	private JMenu jm05=new JMenu("����");
	private JMenuItem item14=new JMenuItem("����ֽ");
	private JMenuBar mb =new JMenuBar();
	
	private int photoNum=1;
	private JPanel imagepanel;
	private ImageIcon bg=new ImageIcon("photo//photo"+photoNum+".jpg");//����ͼ
	private JLabel label=new JLabel(bg);//�ѱ���ͼ��ʾ�ڱ�ǩ��
	
	private int pageNum=1;//ҳ��
	
	DanCi(){  //���캯������ʼ��
		text01.setText(str[0]);
		text01.setLineWrap(true);//�Զ�����
		text01.setFont(new Font(style,pattern,size));
		text01.setOpaque(false);  //��Ϊ͸��
		this.add(text01,BorderLayout.CENTER);
		
		btn_last.setEnabled(false);
		btn_next.setEnabled(true);
		panel01.add(btn_last);
		panel01.add(btn_next);
		panel01.add(fanhui);
		panel01.setOpaque(false); //��Ϊ͸��
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
		
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight()); //���ñ߽�
		imagepanel=(JPanel)this.getContentPane();//����������ת��Ϊ���
		imagepanel.setOpaque(false);//��Ϊ͸��
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼ��ӵ��ֲ���ײ�
		
		
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
				//�˴�����¼��������
				if(e.getSource()==fanhui){//
					dispose();
					ChooseEnglish g=new ChooseEnglish();
					g.setTitle("Ӣ��ѧϰϵͳ");
					g.setSize(500, 300);
					g.setVisible(true);
					g.setResizable(false);//���ڲ������ô�С
					}

				
				if(e.getSource()==btn_last){//��һҳ
					if(pageNum>1){//��ǰ���ǵ�һҳ
						pageNum--;
						btn_last.setEnabled(true);
						btn_next.setEnabled(true);
					}
					if(pageNum==1){//��ǰ�ǵ�һҳ
						btn_last.setEnabled(false);
						btn_next.setEnabled(true);

					}
				}
	            if(e.getSource()==btn_next){//��һҳ
	            	if(pageNum<str.length){//��ǰ��Ϊ���һҳ
	            		pageNum++;
	            		btn_last.setEnabled(true);
	            		btn_next.setEnabled(true);	            		
	            	}
	            	if(pageNum==str.length){//��ǰΪ���һҳ
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
					style="����";
				}
				if(e.getSource()==item06){					
					style="����";
				}
				if(e.getSource()==item07){					
					style="����";
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
