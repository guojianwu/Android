package com.example.whiteblock;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class FailureActicity extends Activity {
	
	private TextView tv_top,tv_exit,tv_again;
	private int index;
	private String oldScore;
	private MyDatabaseUtil mUtil;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.failure_activity);
		//��ô�������INDEX,����INDEX����ֵ����ѯ���ݿ⣬�Ի����ʷ��ѳɼ�
		tv_top=(TextView) findViewById(R.id.tv_top);
		tv_exit=(TextView) findViewById(R.id.tv_exit);
		tv_again=(TextView) findViewById(R.id.tv_again);
		
		Bundle bundle =this.getIntent().getExtras();
		index=bundle.getInt("INDEX");
		mUtil=new MyDatabaseUtil(this, "newrecord.db", null, 1);
		db=mUtil.getWritableDatabase();
		oldScore=mUtil.getScoreValueById(db, index+"");
		tv_top.setText("��ʷ��ѣ�"+oldScore+"\n����"+(index+1));
		
		
		//����
		tv_again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(FailureActicity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
		
		//�˳�
		tv_exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				FailureActicity.this.finish();
				GameScene.getGameScene().closeGameScene();  
				MainActivity.getMainActivity().closeMainActivity();
			}
		});
		
		
	}
	
}
