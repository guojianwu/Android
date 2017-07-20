package com.example.mycolor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
private TextView textView[] = new TextView[8];
private int ID[] = {R.id.textView01,R.id.textView02,R.id.textView03,R.id.textView04,
		R.id.textView05,R.id.textView06,R.id.textView07,R.id.textView08};
private String str[]={"红色","绿色","蓝色","黄色","紫色","黑色","品红色","青色"};

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < str.length; i++) {
			textView[i] = (TextView) findViewById(ID[i]);
			final int n = i;
			textView[i].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, str[n], Toast.LENGTH_SHORT).show();
				}
			});
		}

	}
    
  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}





}




