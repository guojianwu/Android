package com.example.myviewplayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseUtil extends SQLiteOpenHelper{
	//ʹ�����ݿ�洢Ӧ���Ƿ��һ��������Լ�������ݿ��newApp�����stateValue=0,��ʾ��Ӧ�õ�һ��������
	//���stateValue=1,��ʾ��Ӧ�ò��ǵ�һ��������
	private String createAppTable = "create table if not exists newApp(stateId,stateValue)" ;

	public MyDataBaseUtil(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		//һ���ٴ˷����д���һ�����ݿ��
		arg0.execSQL(createAppTable);
		arg0.execSQL("insert into newApp(stateId,stateValue)values(?,?)",new String[]{"1","0"});
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		//�����ݿⷢ�����µ�ʱ�򱻵���
	}
	
	//��ȡstateValue(db,"1");
	public String getStateById(SQLiteDatabase db,String id){
		Cursor cursor = db.rawQuery("select * from newApp where stateId = ?",new String[]{id});
		if(cursor.moveToNext()){ //����Ϊ�棬��ʾ��һ����¼�������ʾû�м�¼
			return cursor.getString(cursor.getColumnIndex("stateValue"));
		}else{
			return "";
		}
	}
	
	
	public void updateStateValue(SQLiteDatabase db,String id, String newValue){
		db.execSQL("update newApp set stateValue = ? where stateId=?",new String[]{newValue,id});
	}

}
