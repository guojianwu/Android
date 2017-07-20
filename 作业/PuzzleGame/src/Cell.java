import javax.swing.Icon;
import javax.swing.JButton;


public class Cell extends JButton {
	
	public Cell(String text,Icon icon) {   //���ֺ�ͼƬ
		
		this.setSize(140,140);  //���õ�Ԫ��Ĵ�С
		this.setIcon(icon);
		this.setHorizontalTextPosition(CENTER);  //����ˮƽ����
		this.setVerticalTextPosition(CENTER);  //���ִ�ֱ����
		
	}
	
	public void move(String direction){//��������
		if(direction=="UP"){
			this.setLocation(this.getBounds().x,this.getBounds().y-140);
		}
		else if(direction=="DOWN"){
			this.setLocation(this.getBounds().x,this.getBounds().y+140);
		}
		else if(direction=="LEFT"){
			this.setLocation(this.getBounds().x-140,this.getBounds().y);
		}
		else if(direction=="RIGHT"){
			this.setLocation(this.getBounds().x+140,this.getBounds().y);
		}
	}

}
