import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PhotoPreview extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		String filename="image//p"+PhotoCanvas.phtotID+".jpg";
		ImageIcon icon =new ImageIcon(filename);
		Image image=icon.getImage();
		g.drawImage(image,10,20,420,420,this);
	}
}
