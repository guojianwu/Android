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
	// 构造方法，用于创建数据库,将通过new构造方法创建数据库
	public MyDataBaseUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		this.myContext=context;
		// TODO Auto-generated constructor stub
	}

	// 当数据库被创建时调用，一般完成初始化操作，在此我们完成两个任务1.创建数据表course2.完成数据表初始化
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(createCourseTable);// 执行SQL语句创建表
		// courseId由周+行+列构成
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

	// 当数据库信息发生改变时调用
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	// 定义一个方法courseName的读写(方法的定义：返回值类型（参数列表）{})
	public String getCourseNameById(SQLiteDatabase db, String courseId) {
		// cursor最多只有一条记录
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()方法返回true表示有记录，否则没有。
			// 返回这条记录对应的courseName这个字段的内容
		return	cursor.getString(cursor.getColumnIndex("courseName"));
		}
		return "";
	}

	public void updateCourseName(SQLiteDatabase db, String courseId,
			String newCourseName) {
		db.execSQL("update course set courseName = ? where courseId=?",
				new String[] { newCourseName, courseId });
	}

	// 定义方法完成courseTeacher的读写
	public String getCourseTeacherById(SQLiteDatabase db, String courseId) {
		// cursor最多只有一条记录
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()方法返回true表示有记录，否则没有。
			// 返回这条记录对应的courseTeacher这个字段的内容
			return cursor.getString(cursor.getColumnIndex("courseTeacher"));
		}
		return "";
	}

	public void updateCourseTeacher(SQLiteDatabase db, String courseId,
			String newCourseTeacher) {
		db.execSQL("update course set courseTeacher = ? where courseId=?",
				new String[] { newCourseTeacher, courseId });
	}

	// 定义方法完成courseStart的读写
	public String getCourseStartById(SQLiteDatabase db, String courseId) {
		// cursor最多只有一条记录
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()方法返回true表示有记录，否则没有。
			// 返回这条记录对应的courseStart这个字段的内容
			return cursor.getString(cursor.getColumnIndex("courseStart"));
		}
		return "";
	}

	public void updateCourseStart(SQLiteDatabase db, String courseId,
			String newCourseStart) {
		db.execSQL("update course set courseStart = ? where courseId=?",
				new String[] { newCourseStart, courseId });
	}

	// 定义方法完成courseEnd的读写
	public String getCourseEndById(SQLiteDatabase db, String courseId) {
		// cursor最多只有一条记录
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()方法返回true表示有记录，否则没有。
			// 返回这条记录对应的courseEnd这个字段的内容
			return cursor.getString(cursor.getColumnIndex("courseEnd"));
		}
		return "";
	}

	public void updateCourseEnd(SQLiteDatabase db, String courseId,
			String newCourseEnd) {
		db.execSQL("update course set courseEnd = ? where courseId=?",
				new String[] { newCourseEnd, courseId });
	}

	// 定义方法完成coursePlaceNum的读写
	public String getCoursePlaceNumById(SQLiteDatabase db, String courseId) {
		// cursor最多只有一条记录
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()方法返回true表示有记录，否则没有。
			// 返回这条记录对应的coursePlaceNum这个字段的内容
			return cursor.getString(cursor.getColumnIndex("coursePlaceNum"));
		}
		return "";
	}

	public void updateCoursePlaceNum(SQLiteDatabase db, String courseId,
			String newCoursePlaceNum) {
		db.execSQL("update course set coursePlaceNum = ? where courseId=?",
				new String[] { newCoursePlaceNum, courseId });
	}

	// 定义方法完成coursePlace的读写
	public String getCoursePlaceById(SQLiteDatabase db, String courseId) {
		// cursor最多只有一条记录
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		if (cursor.moveToNext()) { // moveToNext()方法返回true表示有记录，否则没有。
			// 返回这条记录对应的coursePlace这个字段的内容
			return cursor.getString(cursor.getColumnIndex("coursePlace"));
		}
		return "";
	}

	public void updateCoursePlace(SQLiteDatabase db, String courseId,
			String newCoursePlace) {
		db.execSQL("update course set coursePlace = ? where courseId=?",
				new String[] { newCoursePlace, courseId });
	}

	// 定义方法用于返回某周课程信息
	public String getWeekCourseById(SQLiteDatabase db, String courseId) {
		Cursor cursor = db.rawQuery("select * from course where courseId=?",
				new String[] { courseId });
		String temp = ",,-周[]";// 储存课程信息
		if (cursor.moveToNext()) {
			temp = cursor.getString(cursor.getColumnIndex("courseName")) + ","
					+ cursor.getString(cursor.getColumnIndex("courseTeacher"))
					+ ","
					+ cursor.getString(cursor.getColumnIndex("courseStart"))
					+ "-" + cursor.getString(cursor.getColumnIndex("courseEnd"))
					+ "周["
					+ cursor.getString(cursor.getColumnIndex("coursePlaceNum"))
					+ cursor.getString(cursor.getColumnIndex("coursePlace"))
					+ "]";
		}
		Toast.makeText(myContext, temp,
				Toast.LENGTH_SHORT).show();
		return temp;// temp返回temp的值有两种可能1.没有匹配的courseId或有匹配的courseId课程信息为空，此时temp返回的结果为“，，周[]”
		// 2.有匹配的courseId且课程信息不为空，此时temp返回的结果为对应的课程信息，如“html5,王，1-3周[304机房]
	}

	// 定义方法用于返回学期课程信息
	public String getTermCourseByRC(SQLiteDatabase db, String courseRC) {
		Cursor cursor = db.rawQuery("select * from course where courseRC=?",
				new String[] { courseRC });
		String temp = "";
		String result = "";
		Set<String> hs = new HashSet<String>();// Set表示集合结构，元素不重复
		while (cursor.moveToNext()) {
			temp = cursor.getString(cursor.getColumnIndex("courseName")) + ","
					+ cursor.getString(cursor.getColumnIndex("courseTeacher"))
					+ ","
					+ cursor.getString(cursor.getColumnIndex("courseStart"))
					+ "-" + cursor.getString(cursor.getColumnIndex("courseEnd"))
					+ "周["
					+ cursor.getString(cursor.getColumnIndex("coursePlaceNum"))
					+ cursor.getString(cursor.getColumnIndex("coursePlace"))
					+ "]";
			// 在添加每条课程信息前，要进行去重，把不重复的信息进行添加
			if (!temp.equals(",,-周[]") && !hs.contains(temp)) {
				hs.add(temp);
				result = result + temp+"\n";
			}
		}
		return result;  //"",
	}
}
