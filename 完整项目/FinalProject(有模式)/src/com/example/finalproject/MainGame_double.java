package com.example.finalproject;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainGame_double extends Activity {
	private TextView currentScore,topScore,time;
	private MyDataBaseUtil mUtil;
    private SQLiteDatabase db;
    private int oldScore ,score;
    
    private int speed=1000; //时间间隔
	private int guan=20;
	private Timer timer;
	private Handler handler;
	private boolean isStartTimer;
		
	private static MainGame_double mainGame_double=null;	
	
	private int isNewScore=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_game_double);
		
		currentScore=(TextView) findViewById(R.id.currentScore);
		topScore=(TextView) findViewById(R.id.topScore);
		time=(TextView) findViewById(R.id.time);
		isStartTimer=true;
		
		 mUtil=new MyDataBaseUtil(this, "newrecord", null, 1);
	        db=mUtil.getWritableDatabase();
	        
	        //获取历史最高分
	        getHeihtScore();
	        
	        //startFlash();
	        
	        handler=new Handler(){

				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					if(msg.what==0x22){
						guan--;
						time.setText(guan+"");
						
					}
					 
			        if(guan<=0){
						timer.cancel();
						guan=20;
						gameOver();
					}
					
					super.handleMessage(msg);
				}
				
			};
			
		
		
	}
	
	
	public void startFlash(){
		timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//发送空消息
				handler.sendEmptyMessage(0x22);
			}
		}, 0, speed);
	}

	
	public void startTimer(){
		if(isStartTimer){
			startFlash();
			isStartTimer=false;
		}
	}
	

    private void getHeihtScore() {
		String temp=mUtil.getScoreById(db, "1");
		topScore.setText("闯关最高\n"+temp);
		oldScore=Integer.parseInt(temp);
	}
	
	 public void addScore(int s){
	    	score=s;
	    	currentScore.setText("关数\n"+s);
	    	if(s>oldScore){
	    		//更新数据库历史最高，并且最高分数文本框要刷新
	    		isNewScore=1;
	    		mUtil.updateScoreValue(db, "1", s+"");
	    		topScore.setText("闯关最高\n"+s);
	    		topScore.setTextColor(Color.RED);
	    	}
	    }
	
	public void gameOver(){
		
		//gv.setNum(2);
		if(!isStartTimer){
			timer.cancel();
		}
		guan=20;
		Intent intent=new Intent();
		intent.setClass(MainGame_double.this, Failure.class);
		Bundle bundle=new Bundle();
    	bundle.putInt("SCORE", score);
    	bundle.putInt("ISNEWSCORE", isNewScore);
    	intent.putExtras(bundle);
		startActivity(intent);
	}
	

    public MainGame_double(){
    	mainGame_double=this;
    }
    public static MainGame_double getMainGame_double(){
    	return mainGame_double;
    }
	
	
}
