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
	private int currentPosition=0;   //保存当前页面
	private GestureDetector gesDetector; //手势 左右滑动 及长按松开
	

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();   //初始化
	}
	
	//控制视图大大小及位置，左上右下
	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		//getChildCount();  // 获取添加子视图的个数
		//为每个子视图设置大小及位置
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
	//添加子视图
	public void initImages(int[] imageIds){
		for (int i = 0; i < imageIds.length; i++) {
			ImageView image=new ImageView(getContext());
			image.setImageResource(imageIds[i]);
			image.setScaleType(ScaleType.FIT_XY); //按照图片的长宽进行缩放
			this.addView(image);
		}
	}
	
	
	//启动定时器
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
					//图片滚动，定义一个方法scrollToTarget()来实现
					scrollToTarget((currentPosition+1)%getChildCount());
				}
				super.handleMessage(msg);
			}
			
		};
		
		gesDetector=new GestureDetector(getContext(),new OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//手指离开触摸屏的那一刹调用次方法
				return true;
			}
			
			@Override
			public void onShowPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//在长按之前。按在触摸屏上的时间范围内有效
				
			}
			
			@Override
			public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
					float arg3) {
				// TODO Auto-generated method stub
				//滑动
				//arg2表示在X方向上划过的距离，如果arg2是正数，则表示左滑
				//						   如果arg2是负数，则表示右滑
				if((arg2<0) && (getScrollX()>0 )|| (arg2>0) && (getScrollX()<(getChildCount()-1)*getWidth())){
					scrollBy((int)arg2, 0);
			   }
				
				//scrollBy(dx,dy)  dx表示在水平方向上移动的距离，dy表示在垂直方向上滑动的距离，是个相对的概念
				//scrollTo(x,y)   x表示新的位置的横坐标，y表示新的纵坐标，是个绝对的概念
				
				return true;
			}
			
			@Override
			public void onLongPress(MotionEvent arg0) {
				// TODO Auto-generated method stub
				//按在手机屏幕上并持续一段时间，且没有松开
				//进入到第二个页面显示详细的内容   ====》有待实现
				//获取上下文件，强制转换，调用其他文件方法
				((MainActivity)getContext()).showDetail();
			}
			
			@Override
			public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
					float arg3) {
				// TODO Auto-generated method stub
				//迅速松开
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
		int distance=targetPosition*getWidth()-getScrollX();  //有可能为负
		int time=2*Math.abs(distance);
		mScroller.startScroll(getScrollX(), 0, distance, 0, time);
		postInvalidate(); // 用于刷新界面
		currentPosition=targetPosition;
		//6个小圆圈要同步更新
		((MainActivity)getContext()).scrollToTarget(targetPosition);
		//getScrollX()获得当前View的左上角的偏移量
	}
	//此方法是在startScroll()后被调用，用于在滑动时显示对应的位置
	public void computeScroll(){
		super.computeScroll();
		//必须由scrollTo()方法来完成实际的滚动
		//其中，getCurrX()返回当前X坐标
		if(mScroller.computeScrollOffset()){
			//computeScrollOffset()用于判断滚动是否完成，true表示未完成，false表示完成
			scrollTo(mScroller.getCurrX(), 0);
		}
	}
	public boolean onTouchEvent(MotionEvent event){
		gesDetector.onTouchEvent(event);
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:    //触摸后松开
			//当滑动的距离超过屏幕宽度的一半，才滚动下一张，如果滑动的距离不够屏幕宽度的一半，则不做滚动
			scrollToTarget((int)(getScrollX()+getWidth()/2)/getWidth());
			
			break;

		}
		return true;
		
	}
	//假如getScrollX()>getWidth() + getWidth()/2

}






