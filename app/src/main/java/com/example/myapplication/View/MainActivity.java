package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DrawView();
    }

    /**
    //通过Java代码把DrawView组件添加到Layout容器里
    private void DrawView(){
        // 获取布局文件中的LinearLayout容器
        LinearLayout root = findViewById(R.id.root);
        // 创建DrawView组件
        DrawView draw = new DrawView(this);
        // 设置自定义组件的最小宽度、高度
        draw.setMinimumWidth(300);
        draw.setMinimumHeight(500);
        root.addView(draw);
    }
    */

}