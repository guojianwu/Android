package com.example.calculator;

import java.lang.reflect.WildcardType;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private int[] numberIds={R.id.btn_0,R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,
			R.id.btn_5,R.id.btn_6,R.id.btn_7,R.id.btn_8,R.id.btn_9,R.id.btn_dot};
	//实现了加，减。，除，等于，退格，清零，模，倒数，开方
	private int[] operatorIds={R.id.btn_plus,R.id.btn_minus,R.id.btn_mul,R.id.btn_div,
			R.id.btn_equal,R.id.btn_arrow,R.id.btn_clear,R.id.btn_mode,R.id.btn_daoshu,R.id.btn_root};
	private Button[] numBtns=new Button[numberIds.length];
	private Button[] operatorBtns=new Button[operatorIds.length];
	private EditText edit;
	//定义第一个操作数，第二个操作数，第三个操作数
	private String num01Str,num02Str,operStr,tempStr;
	private double result; //计算结果
	private boolean lastClickIsNum=false; //上一次点击的是否是数字
	private boolean isFisrtClickOpre=true; //是否第一次点击运算符
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NumberListener numLisLener=new NumberListener();
		
		for (int i = 0; i < numberIds.length; i++) {
			numBtns[i]=(Button) findViewById(numberIds[i]);
			numBtns[i].setOnClickListener(numLisLener);  //需要实现数字监听器
			
			
		}
		OperatorListener operatorListener=new OperatorListener();
		for (int i = 0; i < operatorIds.length; i++) {
			operatorBtns[i]=(Button) findViewById(operatorIds[i]);
			operatorBtns[i].setOnClickListener(operatorListener);  //需要实现运算监听器
			
			
		}
		
		edit=(EditText) findViewById(R.id.edit);
		
	}
	
	public class NumberListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			//若上次点击的你是数字，则1、如果点了小数点，则操作数应和显示均为0.，否则直接显示数字
			//若上次点击的是数字，则如果点击了小数点，则应选判断是否含有小数点
			//若含有小数点，则直接返回；否则点击了数字，需要进行串接
			if(lastClickIsNum){
				if(arg0.getId()==R.id.btn_dot){
					if(tempStr.indexOf(".") > 0){
						return;
					}
				}
				tempStr=tempStr+ ((Button)arg0).getText().toString();
				
			}else{
				//上次点击的不是数字，则意味着要新产生一个操作数
				if(arg0.getId()==R.id.btn_dot){
					tempStr="0.";
				}else {
					tempStr= ((Button)arg0).getText().toString();
				}
				
			}
			
			//消除多余的0
			tempStr=clearZero(tempStr);
			edit.setText(tempStr);
			lastClickIsNum=true;
			
		}
	}
	public class OperatorListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			if(arg0.getId()==R.id.btn_clear){
				reset();
				edit.setText("0");
				return;
			}
			if(arg0.getId()==R.id.btn_arrow){
				if(tempStr.length()>1){
					tempStr=tempStr.substring(0, tempStr.length()-1);
				}else{
					tempStr="0";
				}
				edit.setText(tempStr);
			}
			if(arg0.getId()==R.id.btn_daoshu){
				String str=edit.getText().toString();
				double a=Double.parseDouble(str); 
				if(a==0){
					new AlertDialog.Builder(MainActivity.this)
					.setTitle("错误")
					.setMessage("分母不能为0")
					.setPositiveButton("OK", null)
					.show();
				}else {
					result=1/a;
					edit.setText("1/"+str+"="+result);
					return;
				}
			}
			if(arg0.getId()==R.id.btn_root){
				String str=edit.getText().toString();
				double a=Double.parseDouble(str); 
				result=Math.sqrt(a);
				edit.setText("√"+str+"="+result);
			}
			
			//=+-*/
			//如果上一次点击的是数字，并且这是第一次点击运算符，如果点击的不把是=，把tempStr作为第一个操作数并且保存运算符
			//如果上一次点击的是数字，并且这不是第一次点击运算符，把tempStr作为第二操作数，求出运算结果，且把运算结果作为第一个操作数
			//如果上一次点击的是数字，并且如果点击的是=，则reset（）；
			//                   如果点击的是+-*/则把运算结果作为下一轮运算的第一个操作符
			//如果上次点击的不是数字保存最新的运算符
			
			String oper=((Button)arg0).getText().toString(); //保存最新+-*/
			if(lastClickIsNum){
				if(isFisrtClickOpre){
					if(!oper.equals("=")){
						num01Str=tempStr;  //获取第一个操作数
						operStr=oper;      //保存运算符
						isFisrtClickOpre=false;
					}
				}else{
					num02Str=tempStr;
					//定义方法getResult()来计算并显示+-*/的运算结果
					getResult();
					if(oper.equals("=")){
						reset();
					}else{
						num01Str=""+result;
						edit.setText(num01Str);
						//tempStr=num01Str;
						operStr=oper;
					}
				}
			}else{
				operStr=oper;//保存最新+-*/
				
			}
			lastClickIsNum=false;
			
		}
		
	}
	
	
	public void getResult(){
		double num1=Double.parseDouble(num01Str);
		double num2=Double.parseDouble(num02Str);
		if(operStr.equals("+")){
			result=num1+num2;
		}else if(operStr.equals("-")){
			result=num1-num2;
		}else if(operStr.equals("*")){
			result=num1*num2;
		}else if(operStr.equals("/")){
			result=num1/num2;
		}else if(operStr.equals("%")){
			result=num1%num2;
		}
		edit.setText(num01Str+operStr+num02Str+"="+result);
	}
	
	public void reset(){
		//所以成员变量恢复初始值
		num01Str="";
		num02Str="";
		tempStr="";
		operStr="";
		lastClickIsNum=false;
		isFisrtClickOpre=true;
	}
	
	
	
	public String clearZero(String s){
		while (!s.startsWith("0.") && s.startsWith("0") && s.length()>1) {
			s=s.substring(1);
		}
		return s;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
