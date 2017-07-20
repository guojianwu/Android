import javax.swing.Icon;
import javax.swing.JButton;


public class Cell extends JButton {
	
	public Cell(String text,Icon icon) {   //文字和图片
		
		this.setSize(140,140);  //设置单元格的大小
		this.setIcon(icon);
		this.setHorizontalTextPosition(CENTER);  //文字水平居中
		this.setVerticalTextPosition(CENTER);  //文字垂直居中
		
	}
	
	public void move(String direction){//上下左右
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
