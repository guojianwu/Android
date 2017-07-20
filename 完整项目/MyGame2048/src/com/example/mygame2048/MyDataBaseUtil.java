package com.example.mygame2048;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseUtil extends SQLiteOpenHelper{

	private String createScoreTable="create table if not exists newrecord(scoreId,scoreValue)";
	
	public MyDataBaseUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL(createScoreTable);
		arg0.execSQL("insert into newrecord(scoreId,scoreValue)values(?,?)",new String[]{"1","0"});
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	//读取分数的操作
	public String getScoreById(SQLiteDatabase arg0,String scoreId){
		Cursor cursor=arg0.rawQuery("select * from newrecord where scoreId=?",new String[]{scoreId});
		if(cursor.moveToNext()){
			return cursor.getString(cursor.getColumnIndex("scoreValue"));
		}
		return "";
	}
	public void updateScoreValue(SQLiteDatabase arg0,String scoreId,String newScoreValue){
		arg0.execSQL("update newrecord set scoreValue=? where scoreId=?", new String[]{newScoreValue,scoreId});
	}
	
	

}
