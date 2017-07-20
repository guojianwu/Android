package com.example.mygame2048;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Failure extends Activity {
	
	private TextView score;
	private Button again;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_over);
		score=(TextView) findViewById(R.id.score);
		again=(Button) findViewById(R.id.again);
		
		Bundle bundle=this.getIntent().getExtras();
		int temp=bundle.getInt("SCORE");
		score.setText(temp+"");
		again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Failure.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
	}

}
