import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;


public class cs {
    private Frame f=new Frame("����");
    private MenuBar mb =new MenuBar();//����һ���˵���
    Menu file=new Menu("�ļ�");
    Menu edit=new Menu("�༭");
    MenuItem newItem=new MenuItem("�½�");
    MenuItem saveItem=new MenuItem("����");
    MenuItem exitItem=new MenuItem("�˳�",new MenuShortcut(KeyEvent.VK_X));
    
    CheckboxMenuItem autowrap=new CheckboxMenuItem("�Զ�����");
    MenuItem copYItem =new MenuItem("����");
    MenuItem pastItem =new MenuItem("����");
    Menu format=new Menu("��ʽ");
    MenuItem commentItem =new MenuItem("ע��");
    MenuItem canclitem =new MenuItem("ȡ��ע��");
    
    private TextArea ta=new TextArea(6,40);
    
    public void init(){
    	file.add(newItem);
    	file.add(saveItem);
    	file.add(exitItem);
    	
    	edit.add(autowrap);
    	edit.addSeparator();   //��ӷָ���
    	edit.add(copYItem);
    	edit.add(pastItem);
    	edit.add(commentItem);
    	edit.add(canclitem );
    	edit.add(format);
    	
    	mb.add(file);
    	mb.add(edit);
    	
    	f.setMenuBar(mb);
    	f.add(ta);
    	f.pack();
    	f.setVisible(true);
    	
    }
    public static void main(String[] args){
    	new cs().init();
    }
}
