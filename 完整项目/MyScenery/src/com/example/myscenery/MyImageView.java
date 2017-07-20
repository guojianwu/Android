package com.example.myscenery;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Scroller;

public class MyImageView extends ViewGroup{

	private Scroller mScroller=new Scroller(getContext());
	private Handler mHandler;
	private Timer timer;
	private int currentPosition=0;   //���浱ǰҳ��
	private GestureDetector gesDetector; //���� ���һ��� �������ɿ�
	

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();   //��ʼ��
	}
	
	//������ͼ���С��λ�ã���������
	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		//getChildCount();  // ��ȡ�������ͼ�ĸ���
		//Ϊÿ������ͼ���ô�С��λ��
		for (int i = 0; i < getChildCount(); i++) {
			View child = getChildAt(i);
			child.measure(arg3-arg1, arg4-arg2);
			//1==>(0,0)(width,height)
			//2==>(width,0)(3*width,height)
			//i==>(i*width,0)((i+1)8widht,height)
			child.layout(i*getWidth(), 0, (i+1)*getWidth(), getHeight());
		}
	}
	//int[] ids={R.drawable.p01,R.drawable.p02,...,R.drawable.p06}
	//�������ͼ
	public void initImages(int[] imageIds){
		for (int i = 0; i < imageIds.length; i++) {
			ImageView image=new ImageView(getContext());
			image.setImageResource(imageIds[i]);
			image.setScaleType(ScaleType.FIT_XY); //����ͼƬ�ĳ����������
			this.addView(image);
		}
	}
	
	
	//������ʱ��
	public void start(){
		timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mHandler.sendEmptyMessage(0x11);
			}
		},5000,5000);
	}
	
	public void init(){
		mHandler=new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what==0x11){
					//ͼƬ����������һ������scrollToTarget()��ʵ��
					scrollToTarget((currentPosition+1)%getChildCount());
				}
				super.handleMessage(msg);
			}
			
		};
		
		gesDetector=new GestureDetector(getContext(),new OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//��ָ�뿪����������һɲ���ôη���
				return true;
			}
			
			@Override
			public void onShowPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//�ڳ���֮ǰ�����ڴ������ϵ�ʱ�䷶Χ����Ч
				
			}
			
			@Override
			public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
					float arg3) {
				// TODO Auto-generated method stub
				//����
				//arg2��ʾ��X�����ϻ����ľ��룬���arg2�����������ʾ��
				//						   ���arg2�Ǹ��������ʾ�һ�
				if((arg2<0) && (getScrollX()>0 )|| (arg2>0) && (getScrollX()<(getChildCount()-1)*getWidth())){
					scrollBy((int)arg2, 0);
			   }
				
				//scrollBy(dx,dy)  dx��ʾ��ˮƽ�������ƶ��ľ��룬dy��ʾ�ڴ�ֱ�����ϻ����ľ��룬�Ǹ���Եĸ���
				//scrollTo(x,y)   x��ʾ�µ�λ�õĺ����꣬y��ʾ�µ������꣬�Ǹ����Եĸ���
				
				return true;
			}
			
			@Override
			public void onLongPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//�����ֻ���Ļ�ϲ�����һ��ʱ�䣬��û���ɿ�
				//���뵽�ڶ���ҳ����ʾ��ϸ������   ====���д�ʵ��
				//��ȡ�����ļ���ǿ��ת�������������ļ�����
				((MainActivity)getContext()).showDetail();
			}
			
			@Override
			public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
					float arg3) {
				// TODO Auto-generated method stub
				//Ѹ���ɿ�
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
	}
	
	public void scrollToTarget(int targetPosition){
		int distance=targetPosition*getWidth()-getScrollX();  //�п���Ϊ��
		int time=2*Math.abs(distance);
		mScroller.startScroll(getScrollX(), 0, distance, 0, time);
		postInvalidate(); // ����ˢ�½���
		currentPosition=targetPosition;
		//6��СԲȦҪͬ������
		((MainActivity)getContext()).scrollToTarget(targetPosition);
		//getScrollX()��õ�ǰView�����Ͻǵ�ƫ����
	}
	//�˷�������startScroll()�󱻵��ã������ڻ���ʱ��ʾ��Ӧ��λ��
	public void computeScroll(){
		super.computeScroll();
		//������scrollTo()���������ʵ�ʵĹ���
		//���У�getCurrX()���ص�ǰX����
		if(mScroller.computeScrollOffset()){
			//computeScrollOffset()�����жϹ����Ƿ���ɣ�true��ʾδ��ɣ�false��ʾ���
			scrollTo(mScroller.getCurrX(), 0);
		}
	}
	public boolean onTouchEvent(MotionEvent event){
		gesDetector.onTouchEvent(event);
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:    //�������ɿ�
			//�������ľ��볬����Ļ��ȵ�һ�룬�Ź�����һ�ţ���������ľ��벻����Ļ��ȵ�һ�룬��������
			scrollToTarget((int)(getScrollX()+getWidth()/2)/getWidth());
			
			break;

		}
		return true;
		
	}
	//����getScrollX()>getWidth() + getWidth()/2

}






