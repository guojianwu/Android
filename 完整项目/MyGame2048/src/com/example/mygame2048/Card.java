package com.example.mygame2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout{

	private int num=0;
	private TextView label;
	
	
	
	public Card(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//用Java代码生成组件
		label=new TextView(getContext());
		label.setTextSize(25);
		label.setBackgroundResource(R.drawable.border_card0);
		label.setGravity(Gravity.CENTER);
		//LayoutParams 类知识简单地描述了组件的宽高，其中，宽高的值可以设置成以下三种情况之一
		//1、一个确定的值
		//2、取值为-1：表示ViewGround.LayoutParams.MATCH_PARENT
		//2、取值为-2：表示ViewGround.LayoutParams.WRAP_CONTENT
	    LayoutParams lp=new LayoutParams(-1,-1);
	    lp.setMargins(10, 10, 0, 0);
		this.addView(label,lp);
	}
	//提供num的设置器和访问器
	public void setNum(int num){
		this.num=num;
		if(num<=0){
			label.setText("");
		}else{
			label.setText(num+"");
		}
	}
	
	public int getNum(){
		return num;
	}
	
	public boolean isEqual(Card c){
		return getNum()==c.getNum();
	}
	public void setCardColor(int num){
		switch (num) {
		case 0:
			label.setBackgroundResource(R.drawable.border_card0);
			break;
		case 2:
			label.setBackgroundResource(R.drawable.border_card0002);
			break;
		case 4:
			label.setBackgroundResource(R.drawable.border_card0004);
			break;
		case 8:
			label.setBackgroundResource(R.drawable.border_card0008);
			break;
		case 16:
			label.setBackgroundResource(R.drawable.border_card0016);
			break;
		case 32:
			label.setBackgroundResource(R.drawable.border_card0032);
			break;
		case 64:
			label.setBackgroundResource(R.drawable.border_card0064);
			break;
		case 128:
			label.setBackgroundResource(R.drawable.border_card0128);
			break;
		case 256:
			label.setBackgroundResource(R.drawable.border_card0256);
			break;
		case 512:
			label.setBackgroundResource(R.drawable.border_card0512);
			break;
		case 1024:
			label.setBackgroundResource(R.drawable.border_card1024);
			break;
		case 2048:
			label.setBackgroundResource(R.drawable.border_card2048);
			break;
		case 4096:
			label.setBackgroundResource(R.drawable.border_card4096);
			break;
		case 8192:
			label.setBackgroundResource(R.drawable.border_card8192);
			break;
			
		}
	}

}








