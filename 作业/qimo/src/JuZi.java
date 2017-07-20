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
	private String style="����";
	private int pattern=Font.PLAIN;
	private String str[]=new String[]{
			      "  1��Ӣ�ģ�You have to believe in yourself . That's the secret of success.\n"+
                  "  ���ģ��˱��������Լ������ǳɹ����ؾ���\n"
					+ "  2��Ӣ�ģ�You can��t have a better tomorrow if you don��t stop thinking about yesterday.\n"
					+ "  ���ģ�������޷��������죬�Ͳ�����һ�����õ����졣\n"
					+ "  3��Ӣ�ģ�While there is life there is hope.\n"
					+ "  ���ģ�һϢ���棬ϣ������\n"
					+ "  4��Ӣ�ģ�When there��s no expectation, losing won��t bring hurt, gaining makes you surprised.\n"
					+ "  ���ģ���ȥ������ʧȥ�˲������ģ��õ��˱��Ǿ�ϲ��\n"
					+ "  5��Ӣ�ģ�What today will be like is up to me , I get to choose what kind of day I will have.\n"
					+ "  ���ģ�����ʲô������ȫ���Ҿ��������������ȹ�������ѡ��\n",

			       "   1��Ӣ�ģ�The road of life is like a large river,because of the power of the currents,river courses appear unexpectedly where there is no flowing water.\n"
					+ "  ���ģ������ĵ�·����һ����ӣ����ڼ�������ĳ�������ڴ�ǰû��ˮ���ĵط�����ˢ��ո�µ����ϲ����ĺӵ���\n"
					+"  2��Ӣ�ģ�There will be no regret and sorrow if you fight with all your strength.\n"
					+ "  ���ģ�ֻҪȫ����ƴ�����Ͳ������ź���û�к�ڡ�\n"
					+"  3��Ӣ�ģ�Time is a bird for ever on the wing.\n"
					+ "  ���ģ�ʱ����һֻ��Զ�ڷ������\n"
					+"  4��Ӣ�ģ�Time will never change and stop for any person.\n"
					+ "  ���ģ�ʱ�䲻���κ������棬Ҳ����Ϊ˭��ͣ����\n"
					+"  5��Ӣ�ģ�Today, give a stranger one of your smiles. It might be the only sunshine he sees all day.\n"
					+ "  ���ģ����죬��һ��İ�����������΢Ц�ɡ��ܿ��ܣ�������һ���м�����Ψһ�����⡣\n"
					+"  6��Ӣ�ģ�Victory won't come to me unless I go to it.\n"
					+ "  ���ģ�ʤ���ǲ��������������ģ��ұ����Լ�����ʤ����\n",
			
			       "  Ӣ�ģ�Walk the road you want to walk and do what you want to do , keep moving ahead and that��s not the silence of failure.\n"
					+ "  ���ģ����Լ����ߵ�·�����Լ���ɵ��£��¸���ǰ��������㲻�ܵĳ�Ĭ��\n"
					+

					"  Ӣ�ģ�We all have moments of desperation. But if we can face them head on, that��s when we find out just how strong we really are.\n"
					+ "  ���ģ����Ƕ��о�����ʱ��ֻ�����¸����ʱ�����ǲ�֪�������ж��ǿ��\n"
					+

					"  Ӣ�ģ�We must accept finite disappointment, but we must never lose infinite hope.\n"
					+ "  ���ģ����Ǳ������ʧ������Ϊ�������޵ģ���ǧ�򲻿�ʧȥϣ������Ϊ��������ġ�\n"
					+

					"  Ӣ�ģ�The future is scary but you can��t just run to the past cause it��s familiar.\n"
					+ "  ���ģ�δ������������η�壬��������ȴ������Ϊϰ���˹�ȥ�����ӻع�ȥ��\n"
					+

					"  Ӣ�ģ�The first step is as good as half over.\n"
					+ "  ���ģ���һ������ؼ���һ����\n"

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
	
	
	
	JuZi(){  //���캯������ʼ��
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
