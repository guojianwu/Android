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
	
	private SoundPool sp;  //音频池
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
        
        //获取历史最高分
        getHeihtScore();
    }


    private void getHeihtScore() {
		String temp=mUtil.getScoreById(db, "1");
		topScore.setText("最高分数\n"+temp);
		oldScore=Integer.parseInt(temp);
	}
    
    public void addScore(int s){
    	score+=s;
    	currentScore.setText("分数\n"+score);
    	if(score>oldScore){
    		//更新数据库历史最高，并且最高分数文本框要刷新
    		mUtil.updateScoreValue(db, "1", score+"");
    		topScore.setText("最高分数\n"+score);
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
		//获取当前手机的最大音量
		float audioCurrentVolumn=am.getStreamVolume(AudioManager.STREAM_MUSIC);
		
		//计算变化率
		float volumRatio=audioCurrentVolumn/audioMaxVoum;
		sp.play(spMap.get(sound), volumRatio, volumRatio, 1, 0, 1);
		//播放的音乐id；左声道音量，右声道音量，优选级：0为最低，
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
