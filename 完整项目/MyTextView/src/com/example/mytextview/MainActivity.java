package com.example.mytextview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;

public class MainActivity extends Activity {
	private MyMarquee mView01,mView02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		mView01=(MyMarquee) findViewById(R.id.mView01);
		Spanned spanned=Html.fromHtml("同学。你好！欢迎参加广东省大学生<font color='yellow'><b><big>手机设计大赛！！！</font></b></big>");
		mView01.setText(spanned);
		mView01.startMarquee();
		mView01.setTime(50);
		mView01.setSpeed(6);
		
		mView02=(MyMarquee) findViewById(R.id.mView02);
		String text="合作院校：中山火炬职业技术学院 地址：广东省中山市火炬开发区中山港大道60号";
		SpannableString spanText=new SpannableString(text);
		spanText.setSpan(new BackgroundColorSpan(Color.GREEN), 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
		spanText.setSpan(new ForegroundColorSpan(Color.BLUE), 5, 15, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
		spanText.setSpan(new UnderlineSpan(), 5, 15,  Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
		mView02.setText(spanText);
		mView02.startMarquee();
		mView02.setTime(50);
		mView02.setSpeed(6);

	
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
