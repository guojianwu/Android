
import java.awt.*;import 
javax.swing.*;import 
java.awt.event.*;
public class Login extends JFrame{ 
public Login() {  
setLayout(new GridLayout(1,2));//���񲼾֣�1��2�У����������������  
setTitle("����iPhone˵˵");//���ô��ڱ���  
setSize(550,300);//���ô�С  
setLocationRelativeTo(null);//���ô���λ��  
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڹرհ�ť���� 
//�����  
JPanel leftPanel = new JPanel(); 
leftPanel.setBorder(BorderFactory.createTitledBorder("��¼�ֻ���Ѷ��"));//���������ϱ߿򣬲�������� 
 leftPanel.setLayout(new BorderLayout());  
JPanel leftPanelTop = new JPanel();  
JPanel leftPanelBottom = new JPanel();  
leftPanel.add(leftPanelTop, BorderLayout.CENTER);  
leftPanel.add(leftPanelBottom, BorderLayout.SOUTH);  
leftPanelTop.setLayout(new GridLayout(3,2));//���񲼾֣�3��2��        //========================��������д����Ĵ���  
JLabel qq = new JLabel("QQ����");  
JTextField qqNum = new JTextField(10);  
JLabel pwd = new JLabel("QQ����");  
JPasswordField  qqPwd = new JPasswordField(10);  
JLabel verify = new JLabel("��֤��");  
JTextField qqVer = new JTextField(10);  
leftPanelTop.add(qq);  
leftPanelTop.add(qqNum);  
leftPanelTop.add(pwd);  
leftPanelTop.add(qqPwd);  
leftPanelTop.add(verify);  
leftPanelTop.add(qqVer);  
leftPanelBottom.setLayout(new GridLayout(1,2));  
JLabel i_vc = new JLabel(new ImageIcon("images/VerificationCode.jpg"));//������ʾ��֤��ı�ǩ������д���ˣ�����ֱ�ӵ��ü��ɡ� 
 JButton bt1 = new JButton("�ʺ������½");  
JButton bt2 = new JButton("����֤���½");  
JPanel btPanel = new JPanel();  
btPanel.setLayout(new GridLayout(2,1));  
btPanel.add(bt1);  
btPanel.add(bt2);  
leftPanelBottom.add(i_vc);  
leftPanelBottom.add(btPanel);  //============================================  
add(leftPanel);//���������봰����  //�����  
JPanel rightPanel = new JPanel();  
rightPanel.setBorder(BorderFactory.createTitledBorder("����iPhone˵˵"));//���������ϱ߿򣬲��������  
//========================��������д����Ĵ���  
JTextArea msg = new JTextArea();  
JButton submit = new JButton("���Ϸ���˵˵");  
rightPanel.setLayout(new BorderLayout());  
rightPanel.add(msg, BorderLayout.CENTER);  
rightPanel.add(submit, BorderLayout.SOUTH);  
//============================================  
add(rightPanel);//���������봰����  
setVisible(true);//ʹ����ɼ� 
} 
public static void main(String[] args){ 
 new Login(); 
}
}
