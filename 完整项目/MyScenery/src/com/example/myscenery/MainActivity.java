package com.example.myscenery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private int[] images={R.drawable.p01,R.drawable.p02,R.drawable.p03,
			              R.drawable.p04,R.drawable.p05,R.drawable.p06};
	private int[] contentIds={R.raw.w01,R.raw.w02,R.raw.w03,
			R.raw.w04,R.raw.w05,R.raw.w06};
	private MyImageView mImageView;
	private String[] names = new String[]{"������","�˴�ɽ�˼����","������",
			"��ɽɭ�ֹ�԰","��ɽ���ٹ�","÷��"};
	private String[] briefs = new String[]{"����������¥֮��","���ղأ����У��о�������Ϊһ��",
			"��ɽ��ˮ���羰��ʣ�ʢ��������ˬ","������У��������ȼٵ���ѳ���","�����������̹��ۺ����ʥ��","ɽ���϶룬���͵��䣬��ʱ��������������"};
	private ListView mListView;
	//�������������
	private List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
	private LinearLayout mLinearLayout;
	private ImageView[] mViews = new ImageView[images.length];//��������СԲȦͼƬ
	private int lastClick =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ͼƬ����
		mImageView=(MyImageView) findViewById(R.id.mImageView);
		mImageView.initImages(images);
		mImageView.start();
		
		
		
		//�������СԲȦ
		mLinearLayout = (LinearLayout)findViewById(R.id.mLinearLayout);
		//��ʼ��
		initLinearLayout();
		//�б�����
		mListView = (ListView)findViewById(R.id.mList);
		initDatas();
		SimpleAdapter adapter = new SimpleAdapter(this,datas,R.layout.item,
				new String[]{"img","name","brief"},new int[]{R.id.img,R.id.name,R.id.brief});
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, SceneryDetail.class);
					//ͼƬ�����⣬��������
					intent.putExtra("imgage", images[arg2]);
					intent.putExtra("name", names[arg2]);
					intent.putExtra("content", contentIds[arg2]);
					startActivity(intent);
				
			}
			
		});
	}
	public void initLinearLayout(){
		MyClickListener mListenter = new MyClickListener();
		for(int i=0; i<mViews.length; i++){
			mViews[i] = new ImageView(this);
			if(i==0){
				mViews[i].setImageResource(R.drawable.choosed);
				mViews[i].setAlpha(1.0f);
				
			}
			else{
				mViews[i].setImageResource(R.drawable.unchoosed);
				mViews[i].setAlpha(0.3f);
			}
			mViews[i].setPadding(30, 0, 0, 0);//����ÿ��СԲȦ����߾�
			mViews[i].setId(i);
			mLinearLayout.addView(mViews[i]);
			mViews[i].setOnClickListener(mListenter);
		}
		
	}
	private class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			mViews[lastClick].setImageResource(R.drawable.unchoosed);
			mViews[lastClick].setAlpha(0.3f);
			mViews[arg0.getId()].setImageResource(R.drawable.choosed);
			mViews[arg0.getId()].setAlpha(1.0f);
			
			//ͼƬ��������Ӧ��λ��
			if(lastClick!=arg0.getId()){
				mImageView.scrollToTarget(arg0.getId());
				
			}
			lastClick=arg0.getId();
			
		}
		
	}
	
	//��Ҫ�ṩһ��������ʹ���������ܹ�ͨ���˷���ͨѶ��������������СԲȦ
	public void scrollToTarget(int targetIndex){//СԲȦ�ı仯
		mViews[lastClick].setImageResource(R.drawable.unchoosed);
		mViews[lastClick].setAlpha(0.3f);
		mViews[targetIndex].setImageResource(R.drawable.choosed);
		mViews[targetIndex].setAlpha(1.0f);
		lastClick=targetIndex;
		
	}
	//�����ת
	public void showDetail(){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, SceneryDetail.class);
		intent.putExtra("imgage", images[lastClick]);
		intent.putExtra("name", names[lastClick]);
		intent.putExtra("content", contentIds[lastClick]);
		startActivity(intent);
		
	}
	//����һ������initDatas()׼������
	public void initDatas(){
		for(int i=0; i<images.length;i++){
			Map<String, Object> map = new HashMap <String, Object>();
			map.put("img",images[i]);
			map.put("name",names[i]);
			map.put("brief",briefs[i]);
			datas.add(map);
			
		}
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
