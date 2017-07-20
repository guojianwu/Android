package com.example.finalproject;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class GameView_double extends GridLayout{

	private int num=3;
	private int score=1;
	
	private Card[][] cardsMap; //= new Card[6][6];
	private List<Point> emptyPoints = new ArrayList<Point>();
	
	private MyClickListener l = new MyClickListener();
	
	private int isFinish;
	private int select=0;
	
	public GameView_double(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initGameView();
		
	}


	public GameView_double(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initGameView();
	}


	public GameView_double(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initGameView();
	}


	private void initGameView() {
		addCards();
		
	}

	public void addCards(){
		this.removeAllViews();
		isFinish=2;
        cardsMap=new Card[num][num];
		//1、设置网格布局的列数
		setColumnCount(num);
		
		int cardWidth = 450/num;
		for (int y = 0; y < num; y++) {
			for (int x = 0; x < num; x++) {
				emptyPoints.add(new Point(x,y)); 
				cardsMap[x][y] =new Card(getContext());
				addView(cardsMap[x][y],cardWidth, cardWidth);
				cardsMap[x][y].setNum(0);
				cardsMap[x][y].setOnClickListener(l);
			}
		}
		int randX = (int)(Math.random()*num);
		int randY = (int)(Math.random()*num);
		int randX1 = (int)(Math.random()*num);
		int randY1 = (int)(Math.random()*num);
		do {
			 randX1 = (int)(Math.random()*num);
			 randY1 = (int)(Math.random()*num);
		} while (randX==randX && randY==randY1);
		
		
		cardsMap[randX][randY].setNum(1);
		cardsMap[randX1][randY1].setNum(1);
		setColor();
		
	}
	class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub		
			if(((Card)arg0).getNum()==1){
				isFinish--;
				((Card)arg0).setCardColor(select);
				if(isFinish==0){
					//isFinish=2;
					nextInitGame();
					setColor();	
				}

				 	  
			}else{
				num=3;
				MainGame_double.getMainGame_double().gameOver();
				
			}
			
			
		}
		
	}
	
	public void nextInitGame(){
		num++;
		score++;	
		MainGame_double.getMainGame_double().addScore(score);
		MainGame_double.getMainGame_double().startTimer();
		addCards();
	}
	
	public void setColor(){
		int randNum=(int)(Math.random()*6);
		select = randNum==0?6:randNum;
		if(randNum==0){
			select(6, 66);
		}
		if(randNum==1){
			select(1, 11);
		}
		
		
		if(randNum==2){
			for (int x = 0; x <num; x++) {
				select(2, 22);
			}
		}
		if(randNum==3){
			for (int x = 0; x <num; x++) {
				select(3, 33);
			}
		}
		if(randNum==4){
			for (int x = 0; x <num; x++) {
				select(4, 44);
			}
		}
		if(randNum==5){
			for (int x = 0; x <num; x++) {
				select(5, 55);
			}
		}
		
	}
	
	
	public void select(int select ,int unselect){
		for (int x = 0; x <num; x++) {
			for (int y = 0; y < num; y++) {
				if(cardsMap[x][y].getNum()==0){
					cardsMap[x][y].setCardColor(select);
				}else {
					cardsMap[x][y].setCardColor(unselect);
				}
			}
		}
	}
	
	
	
	
}






