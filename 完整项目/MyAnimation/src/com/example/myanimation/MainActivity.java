package com.example.myanimation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	
	private int[] ids=new int[]{R.id.btn01,R.id.btn02,R.id.btn03,R.id.btn04,R.id.btn05,
			R.id.btn06,R.id.btn07,R.id.btn08,R.id.btn09,R.id.btn10,R.id.btn11,
			R.id.btn12,R.id.btn13,R.id.btn14};
	private Button[] btns=new Button[ids.length];
	private MyClickListener mListener=new MyClickListener();
	private int num=0;
	//Button btn02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for (int i = 0; i < btns.length; i++) {
			btns[i]=(Button) findViewById(ids[i]);
			btns[i].setOnClickListener(mListener);
		}
	}
	//补间动画  
	private class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			for (int i = 0; i < ids.length; i++) {
				if(arg0.getId()==ids[i]){
					num=i;
				}
			}
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, MyPage01.class);
			startActivity(intent);
			switch (num) {
			case 0:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
				break;
			case 1:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				break;
			case 2:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.slide_down_in, R.anim.slide_up_out);
				break;
			case 3:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
				break;
			case 4:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.bounce_down_in, R.anim.bounce_up_out);
			
				break;
			case 5:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.fade_in, R.anim.rotate_out);
				break;
			case 6:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.blink, R.anim.blink);
				break;
			case 7:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.move_in, R.anim.fade_out);
				break;
			case 8:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.flip_up_in, R.anim.flip_up_out);
				break;
			case 9:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.flip_down_in, R.anim.flip_down_out);
				break;
			case 10:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.flip_left_in, R.anim.flip_left_out);
				break;
			case 11:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.flip_right_in, R.anim.flip_right_out);
				break;
			case 12:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.fade_in, R.anim.together_out);
				break;
			case 13:
				//overridePendingTransition页面间的切换效果
				overridePendingTransition(R.anim.sequential_in, R.anim.fade_out);
				break;

			
			}
			
			
			//Intent intent=new Intent();
			//intent.setClass(MainActivity.this, MyPage01.class);
			//startActivity(intent);
			//overridePendingTransition页面间的切换效果
			//overridePendingTransition(R.anim.in, R.anim.out);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
