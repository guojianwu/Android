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
	Frame f=new Frame("����");
	Button ok =new Button("ȷ��");
	TextField name=new TextField(50);//����һ�������ı���
	Choice colorChooser=new Choice();//����ʽѡ���
	
	CheckboxGroup cbg=new CheckboxGroup();//�����飬cbgΪ����
	Checkbox male=new Checkbox("��",cbg,true);
	Checkbox female=new Checkbox("Ů",cbg,false);
	Checkbox married=new Checkbox("�Ƿ��ѻ飿",false);
	TextArea ta=new TextArea(5,20);//�����ı���
	List colorList =new List(6,true);//�б�򣬿�����Ӷ�����Ŀ
	//��init������
	public void init(){
		colorChooser.add("��ɫ");
        colorChooser.add("��ɫ");
        colorChooser.add("��ɫ");
        colorList.add("��ɫ");
        colorList.add("��ɫ");
        colorList.add("��ɫ");
        
        Panel bottom = new Panel();//����һ������
      //��ȷ����ť�����ı����������
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom , BorderLayout.SOUTH);//����������
		
		
		f.add(bottom,BorderLayout.SOUTH);
		Box top=Box.createHorizontalBox();//����ˮƽ����
		Box topLeft=Box.createVerticalBox();//������ֱ����
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
