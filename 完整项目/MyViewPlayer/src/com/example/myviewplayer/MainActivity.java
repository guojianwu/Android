package com.example.myviewplayer;

import android.app.Activity;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private ViewPager mpager;
	private LinearLayout mLinearLayout;
	private Button btn01, btn02;
	private int[] viewId = { R.layout.page01, R.layout.page02, R.layout.page03,
			R.layout.page04 };
	private View[] views = new View[viewId.length];
	private ImageView[] mImages = new ImageView[viewId.length];
	private int lastClick = 0;// ���ڱ����ϴα�ѡ�е�ҳ������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		mpager = (ViewPager) findViewById(R.id.mPager);
		for (int i = 0; i < viewId.length; i++) {
			views[i] = getLayoutInflater().inflate(viewId[i], null);
		}
		mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
		btn01 = (Button) findViewById(R.id.btn01);
		btn02 = (Button) findViewById(R.id.btn02);
		// ����ViewPager,��Ҫʹ����������������ݵ�װ�صȲ���
		// ����������������
		MyPagerAdapter mAdapter = new MyPagerAdapter();
		mpager.setAdapter(mAdapter);
		// ҳ�滬���¼����·����ĸ���ťҪͬ������
		mpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				// ҳ�汻ѡ����󣬸����ĸ�СԲȦ
				mImages[lastClick].setImageResource(R.drawable.unchoosed);
				mImages[arg0].setImageResource(R.drawable.choosed);
				lastClick = arg0;
				if (arg0 == 3) {
					btn01.setVisibility(View.INVISIBLE);
					btn02.setVisibility(View.VISIBLE);

				} else {
					btn02.setVisibility(View.INVISIBLE);
					btn01.setVisibility(View.VISIBLE);
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		// ����һ������initLinearlayout()��ʼ�����Բ��ֵ�����
		initLinearlayout();
		btn01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, MyCaculator.class);
				startActivity(intent);
			}
		});
		btn02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, MyCaculator.class);
				startActivity(intent);
			}
		});
	}

	public void initLinearlayout() {
		MyClickListener mListener = new MyClickListener();
		for (int i = 0; i < mImages.length; i++) {
			mImages[i] = new ImageView(this); // �����ĸ���ťͼƬ����
			// ��ʼ���ĸ���ťͼƬ����
			if (i == 0) {
				mImages[i].setImageResource(R.drawable.choosed);
			} else {
				mImages[i].setImageResource(R.drawable.unchoosed);
			}
			mImages[i].setPadding(20, 0, 0, 0);// ����ԲȦͼƬ���
			mImages[i].setId(i);// Ϊÿ��ԲȦ��ť���ID
			mLinearLayout.addView(mImages[i]);// ���ĸ�ԲȦ��ťһ����ӵ����Բ�����
			// Ϊÿ��ԲȦ��ť��Ӽ��������Ա�����Ӧ�İ�ť����ת����Ӧ��ҳ��
			mImages[i].setOnClickListener(mListener);
		}

	}

	private class MyClickListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// ���ϴ�ѡ�е����ó�δѡ��
			mImages[lastClick].setImageResource(R.drawable.unchoosed);
			// ���õ�ǰ���еİ�ťͼƬ����
			((ImageView) arg0).setImageResource(R.drawable.choosed);
			lastClick = arg0.getId();
		}

	}

	private class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return viewId.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub

			container.removeView(views[position]);

		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub

			container.addView(views[position]);
			return views[position];
		}

	}

	// onAttachedToWindow����ʵ��Activity/View��������ӵ�ʱ����ã���ÿ��View֮����һ��
	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();

		View view = getWindow().getDecorView();
		WindowManager.LayoutParams lp = (WindowManager.LayoutParams) view
				.getLayoutParams();
		lp.gravity = Gravity.CENTER;
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		lp.width = metric.widthPixels - 50;
		lp.height = metric.heightPixels - 100;
		getWindowManager().updateViewLayout(view, lp);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
}
