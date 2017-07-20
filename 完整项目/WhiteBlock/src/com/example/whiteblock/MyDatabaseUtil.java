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
		db.execSQL(createScoreTable);  //����newrecore��
		for (int i = 0; i < 4; i++) { //����newrecord����ʼ��
			db.execSQL("insert into newrecord(scoreId,scoreValue)values(?,?)", new String[]{i+"","0"});
		}
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	//���巽�����ScoreValue�Ķ�д    �����Ķ��壺����ֵ���ͷ�������������{}	 
	//�����ݱ��л�ȡ��ʷ���ֵ������ǰ��ʱ�����ʷ���ֵ���٣�����Ҫ����
		public String getScoreValueById(SQLiteDatabase db,String scoreId){
			//cursor���ֻ��һ����¼
			Cursor cursor=db.rawQuery("select * from newrecord where scoreId=?",new String[]{scoreId});
			if(cursor.moveToNext()){  //moveToNext()��������TRUE��ʾ�м�¼������û��
				//����������¼��ӦcourseName����ֶε�����
				//String temp = cursor.getString(cursor.getColumnIndex("scoreValue"));
				
			    return cursor.getString(cursor.getColumnIndex("scoreValue"));
			}
			return ""; 
		}
		
		//����ScoreValue
		public void updateScoreValue(SQLiteDatabase db,String scoreId,String newScorevalue){
			db.execSQL("update newrecord set scoreValue=? where scoreId=?",new String[]{newScorevalue,scoreId});
		}
	
	

}
