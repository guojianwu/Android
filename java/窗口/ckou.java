import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class ckou{
        public static void main(String[] args){
                Frame f = new Frame("���Դ���");
                f.add(new Button("��"), BorderLayout.EAST);
                f.add(new Button("��"), BorderLayout.SOUTH);
                f.add(new Button("��"), BorderLayout.WEST);
                f.add(new Button("��"), BorderLayout.NORTH);
                f.add(new Button("ȷ��"));
                f.add(new Button("ȡ��"));
                f.pack();
                f.setVisible(true);
        }
}




