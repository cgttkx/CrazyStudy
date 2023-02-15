package com.example.myapplication.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplication.R;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        // 获取界面布局文件中的Spinner组件
        Spinner spinner = findViewById(R.id.spinner);
        String[] arr = new String[]{"孙悟空", "猪八戒", "唐僧"};
        // 创建ArrayAdapter对象
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, arr);
        // 为Spinner设置Adapter
        spinner.setAdapter(adapter);
    }
}