import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TakeOut extends JFrame {
	//定义成员变量
     private JPanel panel01 =new JPanel();
     private JLabel label01=new JLabel("欢迎来到张家边外卖系统");
     
     private JPanel panel02=new JPanel();
     private JCheckBox check[]=new JCheckBox[9];  //文字
     private JButton amount[]=new JButton[9];  //按钮
     private JLabel food[]=new JLabel[9];  //图片
     private int num[]=new int[9];   //数量数组 
        
     
     private JTextArea list=new JTextArea(10,10);
     private String str="";
     
      private JPanel panel03=new JPanel();
     private JButton bnt_ok=new JButton("结算");
     private JButton bnt_cancel=new JButton("清空");
     private JLabel label02=new JLabel("总价:");
      private JTextField text01=new JTextField(10);
     
     
     //成员函数
      TakeOut() {     //构造函数，初始化工作
    	  label01.setFont(new Font("黑体",Font.PLAIN,30));
    	  label01.setForeground(Color.BLUE);
    	  panel01.add(label01);
    	  panel01.setOpaque(false);  //设置透明
    	  this.setLayout(new BorderLayout());
    	  this.add(panel01,BorderLayout.NORTH);
    	  this.getContentPane().setBackground(Color.PINK);  //背景颜色
    	  
    	  check[0]=new JCheckBox("  雪糕   5.0元",false);
    	  check[1]=new JCheckBox("  薯条   8.0元",false);
    	  check[2]=new JCheckBox("爆米花  8.0元",false);
    	  check[3]=new JCheckBox("  热狗11.0元",false);
    	  check[4]=new JCheckBox("汉堡包12.0元",false);
    	  check[5]=new JCheckBox("巨无霸15.0元",false);
    	  check[6]=new JCheckBox("  可乐 6.0元",false);
    	  check[7]=new JCheckBox("  果汁    7.0元",false);
    	  check[8]=new JCheckBox("  啤酒    6.0元",false);
    	  
    	  for(int i=0;i<9;i++){
    		  amount[i]=new JButton("1份");
    		  food[i]=new JLabel(new ImageIcon("image//food"+(i+1)+".jpg"));
    		  check[i].setOpaque(false);//设置透明
    		  panel02.add(check[i]);
    		  panel02.add(amount[i]);
    		  panel02.add(food[i]);
    		  num[i]=1;
    	  }
    	  panel02.setOpaque(false);//设置透明
    	  this.add(panel02,BorderLayout.CENTER);
    	  
    	  list.setText("状态:未选择");
    	  list.setBackground(Color.PINK);
    	  panel02.add(list);
    	  
    	
    	  panel03.add(bnt_ok);
    	  panel03.add(bnt_cancel);
    	  panel03.add(label02);
    	  panel03.add(text01);
    	  panel03.setOpaque(false);
    	  this.add(panel03,BorderLayout.SOUTH);
    	  
    	  
    	  
	}
     
     

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TakeOut t=new TakeOut();
		t.setTitle("外卖系统");
		t.setSize(720, 550);
		t.setVisible(true);

	}

}
