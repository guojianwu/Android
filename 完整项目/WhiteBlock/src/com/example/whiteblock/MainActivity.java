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
	private SoundPool sp;//�õ�һ��������
	private HashMap<Integer,Integer>spMap=new HashMap<Integer, Integer>();
	//ӳ��
	//<����ֵ> <1,..> <2,..>
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
		//�������ϴ����Ƶ��Դ
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
			//������ת
			overridePendingTransition(R.anim.fade_in, R.anim.rotate_out);
			//������Ƶ
			playSounds(1);
		}
		
	}
	public void playSounds(int sound){
		//�����Ƶ������
		AudioManager am=(AudioManager) this.getSystemService(this.AUDIO_SERVICE);
		//��ȡ��ǰ�ֻ��������
		float audioMaxVoum=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		//��ȡ��ǰ�ֻ����������
		float audioCurrentVolumn=am.getStreamVolume(AudioManager.STREAM_MUSIC);
		
		//����仯��
		float volumRatio=audioCurrentVolumn/audioMaxVoum;
		sp.play(spMap.get(sound), volumRatio, volumRatio, 1, 0, 1);
		//���ŵ�����id����������������������������ѡ����0Ϊ��ͣ�ѭ��������0��ѭ����-1��ʾ��Զѭ��
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//gameScene����ָ��ǰ����
	
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
