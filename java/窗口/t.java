import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JFrame;

public class t{
        public static void main(String[] args){
                Frame f = new JFrame("测试窗口");
                Box horizontal = Box.createHorizontalBox();
                Box vertical = Box.createVerticalBox();
                horizontal.add(new Button("水平按钮一"));
                horizontal.add(new Button("水平按钮二"));
                vertical.add(new Button("垂直按钮一"));
                vertical.add(new Button("垂直按钮二"));
                f.add(horizontal , BorderLayout.NORTH);
                f.add(vertical);
                f.pack();
                f.setVisible(true);

        }
}
