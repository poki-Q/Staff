package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updatapp extends Activity {
	
	Button btn_return6;
	Button btn_toUpdata;
	EditText edt_updatingID;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_updatapp);
		
		//关联组件
		btn_return6 = (Button)findViewById(R.id.btn_return6);
		btn_toUpdata = (Button)findViewById(R.id.btn_toUpdata);
		edt_updatingID = (EditText)findViewById(R.id.edt_updatingID);
		
		
		//设置事件监听
		
		//返回按钮
		btn_return6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 intent = new Intent(Updatapp.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		//跳转到更新页面按钮
		btn_toUpdata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String updatingID = edt_updatingID.getText().toString();
				intent = new Intent();
				intent.setClass(Updatapp.this, Updata.class);
				Bundle bundle = new Bundle();
				bundle.putString("updatingID", updatingID);
				intent.putExtras(bundle);
				startActivity(intent);
				
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.updatapp, menu);
		return true;
	}

}
