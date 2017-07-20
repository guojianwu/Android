package com.example.mystory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView title,page,text;
	private Button btn_last,btn_first,btn_next;
	private ScrollView mScroll;
	private int[] storyIds=new int[]{R.raw.page01,R.raw.page02,R.raw.page03};
	private int num=0;  //用于保存当前的故事索引位置        
	InputStream inStream;   //定义一个输入流用于读外部文件，如果是写内容到文件上，则用的是OutputStream
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		title=(TextView) findViewById(R.id.view_title);
		page=(TextView) findViewById(R.id.view_page);
		text=(TextView) findViewById(R.id.text);
		btn_last=(Button) findViewById(R.id.btn_last);
		btn_first=(Button) findViewById(R.id.btn_first);
		btn_next=(Button) findViewById(R.id.btn_next);
		mScroll=(ScrollView) findViewById(R.id.mScroll);
		//把输入流以文件相关联，相当于打开一个外部文件
		inStream=getResources().openRawResource(storyIds[num]);
		setContent(inStream);
		btn_last.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num==0){
					Toast.makeText(MainActivity.this, "已经是第一篇", Toast.LENGTH_SHORT).show();
				}else {
					num--;
					inStream=getResources().openRawResource(storyIds[num]);
					setContent(inStream);
					mScroll.scrollTo(0, 0);  //重新定位滚动
				}
			}
		});
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num==storyIds.length-1){
					Toast.makeText(MainActivity.this, "已经是最后一篇", Toast.LENGTH_SHORT).show();		
				}else{
					num++;
					inStream=getResources().openRawResource(storyIds[num]);
					setContent(inStream);
					mScroll.scrollTo(0, 0);  //重新定位滚动
				}
			}
		});
		btn_first.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num==0){
					Toast.makeText(MainActivity.this, "已经是第一篇", Toast.LENGTH_SHORT).show();
				}else {
					num=0;
					inStream=getResources().openRawResource(storyIds[num]);
					setContent(inStream);
					mScroll.scrollTo(0, 0);  //重新定位滚动
				}
			}
		});

		
	}
	
	//读取文件内容显示到text控件上
	public void setContent(InputStream inStream){
		BufferedReader buf;
		//StringBuffer  长度可变字符串类，insert插入字符串，append 追加字符串，String
		StringBuffer sBuffer=new StringBuffer();
		String temp="";
		//传入的参数是字节流，读写时为了能够一行一行读，我们用的是字节流，因此需要
		//把字节流转换成字节流，其中中介是InputStreamReader类
		try {
			buf= new BufferedReader(new InputStreamReader(inStream,"GBK"));
			//读文件的第一行
			temp=buf.readLine().toString();
			title.setText(temp);
			while ((temp=buf.readLine())!=null) {
				sBuffer.append(temp);			
			}
			text.setText(sBuffer);
			page.setText((num+1)+"/"+storyIds.length);
			buf.close();
			inStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
