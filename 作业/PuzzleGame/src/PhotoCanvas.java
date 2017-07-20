import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.crypto.NullCipher;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PhotoCanvas extends JPanel implements MouseListener{

	private Cell cell[]=new Cell[9];   //创建9个单元格
	private Rectangle nullRectangle;
	
	public static int phtotID=1;   //图片的ID
	public static int stepNum=0;
	public boolean hasAddAtionListener=false;  //是否添加事件监听器
	
      PhotoCanvas() {
    	  this.setLayout(null);
    	  for(int i=0;i<3;i++){
    		  for(int j=0;j<3;j++){
    			  int index=i*3+j;  //012345678
    			  String filename="image//p"+PhotoCanvas.phtotID+"_"+index+".jpg";
    			  ImageIcon icon=new ImageIcon(filename);  //加载图片
    			  cell[index]=new Cell("", icon);  //创建图片单元格
    			  cell[index].setLocation(10+j*140,20+i*140);  //设置位置
    			  this.add(cell[index]);  //把单元格添加拼图区
    			  
    		  }
    	  }
    	  this.remove(cell[8]);
    	  nullRectangle=new Rectangle(10+2*140, 20+2*140, 140, 140); //空单元格
	}
      public void reLoadPhotoAddNumber(){   //重新加载图片，添加数字提示
    	  for(int i=0;i<3;i++){
    		  for(int j=0;j<3;j++){
    			  int index=i*3+j;  //012345678
    			  String filename="image//p"+PhotoCanvas.phtotID+"_"+index+".jpg";
    			  ImageIcon icon=new ImageIcon(filename);  //加载图片
    			  cell[index].setIcon(icon);
    			  cell[index].setLocation(10+j*140,20+i*140);  //设置位置
    			  cell[index].setText(""+(index+1));  
    			  
    		  }
    	  }
    	  this.remove(cell[8]);
    	  nullRectangle=new Rectangle(10+2*140, 20+2*140, 140, 140); //空单元格
      
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
    			  ImageIcon icon=new ImageIcon(filename);  //加载图片
    			  cell[index].setIcon(icon);
    			  cell[index].setLocation(10+j*140,20+i*140);  //设置位置
    			  cell[index].setText("");  
    			  
    		  }
    	  }
    	  this.remove(cell[8]);   
    	  nullRectangle=new Rectangle(10+2*140, 20+2*140, 140, 140); //空单元格
      
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
	public void mousePressed(MouseEvent e) {  //鼠标按下时调用的函数
		// TODO Auto-generated method stub
		Cell button=(Cell)e.getSource();  //获取当前点击的单元格
		int clickx=button.getBounds().x;  //获取点击单元格的坐标
		int clicky=button.getBounds().y;
		int nullx=nullRectangle.getBounds().x;  //获取空单元格的坐标
		int nully=nullRectangle.getBounds().y;
		
	    //当前点击的单元格和空单元格进行比较
		if(clickx==nullx && clicky-nully==140){  //点击的是空单元格下面的单元格
			button.move("UP");
		}else if(clickx==nullx && clicky-nully==-140){  //点击的是空单元格上面的单元格
			button.move("DOWN");
		}else if(clickx-nullx==140 && clicky==nully){   //点击的是空单元格右面的单元格
			button.move("LEFT");
		}else if(clickx-nullx==-140 && clicky==nully){   //点击的是空单元格左面的单元格
			button.move("RIGHT");
		}else{
			return;  //不满足移动的条件
		
		}
		nullRectangle.setLocation(clickx, clicky);  //更新空单元格的位置
		this.repaint(); //重新绘制拼图区界面
		stepNum++;
		PuzzleGame.text_step.setText("已走步数:"+stepNum);
		//判断游戏是否结束
		if(checkFinish()){
			//弹出窗口提示
			JOptionPane.showMessageDialog(this, "恭喜你!完成拼图游戏!\n所用步数:"+stepNum);
		    //取消每个单元格的鼠标监听器
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
	
	public void startGame(){  //开始游戏
		if(!hasAddAtionListener){
			for(int i=0;i<8;i++){
				cell[i].addMouseListener(this);  //添加单元格的监听器
				
			}
			hasAddAtionListener=true;
		}
		while (cell[0].getBounds().x<=150 && cell[0].getBounds().y<=160 ) {
			//当第1个单元格距离左上角较近，进行单元格互换
			int nullx=nullRectangle.getBounds().x;  //空单元格位置
			int nully=nullRectangle.getBounds().y;
			
			//随机产生一个方向，进行单元格与普通单元格互换
			int direction=(int)(Math.random()*4);   //0  1  2  3
			switch (direction) {
			case 0:   //空单元格向左移，左边单元格向右移
				nullx=nullx-140;
				cellmove(nullx, nully, "RIGHT");
				break;
			case 1:      //空单元格向右移，右边单元格向左移
				nullx=nullx+140;
				cellmove(nullx, nully, "LEFT");
				break;
			case 2:       //空单元格向上移，上边单元格向下移
				nully=nully-140;
				cellmove(nullx, nully, "DOWN");
				break;
			case 3:        //空单元格向下移，下边单元格向上移
				nully=nully+140;
				cellmove(nullx, nully, "UP");
				break;
			}
		}
	}
	
	public void cellmove(int nullx,int nully,String direction){ //单元格与空单元格位置的互换
		for(int i=0;i<9;i++){
			if(cell[i].getBounds().x==nullx && cell[i].getBounds().y==nully){
				cell[i].move(direction);  //当前单元格的移动
				nullRectangle.setLocation(nullx, nully); //空单元格的移动
				break;  //交换位置后，结束循环
			}
		}
	}
	
	public boolean checkFinish(){
		for(int i=0;i<8;i++){  //根据坐标判断是否完成拼图
			int x=cell[i].getBounds().x;
			int y=cell[i].getBounds().y;
			if(((y-20)/140*3+(x-10)/140)!=i){  //如果没有完成拼图，放回false
				
				
				return false;	
			}		
		}
		return true;
	}
	
	
	
      
}
