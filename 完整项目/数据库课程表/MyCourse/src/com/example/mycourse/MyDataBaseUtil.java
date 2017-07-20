package com.example.mycourse;

import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBaseUtil extends SQLiteOpenHelper {

	private String createCourseTable = "create table if not exists course(courseId,courseRC,courseName,courseTeacher,courseStart,courseEnd,coursePlaceNum,coursePlace)";
	private Context myContext;
	// ���췽�������ڴ������ݿ�,��ͨ��new���췽���������ݿ�
	public MyDataBaseUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		this.myContext=context;
		// TODO Auto-generated constructor stub
	}

	// �����ݿⱻ����ʱ���ã�һ����ɳ�ʼ���������ڴ����������������1.�������ݱ�course2.������ݱ��ʼ��
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(createCourseTable);// ִ��SQL��䴴����
		// courseId����+��+�й���
		for (int w = 1; w <= 20; w++) {
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= 5; j++) {
					db.execSQL(
							"insert into course(courseId,courseRC,courseName,courseTeacher,courseStart,courseEnd,coursePlaceNum,coursePlace)values(?,?,?,?,?,?,?,?)",
							new String[] { "" + w + i + j, "" + i + j, "", "",
									"", "", "", "" });
				}
			}
		}
		
	}

	// �����ݿ���Ϣ�����ı�ʱ����
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	// ����һ������courseName�Ķ�д(�����Ķ��壺����ֵ���ͣ������б�{})
	public String getCourseNameById(SQLiteDatabase db, String courseId) {
		// cursor���ֻ��һ����¼
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()��������true��ʾ�м�¼������û�С�
			// ����������¼��Ӧ��courseName����ֶε�����
		return	cursor.getString(cursor.getColumnIndex("courseName"));
		}
		return "";
	}

	public void updateCourseName(SQLiteDatabase db, String courseId,
			String newCourseName) {
		db.execSQL("update course set courseName = ? where courseId=?",
				new String[] { newCourseName, courseId });
	}

	// ���巽�����courseTeacher�Ķ�д
	public String getCourseTeacherById(SQLiteDatabase db, String courseId) {
		// cursor���ֻ��һ����¼
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()��������true��ʾ�м�¼������û�С�
			// ����������¼��Ӧ��courseTeacher����ֶε�����
			return cursor.getString(cursor.getColumnIndex("courseTeacher"));
		}
		return "";
	}

	public void updateCourseTeacher(SQLiteDatabase db, String courseId,
			String newCourseTeacher) {
		db.execSQL("update course set courseTeacher = ? where courseId=?",
				new String[] { newCourseTeacher, courseId });
	}

	// ���巽�����courseStart�Ķ�д
	public String getCourseStartById(SQLiteDatabase db, String courseId) {
		// cursor���ֻ��һ����¼
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()��������true��ʾ�м�¼������û�С�
			// ����������¼��Ӧ��courseStart����ֶε�����
			return cursor.getString(cursor.getColumnIndex("courseStart"));
		}
		return "";
	}

	public void updateCourseStart(SQLiteDatabase db, String courseId,
			String newCourseStart) {
		db.execSQL("update course set courseStart = ? where courseId=?",
				new String[] { newCourseStart, courseId });
	}

	// ���巽�����courseEnd�Ķ�д
	public String getCourseEndById(SQLiteDatabase db, String courseId) {
		// cursor���ֻ��һ����¼
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()��������true��ʾ�м�¼������û�С�
			// ����������¼��Ӧ��courseEnd����ֶε�����
			return cursor.getString(cursor.getColumnIndex("courseEnd"));
		}
		return "";
	}

	public void updateCourseEnd(SQLiteDatabase db, String courseId,
			String newCourseEnd) {
		db.execSQL("update course set courseEnd = ? where courseId=?",
				new String[] { newCourseEnd, courseId });
	}

	// ���巽�����coursePlaceNum�Ķ�д
	public String getCoursePlaceNumById(SQLiteDatabase db, String courseId) {
		// cursor���ֻ��һ����¼
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()��������true��ʾ�м�¼������û�С�
			// ����������¼��Ӧ��coursePlaceNum����ֶε�����
			return cursor.getString(cursor.getColumnIndex("coursePlaceNum"));
		}
		return "";
	}

	public void updateCoursePlaceNum(SQLiteDatabase db, String courseId,
			String newCoursePlaceNum) {
		db.execSQL("update course set coursePlaceNum = ? where courseId=?",
				new String[] { newCoursePlaceNum, courseId });
	}

	// ���巽�����coursePlace�Ķ�д
	public String getCoursePlaceById(SQLiteDatabase db, String courseId) {
		// cursor���ֻ��һ����¼
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()��������true��ʾ�м�¼������û�С�
			// ����������¼��Ӧ��coursePlace����ֶε�����
			return cursor.getString(cursor.getColumnIndex("coursePlace"));
		}
		return "";
	}

	public void updateCoursePlace(SQLiteDatabase db, String courseId,
			String newCoursePlace) {
		db.execSQL("update course set coursePlace = ? where courseId=?",
				new String[] { newCoursePlace, courseId });
	}

	// ���巽�����ڷ���ĳ�ܿγ���Ϣ
	public String getWeekCourseById(SQLiteDatabase db, String courseId) {
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		String temp = ",,-��[]";// ����γ���Ϣ
		if (cursor.moveToNext()) {
			temp = cursor.getString(cursor.getColumnIndex("courseName")) + ","
					+ cursor.getString(cursor.getColumnIndex("courseTeacher"))
					+ ","
					+ cursor.getString(cursor.getColumnIndex("courseStart"))
					+ "-" + cursor.getString(cursor.getColumnIndex("courseEnd"))
					+ "��["
					+ cursor.getString(cursor.getColumnIndex("coursePlaceNum"))
					+ cursor.getString(cursor.getColumnIndex("coursePlace"))
					+ "]";
		}
		Toast.makeText(myContext, temp,
				Toast.LENGTH_SHORT).show();
		return temp;// temp����temp��ֵ�����ֿ���1.û��ƥ���courseId����ƥ���courseId�γ���ϢΪ�գ���ʱtemp���صĽ��Ϊ��������[]��
		// 2.��ƥ���courseId�ҿγ���Ϣ��Ϊ�գ���ʱtemp���صĽ��Ϊ��Ӧ�Ŀγ���Ϣ���硰html5,����1-3��[304����]
	}

	// ���巽�����ڷ���ѧ�ڿγ���Ϣ
	public String getTermCourseByRC(SQLiteDatabase db, String courseRC) {
		Cursor cursor = db.rawQuery("select * from course where courseRC=?",
				new String[] { courseRC });
		String temp = "";
		String result = "";
		Set<String> hs = new HashSet<String>();// Set��ʾ���Ͻṹ��Ԫ�ز��ظ�
		while (cursor.moveToNext()) {
			temp = cursor.getString(cursor.getColumnIndex("courseName")) + ","
					+ cursor.getString(cursor.getColumnIndex("courseTeacher"))
					+ ","
					+ cursor.getString(cursor.getColumnIndex("courseStart"))
					+ "-" + cursor.getString(cursor.getColumnIndex("courseEnd"))
					+ "��["
					+ cursor.getString(cursor.getColumnIndex("coursePlaceNum"))
					+ cursor.getString(cursor.getColumnIndex("coursePlace"))
					+ "]";
			// �����ÿ���γ���Ϣǰ��Ҫ����ȥ�أ��Ѳ��ظ�����Ϣ�������
			if (!temp.equals(",,-��[]") && !hs.contains(temp)) {
				hs.add(temp);
				result = result + temp+"\n";
			}
		}
		return result;  //"",
	}
}
