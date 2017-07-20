package com.example.mygame2048;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

public class GameView extends GridLayout{

	private Card[][] cardsMap = new Card[4][4];
	private List<Point> emptyPoints = new ArrayList<Point>();
	private float startX,startY,endX,endY,offsetX,offsetY;
	
	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initGameView();
		
	}


	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initGameView();
	}


	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initGameView();
	}


	private void initGameView() {
		//1���������񲼾ֵ�����
		setColumnCount(4);
		//2����Ӧ����
		setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				switch (arg1.getAction()) {
				case MotionEvent.ACTION_DOWN:
					//����������
					startX=arg1.getX();
					startY=arg1.getY();
					break;
				case MotionEvent.ACTION_UP:
					//����յ�����
					endX=arg1.getX();
					endY=arg1.getY();
					offsetX=endX - startX;
					offsetY=endY - startY;
					if(Math.abs(offsetX) > Math.abs(offsetY)){
						if(offsetX<-5){
							//����
							swipLeft();
						}else if(offsetX>5){
							//����
							swipRight();
						}
					}else {
						if(offsetY<-5){
							//����
							swipUp();
						}else if(offsetY>5){
							//����
							swipDown();
						}
					}
					break;
				}
				return true;
			}
		});
		
		
	}

	public void swipRight(){
		boolean merge = false; 
		for (int y = 0; y <4; y++) {
			for (int x = 3; x >= 0; x--) {
				for (int x1 = x-1; x1 >=0; x1--) {
					if(cardsMap[x1][y].getNum()>0){  //����ҵ��ұ�һ���ǿ�ֵ
						if(cardsMap[x][y].getNum() <=0 ){  //��ǰ��ֵΪ�գ����ұߵķǿ�ֵ�Ƶ����
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							x++;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x1][y])){
							//��ǰֵ�ǿգ����ұߵ�����ߣ��ϲ�
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							//��������Ҫ���·���  ����������TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
							
						}
						//����������ɲ�����Ƶ
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //�ж���Ϸ�Ƿ����
		}
		
	}
	public void swipUp(){
			
		boolean merge = false;  // ����ʶ���Ƿ���Ҫ�ڲ���һ�ſ�Ƭ���ж���Ϸ�Ƿ����
		
			
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int y1 = y+1; y1 < 4 ; y1++) {
					if(cardsMap[x][y1].getNum()>0){  //����ҵ��ұ�һ���ǿ�ֵ
						if(cardsMap[x][y].getNum() <=0 ){  //��ǰ��ֵΪ�գ����ұߵķǿ�ֵ�Ƶ����
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							y--;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x][y1])){
							//��ǰֵ�ǿգ����ұߵ�����ߣ��ϲ�
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							//��������Ҫ���·���  ����������TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
						}
						//����������ɲ�����Ƶ
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
				
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //�ж���Ϸ�Ƿ����
		}
		
		
		
		
		
	}
	public void swipDown(){
		
		boolean merge = false;  // ����ʶ���Ƿ���Ҫ�ڲ���һ�ſ�Ƭ���ж���Ϸ�Ƿ����
		
		
		for (int x = 0; x < 4; x++) {
			for (int y = 3; y >=0; y--) {
				for (int y1 = y-1; y1 >=0 ; y1--) {
					if(cardsMap[x][y1].getNum()>0){  //����ҵ��ұ�һ���ǿ�ֵ
						if(cardsMap[x][y].getNum() <=0 ){  //��ǰ��ֵΪ�գ����ұߵķǿ�ֵ�Ƶ����
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							y++;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x][y1])){
							//��ǰֵ�ǿգ����ұߵ�����ߣ��ϲ�
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							//��������Ҫ���·���  ����������TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
						}
						//����������ɲ�����Ƶ
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
				
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //�ж���Ϸ�Ƿ����
		}
		
		
		
		
		
	}
	
	
	public void swipLeft(){
		//�ȿ�ÿһ�У������ο�ÿ�е�ÿһ��
		//�Ե�һ��Ϊ������һ��Ϊ��׼����������������зǿյ�����
		//�ٻع�ͷ�жϵ�һ��
	    //�����һ�������Ϊ�գ���ʱֱ������
		//�����һ�����ݲ�Ϊ�գ����жϵ�һ��������Ƿ���ǿո��������ȣ����ǣ��ϲ�
		//�����������ֿ��ܣ�����Ҫ����һ�������Ƭ���ж���Ϸ�Ƿ����
		boolean merge = false;  // ����ʶ���Ƿ���Ҫ�ڲ���һ�ſ�Ƭ���ж���Ϸ�Ƿ����
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				for (int x1 = x+1; x1 < 4 ; x1++) {
					if(cardsMap[x1][y].getNum()>0){  //����ҵ��ұ�һ���ǿ�ֵ
						if(cardsMap[x][y].getNum() <=0 ){  //��ǰ��ֵΪ�գ����ұߵķǿ�ֵ�Ƶ����
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							x--;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x1][y])){
							//��ǰֵ�ǿգ����ұߵ�����ߣ��ϲ�
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							//��������Ҫ���·���  ����������TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
						}
						//����������ɲ�����Ƶ
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
				
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //�ж���Ϸ�Ƿ����
		}
		
	}
	public void check(int num){
		if(num==2048){
			new AlertDialog.Builder(getContext())
			.setTitle("������������")
			
			.setMessage("ȥѧϰ��������")
			.setPositiveButton("����", null)
			.show();
		}
		if(num==4096){
			new AlertDialog.Builder(getContext())
			.setTitle("���񣡣�")
			.setMessage("��������������")
			.setPositiveButton("����", null)
			.show();
		}
		if(num==8192){
			new AlertDialog.Builder(getContext())
			.setTitle("8192�Ĵ��񣡣�")
			.setMessage("8192��������������")
			.setPositiveButton("����", null)
			.show();
		}
	}
	
	public void checkFinish(){
		boolean isFinish = true;
		//isFinish������У�
		//1.��һ�ſ�ƬΪ��
		//2.�������ڿ�Ƭֵ���
		ALL:
			for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					if(cardsMap[x][y].getNum()== 0 || 
							(x>0 && cardsMap[x][y].isEqual(cardsMap[x-1][y])) ||
							(x<3 && cardsMap[x][y].isEqual(cardsMap[x+1][y])) ||
							(y>0 && cardsMap[x][y].isEqual(cardsMap[x][y-1])) ||
							(y<3 && cardsMap[x][y].isEqual(cardsMap[x][y+1]))){
						isFinish=false;
						break ALL;
						
					}
				}	
			}
		if(isFinish){
			//�ӵ�ǰ������ת��ʧ�ܽ���=========
			MainActivity.getMainActivity().loseGame();
		}
	}
	

	//������GameVie���췽��ǰ���Զ�����
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		//����ÿ�ſ�Ƭ�Ŀ��																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
		int cardWidth = (Math.min(w, h)-10)/4;
		//���ʮ���ų�ʼֵΪ0��Ƭ
		addCards(cardWidth,cardWidth);
		
		//��ʼ��Ϸ
		startGame();
	}
	
	public void addCards(int cardWidth,int cardHeight){
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				cardsMap[x][y] =new Card(getContext());
				addView(cardsMap[x][y],cardWidth, cardHeight);
			}
		}
	}
	
	
	public void startGame(){
		//��յ�ǰ��ֵ====��TODO
		//����������ſ�Ƭ
		addRandomNum();
		addRandomNum();
		
	}

	//����һ�������������һ�ſ�Ƭ
	private void addRandomNum() {
		//����б����Ϣ
		emptyPoints.clear();
		//����ѭ�����пտ�Ƭ
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if(cardsMap[x][y].getNum()<=0){
					emptyPoints.add(new Point(x,y)); 
				}
			}
			
		}
		int pos  = (int)(Math.random()*emptyPoints.size());
		Point p = emptyPoints.remove(pos);
		cardsMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
		cardsMap[p.x][p.y].setCardColor(cardsMap[p.x][p.y].getNum());
		
	}
	
	
	
}






