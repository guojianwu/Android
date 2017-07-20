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
	private String style="����";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			          "    Dear Sir,\nI��m writing to complain about the poor quality of the trolley case. I"
					+ " bought it from your department on May 18 which cost me 800 yuan. Unfortunately, when I got home and had a careful check, I found that one wheel of the case is broken and I could not carry too much luggage in it. It cost me so much money that it should be one of good quality. But the result was really dissatisfactory."
					+ "Could you make a refund to me or have it repaired? Hope to receive your reply as soon as possible.\n "
					+ "  Yours truly,\n" + "   Li Li\n               (������鿴��һҳ)",
					"�װ�������\n    ��д�����뱧Թ�糵����������̫�����5��18�մ���Ĳ����������������800Ԫ�����ҵ��ǣ����һص���һ��ϸ����ҷ���һ�����ӻ��ˡ��Ҳ��ܴ�̫�������"+
                    "����������ô��ǮӦ�������õ�������������ܲ����⡣\n    ���������˿����������ϣ�������յ���Ļظ���\n����\n����",
			
		            	"  June 9\n  Dear Joanna,\n"
					+ "  I have two tickets for the recent movie at Nanjing Peace Cinema on Sunday, June 9. I heard it was a really wonderful film and I made great effort to get the tickets. Will you join me? I��ll be waiting for you at eight sharp Sunday night in front of the cinema, so please don��t disappoint me! Hope to hear from you soon!\n"
					+ "  Warmest regards,\n" + "  Alice\n              (������鿴��һҳ)",
					"6��9��\n�װ����ǰ���\n    ��������������Ͼ���ƽ��ӰԺ��ӳ�ĵ�ӰƱ��ʱ����6��9�ŵ����ա�����˵����һ���ܾ��ʵĵ�Ӱ���������˾޴�Ŭ���õ��˵�ӰƱ����Ը����������һ������յ����ϰ˵����ڵ�ӰԺ�ź���㡣"+
                    "���Բ�Ҫ����ʧ����ϣ��������ظ���\n��������ʺ�\n����˿",
			
			          "  10th December, 2010\n  Dear Sir/Madam,\n"
					+ "  I bought a MP3 player at your place on December 10th , but lately, I found it making noises when playing. Since it's still under warranty, I'd like to ask for free-of-charge repair. Please inform me matters in relation to postage.  Yours sincerely\n  XXX \n              (������鿴��һҳ)",
					
					"2010��12��10��\n�װ�������/Ůʿ\n�����һ��mp3������12��10������ĵط�����������ҷ��������ʱ���������������Ϊ�����ڱ������ڣ�����Ҫ�����ά�ޡ���֪ͨ������������\n��ϵ��ʺ�\nxxx",
					
					"  NOTICE\n  December 18th, 2010To improve the students' interests in learning English, the English Department will host language competition in March. All"
					+ "the students are eligible to signup and participate in it. Contest winner will sent to the municipal competitions. The Preliminary Entry Form must reach the English Department in 2010 December 21-25th.\n  English Association\n              (������鿴��һҳ)",
	                   
					"��ע��\n    2010��12��18�գ������ѧ����ѧϰӢ����Ȥ��Ӣ��ϵ���������������Եľ���������ѧ�����ʸ�ע�Ტ���롣�����ھ������͵��м������������ĵ�"+
                    "������������2010��12��21�յ�25�ս̵�Ӣ��ϵ��\nӢ��Э��"
	
	
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
	
	ZuoWen(){  //���캯������ʼ��
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
