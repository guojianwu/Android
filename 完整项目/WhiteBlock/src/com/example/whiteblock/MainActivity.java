package com.example.whiteblock;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private int[]btnIds=new int[]{R.id.btn01,R.id.btn02,
								  R.id.btn03,R.id.btn04};
	private Button[] btns=new Button[btnIds.length];
	private int songIndex=0;
	private SoundPool sp;//得到一个声音池
	private HashMap<Integer,Integer>spMap=new HashMap<Integer, Integer>();
	//映射
	//<键，值> <1,..> <2,..>
	private static MainActivity mainActivity =null;
	
	
	//private MyDatabaseUtil mUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyClickListener mListener=new MyClickListener();
		for (int i = 0; i < btns.length; i++) {
			btns[i]=(Button)findViewById(btnIds[i]);
			btns[i].setTag(i);
			btns[i].setOnClickListener(mListener);
		}
		sp=new SoundPool(1,AudioManager.STREAM_MUSIC,0);
		//创建集合存放音频资源
		spMap.put(1, sp.load(this, R.raw.go,1));
		
	}
	
	
	public class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			songIndex=(Integer)arg0.getTag();
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, GameScene.class);
			Bundle bundle=new Bundle();
			bundle.putInt("SONG_INDEX", songIndex);
			intent.putExtras(bundle);
			startActivity(intent);
			//动画跳转
			overridePendingTransition(R.anim.fade_in, R.anim.rotate_out);
			//播放音频
			playSounds(1);
		}
		
	}
	public void playSounds(int sound){
		//获得音频管理器
		AudioManager am=(AudioManager) this.getSystemService(this.AUDIO_SERVICE);
		//获取当前手机最大铃声
		float audioMaxVoum=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		//获取当前手机的最大音量
		float audioCurrentVolumn=am.getStreamVolume(AudioManager.STREAM_MUSIC);
		
		//计算变化率
		float volumRatio=audioCurrentVolumn/audioMaxVoum;
		sp.play(spMap.get(sound), volumRatio, volumRatio, 1, 0, 1);
		//播放的音乐id；左声道音量，右声道音量，优选级：0为最低，循环次数：0不循环，-1表示永远循环
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//gameScene对象指向当前界面
	
		public MainActivity(){
			mainActivity=this;
		}
		
		public static MainActivity getMainActivity(){
			return mainActivity;
		}
		public void closeMainActivity(){
			MainActivity.this.finish();
		}

}
