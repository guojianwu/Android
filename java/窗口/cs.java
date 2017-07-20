import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;


public class cs {
    private Frame f=new Frame("测试");
    private MenuBar mb =new MenuBar();//创建一个菜单栏
    Menu file=new Menu("文件");
    Menu edit=new Menu("编辑");
    MenuItem newItem=new MenuItem("新建");
    MenuItem saveItem=new MenuItem("保存");
    MenuItem exitItem=new MenuItem("退出",new MenuShortcut(KeyEvent.VK_X));
    
    CheckboxMenuItem autowrap=new CheckboxMenuItem("自动换行");
    MenuItem copYItem =new MenuItem("复制");
    MenuItem pastItem =new MenuItem("复制");
    Menu format=new Menu("格式");
    MenuItem commentItem =new MenuItem("注释");
    MenuItem canclitem =new MenuItem("取消注释");
    
    private TextArea ta=new TextArea(6,40);
    
    public void init(){
    	file.add(newItem);
    	file.add(saveItem);
    	file.add(exitItem);
    	
    	edit.add(autowrap);
    	edit.addSeparator();   //添加分割线
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
