package com.example.myviewplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MyCaculator extends Activity {

	private int[] numberIds = { R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
			R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8,
			R.id.btn_9, R.id.btn_dot };
	private int[] operatorIds = { R.id.btn_plus, R.id.btn_minus, R.id.btn_div,
			R.id.btn_mul, R.id.btn_equal, R.id.btn_arrow, R.id.btn_clear,
			R.id.btn_mode, R.id.btn_daoshu, R.id.btn_root };

	private Button[] numBtns = new Button[numberIds.length];
	private Button[] operatorBtns = new Button[operatorIds.length];
	private EditText edit;
	//���x��һ�����������ڶ�������������������м��ַ���
	private String num01Str,num02Str,operStr,tempStr;
	private double result;//������
	private boolean lastClickIsNum = false;//��һ�ε�����Ƿ�������
	private boolean isFirstClickOper = true;//�Ƿ��һ�ε�������
	private MyDataBaseUtil mUtil;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caculator);
		
		NumberListener numListener = new NumberListener();
		OperatorListener operatorListener = new OperatorListener();
		
		for(int i = 0;i<numberIds.length;i++){
			numBtns[i] = (Button)findViewById(numberIds[i]);
			numBtns[i].setOnClickListener(numListener);
		}
		for(int i = 0;i<operatorIds.length;i++){
			operatorBtns[i] = (Button)findViewById(operatorIds[i]);
			operatorBtns[i].setOnClickListener(operatorListener);
		}
		edit = (EditText)findViewById(R.id.edit);
		mUtil = new MyDataBaseUtil(MyCaculator.this, "newApp.db", null, 1);
		db = mUtil.getWritableDatabase();
		String temp = mUtil.getStateById(db, "1");
		if(temp.equals("0")){
			Intent intent = new Intent();
			intent.setClass(MyCaculator.this, MainActivity.class);
			mUtil.updateStateValue(db, "1", "1");
		}
	}
	
	public class NumberListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(lastClickIsNum){
				if(arg0.getId() == R.id.btn_dot){
					if(tempStr.indexOf(".")>0){
						return;
					}
				}
				tempStr = tempStr + ((Button)arg0).getText().toString();
				
			}else{
				if(arg0.getId() == R.id.btn_dot){
					tempStr = "0.";
				}else{
					tempStr = ((Button)arg0).getText().toString();
				}
			}
			
			tempStr = clearZero(tempStr);
			edit.setText(tempStr);
			lastClickIsNum = true;
		}
		
	}
	public class OperatorListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(arg0.getId() == R.id.btn_clear){
				reset();
				edit.setText("0");
				return;
			}
			if(arg0.getId() == R.id.btn_arrow){
				if(tempStr.length()>1){
					tempStr = tempStr.substring(0,tempStr.length()-1);
				}else{
					tempStr = "0";
				}
				edit.setText(tempStr);
				return;
			}
			if(arg0.getId() == R.id.btn_daoshu){
				String str = edit.getText().toString();
				double a = Double.parseDouble(str);
				if(a == 0){
					new AlertDialog.Builder(MyCaculator.this)
					.setTitle("����")
					.setMessage("��ĸ����Ϊ0��")
					.setPositiveButton("OK", null)
					.show();
				}else{
					result = 1/a;
					edit.setText("1/"+str+"="+result);
					return;
				}
			}
			if(arg0.getId() == R.id.btn_root){
				String str = edit.getText().toString();
				double a = Double.parseDouble(str);
				if(a <= 0){
					new AlertDialog.Builder(MyCaculator.this)
					.setTitle("����")
					.setMessage("��������Ϊ0������")
					.setPositiveButton("OK", null)
					.show();
				}else{
					result = Math.sqrt(a);
					edit.setText("��"+str+"="+result);
					return;
				}
				
			}
			String oper = ((Button)arg0).getText().toString();
			if(lastClickIsNum){
				if(isFirstClickOper){
					if(!oper.equals("=")){
						num01Str = tempStr;			//��ȡ��һ��������
						operStr = oper;             //���������
						isFirstClickOper = false;
					}
				}else{
					num02Str = tempStr;			//��ȡ�ڶ���������
					getresult();
					if(oper.equals("=")){
						reset();
					}else{
						num01Str = ""+result;
						edit.setText(num01Str);
						tempStr = num01Str;
						operStr = oper;
					}
				}
			}else{
				operStr = oper;
			}
			lastClickIsNum = false;
		}
		
	}
	public void getresult(){
		double num1 = Double.parseDouble(num01Str);
		double num2 = Double.parseDouble(num02Str);
		if(operStr.equals("+")){
			result = num1 + num2;
		}else if(operStr.equals("-")){
			result = num1 - num2;
		}else if(operStr.equals("*")){
			result = num1 * num2;
		}else if(operStr.equals("/")){
			result = num1 / num2;
		}else if(operStr.equals("%")){
			result = num1 % num2;
		}
		edit.setText(num01Str+operStr+num02Str+"="+result);
	}
	public void reset(){
		num01Str = "";
		num02Str = "";
		tempStr = "";
		operStr = "";
		lastClickIsNum = false;
		isFirstClickOper = true;
	}
	
	public String clearZero(String s){
		while(!s.startsWith("0.") && s.startsWith("0") && s.length()>1){
			s = s.substring(1);
		}
		return s;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_settings:
			Intent intent = new Intent();
			intent.setClass(MyCaculator.this, MainActivity.class);
			startActivity(intent);
		}
		return true;
	}
	
}
