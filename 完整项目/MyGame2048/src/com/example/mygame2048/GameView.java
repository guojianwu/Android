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
		//1、设置网格布局的列数
		setColumnCount(4);
		//2、响应触摸
		setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				switch (arg1.getAction()) {
				case MotionEvent.ACTION_DOWN:
					//获得起点坐标
					startX=arg1.getX();
					startY=arg1.getY();
					break;
				case MotionEvent.ACTION_UP:
					//获得终点坐标
					endX=arg1.getX();
					endY=arg1.getY();
					offsetX=endX - startX;
					offsetY=endY - startY;
					if(Math.abs(offsetX) > Math.abs(offsetY)){
						if(offsetX<-5){
							//左移
							swipLeft();
						}else if(offsetX>5){
							//右移
							swipRight();
						}
					}else {
						if(offsetY<-5){
							//上移
							swipUp();
						}else if(offsetY>5){
							//下移
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
					if(cardsMap[x1][y].getNum()>0){  //如果找到右边一个非空值
						if(cardsMap[x][y].getNum() <=0 ){  //当前的值为空，把右边的非空值移到左边
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							x++;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x1][y])){
							//当前值非空，且右边等于左边，合并
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							//主界面上要更新分数  。。。。。TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
							
						}
						//主界面上完成播放音频
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //判断游戏是否结束
		}
		
	}
	public void swipUp(){
			
		boolean merge = false;  // 用来识别是否需要在产生一张卡片和判断游戏是否结束
		
			
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int y1 = y+1; y1 < 4 ; y1++) {
					if(cardsMap[x][y1].getNum()>0){  //如果找到右边一个非空值
						if(cardsMap[x][y].getNum() <=0 ){  //当前的值为空，把右边的非空值移到左边
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							y--;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x][y1])){
							//当前值非空，且右边等于左边，合并
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							//主界面上要更新分数  。。。。。TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
						}
						//主界面上完成播放音频
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
				
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //判断游戏是否结束
		}
		
		
		
		
		
	}
	public void swipDown(){
		
		boolean merge = false;  // 用来识别是否需要在产生一张卡片和判断游戏是否结束
		
		
		for (int x = 0; x < 4; x++) {
			for (int y = 3; y >=0; y--) {
				for (int y1 = y-1; y1 >=0 ; y1--) {
					if(cardsMap[x][y1].getNum()>0){  //如果找到右边一个非空值
						if(cardsMap[x][y].getNum() <=0 ){  //当前的值为空，把右边的非空值移到左边
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							y++;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x][y1])){
							//当前值非空，且右边等于左边，合并
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x][y1].setNum(0);
							cardsMap[x][y1].setCardColor(cardsMap[x][y1].getNum());
							//主界面上要更新分数  。。。。。TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
						}
						//主界面上完成播放音频
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
				
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //判断游戏是否结束
		}
		
		
		
		
		
	}
	
	
	public void swipLeft(){
		//先看每一行，再依次看每行的每一列
		//以第一行为例，第一格为基准。看它后三格，如果有非空的内容
		//再回过头判断第一格
	    //如果第一格的内容为空，此时直接跳过
		//如果第一格内容不为空，再判断第一格的内容是否与非空格的内容相等，若是，合并
		//对于以上两种可能，都需要产生一张随机卡片，判断游戏是否结束
		boolean merge = false;  // 用来识别是否需要在产生一张卡片和判断游戏是否结束
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				for (int x1 = x+1; x1 < 4 ; x1++) {
					if(cardsMap[x1][y].getNum()>0){  //如果找到右边一个非空值
						if(cardsMap[x][y].getNum() <=0 ){  //当前的值为空，把右边的非空值移到左边
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							x--;
							merge=true;
						}else if(cardsMap[x][y].isEqual(cardsMap[x1][y])){
							//当前值非空，且右边等于左边，合并
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum()*2);
							cardsMap[x][y].setCardColor(cardsMap[x][y].getNum());
							cardsMap[x1][y].setNum(0);
							cardsMap[x1][y].setCardColor(cardsMap[x1][y].getNum());
							//主界面上要更新分数  。。。。。TODO
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge=true;
							check(cardsMap[x][y].getNum());
						}
						//主界面上完成播放音频
						MainActivity.getMainActivity().playSounds(1);
						break;
					}
				}
				
			}
		}
		if(merge){
			addRandomNum();
			checkFinish();  //判断游戏是否结束
		}
		
	}
	public void check(int num){
		if(num==2048){
			new AlertDialog.Builder(getContext())
			.setTitle("厉害厉害！！")
			
			.setMessage("去学习啦！！！")
			.setPositiveButton("继续", null)
			.show();
		}
		if(num==4096){
			new AlertDialog.Builder(getContext())
			.setTitle("大神！！")
			.setMessage("大神厉害！！！")
			.setPositiveButton("继续", null)
			.show();
		}
		if(num==8192){
			new AlertDialog.Builder(getContext())
			.setTitle("8192的大神！！")
			.setMessage("8192大神厉害！！！")
			.setPositiveButton("继续", null)
			.show();
		}
	}
	
	public void checkFinish(){
		boolean isFinish = true;
		//isFinish的情况有：
		//1.有一张卡片为空
		//2.两张相邻卡片值相等
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
			//从当前界面跳转到失败界面=========
			MainActivity.getMainActivity().loseGame();
		}
	}
	

	//将会在GameVie构造方法前被自动调用
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		//计算每张卡片的宽高																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
		int cardWidth = (Math.min(w, h)-10)/4;
		//添加十六张初始值为0卡片
		addCards(cardWidth,cardWidth);
		
		//开始游戏
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
		//清空当前分值====》TODO
		//随机产生两张卡片
		addRandomNum();
		addRandomNum();
		
	}

	//定义一个方法随机产生一张卡片
	private void addRandomNum() {
		//清空列表的信息
		emptyPoints.clear();
		//遍历循环所有空卡片
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






