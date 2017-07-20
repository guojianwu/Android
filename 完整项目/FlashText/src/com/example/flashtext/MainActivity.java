package com.example.flashtext;



import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int[] ids=new int[]{R.id.text01,R.id.text02,R.id.text03,R.id.text04,R.id.text05,
			R.id.text06,R.id.text07,R.id.text08,R.id.text09,R.id.text10};
	private TextView[] mTexts=new TextView[ids.length];
//	private int[] argb=new int[]{Color.argb(0, 0, 0, 255),Color.argb(10, 0, 0, 255),Color.argb(20, 0, 0, 255),Color.argb(30, 0, 0, 255),Color.argb(40, 0, 0, 255),Color.argb(50, 0, 0, 255),
//			Color.argb(60, 0, 0, 255),Color.argb(70, 0, 0, 255),Color.argb(80, 0, 0, 255),Color.argb(90, 0, 0, 255),Color.argb(100, 0, 0, 255),
//			Color.argb(120, 0, 0, 255),Color.argb(130, 0, 0, 255),Color.argb(140, 0, 0, 255),Color.argb(150, 0, 0, 255),
//			Color.argb(160, 0, 0, 255),Color.argb(170, 0, 0, 255),Color.argb(180, 0, 0, 255),Color.argb(190, 0, 0, 255),Color.argb(200, 0, 0, 255),
//			Color.argb(210, 0, 0, 255),Color.argb(225, 0, 0, 255)};
private Timer timer;
	private Handler handler;
	int num=0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < ids.length; i++) {
			mTexts[i]=(TextView) findViewById(ids[i]);
		}
		
		handler=new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what==0x22){
					num++;
					for (int i = 0; i < ids.length; i++) {
//						mTexts[i].setBackgroundColor(color[(i+num)%ids.length]);
						mTexts[ids.length-i-1].setTextColor(Color.argb((i+num)*25%255, 0, 0, 255));
//						mTexts[i].setTextColor(argb[(i+num)%ids.length]);
						
					}
				}
				super.handleMessage(msg);
			}
			
		};
		startFlash();
		
		
	}
	
	//开始闪烁
		public void startFlash(){
			timer=new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					//发送空消息
					handler.sendEmptyMessage(0x22);
				}
			}, 0, 150);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
