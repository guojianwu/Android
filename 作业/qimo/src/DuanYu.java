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
	private String style="����";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			"1. face to face ����桢2. far away ңԶ��\n3. far behind ���"
					+ "4. far from Զ�롢5. fall asleep ��˯��\n6. fall down ����;����;�ӡ������¡���"
					+ "7. fall ill/sick ����������8. fall in �ڡ���ʧ�ܣ�(����)������\n9. fall on top of �����ˡ������桢��"
					+ "10. fall off �ӡ���������/ˤ������\n11. fall one��s exam ���Բ�����12. fall over ������ˤ����\n13. family name ��"
					+ "14. family tree ���ס�\n15. feel afraid ���ú��¡�16. feel at home ���ڼ���һ������\n17. feel proud �е��Ժ�����"
					+ "18. feel lonely �е���į��\n19. feel like doing sth ��Ҫ��ĳ��"
					+ "20. feel tired �е�ƣ�͡�\n21. feel well ���������22. feel worried �е����ǡ�\n23. field trip Ұ�����Ρ�"
					+ "24. fight against Ϊ���ԡ���������\n25. fill with װ����26. fill in the blanks ��ա�\n27. finish doing sth. ���/��������"
					+ "28. find out ��������������֣��˽⡢\n29. find it difficult to do sth ���ֺ�����ĳ�¡�30. (sth)fit(sb)well �ǳ�����",

			"  31. fly a kite �÷��ݡ�����32. follow one��s example ���ա����İ���������\n33. follow one��s ��nstruction ����ĳ�˵�ָ��������34. for a moment һ�����"
					+ "����\n35. for a walk ɢ��������36. for ever ��Զ������\n37. for example ���硢����38. for long �ܳ����ܳ�ʱ�䡢����\n39. forget doing sth ��������ĳ�¡�����40. four times as��as���ǡ������ı���"
					+ "����\n41. form now on �Ӵ��Ժ󣬽��42. from then on ����ʱ��\n43. from��to�� �ӡ���������������44. full name ȫ��������\n45. full of װ��"
					+ "��46. get back ���أ�ȡ�ء�����\n47. get down ���������¡�����48. get dressed ���·�������\n49. get home ���ҡ�����50. get in �ռ������롢����\n51. get into ���(���⳵)������52. get lost ��·����ʧ"
					+ "\n53. get long/short �䳤/�̡�54. get off �³���ȡ�£��뿪��\n55. get on �ϳ���56. get on��with sb ��ĳ���ദ����������\n57. get on well with sb��ĳ���ദ��Ǣ��58. get married ���",

			" 59. get more exercise�������˶�������60. get out of �ӡ����������ѡ����ó����� �ӳ��⳵(�γ�)����"
					+ "\n61. get out of bed �𴲡�62. get ready for sth Ϊ������׼��\n63. get ready to do sth ׼����ĳ�¡�"
					+ "64. get up �𴲣�������\n65. get warm ��ů�͡�����66. get well Ȭ��������\n67. get together �žۡ�"
					+ "����68. get to ����(ĳ��)������\n69. get to know ����ʶ����70. get to work ��ʼ����(ѧϰ)"
					+ "\n71. give advice to �������Ὠ�顢����72. give sb ��a call ��ĳ�˴�绰������\n73. give back �黹���ͻء�"
					+ "����74. give first aid ���м��ȡ�\n75. give sb. a push ��ĳ��һ��",

			"76. give sb. a talk ��ĳ�������棬������������\n77. give��a big hug ����ӵ����������78. give�� a hand ���衭������������\n79. give a warm welcome to�� ���һ�ӭ������80. give an operation ������"
					+ "\n81. give up ����������82. give up doing sth. ������ĳ�¡�\n83. give up smoking ���̡�����84. given name ���֡�����\n85. go abroad ����;�ڹ��⡢����86. go away �߿����뿪������\n87. go extinct ���������88. go back ��ȥ������\n89. go past/by ��(·)��������90. go for a walk ȥɢ��������\n91. go for walksȥɢ��������92. go home �ؼҡ�����\n93. go on ����������94. go on doing sth.�� ������ĳ��"

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
	
	DuanYu(){  //���캯������ʼ��
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
