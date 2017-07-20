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
	private Button addBtn;//��Ӱ�ť
	private MyDataBaseUtil mUtil;//�Զ������ݿ�
	private SQLiteDatabase db;//���ݿ����
	private String courseId,courseRC,courseName,courseTeacher,courseStart,
	courseEnd,coursePlaceNum,coursePlace;
	private String courseWeek,courseSection;//courseWeek->���ڣ�courseSection->�ڴ�
	
	private MyClickListener mListener;//��ûʵ��
	private int flag;//0��ʾ��Ӱ�ť��1��ʾ�γ̰�ť
	private int currentWeek;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//�Ը���������ʼ��
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
				btns[i][j].setAlpha(0);//����͸��
				btns[i][j].setOnClickListener(mListener);
				
				btns[i][j].setTag(""+(i+1)+(j+1));//�����к�Ϊ���
			}
		}
		addBtn=(Button)findViewById(R.id.addCourse);
		addBtn.setOnClickListener(mListener);
		
		
		weekStr = new String[] { "ѧ�ڿα�", "��1��", "��2��", "��3��", "��4��", "��5��",
				"��6��", "��7��", "��8��", "��9��", "��10��", "��11��", "��12��", "��13��",
				"��14��", "��15��", "��16��", "��17��", "��18��", "��19��", "��20��" };
		spinner = (Spinner) findViewById(R.id.spanner1);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item,weekStr);
		adapter.setDropDownViewResource(R.layout.myspinner);
		spinner.setAdapter(adapter);
		spinner.setSelection(0, true);// ����Ĭ��ѡ����
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//arg2��ʾ�û�ѡ�е�ĳ��λ�� 0��ʼ
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
			//��ʾѧ�ڿα�
			initTermCourse();
		}else{
			//��ʾ�ܿα�
			initWeekCourse();
		}	
		
		initTermCourse();
	}
	public void initWeekCourse(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				String temp=mUtil.getWeekCourseById(db, ""+currentWeek+(i+1)+(j+1));
				if(temp.equals(",,-��[]")){
					btns[i][j].setText("");
					btns[i][j].setAlpha(0);
				}else{
					btns[i][j].setText(temp);
					btns[i][j].setAlpha(1);//������ɫ��ʾ����
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
					btns[i][j].setAlpha(1);//������ɫ��ʾ����
				}
			}
		}
	}
	//����γ̰�ť����Ӱ�ť������ת��CourseDetail
	//���������ǿγ̰�ť������Ҫ��ʾ�γ���Ϣ�Ա��û��޸�
	//������������Ӱ�ť����ֱ����ʾ�ڶ�������
	
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
				courseRC=(String)arg0.getTag();//ͨ����ñ�ǴӶ�������к�
				courseId=currentWeek+courseRC;
				courseName=mUtil.getCourseNameById(db, courseId);
				courseTeacher=mUtil.getCourseTeacherById(db, courseId);
				courseStart=mUtil.getCourseStartById(db, courseId);
				courseEnd=mUtil.getCourseEndById(db, courseId);
				coursePlaceNum=mUtil.getCoursePlaceNumById(db, courseId);
				coursePlace=mUtil.getCoursePlaceById(db, courseId);
				//�������ڼ��ڴ�û�д��浽���ݿ���У������Ҫ������㣬����ͨ��courseRC���
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
	//�����������������ڻ�ö�ӦcourseRC�����ڼ��ڴ�
	public void setCourseWeek(int i){
		switch(i){
		case 1:
			courseWeek="һ";
			break;
		case 2:
			courseWeek="��";
			break;
		case 3:
			courseWeek="��";
			break;
		case 4:
			courseWeek="��";
			break;
		case 5:
			courseWeek="��";
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
