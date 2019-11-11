package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.AlertDialog.Builder;
import android.widget.EditText;
import android.widget.Toast;
import android.view.LayoutInflater;


public class Delete extends Activity {

	Button btn_return2;
	Button btn_deleting;
	EditText edt_deleting;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		//关联组件
		btn_return2 = (Button)findViewById(R.id.btn_return2);
		btn_deleting = (Button)findViewById(R.id.btn_delete);
		edt_deleting = (EditText)findViewById(R.id.edt_deleting);
		
		
		//设置事件监听
		//返回
		btn_return2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Delete.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		//删除按钮
		btn_deleting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				final String id_delete = edt_deleting.getText().toString();
				AlertDialog.Builder builder = new AlertDialog.Builder(Delete.this);
				builder.setTitle("提示");
				builder.setMessage("\n确定删除编号为"+id_delete+"的信息？");
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						db = openOrCreateDatabase("company.db", Context.MODE_PRIVATE, null);
						String sql_delete = "delete from staff where id = '"+id_delete+"'";
						db.execSQL(sql_delete);
						Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_LONG).show();
							
					}
				});
				
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						dialog.dismiss();
						
					}
				});
				
				builder.create().show();
				
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}

}
