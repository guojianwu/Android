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
		//��ȡIntent
		Intent intent=getIntent(); 
		String name =intent.getStringExtra("name");
		int imageId = intent.getIntExtra("imgage", R.drawable.p01);
		//�ı������
		title.setText(name);
		//����ˮƽչ��
		clipDrawable = new ClipDrawable(getResources().getDrawable(imageId),Gravity.CENTER,ClipDrawable.HORIZONTAL);
		imageView.setImageDrawable(clipDrawable);
		
		int contentId = intent.getIntExtra("content", R.raw.w01);
		//�ֽ�����ȡ�ĵ�,������
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
	//String ���Ȳ��ɱ��࣬StringBuffer��StringBuilder���ȿɱ��ַ�����
	//StringBuffer sb = new StringBuffer("abc");
	//sb.delete[0,2);"c"  ɾ��
	//sb.append("abc");"cabc��  ׷��
	//����һ��������ʵ�ִ���������ȡ����
	public String readFile(InputStream inStream){
		//**********************
		byte[] buffer = new byte[1024];
		int hasRead = 0;
		StringBuffer sBuffer = new StringBuffer();
		try{
		    while ((hasRead = inStream.read(buffer))!=-1){//ʵ�ʴ򵽵�ˮ������û��ˮ����-1
			//�ֽ�����ת�ַ���
			String temp = new String(buffer,0,hasRead,"GBK");
			sBuffer.append(temp);
			
		}  
		}catch(Exception e){
			e.printStackTrace();
		}
		return sBuffer.toString();
	}
	
	
	
	public void startThread(){
		//����ͼƬ��ʾ
		clipDrawable.setLevel(0);
		//����һ���߳�
		new Thread(){
			public void run(){
				while(clipDrawable.getLevel()<10000){
					//���ߣ����
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
