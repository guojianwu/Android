

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

	JFrame jf = new JFrame("С���´����");
    JTextArea tf = new JTextArea(20,40);
    JButton bt1 = new JButton("��һҳ");
    JButton bt2 = new JButton("��һҳ");
    JPanel p2 = new JPanel();
    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    
    
    int size = 10;
    String style = "����";
    int pattern = Font.PLAIN;
  
    
    JMenuBar mb = new JMenuBar();
    JMenu zihao = new JMenu("�ֺ�");
    JMenu ziti = new JMenu("����");
    JMenu zixing = new JMenu("����");
    JMenu yanse = new JMenu("��ɫ");
    JMenu shezhi = new JMenu("����");
    
    JMenuItem seventeen = new JMenuItem("17");
    JMenuItem eighteen = new JMenuItem("18");
    JMenuItem nineteen = new JMenuItem("19");
    JMenuItem Twenty = new JMenuItem("20");
    
    JMenuItem songti = new JMenuItem("����");
    JMenuItem heiti = new JMenuItem("����");
    JMenuItem kaiti = new JMenuItem("����");
    
    JMenuItem changgui = new JMenuItem("����");
    JMenuItem jiacu = new JMenuItem("�Ӵ�");
    JMenuItem qingxie = new JMenuItem("��б");
    
    JMenuItem hongse = new JMenuItem("��ɫ");
    JMenuItem lvse = new JMenuItem("��ɫ");
    JMenuItem lanse = new JMenuItem("��ɫ");
    
    JMenuItem bizhi = new JMenuItem("��ֽ");
    
    String str[] = new String[]{"С���£��ĸ���\n��һλ����ѧ�ң�ִҵ���꣬����˺ܴ�ĳɹ����ھ���ѧ�����кܸߵ�������������ǰ��Ҫ����ʱ�������ڰ����Լ��ı�����������õ���ʦ��������ν�ġ��ĸ�С�֡�.ͷ�������ǡ�Ҫ�ǡ�.��˵����������ಡ�ˣ���ʱ�䶼�����廳�����ϣ���ڵ���������û�������£���Ҫ�������Ǵ�����ǰ׼���ú�һ�㡭�������ߡ�Ҫ���ҵ������˻�ư࡭�������ڰûڵĺ������������صľ������ġ������ķ����ܼ򵥣�ֻҪ����Ĵʻ���Ĩ����Ҫ�ǡ����֣����á��´Ρ����ּ��ɡ�Ӧ�����Լ�˵�����´����л�����Ӧ���������������������˷�ʱ���Ī���ڰûڡ�ǧ��Ҫ���ǵ��������Ĺ����������ں�ڼ���ʱ����Լ�˵�����´��Ҳ�����������" ,
			" С���£�����\nA�ں��ʹ�˾�����죬�����Լ���ǻ����û�еõ��ϼ�����ʶ�������룺�����һ���ܼ������ܣ��л���չʾһ���Լ��ĲŸɾͺ��ˣ���  A��ͬ��B��Ҳ��ͬ�����뷨��������һ����ȥ�����������°��ʱ�䣬�������Ż��ں�ʱ�����ݣ���Ҳ�����ʱ��ȥ�����ݣ�ϣ�����������ܣ��л�����Դ���к������ǵ�ͬ��C����һ��������ϸ�˽����ܵķܶ����̣�Ū�����ܱ�ҵ��ѧУ���˼ʷ�񣬹��ĵ����⣬��������˼����ȴ�з����Ŀ����ף�����õ�ʱ��ȥ�������ݣ������ܴ�������к���������һ������ܳ�̸��һ�Σ����þ���ȡ���˸��õ�ְλ����������ߴ�ʧ���ᣬ������ץ���ᣬ�ɹ��ߴ�����ᡣ����ֻ��׼���õ��ˣ���׼�����֣�����˵˵���ѡ�",
			"С���£���������\n�����и�С�����й���������������һģһ���Ľ��ˣ���̻Իͣ��ѻʵ۸��˻��ˡ�������С���������ͬʱ��һ����Ŀ�������������ĸ����м�ֵ?�ʵ��������İ취�������鱦����飬��������������������һģһ���ġ���ô��?ʹ�߻����Ż�ȥ�㱨�ء������������������С�¶�������?�����һλ��λ���ϴ�˵���а취���ʵ۽�ʹ���뵽���ϳ����г���������������ݣ������һ�����˵Ķ�����⵾�ݴ���һ�߶�������ˡ��ڶ������˵ĵ��ݴ������ֱ�ӵ������������������ˣ����ݽ�ȥ������˶��ӣ�ʲô�춯Ҳû�С��ϳ�˵���������������м�ֵ!ʹ��ĬĬ�������ȷ�� ��������м�ֵ���ˣ���һ��������˵���˵��ˡ������������ֻ����һ����ͣ��������������Ƕ�����˵�ġ��������������ǳ����������������ʡ�"
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
		
		jl2.setText("��"+num+"ҳ");
		p2.add(bt1);
		p2.add(jl2);
		p2.add(bt2);
		p2.setOpaque(false);
		bt1.setEnabled(false);
		jf.add(p2,BorderLayout.SOUTH);
		
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		imagePanel = (JPanel)jf.getContentPane();
		imagePanel.setOpaque(false);
		//�ѱ���ͼ��ӵ��ֲ����Ͳ�
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
					jl2.setText("��"+num+"ҳ");
					if(num>2)
						bt2.setEnabled(false);
				}
				if(e.getSource() == bt1){
					num--;
					tf.setText(str[num-1]);
					bt2.setEnabled(true);
					jl2.setText("��"+num+"ҳ");
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
					tf.setFont(new Font("����",pattern,size));
					style = "����";
				}
				if(e.getSource() == heiti){
					tf.setFont(new Font("����",pattern,size));
					style = "����";
				}
				if(e.getSource() == kaiti){
					tf.setFont(new Font("����",pattern,size));
					style = "����";
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
					//�ѱ���ͼ��ӵ��ֲ����Ͳ�
					jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE+photoNum-1));
					
				}
			}
		};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Test().init();
		
		
	}
}
