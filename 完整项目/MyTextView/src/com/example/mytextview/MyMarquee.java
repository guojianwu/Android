package com.example.mytextview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyMarquee extends TextView{
	//ʵ�����ֵĹ���
	private String mText;  //��������
	private int mTextWidth; //���ֿ��
	private int time=200;  //ms��ʱ����
	private int speed=5;  //5�����صľ���
	private int xoffset=0;  //ƫ�ƾ���
	private Handler mHandler;  //�������߳������̵߳Ľ���
	private boolean isStop=false;  //�Ƿ�ֹͣ  Ĭ��Ϊ��false��
	
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

	//����һ���������������̵߳���Ϣ�����н������
	public void startMarquee(){
		mText=this.getText().toString();
		mTextWidth=(int)getPaint().measureText(mText);//�������ֵĿ��
		//Handler����������߳���Ϣ
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
	
	//����һ�����������������̣߳�������ʱ�ȴ�
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





