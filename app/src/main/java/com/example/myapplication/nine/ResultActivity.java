package com.example.myapplication.nine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.example.myapplication.R;
import java.util.List;
import java.util.Map;


public class ResultActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup);
		ListView listView = findViewById(R.id.show);
		Intent intent = getIntent();
		// 获取该intent所携带的数据
		Bundle data = intent.getExtras();
		// 从Bundle数据包中取出数据
		List<Map<String, String>> list = (List<Map<String, String>>) data.getSerializable("data");
		// 将List封装成SimpleAdapter
		SimpleAdapter adapter = new SimpleAdapter(ResultActivity.this,
			list, R.layout.line, new String[]{"word", "detail"}, new int[]{R.id.word2, R.id.detail2});
		// 填充ListView
		listView.setAdapter(adapter);
	}
}
