package com.example.myanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MyPage02 extends Activity {
	Button btn_statr,btn_start01,btn_last;
	ImageView image,image01;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mypage02);
		btn_statr=(Button) findViewById(R.id.btn_start);
		image=(ImageView) findViewById(R.id.image);
		image01=(ImageView) findViewById(R.id.image01);
		btn_start01=(Button) findViewById(R.id.btn_start01);
		btn_last=(Button) findViewById(R.id.btn_last);
		
		btn_statr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AnimationDrawable animationDrawable=(AnimationDrawable)image.getDrawable();
				animationDrawable.start();//≤•∑≈÷°∂Øª≠
			}
		});
		btn_start01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AnimatorSet animationSet=(AnimatorSet)AnimatorInflater.loadAnimator(MyPage02.this, R.animator.anim02);
				animationSet.setTarget(image01);
				animationSet.setDuration(1000);
				animationSet.start();
			}
		});
		btn_last.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View  arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MyPage02.this, MyPage01.class);
				startActivity(intent);
			}
		});
		
		
		
		
		
	}
	
}
