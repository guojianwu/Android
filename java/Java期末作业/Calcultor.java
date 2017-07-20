  
  
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
  
  
  
public class Calcultor extends WindowAdapter implements ActionListener   
{  
	
	
	   public Calcultor()  
	    {  
	        JFrame f = new JFrame("计算器");  
	        
	        
	        MenuBar mb =new MenuBar();
	   	    Menu bj=new Menu("编辑(E)");
	   	    Menu ck=new Menu("查看(V)");
	   	    Menu bz=new Menu("帮助(H)");	   	    
	   	
	      MenuItem fz=new MenuItem("复制(C)",new MenuShortcut(KeyEvent.VK_C));
	      MenuItem zt=new MenuItem("粘贴(P)",new MenuShortcut(KeyEvent.VK_V));
	      MenuItem jl=new MenuItem("历史记录(Y)",new MenuShortcut(KeyEvent.VK_X)); 
	      
	   	   MenuItem xj=new MenuItem("标准型(T)",new MenuShortcut(KeyEvent.VK_N));
	 	   MenuItem dk=new MenuItem("科学型(S)",new MenuShortcut(KeyEvent.VK_O));
	 	   
	 	  MenuItem hy=new MenuItem("关于计算机(T)",new MenuShortcut(KeyEvent.VK_N));
	 	   MenuItem ckbz=new MenuItem("查看帮助(S)",new MenuShortcut(KeyEvent.VK_O));	   	    
	 	  
	 	      bj.add(fz);
	 	      bj.add(zt);
	 	      bj.addSeparator(); 
	 	      bj.add(jl);
	 	      
	 	      ck.add(xj);
	 	      ck.add(dk);
	 	      
	 	      bz.add(ckbz);
	 	      bz.addSeparator(); 
	 	      bz.add(hy);
	 	      
	    	  mb.add(bj);
	 	      mb.add(ck);
	 	      mb.add(bz);
	 	      f.setMenuBar(mb);
	                  
	         t = new JTextField(); 
	        t.setHorizontalAlignment(JTextField.RIGHT);
	        f.add(t,BorderLayout.NORTH);     
	        f.addWindowListener(this); 
	        JLabel a1=new JLabel(" ");
	   	    JLabel a2=new JLabel(" ");
	        JButton bc= new JButton("C");  
	        JButton bbs= new JButton("backspace"); 
	        JButton bjia=new JButton("+");  
	        JButton bjian=new JButton("-");  
	        JButton bchen=new JButton("*");  
	        JButton bchu=new JButton("/");  
	        JButton bdian=new JButton(".");  
	        JButton bdeng=new JButton("="); 
	        JButton b0= new JButton("0");  
	        JButton b1= new JButton("1");  
	        JButton b2=new JButton("2");  
	        JButton b3=new JButton("3");  
	        JButton b4=new JButton("4");  
	        JButton b5=new JButton("5");  
	        JButton b6=new JButton("6");  
	        JButton b7=new JButton("7");  
	        JButton b8=new JButton("8");  
	        JButton b9=new JButton("9");           
	         b0.addActionListener(this);  
	         b1.addActionListener(this);  
	         b2.addActionListener(this);  
	         b3.addActionListener(this);  
	         b4.addActionListener(this);  
	         b5.addActionListener(this);  
	         b6.addActionListener(this);  
	         b7.addActionListener(this);  
	         b8.addActionListener(this);  
	         b9.addActionListener(this);  
	         bc.addActionListener(this);  
	         bbs.addActionListener(this);  
	         bjia.addActionListener(this);  
	         bjian.addActionListener(this);  
	         bchen.addActionListener(this);  
	         bchu.addActionListener(this);  
	         bdian.addActionListener(this);  
	         bdeng.addActionListener(this);  
	         Panel p = new Panel();  
	        
	      	 p.add(b7);
	      	 p.add(b8);
	      	 p.add(b9);
	      	 p.add(bchu);
	      	 p.add(b4);
	      	 p.add(b5);
	      	 p.add(b6);
	      	 p.add(bchen);
	      	 p.add(b1);
	      	 p.add(b2);
	      	 p.add(b3);
	      	 p.add(bjian);
	      	 p.add(b0);
	      	 p.add(bdian);
	      	 p.add(bjia);
	      	 p.add(bdeng);
	      	  p.add(a1);
	         p.add(bbs);
	      	 p.add(bc);
	      	  p.add(a2);
	      	 
	      	 p.setLayout(new GridLayout(5,4));  
	         f.add(p); 
	          
	         f.setSize(430,250); 
	         f.setVisible(true);  
	    }  
	
	
	
    String s ;  
    JTextField t;  
    double num1;  
    double num2;  
    int x;  
   
    public void actionPerformed(ActionEvent e)  
    {  

        if(e.getActionCommand().equals("C"))  
        t.setText("");  
        
        else if(e.getActionCommand().equals("backspace"))  
        {  

   	     s = t.getText();   	   
   	     s=new String (s.substring(0,s.length()-1));    
   	  
   	   t.setText(s);  
        }
        
        else if(e.getActionCommand().equals("+"))  
        {  //t.setText(  t.getText()+e.getActionCommand() );
            s = t.getText();  
            num1 = Double.parseDouble(s);  
            t.setText("");  
            x=0;  
        }  
        else if(e.getActionCommand().equals("-"))  
        {  
            s = t.getText();  
            num1 = Double.parseDouble(s);  
            t.setText("");  
            x=1;  
        }  
        else if(e.getActionCommand().equals("*"))  
         {  
                s=t.getText();  
                num1=Double.parseDouble(s);  
                t.setText("");  
                x=2;  
          }  
         else if(e.getActionCommand().equals("/"))  
            {  
                s=t.getText();  
                num1=Double.parseDouble(s);  
                t.setText("");  
                x=3;  
            }  
         else if(e.getActionCommand().equals("="))  
         {  
             s = t.getText();  
             num2 = Double.parseDouble(s);  
             switch(x)  
             {  
             case  0 :
            	 t.setText("" + (num1 + num2));
            	 break;  
             case  1 :
            	 t.setText("" + (num1 - num2));
            	 break;  
             case  2 : 
            	 t.setText("" + (num1 * num2));
            	 break;  
             case  3 : 
            	 t.setText("" + (num1 / num2));
            	 break;  
             }  
              
         }  
         else if(e.getActionCommand().equals("."))  
         {  
             if(t.getText().trim().indexOf('.')!=-1){}  
             else  
             {  
                 s = t.getText();  
                 s = s + e.getActionCommand();  
                 t.setText(s);  
                   
             }  
         }  
          
         else  
         {  
             String s = t.getText();  
             s = s + e.getActionCommand();  
             t.setText(s);  
         }  
          
          
    }  
   
      
    public static void main(String[] args){  
        Calcultor guojianwu = new Calcultor();  
          
    }  
      
}   