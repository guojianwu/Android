package com.example.whiteblock;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SuccessActivity extends Activity {
	private TextView tv_sconds,tv_top,tv_exit,tv_again;
	private int index;  //歌曲编号
	private double current; //当前游戏成功的秒数
	private String old; //数据库存储对应歌曲的历史最佳秒数
	private MyDatabaseUtil mUtil;
	private SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success_activity);
		tv_sconds=(TextView) findViewById(R.id.tv_sconds);
		tv_top=(TextView) findViewById(R.id.tv_top);
		tv_exit=(TextView) findViewById(R.id.tv_exit);
		tv_again=(TextView) findViewById(R.id.tv_again);
		
		
		
		
		mUtil=new MyDatabaseUtil(this, "newrecord.db", null, 1);
		db=mUtil.getWritableDatabase();
		Bundle bundle =this.getIntent().getExtras();
		index=bundle.getInt("INDEX");
		current=bundle.getDouble("SECONDS");
		tv_sconds.setText(current+"''");
		old=mUtil.getScoreValueById(db, index+"");
		
		if(old.equals("0")){
			tv_top.setText("新纪录：歌曲"+(index+1));
			mUtil.updateScoreValue(db, index+"", current+"");
		}else if(current< Double.parseDouble(old)){
			tv_top.setText("新纪录：歌曲"+(index+1));
			mUtil.updateScoreValue(db, index+"", current+"");
		}else{
			tv_top.setText("历史最佳："+old+"\n歌曲"+(index+1));
		}
		
		
		//重来
				tv_again.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent=new Intent();
						intent.setClass(SuccessActivity.this, MainActivity.class);
						startActivity(intent);
					}
				});
				
				
				//退出
				tv_exit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						GameScene.getGameScene().closeGameScene();  
						MainActivity.getMainActivity().closeMainActivity();
						SuccessActivity.this.finish();
						
					}
				});
		
	}

}
