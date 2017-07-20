import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 
public class Login extends  
JFrame implements ActionListener{ 
private final int WIDTH = 250;
private final int HEIGHT = 150;
private final String username = "abc";
private final String password = "123";
private final JButton button1;
private final JButton button2;
private final JTextField text1;
private final JTextField text2;
public Login(){this.setTitle("µÇÂ¼½çÃæ"); 
Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
this.setBounds(((int)dimension.getWidth() - WIDTH) / 2, ((int)dimension.getHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
this.setResizable(false);
this.setLayout(null);
this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
JLabel label1 = new JLabel("ÐÕÃû");
label1.setBounds(10, 10, 50, 20);
this.add(label1); 
JLabel label2 = new JLabel("ÃÜÂë");
label2.setBounds(10, 40, 50, 20);
this.add(label2); text1 = new JTextField();
text1.setBounds(70, 10, 130, 20);this.add(text1); 
text2 = new JPasswordField();
text2.setBounds(70, 40, 130, 20);
this.add(text2); 
button1 = new JButton("µÇÂ¼");
button1.setBounds(75, 75, 60, 20);button1.addActionListener(this);
this.add(button1); 
button2 = new JButton("È¡Ïû");
button2.setBounds(140, 75, 60, 20);
button2.addActionListener(this);
this.add(button2); this.setVisible(true);
} 
public void actionPerformed(ActionEvent e) {
if(e.getSource()== button1){//µÇÂ¼°´Å¥ 
if(text1.getText().equals(username)&&text2.getText().equals(password)){
JOptionPane.showMessageDialog(null, "µÇÂ¼¹¦"); 
}else{JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°ÜÓÃ»§Ãû»òÃÜÂë´íÎó", "µÇÂ¼Ê§°Ü",JOptionPane.PLAIN_MESSAGE);  
}
}
else if(e.getSource()==button2){//ÍË°´Å¥System.exit(0);
}
 }
 public static void main(String[] args){new Login();
} 
}