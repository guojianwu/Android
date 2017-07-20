package com.example.finalproject;











import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class MainActivity extends Activity {
	private LinearLayout toast;
	private TextView topScore,jingdian,shuan;
	private CheckBox check;
	private MyDataBaseUtil mUtil;
    private SQLiteDatabase db;
    private int shijian,jishi;
    
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private String[] weekStr;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 weekStr = new String[] {"20", "30", "40", "50", "60", "70","80","90","100"};
		//topScore=(TextView) findViewById(R.id.topScore);
		check=(CheckBox) findViewById(R.id.check);
		jingdian=(TextView) findViewById(R.id.jingdian);
		topScore=(TextView) findViewById(R.id.topScore);
		shuan=(TextView) findViewById(R.id.shuan);
		toast=(LinearLayout) findViewById(R.id.tosat);
		
		spinner = (Spinner) findViewById(R.id.spanner1);

		shijian=20;
		jishi=0;
		spinner.setClickable(false);
		 mUtil=new MyDataBaseUtil(this, "newrecord", null, 1);
	     db=mUtil.getWritableDatabase();
	     
	     String temp=mUtil.getScoreById(db, "1");
		 topScore.setText("闯关最高\n"+temp);
			

		
		
			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_dropdown_item,weekStr);
			adapter.setDropDownViewResource(R.layout.myspinner);
			spinner.setAdapter(adapter);
			spinner.setSelection(0, true);// 设置默认选择项
			spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					//arg2表示用户选中的某项位置 0开始
				//	String sInfo=arg0.getItemAtPosition(arg2).toString(); 
					shijian=Integer.parseInt(arg0.getItemAtPosition(arg2).toString()); 
					//shijian=(int)sInfo;
					
		            //Toast.makeText(MainActivity.this, shijian+"", Toast.LENGTH_LONG).show();   
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			toast.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(jishi==0){
						Toast.makeText(MainActivity.this, "请开启计时器", Toast.LENGTH_SHORT).show();
					}
				}
			});
		  
	        check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
					// TODO Auto-generated method stub
					if(arg1==true){
						spinner.setClickable(true);
						jishi=1;
					}
					
					else {
						spinner.setClickable(false);
						jishi=0;					
					}
				}
			});
	
		jingdian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//moshi=1;
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, MainGame.class);
				Bundle bundle=new Bundle();
		    	bundle.putInt("JISHI", jishi);
		    	bundle.putInt("SHIJIAN", shijian);
		    	intent.putExtras(bundle);
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
				Bundle bundle=new Bundle();
				bundle.putInt("JISHI", jishi);
				bundle.putInt("SHIJIAN", shijian);
		    	intent.putExtras(bundle);
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
