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
	private String style="����";
	private int pattern=Font.PLAIN;
	/*private String str[]=new String[]{
			"    С���£�\n�ĸ�����һλ����ѧ�ң�ִҵ���꣬����˺ܴ�ĳɹ���" +
			"�ھ���ѧ�����кܸߵ�������������ǰ��Ҫ����ʱ�������ڰ����Լ��ı�����������õ���ʦ��" +
			"������ν�ġ��ĸ�С�֡�.ͷ�������ǡ�Ҫ�ǡ�.��˵����������ಡ�ˣ���ʱ�䶼�����廳�����ϣ�" +
			"��ڵ���������û�������£���Ҫ�������Ǵ�����ǰ׼���ú�һ�㡭�������ߡ�Ҫ���ҵ������˻�ư࡭����" +
			"���ڰûڵĺ������������صľ������ġ������ķ����ܼ򵥣�ֻҪ����Ĵʻ���Ĩ����Ҫ�ǡ����֣����á��´Ρ����ּ��ɡ�" +
			"Ӧ�����Լ�˵�����´����л�����Ӧ���������������������˷�ʱ���Ī���ڰûڡ�" +
			"ǧ��Ҫ���ǵ��������Ĺ����������ں�ڼ���ʱ����Լ�˵�����´��Ҳ�����������",	
			
			"  С���£�\n����A�ں��ʹ�˾�����죬�����Լ���ǻ����û�еõ��ϼ�����ʶ�������룺�����һ���ܼ�������" +
			"���л���չʾһ���Լ��ĲŸɾͺ��ˣ���  A��ͬ��B��Ҳ��ͬ�����뷨��������һ����" +
			"ȥ�����������°��ʱ�䣬�������Ż��ں�ʱ�����ݣ���Ҳ�����ʱ��ȥ�����ݣ�" +
			"ϣ�����������ܣ��л�����Դ���к������ǵ�ͬ��C����һ��������ϸ�˽����ܵķܶ����̣�" +
			"Ū�����ܱ�ҵ��ѧУ���˼ʷ�񣬹��ĵ����⣬��������˼����ȴ�з����Ŀ����ף�" +
			"����õ�ʱ��ȥ�������ݣ������ܴ�������к���������һ������ܳ�̸��һ�Σ�" +
			"���þ���ȡ���˸��õ�ְλ����������ߴ�ʧ���ᣬ������ץ���ᣬ�ɹ��ߴ�����ᡣ" +
			"����ֻ��׼���õ��ˣ���׼�����֣�����˵˵���ѡ�",
			
			" С���£�\n�������������и�С�����й���������������һģһ���Ľ��ˣ�" +
			"��̻Իͣ��ѻʵ۸��˻��ˡ�������С���������ͬʱ��һ����Ŀ��" +
			"�����������ĸ����м�ֵ?�ʵ��������İ취�������鱦����飬��������" +
			"������������һģһ���ġ���ô��?ʹ�߻����Ż�ȥ�㱨�ء���������" +
			"���������С�¶�������?�����һλ��λ���ϴ�˵���а취��" +
			"�ʵ۽�ʹ���뵽���ϳ����г���������������ݣ������һ�����˵Ķ����" +
			"�⵾�ݴ���һ�߶�������ˡ��ڶ������˵ĵ��ݴ������ֱ�ӵ������������������ˣ�" +
			"���ݽ�ȥ������˶��ӣ�ʲô�춯Ҳû�С��ϳ�˵���������������м�ֵ!ʹ��ĬĬ���" +
			"����ȷ�� ��������м�ֵ���ˣ���һ��������˵���˵��ˡ������������ֻ����һ����ͣ�" +
			"�������������Ƕ�����˵�ġ��������������ǳ����������������ʡ�"
	};*/
	private static String str[]=new String[4];
	
	private JPanel panel01=new JPanel();
	private JButton btn_last=new JButton("��һҳ");
	private JButton btn_next=new JButton("��һҳ");
	
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
	
	
	
	Stroy(){  //���캯������ʼ��
		//text01.setText(str[0]);
		text01.setLineWrap(true);//�Զ�����
		text01.setFont(new Font(style,pattern,size));
		text01.setOpaque(false);  //��Ϊ͸��
		this.add(text01,BorderLayout.CENTER);
		
		btn_last.setEnabled(false);
		btn_next.setEnabled(true);
		panel01.add(btn_last);
		panel01.add(btn_next);
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
		;
	}
	
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Stroy s=new Stroy();
		s.setTitle("�����С����");
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
				//�˴�����¼��������
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
		
		public String readFile(InputStream inStream){//��ȡ�ļ��е�����
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
