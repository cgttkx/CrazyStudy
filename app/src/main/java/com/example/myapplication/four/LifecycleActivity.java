package com.example.myapplication.four;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplication.R;

public class LifecycleActivity extends AppCompatActivity {
    private Button startActivityBn,finishBn;
    private static final String TAG = "--CrazyIt--";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        // 输出日志
        Log.d(TAG, "-------onCreate------");
        finishBn = findViewById(R.id.finish);
        startActivityBn = findViewById(R.id.startActivity);
        // 为startActivity按钮绑定事件监听器
        startActivityBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifecycleActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        // 为finish按钮绑定事件监听器
        finishBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onStart()
    {
        super.onStart();
        // 输出日志
        Log.d(TAG, "-------onStart------");
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        // 输出日志
        Log.d(TAG, "-------onRestart------");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        // 输出日志
        Log.d(TAG, "-------onResume------");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        // 输出日志
        Log.d(TAG, "-------onPause------");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        // 输出日志
        Log.d(TAG, "-------onStop------");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        // 输出日志
        Log.d(TAG, "-------onDestroy------");
    }
}