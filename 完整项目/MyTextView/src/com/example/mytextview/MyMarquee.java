package com.example.mytextview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyMarquee extends TextView{
	//实现文字的滚动
	private String mText;  //文字内容
	private int mTextWidth; //文字宽度
	private int time=200;  //ms，时间间隔
	private int speed=5;  //5个像素的距离
	private int xoffset=0;  //偏移距离
	private Handler mHandler;  //负责主线程与子线程的交互
	private boolean isStop=false;  //是否停止  默认为（false）
	
	public MyMarquee(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyMarquee(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void setTime(int time){
		this.time=time;
	}
	
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//定义一个方法来接受子线程的信息，进行界面更新
	public void startMarquee(){
		mText=this.getText().toString();
		mTextWidth=(int)getPaint().measureText(mText);//滚动文字的宽度
		//Handler负责接受子线程信息
		mHandler=new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if(msg.what==0x55){
					xoffset+=speed;
					if(xoffset>=mTextWidth){
						xoffset=-getWidth();
					}
					scrollTo(xoffset,0);
				}
			}
			
		};
		startThread();
	}
	
	//定义一个方法用于启动子线程，负责延时等待
	 public void startThread(){
		 new Thread(){
			 public void run(){
				 while (!isStop) {
					 try{
						 Thread.sleep(time);
						 mHandler.sendEmptyMessage(0x55);
					 }catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
			 }
		 }.start();
	 }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			isStop=true;
			break;
		default:
			isStop=false;
			startMarquee();
			break;
		}
		
		//return super.onTouchEvent(event);
		return true;
	}
	
	
	
	
	
}





