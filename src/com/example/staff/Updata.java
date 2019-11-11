package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Updata extends Activity {
	
	Button btn_return3;
	Button btn_updating;
	EditText edt_updataID, edt_updataName, edt_updataSex, edt_updataAge, edt_updataJoinTime, 
	 		 edt_updataPhone, edt_updataAddress;
	Intent intent;	
	SQLiteDatabase db;
	Button btn_toMain2;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_updata);
		
		//关联组件
		btn_return3 = (Button)findViewById(R.id.btn_return3);
		btn_updating = (Button)findViewById(R.id.btn_updating);
		btn_toMain2 = (Button)findViewById(R.id.btn_toMain2);
		edt_updataID = (EditText)findViewById(R.id.edt_updataID);
		edt_updataName = (EditText)findViewById(R.id.edt_updataName);
		edt_updataSex = (EditText)findViewById(R.id.edt_updataSex);
		edt_updataAge = (EditText)findViewById(R.id.edt_updataAge);
		edt_updataJoinTime = (EditText)findViewById(R.id.edt_updataJoinTime);
		edt_updataPhone = (EditText)findViewById(R.id.edt_updataPhone);
		edt_updataAddress = (EditText)findViewById(R.id.edt_updataAddress);
		
		//返回按钮
		btn_return3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Updata.this, Updatapp.class);
				startActivity(intent);
				
			}
		});
		
		//获取要修改的ID
		intent = this.getIntent();
		Bundle bundle = new Bundle();
		bundle = intent.getExtras();
		final String  updatingID = bundle.getString("updatingID");
		
		
		//查询原有信息
		db = openOrCreateDatabase("company.db", Context.MODE_PRIVATE, null);
		
		Cursor c = db.rawQuery("select * from staff where id = '"+updatingID+"' ", null);
		 if(c.moveToFirst()){
			 String id = c.getString(c.getColumnIndex("id"));
			 String name = c.getString(c.getColumnIndex("name")); 
			 String sex = c.getString(c.getColumnIndex("sex")); 
			 String age = c.getString(c.getColumnIndex("age")); 
			 String joinTime = c.getString(c.getColumnIndex("joinTime")); 
			 String phone = c.getString(c.getColumnIndex("phone")); 
			 String address = c.getString(c.getColumnIndex("address")); 
			 edt_updataID.setText(id);
			 edt_updataName.setText(name);
			 edt_updataSex.setText(sex);
			 edt_updataAge.setText(age);
			 edt_updataJoinTime.setText(joinTime);
			 edt_updataPhone.setText(phone);
			 edt_updataAddress.setText(address);
		 }
		 
		 
		 //修改按钮
		 btn_updating.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			
				
				
				
				String updatedID = edt_updataID.getText().toString();
				String updatedName = edt_updataName.getText().toString();
				String updatedSex = edt_updataSex.getText().toString();
				String updatedAge = edt_updataAge.getText().toString();
				String updatedJoinTime = edt_updataJoinTime.getText().toString();
				String updatedPhone = edt_updataPhone.getText().toString();
				String updatedAddress = edt_updataAddress.getText().toString();
				
				/*String sql_updata = "updata staff set id = '"+updatedID+"',name = '"+updatedName+"'," +
						"sex = '"+updatedSex+"',age = '"+updatedAge+"',joinTime = '"+updatedJoinTime+"'," +
								"phone = '"+updatedPhone+"',address = '"+updatedAddress+"' where id = '"+updatedID+"'";*/
				ContentValues cv = new ContentValues();
				cv.put("id", updatedID);
				cv.put("name", updatedName);
				cv.put("sex", updatedSex);
				cv.put("age", updatedAge);
				cv.put("joinTime", updatedJoinTime);
				cv.put("phone", updatedPhone);
				cv.put("address", updatedAddress);
				String whereClause = "id = ?";
				String[] whereArgs = {String.valueOf(updatingID)};
				db.update("staff", cv, whereClause, whereArgs);
				db.close();
				Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_LONG).show();
				
			}
		});
		 
		 //返回主界面
		 btn_toMain2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Updata.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.updata, menu);
		return true;
	}

}
