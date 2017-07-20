package com.example.flashinglamp02;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int[] ids=new int[]{R.id.text01,R.id.text02,R.id.text03,R.id.text04,R.id.text05};
	private TextView[] mTexts=new TextView[ids.length];
	private int[] color=new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.YELLOW};
	private CheckBox check;
	private SeekBar seekBar;
	private int speed=1000; //时间间隔
	int num=0;
	private Timer timer;
	private Handler handler;
	private boolean isCheck=true;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < ids.length; i++) {
			mTexts[i]=(TextView) findViewById(ids[i]);
		}
		check=(CheckBox) findViewById(R.id.check);
		seekBar=(SeekBar) findViewById(R.id.seekBar);
		
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(arg1){
					speed=2000-seekBar.getProgress()*20+1;  //[1--1999]
					//调用闪烁方法
					startFlash();
					isCheck=true;
				}else {
					timer.cancel();
					isCheck=false;
					
				}
				
			}
		});
		
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				if(isCheck){
					timer.cancel();
					speed=2000-seekBar.getProgress()*20+1;
					startFlash();
					
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				
			}
		});
		
		handler=new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what==0x22){
					num++;
					for (int i = 0; i < ids.length; i++) {
						mTexts[i].setBackgroundColor(color[(i+num)%ids.length]);
						
					}
				}
				super.handleMessage(msg);
			}
			
		};
		
		
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
		}, 0, speed);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
