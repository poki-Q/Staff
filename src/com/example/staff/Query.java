package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Query extends Activity {
	Button btn_return4,btn_quering;
	EditText edt_queringID;
	Intent intent;
	SQLiteDatabase db;
	Bundle bundle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query);
		
		//关联组件
		btn_return4 = (Button)findViewById(R.id.btn_return4);
		btn_quering = (Button)findViewById(R.id.btn_return5);
		edt_queringID = (EditText)findViewById(R.id.edt_queringID);
		
		
		//设置事件监听
		//返回按钮
		btn_return4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Query.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		//查询按钮
		btn_quering.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String queringID = edt_queringID.getText().toString();
				db = openOrCreateDatabase("company.db", Context.MODE_PRIVATE, null);
				
				Cursor c = db.rawQuery("select * from staff where id = '"+queringID+"' ", null);
				 if(c.moveToFirst()){
					 String id = c.getString(c.getColumnIndex("id"));
					 String name = c.getString(c.getColumnIndex("name")); 
					 String sex = c.getString(c.getColumnIndex("sex")); 
					 String age = c.getString(c.getColumnIndex("age")); 
					 String joinTime = c.getString(c.getColumnIndex("joinTime")); 
					 String phone = c.getString(c.getColumnIndex("phone")); 
					 String address = c.getString(c.getColumnIndex("address")); 
					
					 	intent = new Intent();
						intent.setClass(Query.this, Show.class);
						bundle = new Bundle();
						bundle.putString("id", id);
						bundle.putString("name", name);
						bundle.putString("sex", sex);
						bundle.putString("age", age);
						bundle.putString("joinTime", joinTime);
						bundle.putString("phone", phone);
						bundle.putString("address", address);
						bundle.putString("queringID", queringID);
						intent.putExtras(bundle);
						startActivity(intent);
						
					 }
				 else{
					 Toast.makeText(getApplicationContext(), "信息不存在", Toast.LENGTH_LONG).show();
				 }
				 
				
				 
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.query, menu);
		return true;
	}

}
