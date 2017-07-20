package com.example.finalproject;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Failure extends Activity{
	
	private TextView again,score;
	
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
    	
    	again=(TextView) findViewById(R.id.again);
    	again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//MainActivity.getMainActivity().finish();
				
				Intent intent =new Intent();
				intent.setClass(Failure.this, MainActivity.class);
				startActivity(intent);
			}
		});
    	
    }
}
