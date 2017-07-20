import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class TakeOut extends JFrame {
	//定义成员变量
     private JPanel panel01 =new JPanel();
     private JLabel label01=new JLabel("欢迎来到张家边外卖系统!");
     private JLabel label03=new JLabel("       满50元免配送费,满100元减10元!");
     
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
     private double a[]=new double[9];//食物的单价
     private double total=0;  //总价
     private JTextArea text02=new JTextArea(1,15);
     
     private final int FEE=5;
     
     private Color color[]=new Color[]{
    		Color.black,Color.red,Color.blue,Color.LIGHT_GRAY,
    		Color.yellow,Color.magenta    		
     };
     
     private Timer timer;
     private int colorIndex=0;
     
     
     //成员函数
      TakeOut() {     //构造函数，初始化工作
    	  label01.setFont(new Font("黑体",Font.PLAIN,30));
    	  label01.setForeground(Color.BLUE);
    	  //panel01.add(label01);
    	  label01.setFont(new Font("黑体",Font.PLAIN,20));
    	  label03.setForeground(Color.RED);
    	  //panel01.add(label03);
    	  panel01.setOpaque(false);  //设置透明
    	  Box box=Box.createVerticalBox();
    	  box.add(label01);
    	  box.add(label03);
    	  panel01.add(box);
    	  
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
    	  
    	  MyListener myListener=new MyListener();
    	  
    	  for(int i=0;i<9;i++){
    		  amount[i]=new JButton("1份");
    		  food[i]=new JLabel(new ImageIcon("image//food"+(i+1)+".jpg"));
    		  check[i].setOpaque(false);//设置透明
    		  panel02.add(check[i]);
    		  panel02.add(amount[i]);
    		  panel02.add(food[i]);
    		  num[i]=1;
    		  
    		  amount[i].addActionListener(myListener);//数量监听器
    		  
    		  
    	  }
    	  panel02.setOpaque(false);//设置透明
    	  this.add(panel02,BorderLayout.CENTER);
    	  
    	  list.setText("状态:未选餐");
    	  list.setBackground(Color.PINK);
    	  list.setEditable(false);
    	  panel02.add(list);
    	  
    	
    	  panel03.add(bnt_ok);
    	  panel03.add(bnt_cancel);
    	  panel03.add(label02);
    	  panel03.add(text01);
    	  panel03.add(text02);
    	  text02.setEditable(false);
    	  text02.setOpaque(false);
    	  text02.setBackground(Color.PINK);
    	  text01.setEditable(false);
    	  panel03.setOpaque(false);
    	  this.add(panel03,BorderLayout.SOUTH);
    	  
    	  a[0]=5.0;
    	  a[1]=8.0;
    	  a[2]=8.0;    	  
    	  a[3]=11.0;
    	  a[4]=12.0;
    	  a[5]=15.0;
    	  a[6]=6.0;
    	  a[7]=7.0;
    	  a[8]=6.0;
    	  
    	  bnt_ok.addActionListener(myListener);  //结算监听器
    	  bnt_cancel.addActionListener(myListener);//清空监听器
    	  
    	  
    	  timer=new Timer(1000,new timerListener());
    	  timer.start();
    	  
   
    	  
    	  
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
	
	
	
	
	
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//添加事件处理代码
			for(int i=0;i<9;i++){
				if(e.getSource()==amount[i]){
					if(num[i]<9)
						num[i]++;
					else
						num[i]=1;
					amount[i].setText(num[i]+"份");
				}
			}
			if(e.getSource()==bnt_ok){ //结算监听事件
				total=0;
				str="";
				for(int i=0;i<9;i++){
					if(check[i].isSelected()==true){
						total=total+a[i]*num[i];
						str=str+check[i].getText()+"    "+amount[i].getText()+"\n";
						
					}				
				}
				
				if(total<50 && total>0){					
					total=total+FEE;													
					text02.setText("还差"+(50-total)+"就免配送费,还差"+(100-total)+"就满100减10");
				    str=str+"配送费  5元";
				    list.setText("状态:已选餐 ！ \n"+ str+"\n");
				
				}else if(total<100){									
					text02.setText("还差"+(100-total)+"就满100减10");	
					list.setText("状态:已选餐 ！ \n"+ str+"\n");
				}
				else{									
					text02.setText("免配送费,满100减10,已参与"+total+"-10");
				    total=total-10;		
				    list.setText("状态:已选餐 ！ \n"+ str+"\n");
				}
			}
			if(total==0){
				list.setText("状态:未选餐!");
			}
			text01.setText(""+total);
			//list.setText("状态:已选餐 ！ \n"+ str+"\n");
			if(e.getSource()==bnt_cancel){//清空监听事件
				for(int i=0;i<9;i++){
					check[i].setSelected(false);
					amount[i].setText("1份");
					num[i]=1;
				}
				total=0;
				str="";
				text01.setText(""+total);
				list.setText("状态:未选餐！");
			}
			
		}
		
	}
	
	class timerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			colorIndex++;  //12%7=5
			label01.setForeground(color[colorIndex%color.length]);
			
			String tem=label01.getText();
			label01.setText(tem.substring(1,tem.length())+tem.substring(0,1));
			
			
		}
		
	}

}
