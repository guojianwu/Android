package com.example.whiteblock;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseUtil extends SQLiteOpenHelper {

	private String createScoreTable="create table if not exists newrecord(scoreId,scoreValue)";
	
	public MyDatabaseUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(createScoreTable);  //创建newrecore表
		for (int i = 0; i < 4; i++) { //创建newrecord表并初始化
			db.execSQL("insert into newrecord(scoreId,scoreValue)values(?,?)", new String[]{i+"","0"});
		}
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	//定义方法完成ScoreValue的读写    方法的定义：返回值类型方法名（参数表）{}	 
	//从数据表中获取历史最佳值，当当前的时间比历史最佳值还少，则需要更新
		public String getScoreValueById(SQLiteDatabase db,String scoreId){
			//cursor最多只有一条记录
			Cursor cursor=db.rawQuery("select * from newrecord where scoreId=?",new String[]{scoreId});
			if(cursor.moveToNext()){  //moveToNext()方法返回TRUE表示有记录，否则没有
				//返回这条记录对应courseName这个字段的内容
				//String temp = cursor.getString(cursor.getColumnIndex("scoreValue"));
				
			    return cursor.getString(cursor.getColumnIndex("scoreValue"));
			}
			return ""; 
		}
		
		//更新ScoreValue
		public void updateScoreValue(SQLiteDatabase db,String scoreId,String newScorevalue){
			db.execSQL("update newrecord set scoreValue=? where scoreId=?",new String[]{newScorevalue,scoreId});
		}
	
	

}
