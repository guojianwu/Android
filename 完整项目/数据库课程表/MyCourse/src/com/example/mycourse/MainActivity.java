package com.example.mycourse;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private String[] weekStr;
	private int[][] ids = new int[][] {
			{ R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15 },
			{ R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25 },
			{ R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34, R.id.btn35 },
			{ R.id.btn41, R.id.btn42, R.id.btn43, R.id.btn44, R.id.btn45 },
			{ R.id.btn51, R.id.btn52, R.id.btn53, R.id.btn54, R.id.btn55 } };
	private Button[][] btns;
	private Button addBtn;//添加按钮
	private MyDataBaseUtil mUtil;//自定义数据库
	private SQLiteDatabase db;//数据库对象
	private String courseId,courseRC,courseName,courseTeacher,courseStart,
	courseEnd,coursePlaceNum,coursePlace;
	private String courseWeek,courseSection;//courseWeek->星期，courseSection->节次
	
	private MyClickListener mListener;//还没实现
	private int flag;//0表示添加按钮，1表示课程按钮
	private int currentWeek;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//对各个变量初始化
		courseId ="";
		courseRC="";
		courseName = "";
		courseTeacher="";
		coursePlaceNum="";
		coursePlace="";
		courseStart="";
		courseEnd="";
		courseWeek="";
		courseSection="";
		mUtil=new MyDataBaseUtil(this,"course.db",null,1);
		db=mUtil.getWritableDatabase();
		
		mListener = new MyClickListener();
		
		btns=new Button[5][5];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				btns[i][j]=(Button) findViewById(ids[i][j]);
				btns[i][j].setAlpha(0);//设置透明
				btns[i][j].setOnClickListener(mListener);
				
				btns[i][j].setTag(""+(i+1)+(j+1));//用行列号为标记
			}
		}
		addBtn=(Button)findViewById(R.id.addCourse);
		addBtn.setOnClickListener(mListener);
		
		
		weekStr = new String[] { "学期课表", "第1周", "第2周", "第3周", "第4周", "第5周",
				"第6周", "第7周", "第8周", "第9周", "第10周", "第11周", "第12周", "第13周",
				"第14周", "第15周", "第16周", "第17周", "第18周", "第19周", "第20周" };
		spinner = (Spinner) findViewById(R.id.spanner1);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item,weekStr);
		adapter.setDropDownViewResource(R.layout.myspinner);
		spinner.setAdapter(adapter);
		spinner.setSelection(0, true);// 设置默认选择项
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//arg2表示用户选中的某项位置 0开始
				currentWeek=arg2;
				if(arg2==0){
					initTermCourse();
				}else{
					initWeekCourse();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		currentWeek = 0;
		if(currentWeek==0){
			//显示学期课表
			initTermCourse();
		}else{
			//显示周课表
			initWeekCourse();
		}	
		
		initTermCourse();
	}
	public void initWeekCourse(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				String temp=mUtil.getWeekCourseById(db, ""+currentWeek+(i+1)+(j+1));
				if(temp.equals(",,-周[]")){
					btns[i][j].setText("");
					btns[i][j].setAlpha(0);
				}else{
					btns[i][j].setText(temp);
					btns[i][j].setAlpha(1);//背景红色显示出来
				}
			}
		}
	}
	public void initTermCourse(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				String temp=mUtil.getTermCourseByRC(db, ""+(i+1)+(j+1));
				if(temp.equals("")){
					btns[i][j].setText("");
					btns[i][j].setAlpha(0);
				}else{
					btns[i][j].setText(temp);
					btns[i][j].setAlpha(1);//背景红色显示出来
				}
			}
		}
	}
	//点击课程按钮及添加按钮都会跳转到CourseDetail
	//如果点击的是课程按钮，则需要显示课程信息以便用户修改
	//如果点击的是添加按钮，则直接显示第二个界面
	
	class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, CourseDatal.class);
			Bundle bundle=new Bundle();
			if(arg0.getId()==R.id.addCourse){
				flag=0;
			}else{
				flag=1;
				courseRC=(String)arg0.getTag();//通过获得标记从而获得行列号
				courseId=currentWeek+courseRC;
				courseName=mUtil.getCourseNameById(db, courseId);
				courseTeacher=mUtil.getCourseTeacherById(db, courseId);
				courseStart=mUtil.getCourseStartById(db, courseId);
				courseEnd=mUtil.getCourseEndById(db, courseId);
				coursePlaceNum=mUtil.getCoursePlaceNumById(db, courseId);
				coursePlace=mUtil.getCoursePlaceById(db, courseId);
				//由于星期及节次没有储存到数据库表中，因此需要另外计算，可以通过courseRC获得
				setCourseWeek(Integer.parseInt(courseRC)%10 );
				setCourseSetion(Integer.parseInt(courseRC)/10);
				bundle.putString("course_id", courseId);
				bundle.putString("course_rc", courseRC);
				bundle.putString("course_name", courseName);
				bundle.putString("course_teacher", courseTeacher);
				bundle.putString("course_start", courseStart);
				bundle.putString("course_end", courseEnd);
				bundle.putString("course_placeNum", coursePlaceNum);
				bundle.putString("course_place", coursePlace);
				bundle.putString("course_week", courseWeek);
				bundle.putString("course_section", courseSection);
				
			}
			bundle.putInt("btn_flag", flag);
			bundle.putInt("current_week", currentWeek);
			intent.putExtras(bundle);
			startActivity(intent);
		}
		
	}
	//定义两个方法，用于获得对应courseRC的星期及节次
	public void setCourseWeek(int i){
		switch(i){
		case 1:
			courseWeek="一";
			break;
		case 2:
			courseWeek="二";
			break;
		case 3:
			courseWeek="三";
			break;
		case 4:
			courseWeek="四";
			break;
		case 5:
			courseWeek="五";
			break;
		}
	}
	
	public void setCourseSetion(int i){
		switch(i){
		case 1:
			courseSection="1-2";
			break;
		case 2:
			courseSection="3-4";
			break;
		case 3:
			courseSection="5-6";
			break;
		case 4:
			courseSection="7-8";
			break;
		case 5:
			courseSection="9-10";
			break;
		}
		
		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
