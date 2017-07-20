package com.example.mygame2048;

import java.util.HashMap;

import android.R.raw;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView currentScore,topScore;
	private static MainActivity mainActivity=null;	
	private int score=0,top=0;
	
	private SoundPool sp;  //��Ƶ��
	private HashMap<Integer, Integer> spMap=new HashMap<Integer, Integer>();
	private MyDataBaseUtil mUtil;
	private SQLiteDatabase db;
	private int oldScore,newScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentScore=(TextView) findViewById(R.id.currentScore);
        topScore=(TextView) findViewById(R.id.topScore);

        sp=new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        spMap.put(1, sp.load(this,R.raw.sound01,1 ));
        
        mUtil=new MyDataBaseUtil(this, "newrecord", null, 1);
        db=mUtil.getWritableDatabase();
        
        //��ȡ��ʷ��߷�
        getHeihtScore();
    }


    private void getHeihtScore() {
		String temp=mUtil.getScoreById(db, "1");
		topScore.setText("��߷���\n"+temp);
		oldScore=Integer.parseInt(temp);
	}
    
    public void addScore(int s){
    	score+=s;
    	currentScore.setText("����\n"+score);
    	if(score>oldScore){
    		//�������ݿ���ʷ��ߣ�������߷����ı���Ҫˢ��
    		mUtil.updateScoreValue(db, "1", score+"");
    		topScore.setText("��߷���\n"+score);
    	}
    }
    
    public MainActivity(){
    	mainActivity=this;
    }
    public static MainActivity getMainActivity(){
    	return mainActivity;
    }
    
    public void playSounds(int sound){
    	AudioManager am=(AudioManager)this.getSystemService(this.AUDIO_SERVICE);
    	float audioMaxVoum=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		//��ȡ��ǰ�ֻ����������
		float audioCurrentVolumn=am.getStreamVolume(AudioManager.STREAM_MUSIC);
		
		//����仯��
		float volumRatio=audioCurrentVolumn/audioMaxVoum;
		sp.play(spMap.get(sound), volumRatio, volumRatio, 1, 0, 1);
		//���ŵ�����id����������������������������ѡ����0Ϊ��ͣ�
    }
    
    public void loseGame(){
    	Intent intent=new Intent();
    	intent.setClass(MainActivity.getMainActivity(), Failure.class);
    	Bundle bundle=new Bundle();
    	bundle.putInt("SCORE", score);
    	intent.putExtras(bundle);
    	startActivity(intent);
    }


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
