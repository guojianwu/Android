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
	private int num=0;  //���ڱ��浱ǰ�Ĺ�������λ��        
	InputStream inStream;   //����һ�����������ڶ��ⲿ�ļ��������д���ݵ��ļ��ϣ����õ���OutputStream
	
	
	
	
	
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
		//�����������ļ���������൱�ڴ�һ���ⲿ�ļ�
		inStream=getResources().openRawResource(storyIds[num]);
		setContent(inStream);
		btn_last.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num==0){
					Toast.makeText(MainActivity.this, "�Ѿ��ǵ�һƪ", Toast.LENGTH_SHORT).show();
				}else {
					num--;
					inStream=getResources().openRawResource(storyIds[num]);
					setContent(inStream);
					mScroll.scrollTo(0, 0);  //���¶�λ����
				}
			}
		});
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num==storyIds.length-1){
					Toast.makeText(MainActivity.this, "�Ѿ������һƪ", Toast.LENGTH_SHORT).show();		
				}else{
					num++;
					inStream=getResources().openRawResource(storyIds[num]);
					setContent(inStream);
					mScroll.scrollTo(0, 0);  //���¶�λ����
				}
			}
		});
		btn_first.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(num==0){
					Toast.makeText(MainActivity.this, "�Ѿ��ǵ�һƪ", Toast.LENGTH_SHORT).show();
				}else {
					num=0;
					inStream=getResources().openRawResource(storyIds[num]);
					setContent(inStream);
					mScroll.scrollTo(0, 0);  //���¶�λ����
				}
			}
		});

		
	}
	
	//��ȡ�ļ�������ʾ��text�ؼ���
	public void setContent(InputStream inStream){
		BufferedReader buf;
		//StringBuffer  ���ȿɱ��ַ����࣬insert�����ַ�����append ׷���ַ�����String
		StringBuffer sBuffer=new StringBuffer();
		String temp="";
		//����Ĳ������ֽ�������дʱΪ���ܹ�һ��һ�ж��������õ����ֽ����������Ҫ
		//���ֽ���ת�����ֽ����������н���InputStreamReader��
		try {
			buf= new BufferedReader(new InputStreamReader(inStream,"GBK"));
			//���ļ��ĵ�һ��
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
