import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class ckou{
        public static void main(String[] args){
                Frame f = new Frame("测试窗口");
                f.add(new Button("东"), BorderLayout.EAST);
                f.add(new Button("南"), BorderLayout.SOUTH);
                f.add(new Button("西"), BorderLayout.WEST);
                f.add(new Button("北"), BorderLayout.NORTH);
                f.add(new Button("确认"));
                f.add(new Button("取消"));
                f.pack();
                f.setVisible(true);
        }
}




