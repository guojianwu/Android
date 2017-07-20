import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.crypto.NullCipher;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PhotoCanvas extends JPanel implements MouseListener{

	private Cell cell[]=new Cell[9];   //����9����Ԫ��
	private Rectangle nullRectangle;
	
	public static int phtotID=1;   //ͼƬ��ID
	public static int stepNum=0;
	public boolean hasAddAtionListener=false;  //�Ƿ�����¼�������
	
      PhotoCanvas() {
    	  this.setLayout(null);
    	  for(int i=0;i<3;i++){
    		  for(int j=0;j<3;j++){
    			  int index=i*3+j;  //012345678
    			  String filename="image//p"+PhotoCanvas.phtotID+"_"+index+".jpg";
    			  ImageIcon icon=new ImageIcon(filename);  //����ͼƬ
    			  cell[index]=new Cell("", icon);  //����ͼƬ��Ԫ��
    			  cell[index].setLocation(10+j*140,20+i*140);  //����λ��
    			  this.add(cell[index]);  //�ѵ�Ԫ�����ƴͼ��
    			  
    		  }
    	  }
    	  this.remove(cell[8]);
    	  nullRectangle=new Rectangle(10+2*140, 20+2*140, 140, 140); //�յ�Ԫ��
	}
      public void reLoadPhotoAddNumber(){   //���¼���ͼƬ�����������ʾ
    	  for(int i=0;i<3;i++){
    		  for(int j=0;j<3;j++){
    			  int index=i*3+j;  //012345678
    			  String filename="image//p"+PhotoCanvas.phtotID+"_"+index+".jpg";
    			  ImageIcon icon=new ImageIcon(filename);  //����ͼƬ
    			  cell[index].setIcon(icon);
    			  cell[index].setLocation(10+j*140,20+i*140);  //����λ��
    			  cell[index].setText(""+(index+1));  
    			  
    		  }
    	  }
    	  this.remove(cell[8]);
    	  nullRectangle=new Rectangle(10+2*140, 20+2*140, 140, 140); //�յ�Ԫ��
      
    	  if(hasAddAtionListener){
    		  for(int i=0;i<8;i++){
    			  cell[i].removeMouseListener(this);
    		  }
    		  hasAddAtionListener=false;
    	  }
      
      }
      
      public void reLoadPotoClearNumber(){
    	  for(int i=0;i<3;i++){
    		  for(int j=0;j<3;j++){
    			  int index=i*3+j;  //012345678
    			  String filename="image//p"+PhotoCanvas.phtotID+"_"+index+".jpg";
    			  ImageIcon icon=new ImageIcon(filename);  //����ͼƬ
    			  cell[index].setIcon(icon);
    			  cell[index].setLocation(10+j*140,20+i*140);  //����λ��
    			  cell[index].setText("");  
    			  
    		  }
    	  }
    	  this.remove(cell[8]);   
    	  nullRectangle=new Rectangle(10+2*140, 20+2*140, 140, 140); //�յ�Ԫ��
      
    	  if(hasAddAtionListener){
    		  for(int i=0;i<8;i++){
    			  cell[i].removeMouseListener(this);
    		  }
    		  hasAddAtionListener=false;
    	  }
      }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {  //��갴��ʱ���õĺ���
		// TODO Auto-generated method stub
		Cell button=(Cell)e.getSource();  //��ȡ��ǰ����ĵ�Ԫ��
		int clickx=button.getBounds().x;  //��ȡ�����Ԫ�������
		int clicky=button.getBounds().y;
		int nullx=nullRectangle.getBounds().x;  //��ȡ�յ�Ԫ�������
		int nully=nullRectangle.getBounds().y;
		
	    //��ǰ����ĵ�Ԫ��Ϳյ�Ԫ����бȽ�
		if(clickx==nullx && clicky-nully==140){  //������ǿյ�Ԫ������ĵ�Ԫ��
			button.move("UP");
		}else if(clickx==nullx && clicky-nully==-140){  //������ǿյ�Ԫ������ĵ�Ԫ��
			button.move("DOWN");
		}else if(clickx-nullx==140 && clicky==nully){   //������ǿյ�Ԫ������ĵ�Ԫ��
			button.move("LEFT");
		}else if(clickx-nullx==-140 && clicky==nully){   //������ǿյ�Ԫ������ĵ�Ԫ��
			button.move("RIGHT");
		}else{
			return;  //�������ƶ�������
		
		}
		nullRectangle.setLocation(clickx, clicky);  //���¿յ�Ԫ���λ��
		this.repaint(); //���»���ƴͼ������
		stepNum++;
		PuzzleGame.text_step.setText("���߲���:"+stepNum);
		//�ж���Ϸ�Ƿ����
		if(checkFinish()){
			//����������ʾ
			JOptionPane.showMessageDialog(this, "��ϲ��!���ƴͼ��Ϸ!\n���ò���:"+stepNum);
		    //ȡ��ÿ����Ԫ�����������
			for(int i=0;i<8;i++){
				cell[i].removeMouseListener(this);
			}
			hasAddAtionListener=false;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void startGame(){  //��ʼ��Ϸ
		if(!hasAddAtionListener){
			for(int i=0;i<8;i++){
				cell[i].addMouseListener(this);  //��ӵ�Ԫ��ļ�����
				
			}
			hasAddAtionListener=true;
		}
		while (cell[0].getBounds().x<=150 && cell[0].getBounds().y<=160 ) {
			//����1����Ԫ��������ϽǽϽ������е�Ԫ�񻥻�
			int nullx=nullRectangle.getBounds().x;  //�յ�Ԫ��λ��
			int nully=nullRectangle.getBounds().y;
			
			//�������һ�����򣬽��е�Ԫ������ͨ��Ԫ�񻥻�
			int direction=(int)(Math.random()*4);   //0  1  2  3
			switch (direction) {
			case 0:   //�յ�Ԫ�������ƣ���ߵ�Ԫ��������
				nullx=nullx-140;
				cellmove(nullx, nully, "RIGHT");
				break;
			case 1:      //�յ�Ԫ�������ƣ��ұߵ�Ԫ��������
				nullx=nullx+140;
				cellmove(nullx, nully, "LEFT");
				break;
			case 2:       //�յ�Ԫ�������ƣ��ϱߵ�Ԫ��������
				nully=nully-140;
				cellmove(nullx, nully, "DOWN");
				break;
			case 3:        //�յ�Ԫ�������ƣ��±ߵ�Ԫ��������
				nully=nully+140;
				cellmove(nullx, nully, "UP");
				break;
			}
		}
	}
	
	public void cellmove(int nullx,int nully,String direction){ //��Ԫ����յ�Ԫ��λ�õĻ���
		for(int i=0;i<9;i++){
			if(cell[i].getBounds().x==nullx && cell[i].getBounds().y==nully){
				cell[i].move(direction);  //��ǰ��Ԫ����ƶ�
				nullRectangle.setLocation(nullx, nully); //�յ�Ԫ����ƶ�
				break;  //����λ�ú󣬽���ѭ��
			}
		}
	}
	
	public boolean checkFinish(){
		for(int i=0;i<8;i++){  //���������ж��Ƿ����ƴͼ
			int x=cell[i].getBounds().x;
			int y=cell[i].getBounds().y;
			if(((y-20)/140*3+(x-10)/140)!=i){  //���û�����ƴͼ���Ż�false
				
				
				return false;	
			}		
		}
		return true;
	}
	
	
	
      
}
