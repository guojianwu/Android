
import java.awt.*;import 
javax.swing.*;import 
java.awt.event.*;
public class Login extends JFrame{ 
public Login() {  
setLayout(new GridLayout(1,2));//网格布局，1行2列，放置左面板和右面板  
setTitle("发表iPhone说说");//设置窗口标题  
setSize(550,300);//设置大小  
setLocationRelativeTo(null);//设置窗口位置  
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭按钮动作 
//左面板  
JPanel leftPanel = new JPanel(); 
leftPanel.setBorder(BorderFactory.createTitledBorder("登录手机腾讯网"));//给左面板加上边框，并添加文字 
 leftPanel.setLayout(new BorderLayout());  
JPanel leftPanelTop = new JPanel();  
JPanel leftPanelBottom = new JPanel();  
leftPanel.add(leftPanelTop, BorderLayout.CENTER);  
leftPanel.add(leftPanelBottom, BorderLayout.SOUTH);  
leftPanelTop.setLayout(new GridLayout(3,2));//网格布局，3行2列        //========================请在下面写上你的代码  
JLabel qq = new JLabel("QQ号码");  
JTextField qqNum = new JTextField(10);  
JLabel pwd = new JLabel("QQ密码");  
JPasswordField  qqPwd = new JPasswordField(10);  
JLabel verify = new JLabel("验证码");  
JTextField qqVer = new JTextField(10);  
leftPanelTop.add(qq);  
leftPanelTop.add(qqNum);  
leftPanelTop.add(pwd);  
leftPanelTop.add(qqPwd);  
leftPanelTop.add(verify);  
leftPanelTop.add(qqVer);  
leftPanelBottom.setLayout(new GridLayout(1,2));  
JLabel i_vc = new JLabel(new ImageIcon("images/VerificationCode.jpg"));//这是显示验证码的标签，帮你写好了，后面直接调用即可。 
 JButton bt1 = new JButton("帐号密码登陆");  
JButton bt2 = new JButton("带验证码登陆");  
JPanel btPanel = new JPanel();  
btPanel.setLayout(new GridLayout(2,1));  
btPanel.add(bt1);  
btPanel.add(bt2);  
leftPanelBottom.add(i_vc);  
leftPanelBottom.add(btPanel);  //============================================  
add(leftPanel);//将左面板放入窗体中  //右面板  
JPanel rightPanel = new JPanel();  
rightPanel.setBorder(BorderFactory.createTitledBorder("发表iPhone说说"));//给右面板加上边框，并添加文字  
//========================请在下面写上你的代码  
JTextArea msg = new JTextArea();  
JButton submit = new JButton("马上发表说说");  
rightPanel.setLayout(new BorderLayout());  
rightPanel.add(msg, BorderLayout.CENTER);  
rightPanel.add(submit, BorderLayout.SOUTH);  
//============================================  
add(rightPanel);//将右面板放入窗体中  
setVisible(true);//使窗体可见 
} 
public static void main(String[] args){ 
 new Login(); 
}
}
