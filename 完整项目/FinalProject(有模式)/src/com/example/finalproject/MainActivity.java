package com.example.finalproject;







import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class MainActivity extends Activity {
	
	private TextView topScore,jingdian,shuan;
	private MyDataBaseUtil mUtil;
    private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		topScore=(TextView) findViewById(R.id.topScore);
		
		 mUtil=new MyDataBaseUtil(this, "newrecord", null, 1);
	     db=mUtil.getWritableDatabase();
	     
	     String temp=mUtil.getScoreById(db, "1");
		 topScore.setText("闯关最高\n"+temp);
			

		jingdian=(TextView) findViewById(R.id.jingdian);
		topScore=(TextView) findViewById(R.id.topScore);
		shuan=(TextView) findViewById(R.id.shuan);
	
		
		
	
		jingdian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//moshi=1;
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, MainGame.class);
				//Bundle bundle=new Bundle();
		    	//bundle.putInt("MOSHI", moshi);
		    	//intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		

		shuan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//moshi=2;
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, MainGame_double.class);
				//Bundle bundle=new Bundle();
		    	//bundle.putInt("MOSHI", moshi);
		    	//intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	
		
		/*
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
			
			*/
			
	}	
	
	
	/*
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
	    	}
	    }
	
	public void gameOver(){
		
		//gv.setNum(2);
		if(!isStartTimer){
			timer.cancel();
		}
		guan=20;
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, Failure.class);
		Bundle bundle=new Bundle();
    	bundle.putInt("SCORE", score);
    	bundle.putInt("ISNEWSCORE", isNewScore);
    	intent.putExtras(bundle);
		startActivity(intent);
	}
	

    public MainActivity(){
	    mainActivity=this;
    }
    public static MainActivity getMainActivity(){
    	return mainActivity;
    }
    
    */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
