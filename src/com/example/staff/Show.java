package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Show extends Activity {
	Button btn_return5;
	TextView tv_queried,tv_showID,tv_showName,tv_showSex,tv_showAge,tv_showJoinTime,tv_showPhone,tv_showAddress;
	Intent intent;
	Bundle bundle;
	Button btn_toMain1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		
		//关联组件
		btn_return5 = (Button)findViewById(R.id.btn_return5);
		btn_toMain1 = (Button)findViewById(R.id.btn_toMain1);
		tv_queried = (TextView)findViewById(R.id.tv_queried);
		tv_showID = (TextView)findViewById(R.id.tv_showID);
		tv_showName = (TextView)findViewById(R.id.tv_showName);
		tv_showSex = (TextView)findViewById(R.id.tv_showSex);
		tv_showAge = (TextView)findViewById(R.id.tv_showAge);
		tv_showJoinTime = (TextView)findViewById(R.id.tv_showJoinTime);
		tv_showPhone = (TextView)findViewById(R.id.tv_showPhone);
		tv_showAddress = (TextView)findViewById(R.id.tv_showAddress);
		//获取数据
		intent = this.getIntent();
		bundle = intent.getExtras();
		String id = bundle.getString("id");
		String name = bundle.getString("name");
		String sex = bundle.getString("sex");
		String age = bundle.getString("age");
		String jionTime = bundle.getString("joinTime");
		String phone = bundle.getString("phone");
		String address = bundle.getString("address");
		String queringID = bundle.getString("queringID");
		
		tv_queried.setText(queringID);
		tv_showID.setText(id);
		tv_showName.setText(name);
		tv_showSex.setText(sex);
		tv_showAge.setText(age);
		tv_showJoinTime.setText(jionTime);
		tv_showPhone.setText(phone);
		tv_showAddress.setText(address);
		
		//返回按钮
		btn_return5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Show.this, Query.class);
				startActivity(intent);
			}
		});
		
		//返回首页
		btn_toMain1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(Show.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}

}
