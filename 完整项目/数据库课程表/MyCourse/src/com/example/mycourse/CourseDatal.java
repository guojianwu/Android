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
		Intent intent = getIntent();// ��ͼ
		Bundle bundle = intent.getExtras();
		flag = bundle.getInt("btn_flag", 0);
		currentWeek = bundle.getInt("current_Week", 0);

		if (flag == 1) {

			// ����˿γ̰�ť
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
			// Լ��ֻ�����û��޸Ŀγ̡����ֺͽ�ʦ���Ͽεص㣬������ʼ�ܣ����ڼ��ڴβ����޸�
			courseWeek.setEnabled(false);
			courseSection.setEnabled(false);
			courseStart.setEnabled(false);
			courseEnd.setEnabled(false);
		}
		btn_complete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// �����Ӱ�ť��2-5�ܣ��γ�����п��ܳ�ͻ�����⣬��ӵ����ݿ����Ƕ���

				// ����γ̰�ť��ֻ�޸��˶�Ӧ����һ��
				if (flag == 0) {
					// ���÷���getCourseWeekSection�������к�
					rc = getCourseWeekSection(courseWeek.getText().toString(),
							courseSection.getText().toString());

					// �Ƿ��г�ͻ������ӿγ�
					startWeek = Integer.parseInt(courseStart.getText().toString());
					endWeek = Integer.parseInt(courseEnd.getText().toString());
					// ����һ������isNotCourseCrash(),�����жϿγ��Ƿ��ͻ�����򷵻�true
					if (isNotCourseCrash()) {
						// �ڴ�����������γ̼�¼
						
						updateDatas();// ����һ������,����������γ���Ϣ,��ʱ���к���rcȷ��

					} else {
						Toast.makeText(CourseDatal.this, "��ӿγ�ʱ���С���ͻ����ȷ��������ȷ��",
								Toast.LENGTH_SHORT).show();
					}

				} else {
					// ֱ���޸Ķ�Ӧ��������¼����ʱ���к���courseRCȷ��
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
				// ������������Ӱ�ť��������Ƕ����е��ı�����ѡ�򼰵�ѡ��ť���
				// ���������ǿγ̰�ť����ֻ�ܶԿγ����ֺͽ�ʦ���Ͽεص�������
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
		// ���������ݿ��д�ŵ��ֶ���id,rc,name,teacher,start,end,placeNum,place
		// id����+rc
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
		// ���������ݿ��д�ŵ��ֶ���id,rc,name,teacher,start,end,placeNum,place
		// id����+courseRC
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
		boolean isNotCrash = true;// Ĭ�ϲ��γ̳�ͻ
		// id=��+���кţ����к�ͨ�����ڼ��ڴ����
		// ����һ������getCourseWeekSection��������к�
		rc = getCourseWeekSection(courseWeek.getText().toString(),
				courseSection.getText().toString());
		for (int w = startWeek; w <= endWeek; w++) {
			String idTemp = w + rc;
			// ͨ���ж�ÿ�ܶ�Ӧ�����к��Ƿ��пγ̣��ڴ�ֻ�Ǽ򵥵��ж��Ƿ��пγ���������У����ʾ�γ̳�ͻ�����򲻳�ͻ��
			String courseTemp = mUtil.getCourseNameById(db, idTemp);
			if (!courseTemp.equals("")) {
				isNotCrash = false;
				break;
			}
		}
		return isNotCrash;
	}

	public String getCourseWeekSection(String week, String section) {
		String tempi = "", tempj = "";// ������ tempi,�к�tempj
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
		if (week.equals("һ")) {
			tempj = "1";
		}
		if (week.equals("��")) {
			tempj = "2";
		}
		if (week.equals("��")) {
			tempj = "3";
		}
		if (week.equals("��")) {
			tempj = "4";
		}
		if (week.equals("��")) {
			tempj = "5";
		}
		return tempi + tempj;
	}
}
