package com.example.whiteblock;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Audio;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameScene extends Activity{
	
	private int[][] btnId=new int[][]{{R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14},
									 {R.id.btn21,R.id.btn22,R.id.btn23,R.id.btn24},
									 {R.id.btn31,R.id.btn32,R.id.btn33,R.id.btn34},
									 {R.id.btn41,R.id.btn42,R.id.btn43,R.id.btn44}};
	private Button[][] mBtns=new Button[4][4];
	private TextView text_time;
	ProgressBar progress;
	
	private int num[][]=new int[4][4];
	private int position[]=new int[4];
	private int blockNum=0;
	private double seconds=0;
	private Timer timer;
	private Handler mHandler;
	private boolean isStart=false; //是否点击开始按钮
	private boolean isFirstClick=true;
	private SoundPool sp;
	private HashMap<Integer, Integer> spMap =new HashMap<Integer, Integer>();
	
	
	
	
	private int[] litterStar=new int[]{ //小星星
			1,1,5,5,6,6,5,   4,4,3,3,2,2,1,
			5,5,4,4,3,3,2,   5,5,4,4,3,3,2,
			1,1,5,5,6,6,5,   4,4,3,3,2,2,1};
	private int[] theEndofTheWorld =new int[] { //后会无期
			13,13,12,11,13,16,15,12,    11,11,7,6,11,14,13,13,
			12,16,15,16,   15,16,17,17,15,13,15,
			13,15,16,15,15,14,13,12,12,12,13,14,
			13,13,12,11,13,16,15,12,    11,11,7,6,11,14,13,13,
			12,16,15,16,   15,16,17,17,15,13,15,
			13,15,16,14,14,12,11,7,7,12,11,11,			
			11,6,6,11,11,14,14,16,16,16,15,13,13,13,
			13,14,13,14,14,  14,14,15,15,13,13,
			15,15,17,17,15,13,15,  13,15,17,17,15,13,15,
			13,16,15,15,14,13,12, 13,14,14,
			13,13,12,11,13,16,15,12,    11,11,7,6,11,14,13,13,
			12,16,15,16,  15,16,17,17,15,13,15,
			14,15,16,14,14,12,11,7,7,7,12,11,11 };
	private int[] littleApple=new int[] { //小苹果
		1,1,1,1,1,1,1,    1,1,1,1,1,1,1,    5,5,5,5,5,6,5,6,
		1,1,1,1,1,1,1,    1,1,1,1,1,1,1,   	5,5,5,5,5,6,5,6,
		6,6,6,7,1,3,2,1,7,6,7,6,7,  5,5,5,6,7,2,1,7,6,5,6,5,6,
		6,6,6,7,1,3,2,1,7,6,7,6,7,  5,5,5,6,7,2,1,7,6,5,6,5,6,
		3,1,2,6,3,2,1,2,6,    3,1,2,2,5,3,7,1,  
		1,7,6,7,1,2,5,6,5,3,3,    3,2,1,2,3,2,3,2,5,5,   
		3,1,2,6,3,2,1,2,16,    3,1,2,2,2,5,3,7,1, 
		1,7,6,7,1,2,5,6,5,3,3,    3,2,1,2,3,2,5,6,6,1,6  };	
	private int[] outsideWorld=new int[] {  //外面的世界
		13,13,13,15,15,14,13,   13,13,12,11,   12,12,11,13,
		13,13,13,15,15,16,16,   13,13,12,11,   11,12,15,12,11,
		14,14,14,15,15,15,16,15,   12,13,14,15,15,15,12,13,
		14,14,14,14,15,15,15,15,16,15,15,13,   13,12,12,12,11,12,12,12,13,13,12,
		13,13,13,13,15,15,15,14,13,  13,12,11,11,12,12,12,11,13,
		13,13,13,15,15,15,16,16,     13,13,11,13,13,12,15,12,11  };

	
	private int soundNum=-1; //播放的音符号
	private int soungIndex;  //0位第一首，1位第二首
	private int maxNum;  //哥的长度
	private static GameScene gameScene =null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_scene);
		MyClickListener mListener=new MyClickListener();
		
		
		// 关联界面组件id和按钮
		for (int i = 0; i < 4; i++) {
			//再次处生产每行黑块的位置
			position[i]=(int)(Math.random()*4);
			for (int j = 0; j < 4; j++) {
				mBtns[i][j]=(Button) findViewById(btnId[i][j]);
				mBtns[i][j].setOnClickListener(mListener);
				if(i!=3){
					//判断每行的黑块位置，然后设置黑色背景，其余十的设置白色背景
					if(position[i]==j){
						//黑色
						mBtns[i][j].setBackgroundResource(R.drawable.border_black);
						num[i][j]=0;
					}else{
						mBtns[i][j].setBackgroundResource(R.drawable.border_white);
						num[i][j]=1;
					}
				}else{
					//设置按钮背景颜色为黄色
					mBtns[i][j].setBackgroundResource(R.drawable.border_yellow);
					num[i][j]=4;
				}				
			}

		}
	
			mBtns[2][position[2]].setText("开始");
			mBtns[2][position[2]].setTextSize(30);
			mBtns[2][position[2]].setTextColor(Color.YELLOW);
			
			text_time=(TextView) findViewById(R.id.text_time);
			progress=(ProgressBar) findViewById(R.id.progress);
			progress.setProgress(0);  //设置当前进度
			
			//定义一个initMySound（）来实现加载音频资源和获取歌曲编号
			initMySound();
			
			mHandler=new Handler(){

				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					if(msg.what==0x55){
						seconds++;
						text_time.setText(seconds/1000+"''");
					}
					super.handleMessage(msg);
				}
				
			};
	
	}
	
	private void initMySound(){
		sp=new SoundPool(1,AudioManager.STREAM_MUSIC,0);
		spMap.put(1, sp.load(this, R.raw.white11,1));
		spMap.put(2, sp.load(this, R.raw.white12,1));
		spMap.put(3, sp.load(this, R.raw.white13,1));
		spMap.put(4, sp.load(this, R.raw.white14,1));
		spMap.put(5, sp.load(this, R.raw.white15,1));
		spMap.put(6, sp.load(this, R.raw.white16,1));
		spMap.put(7, sp.load(this, R.raw.white17,1));
		
		spMap.put(11, sp.load(this, R.raw.white21,1));
		spMap.put(12, sp.load(this, R.raw.white22,1));
		spMap.put(13, sp.load(this, R.raw.white23,1));
		spMap.put(14, sp.load(this, R.raw.white24,1));
		spMap.put(15, sp.load(this, R.raw.white25,1));
		spMap.put(16, sp.load(this, R.raw.white26,1));
		spMap.put(17, sp.load(this, R.raw.white27,1));
		
		spMap.put(20, sp.load(this, R.raw.wao,1));
		spMap.put(21, sp.load(this, R.raw.lose,1));
		
		
		//获取从MianActivity界面传送过来的歌曲信息
		Bundle bundle=this.getIntent().getExtras();
		soungIndex=bundle.getInt("SONG_INDEX");
		switch (soungIndex) {
		case 0:
			maxNum=litterStar.length;
			break;
		case 1:
			maxNum=theEndofTheWorld.length;
			break;
		case 2:
			maxNum=littleApple.length;
			break;
		case 3:
			maxNum=outsideWorld.length;
			break;
		}
		
	}
	
	
	
	private class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//如果游戏还没开始，此时如果点击开始按钮，则游戏开始执行
			//否则如果游戏正在进行，此时计时器计时，若用户点击了倒数第二行的黑块，则要更新进度条，播放下一个音符
			if(!isStart){ //游戏没开始
				//点击了开始按钮
				if(arg0==mBtns[2][position[2]]){
					isStart=true;
					//开始计时，开始按钮背景更换为灰色，文字清空，游戏
					startTimer();
					((Button)arg0).setBackgroundResource(R.drawable.border_gray);
					((Button)arg0).setText("");
					playGame(); //有待实现
				}
				
			}else{  //游戏已经开始
				//如果点击的是倒数第二行的黑块-》灰快
				if(arg0==mBtns[2][position[2]]){
					((Button)arg0).setBackgroundResource(R.drawable.border_gray);
					playGame(); //有待实现
				}else{
					//更新成红快，发出失败的声音，跳转到失败的页面，停止计时
					((Button)arg0).setBackgroundResource(R.drawable.border_red);
					timer.cancel();
					Intent intent=new Intent();
					intent.setClass(GameScene.this, FailureActicity.class);
					
					Bundle bundle=new Bundle();
					bundle.putInt("INDEX", soungIndex);
					intent.putExtras(bundle);
					startActivity(intent);
					overridePendingTransition(R.anim.flip_down_in, R.anim.flip_down_out);
					playSounds(21,0);
					

				}
				
			}
		}
		
	}
	public void playGame(){
		//1、数组num对应的值要更新成2，表示灰色
		//2、播放对应歌曲的下一个音符
		//3、maxNum==歌曲的长度，blockNum==表示被点击的黑块数，即已经播放的音符数--》计算出进度条的位置
		//4、前三行的块往下移一行，第一行重新  产生黑块位置
		//5、完成判断进行跳转成功的页面
		num[2][position[2]]=2;
		soundNum++;
		switch (soungIndex) {
		case 0:
			playSounds(litterStar[soundNum], 0);
			break;
		case 1:
			playSounds(theEndofTheWorld[soundNum], 0);
			break;
		case 2:
			playSounds(littleApple[soundNum], 0);
			break;
		case 3:
			playSounds(outsideWorld[soundNum], 0);
			break;
		}
		blockNum++;
		progress.setProgress(blockNum*100/maxNum);
		downTiles();
		//判断是否完成
		if(blockNum==maxNum){
			//停止计时器，条状到成功页（歌曲索引，当前用时），播放动画和音频
			timer.cancel();
			Intent intent=new Intent();
			intent.setClass(GameScene.this, SuccessActivity.class);
			Bundle bundle=new Bundle();
			bundle.putInt("INDEX", soungIndex);
			String temp=text_time.getText().toString();
			temp=temp.substring(0, temp.length()-2);
			bundle.putDouble("SECONDS", Double.parseDouble(temp));
			intent.putExtras(bundle);
			startActivity(intent);
			overridePendingTransition(R.anim.bounce_down_in, R.anim.bounce_up_out);
			playSounds(20, 0);
		}
	}
	
	public void downTiles(){
		//原来的1到3行整体往下移动
		for (int i = 3; i >0; i--) {
			//按钮背景颜色更改，num数组同步更新，position同步更新
			position[i]=position[i-1];
			for (int j = 0; j < 4; j++) {
				num[i][j]=num[i-1][j];
			}
		}
		//第一行随机生成一个黑块
		position[0]=(int)(Math.random()*4);
		for(int j=0;j<4;j++){
			if(j == position[0]){
				num[0][j]=0;
			}else{
				num[0][j]=1;
			}
		}
		
		//从倒数第三行开始显示绿色
		if(blockNum>=maxNum-2){
			for (int j = 0; j < 4; j++) {
				num[0][j]=3;
				
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				switch (num[i][j]) {
				case 0:
					mBtns[i][j].setBackgroundResource(R.drawable.border_black);
					break;
				case 1:
					mBtns[i][j].setBackgroundResource(R.drawable.border_white);
					break;
				case 2:
					mBtns[i][j].setBackgroundResource(R.drawable.border_gray);
					break;
				case 3:
					mBtns[i][j].setBackgroundResource(R.drawable.border_green);
					break;
					
				}
			}
		}
		
	}
	
	
	public void playSounds(int sound,int number){
		//获得音频管理器
				AudioManager am=(AudioManager) this.getSystemService(this.AUDIO_SERVICE);
				//获取当前手机最大铃声
				float audioMaxVoum=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
				//获取当前手机的最大音量
				float audioCurrentVolumn=am.getStreamVolume(AudioManager.STREAM_MUSIC);
				
				//计算变化率
				float volumRatio=audioCurrentVolumn/audioMaxVoum;
				sp.play(spMap.get(sound), volumRatio, volumRatio, 1, number, 1);
				//播放的音乐id；左声道音量，右声道音量，优选级：0为最低，循环次数：0不循环，
	}
	
	
	public void startTimer(){
		timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mHandler.sendEmptyMessage(0x55);
			}
		}, 0, 1);
	}
	
	//gameScene对象指向当前界面
	public GameScene(){
		gameScene=this;
	}
	
	public static GameScene getGameScene(){
		return gameScene;
	}
	public void closeGameScene(){
		GameScene.this.finish();
	}
	

}








