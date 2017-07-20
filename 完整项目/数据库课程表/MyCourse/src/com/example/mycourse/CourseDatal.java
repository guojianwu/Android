package com.example.mycourse;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CourseDatal extends Activity {

	private EditText courseName, courseTeacher, courseStart, courseEnd,
			coursePlaceNum, courseSection, courseWeek;
	private RadioButton radio01, radio02;
	private Button btn_complete, btn_clear;
	private MyDataBaseUtil mUtil;
	private SQLiteDatabase db;
	private int flag, currentWeek, startWeek, endWeek;
	private String courseId, courseRC, rc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_detail);
		courseName = (EditText) findViewById(R.id.courseName);
		courseTeacher = (EditText) findViewById(R.id.courseTeacher);
		courseStart = (EditText) findViewById(R.id.courseStart);
		courseEnd = (EditText) findViewById(R.id.courseEnd);
		coursePlaceNum = (EditText) findViewById(R.id.coursePlaceNum);
		courseWeek = (EditText) findViewById(R.id.courseWeek);
		courseSection = (EditText) findViewById(R.id.courseSection);
		
		radio01 = (RadioButton) findViewById(R.id.radio01);
		radio02 = (RadioButton) findViewById(R.id.radio02);
		btn_complete = (Button) findViewById(R.id.btn_complete);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		mUtil = new MyDataBaseUtil(this, "course.db", null, 1);
		db = mUtil.getWritableDatabase();
		Intent intent = getIntent();// 意图
		Bundle bundle = intent.getExtras();
		flag = bundle.getInt("btn_flag", 0);
		currentWeek = bundle.getInt("current_Week", 0);

		if (flag == 1) {

			// 点击了课程按钮
			courseName.setText(bundle.getString("course_name"));
			courseTeacher.setText(bundle.getString("course_teacher"));
			courseStart.setText(bundle.getString("course_start"));
			courseEnd.setText(bundle.getString("course_end"));
			coursePlaceNum.setText(bundle.getString("course_placeNum"));
			courseSection.setText(bundle.getString("course_section"));
			courseWeek.setText(bundle.getString("course_week"));
			
			
			if (bundle.getString("course_place").equals(
					radio01.getText().toString())) {
				radio01.setChecked(true);
			} else if (bundle.getString("course_place").equals(
					radio02.getText().toString())) {
				radio02.setChecked(true);
			}
			courseId = bundle.getString("course_id");
			courseRC = bundle.getString("course_rc");
			// 约定只能让用户修改课程·名字和教师和上课地点，其余起始周，星期及节次不能修改
			courseWeek.setEnabled(false);
			courseSection.setEnabled(false);
			courseStart.setEnabled(false);
			courseEnd.setEnabled(false);
		}
		btn_complete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 点击添加按钮，2-5周，课程添加有可能冲突，另外，添加的内容可能是多条

				// 点击课程按钮，只修改了对应的那一条
				if (flag == 0) {
					// 调用方法getCourseWeekSection计算行列号
					rc = getCourseWeekSection(courseWeek.getText().toString(),
							courseSection.getText().toString());

					// 是否有冲突，再添加课程
					startWeek = Integer.parseInt(courseStart.getText().toString());
					endWeek = Integer.parseInt(courseEnd.getText().toString());
					// 定义一个方法isNotCourseCrash(),用于判断课程是否冲突，否则返回true
					if (isNotCourseCrash()) {
						// 在此添加若干条课程记录
						
						updateDatas();// 定义一个方法,添加若干条课程信息,此时行列号由rc确定

					} else {
						Toast.makeText(CourseDatal.this, "添加课程时间有·冲突，请确保输入正确！",
								Toast.LENGTH_SHORT).show();
					}

				} else {
					// 直接修改对应的那条记录，此时行列号由courseRC确定
					updateOneData();
					
				}
				Intent intent=new Intent();
				intent.setClass(CourseDatal.this,MainActivity.class);
				startActivity(intent);
			}
		});

		btn_clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 如果点击的是添加按钮，则清空是对所有的文本及单选框及单选按钮清空
				// 如果点击的是课程按钮，则只能对课程名字和教师和上课地点进行清空
				courseName.setText("");
				courseTeacher.setText("");
				coursePlaceNum.setText("");
				radio01.setChecked(false);
				radio02.setChecked(false);
				if (flag == 0) {
					courseWeek.setText("");
					courseSection.setText("");
					courseStart.setText("");
					courseEnd.setText("");
				}
			}
		});
	}

	public void updateDatas() {
		// 由于在数据库中存放的字段有id,rc,name,teacher,start,end,placeNum,place
		// id由周+rc
		for (int w = startWeek; w <= endWeek; w++) {
			String tempId = w + rc;
			mUtil.updateCourseName(db, tempId, courseName.getText().toString());
			mUtil.updateCourseTeacher(db, tempId, courseTeacher.getText()
					.toString());
			mUtil.updateCourseStart(db, tempId, courseStart.getText()
					.toString());
			mUtil.updateCoursePlaceNum(db, tempId, coursePlaceNum.getText()
					.toString());
			mUtil.updateCourseEnd(db, tempId, courseEnd.getText().toString());
		if(radio01.isChecked()){
			mUtil.updateCoursePlace(db, tempId, radio01.getText().toString());
					
		}else if(radio02.isChecked()){
			mUtil.updateCoursePlace(db, tempId, radio02.getText().toString());
		}else{
			mUtil.updateCoursePlace(db, tempId, "");
		}
		}
		
		
	}
	public void updateOneData() {
		// 由于在数据库中存放的字段有id,rc,name,teacher,start,end,placeNum,place
		// id由周+courseRC
		String tempId=currentWeek+courseRC;
			
			mUtil.updateCourseName(db, tempId, courseName.getText().toString());
			mUtil.updateCourseTeacher(db, tempId, courseTeacher.getText()
					.toString());
			mUtil.updateCourseStart(db, tempId, courseStart.getText()
					.toString());
			mUtil.updateCoursePlaceNum(db, tempId, coursePlaceNum.getText()
					.toString());
			mUtil.updateCourseEnd(db, tempId, courseEnd.getText().toString());
		if(radio01.isChecked()){
			mUtil.updateCoursePlace(db, tempId, coursePlaceNum.getText()
					.toString());
		}else if(radio02.isChecked()){
			mUtil.updateCoursePlace(db, tempId, coursePlaceNum.getText()
					.toString());
		}else{
			mUtil.updateCoursePlace(db, tempId, "");
		}
		Toast.makeText(CourseDatal.this, "1234",
				Toast.LENGTH_SHORT).show();
	}

	public boolean isNotCourseCrash() {
		boolean isNotCrash = true;// 默认不课程冲突
		// id=周+行列号，行列号通过星期及节次求出
		// 定义一个方法getCourseWeekSection来求得行列号
		rc = getCourseWeekSection(courseWeek.getText().toString(),
				courseSection.getText().toString());
		for (int w = startWeek; w <= endWeek; w++) {
			String idTemp = w + rc;
			// 通过判断每周对应的行列号是否有课程，在此只是简单的判断是否有课程名，如果有，则表示课程冲突，否则不冲突·
			String courseTemp = mUtil.getCourseNameById(db, idTemp);
			if (!courseTemp.equals("")) {
				isNotCrash = false;
				break;
			}
		}
		return isNotCrash;
	}

	public String getCourseWeekSection(String week, String section) {
		String tempi = "", tempj = "";// 保持行 tempi,列号tempj
		if (section.equals("1-2")) {
			tempi = "1";
		}
		if (section.equals("3-4")) {
			tempi = "2";
		}
		if (section.equals("5-6")) {
			tempi = "3";
		}
		if (section.equals("7-8")) {
			tempi = "4";
		}
		if (section.equals("9-10")) {
			tempi = "5";
		}
		if (week.equals("一")) {
			tempj = "1";
		}
		if (week.equals("二")) {
			tempj = "2";
		}
		if (week.equals("三")) {
			tempj = "3";
		}
		if (week.equals("四")) {
			tempj = "4";
		}
		if (week.equals("五")) {
			tempj = "5";
		}
		return tempi + tempj;
	}
}
