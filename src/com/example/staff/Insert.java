package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends Activity {
	
	Button btn_return;
	Button btn_submit;
	Intent intent;
	SQLiteDatabase db;
	EditText edt_name,edt_id,edt_sex,edt_age,edt_joinTime,edt_phone,edt_address;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert);
		
		//关联组件
		btn_return = (Button)findViewById(R.id.btn_return);
		btn_submit = (Button)findViewById(R.id.btn_submit);
		edt_id = (EditText)findViewById(R.id.edt_id);
		edt_name = (EditText)findViewById(R.id.edt_name);
		edt_sex = (EditText)findViewById(R.id.edt_sex);
		edt_age = (EditText)findViewById(R.id.edt_age);
		edt_joinTime = (EditText)findViewById(R.id.edt_joinTime);
		edt_phone = (EditText)findViewById(R.id.edt_phone);
		edt_address = (EditText)findViewById(R.id.edt_address);
		
		//设置事件监听
		//返回按钮
		btn_return.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Insert.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		//提交按钮
		btn_submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				//获取输入框信息
				String id = edt_id.getText().toString();
				String name = edt_name.getText().toString();
				String sex = edt_sex.getText().toString();
				String age = edt_age.getText().toString();
				String joinTime = edt_joinTime.getText().toString();
				String phone = edt_phone.getText().toString();
				String address = edt_address.getText().toString();
				
				db = openOrCreateDatabase("company.db", Context.MODE_PRIVATE, null);
				
				/*
				String sql_createTable = "create table staff(id text primary key,name text," +
						"sex text,age text,joinTime text,phone text,address text )"; 
				db.execSQL(sql_createTable);
				Toast.makeText(getApplicationContext(), "创建表成功", Toast.LENGTH_LONG).show();
				*/
				
				ContentValues cValue = new ContentValues();
				
				cValue.put("id", id);
				cValue.put("name", name);
				cValue.put("sex", sex);
				cValue.put("age", age);
				cValue.put("joinTime", joinTime);
				cValue.put("phone", phone);
				cValue.put("address", address);
				
				db.insert("staff", null, cValue);
				Toast.makeText(getApplicationContext(), "录入成功", Toast.LENGTH_LONG).show();
				db.close();
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inserter, menu);
		return true;
	}

}
