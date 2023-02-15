package com.example.myapplication.six;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class InternationalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);
        TextView tvShow = findViewById(R.id.show);
        // 设置文本框所显示的文本
        tvShow.setText(R.string.msg);
    }
}