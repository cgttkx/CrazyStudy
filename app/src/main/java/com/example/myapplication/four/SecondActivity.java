package com.example.myapplication.four;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("对话框风格的Activity");
		setContentView(tv);
	}
}
