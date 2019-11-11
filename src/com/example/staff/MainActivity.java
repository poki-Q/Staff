package com.example.staff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button btn_insert,btn_delete,btn_updata,btn_query;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //关联组件
        btn_insert = (Button)findViewById(R.id.btn_return);
        btn_delete = (Button)findViewById(R.id.btn_delete);
        btn_updata = (Button)findViewById(R.id.btn_updata);
        btn_query = (Button)findViewById(R.id.btn_query);
        
        //设置事件监听
        //插入
        btn_insert.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent	intent = new Intent(MainActivity.this, Insert.class);
				startActivity(intent);
				
			}
		});
        
        //删除
        btn_delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent	intent = new Intent(MainActivity.this, Delete.class);
				startActivity(intent);
				
			}
		});
        
        //修改
        btn_updata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent	intent = new Intent(MainActivity.this, Updatapp.class);
				startActivity(intent);
				
			}
		});
        
        //查询
        btn_query.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent	intent = new Intent(MainActivity.this, Query.class);
				startActivity(intent);
				
			}
		});
        
        
        
        
        
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
