package com.example.myviewplayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseUtil extends SQLiteOpenHelper{
	//使用数据库存储应用是否第一次启动，约定，数据库表newApp中如果stateValue=0,表示此应用第一次启动，
	//如果stateValue=1,表示此应用不是第一次启动，
	private String createAppTable = "create table if not exists newApp(stateId,stateValue)" ;

	public MyDataBaseUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		//一般再此方法中创建一个数据库表
		arg0.execSQL(createAppTable);
		arg0.execSQL("insert into newApp(stateId,stateValue)values(?,?)",new String[]{"1","0"});
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		//当数据库发生更新的时候被调用
	}
	
	//获取stateValue(db,"1");
	public String getStateById(SQLiteDatabase db,String id){
		Cursor cursor = db.rawQuery("select * from newApp where stateId = ?",new String[]{id});
		if(cursor.moveToNext()){ //返回为真，表示有一条记录，否则表示没有记录
			return cursor.getString(cursor.getColumnIndex("stateValue"));
		}else{
			return "";
		}
	}
	
	
	public void updateStateValue(SQLiteDatabase db,String id, String newValue){
		db.execSQL("update newApp set stateValue = ? where stateId=?",new String[]{newValue,id});
	}

}
