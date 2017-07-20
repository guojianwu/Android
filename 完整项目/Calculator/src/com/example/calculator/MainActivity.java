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
	//ʵ���˼ӣ��������������ڣ��˸����㣬ģ������������
	private int[] operatorIds={R.id.btn_plus,R.id.btn_minus,R.id.btn_mul,R.id.btn_div,
			R.id.btn_equal,R.id.btn_arrow,R.id.btn_clear,R.id.btn_mode,R.id.btn_daoshu,R.id.btn_root};
	private Button[] numBtns=new Button[numberIds.length];
	private Button[] operatorBtns=new Button[operatorIds.length];
	private EditText edit;
	//�����һ�����������ڶ�����������������������
	private String num01Str,num02Str,operStr,tempStr;
	private double result; //������
	private boolean lastClickIsNum=false; //��һ�ε�����Ƿ�������
	private boolean isFisrtClickOpre=true; //�Ƿ��һ�ε�������
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NumberListener numLisLener=new NumberListener();
		
		for (int i = 0; i < numberIds.length; i++) {
			numBtns[i]=(Button) findViewById(numberIds[i]);
			numBtns[i].setOnClickListener(numLisLener);  //��Ҫʵ�����ּ�����
			
			
		}
		OperatorListener operatorListener=new OperatorListener();
		for (int i = 0; i < operatorIds.length; i++) {
			operatorBtns[i]=(Button) findViewById(operatorIds[i]);
			operatorBtns[i].setOnClickListener(operatorListener);  //��Ҫʵ�����������
			
			
		}
		
		edit=(EditText) findViewById(R.id.edit);
		
	}
	
	public class NumberListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			//���ϴε�����������֣���1���������С���㣬�������Ӧ����ʾ��Ϊ0.������ֱ����ʾ����
			//���ϴε���������֣�����������С���㣬��Ӧѡ�ж��Ƿ���С����
			//������С���㣬��ֱ�ӷ��أ������������֣���Ҫ���д���
			if(lastClickIsNum){
				if(arg0.getId()==R.id.btn_dot){
					if(tempStr.indexOf(".") > 0){
						return;
					}
				}
				tempStr=tempStr+ ((Button)arg0).getText().toString();
				
			}else{
				//�ϴε���Ĳ������֣�����ζ��Ҫ�²���һ��������
				if(arg0.getId()==R.id.btn_dot){
					tempStr="0.";
				}else {
					tempStr= ((Button)arg0).getText().toString();
				}
				
			}
			
			//���������0
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
					.setTitle("����")
					.setMessage("��ĸ����Ϊ0")
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
				edit.setText("��"+str+"="+result);
			}
			
			//=+-*/
			//�����һ�ε���������֣��������ǵ�һ�ε����������������Ĳ�����=����tempStr��Ϊ��һ�����������ұ��������
			//�����һ�ε���������֣������ⲻ�ǵ�һ�ε�����������tempStr��Ϊ�ڶ���������������������Ұ���������Ϊ��һ��������
			//�����һ�ε���������֣���������������=����reset������
			//                   ����������+-*/�����������Ϊ��һ������ĵ�һ��������
			//����ϴε���Ĳ������ֱ������µ������
			
			String oper=((Button)arg0).getText().toString(); //��������+-*/
			if(lastClickIsNum){
				if(isFisrtClickOpre){
					if(!oper.equals("=")){
						num01Str=tempStr;  //��ȡ��һ��������
						operStr=oper;      //���������
						isFisrtClickOpre=false;
					}
				}else{
					num02Str=tempStr;
					//���巽��getResult()�����㲢��ʾ+-*/��������
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
				operStr=oper;//��������+-*/
				
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
		//���Գ�Ա�����ָ���ʼֵ
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
