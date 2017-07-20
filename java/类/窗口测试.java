import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;


public class g {
	Frame f=new Frame("测试");
	Button ok =new Button("确定");
	TextField name=new TextField(50);
	Choice colorChooser=new Choice();
	
	CheckboxGroup cbg=new CheckboxGroup();//创建组，cbg为组名
	Checkbox male=new Checkbox("男",cbg,true);
	Checkbox female=new Checkbox("女",cbg,false);
	Checkbox married=new Checkbox("是否已婚？",false);
	TextArea ta=new TextArea(5,20);
	List colorList =new List(6,true);
	//在init方法里
	public void init(){
		colorChooser.add("红色");
        colorChooser.add("绿色");
        colorChooser.add("蓝色");
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");
        
        Panel bottom = new Panel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom , BorderLayout.SOUTH);
		
		
		f.add(bottom,BorderLayout.SOUTH);
		Box top=Box.createHorizontalBox();//创建水平盒子
		Box topLeft=Box.createVerticalBox();//创建垂直盒子
		topLeft.add(ta);
		
		Panel checkPanel=new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		topLeft.add(checkPanel);
		top.add(topLeft);
		top.add(colorList);
		f.add(top);
		f.setVisible(true);
		f.pack();
    }
	public static void main(String[] args){
		new g().init();
	}
	}
