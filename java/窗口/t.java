import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JFrame;

public class t{
        public static void main(String[] args){
                Frame f = new JFrame("���Դ���");
                Box horizontal = Box.createHorizontalBox();
                Box vertical = Box.createVerticalBox();
                horizontal.add(new Button("ˮƽ��ťһ"));
                horizontal.add(new Button("ˮƽ��ť��"));
                vertical.add(new Button("��ֱ��ťһ"));
                vertical.add(new Button("��ֱ��ť��"));
                f.add(horizontal , BorderLayout.NORTH);
                f.add(vertical);
                f.pack();
                f.setVisible(true);

        }
}
