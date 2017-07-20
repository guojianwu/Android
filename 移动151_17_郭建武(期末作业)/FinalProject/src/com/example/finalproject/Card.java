package com.example.finalproject;

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
		//��Java�����������
		label=new TextView(getContext());
		label.setTextSize(25);
		label.setBackgroundResource(R.drawable.border_card0);
		label.setGravity(Gravity.CENTER);
		//LayoutParams ��֪ʶ�򵥵�����������Ŀ�ߣ����У���ߵ�ֵ�������ó������������֮һ
		//1��һ��ȷ����ֵ
		//2��ȡֵΪ-1����ʾViewGround.LayoutParams.MATCH_PARENT
		//2��ȡֵΪ-2����ʾViewGround.LayoutParams.WRAP_CONTENT
	    LayoutParams lp=new LayoutParams(-1,-1);
	    lp.setMargins(1, 1, 0, 0);
		this.addView(label,lp);
	}
	//�ṩnum���������ͷ�����
	public void setNum(int num){
		this.num=num;
		
	}
	
	public int getNum(){
		return num;
	}
	
	public boolean isEqual(Card c){
		return getNum()==c.getNum();
	}
	public void setCardColor(int num){
		switch (num) {
		case 1:
			label.setBackgroundResource(R.drawable.border_card0002);
			break;
		case 11:
			label.setBackgroundResource(R.drawable.border_card0002_1);
			break;
		case 2:
			label.setBackgroundResource(R.drawable.border_card0003);
			break;
		case 22:
			label.setBackgroundResource(R.drawable.border_card0003_1);
			break;
		case 3:
			label.setBackgroundResource(R.drawable.border_card0004);
			break;
		case 33:
			label.setBackgroundResource(R.drawable.border_card0004_1);
			break;
		case 4:
			label.setBackgroundResource(R.drawable.border_card0005);
			break;
		case 44:
			label.setBackgroundResource(R.drawable.border_card0005_1);
			break;
		case 5:
			label.setBackgroundResource(R.drawable.border_card0006);
			break;
		case 55:
			label.setBackgroundResource(R.drawable.border_card0006_1);
			break;
		case 6:
			label.setBackgroundResource(R.drawable.border_card0007);
			break;
		case 66:
			label.setBackgroundResource(R.drawable.border_card0007_1);
			break;
		
			
		}
	}
	
	

}








