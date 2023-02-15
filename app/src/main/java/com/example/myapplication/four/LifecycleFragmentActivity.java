package com.example.myapplication.four;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.R;
import com.example.myapplication.four.fragments.LifecycleFragment;
import com.example.myapplication.four.fragments.SecondFragment;

public class LifecycleFragmentActivity extends FragmentActivity {
    private Button startActivity, addFragment, backFragment, replaceFragment ,finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_fragment);
        startActivity = findViewById(R.id.startActivity);
        addFragment = findViewById(R.id.addFragment);
        backFragment = findViewById(R.id.backFragment);
        replaceFragment = findViewById(R.id.replaceFragment);
        finish = findViewById(R.id.finish);
        // 为startActivity按钮绑定事件监听器
        startActivity.setOnClickListener(source -> {
            Intent intent = new Intent(LifecycleFragmentActivity.this, SecondActivity.class);
            startActivity(intent);
        });
        // 为addFragment按钮绑定事件监听器
        addFragment.setOnClickListener(source -> {
            LifecycleFragment fragment = new LifecycleFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        });
        // 为backFragment按钮绑定事件监听器
        backFragment.setOnClickListener(source -> {
            SecondFragment fragment = new SecondFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack("aa")// 将替换前的Fragment添加到Back栈
                    .commit();
        });
        // 为replaceFragment按钮绑定事件监听器
        replaceFragment.setOnClickListener(source -> {
            SecondFragment fragment = new SecondFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        });
        // 为finish按钮绑定事件监听器
        finish.setOnClickListener(source->LifecycleFragmentActivity.this.finish()/* 结束该Activity*/);
    }
}