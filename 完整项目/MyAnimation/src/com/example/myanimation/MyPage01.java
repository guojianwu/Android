package com.example.myanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyPage01 extends Activity{
	Button btn_back,btn_next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mypage01);
		btn_back=(Button) findViewById(R.id.btn_back);
		btn_next=(Button) findViewById(R.id.btn_next);
		
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MyPage01.this, MainActivity.class);
				startActivity(intent);
			}
		});
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MyPage01.this, MyPage02.class);
				startActivity(intent);
			}
		});
	}
}
