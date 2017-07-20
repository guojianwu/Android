package com.example.myscenery;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class SceneryDetail extends Activity {
	private ImageView imageView;
	private TextView title,contenView;
	private ClipDrawable clipDrawable;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		imageView=(ImageView)findViewById(R.id.imageView);
		title=(TextView)findViewById(R.id.title);
		contenView=(TextView)findViewById(R.id.contentView);
		//获取Intent
		Intent intent=getIntent(); 
		String name =intent.getStringExtra("name");
		int imageId = intent.getIntExtra("imgage", R.drawable.p01);
		//改变标题名
		title.setText(name);
		//设置水平展开
		clipDrawable = new ClipDrawable(getResources().getDrawable(imageId),Gravity.CENTER,ClipDrawable.HORIZONTAL);
		imageView.setImageDrawable(clipDrawable);
		
		int contentId = intent.getIntExtra("content", R.raw.w01);
		//字节流读取文档,输入流
		InputStream inStream = getResources().openRawResource(contentId);
		contenView.setText(readFile(inStream));
		
		startThread();
		
		mHandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what==0x11){
					clipDrawable.setLevel(clipDrawable.getLevel()+400);
				}
				super.handleMessage(msg);
			}
			
		};
	}
	//String 长度不可变类，StringBuffer，StringBuilder长度可变字符串类
	//StringBuffer sb = new StringBuffer("abc");
	//sb.delete[0,2);"c"  删除
	//sb.append("abc");"cabc“  追加
	//定义一个方法，实现从输入流读取数据
	public String readFile(InputStream inStream){
		//**********************
		byte[] buffer = new byte[1024];
		int hasRead = 0;
		StringBuffer sBuffer = new StringBuffer();
		try{
		    while ((hasRead = inStream.read(buffer))!=-1){//实际打到的水滴数，没有水返回-1
			//字节数组转字符串
			String temp = new String(buffer,0,hasRead,"GBK");
			sBuffer.append(temp);
			
		}  
		}catch(Exception e){
			e.printStackTrace();
		}
		return sBuffer.toString();
	}
	
	
	
	public void startThread(){
		//控制图片显示
		clipDrawable.setLevel(0);
		//创建一条线程
		new Thread(){
			public void run(){
				while(clipDrawable.getLevel()<10000){
					//休眠，间隔
					try {
						Thread.sleep(300);
						mHandler.sendEmptyMessage(0x11);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

}
