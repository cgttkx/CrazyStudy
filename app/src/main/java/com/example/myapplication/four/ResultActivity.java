package com.example.myapplication.four;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class ResultActivity extends AppCompatActivity {
    private TextView name2,passwd2,gender2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        name2=findViewById(R.id.name2);
        passwd2=findViewById(R.id.passwd2);
        gender2=findViewById(R.id.gender);
        // 获取启动该Activity的Intent
        Intent intent = getIntent();
        // 直接通过Intent取出它所携带的Bundle数据包中的数据
//        String name=intent.getStringExtra("name");
//        String passwd=intent.getStringExtra("passwd");
//        String gender=intent.getStringExtra("gender");
//        name2.setText("您的用户名为：" + name);
//        passwd2.setText("您的密码为：" + passwd);
//        gender2.setText("您的性别为：" + gender);
        Person p = (Person) intent.getSerializableExtra("person");
        name2.setText("您的用户名为：" + p.getName());
        passwd2.setText("您的密码为：" + p.getPasswd());
        gender2.setText("您的性别为：" + p.getGender());
    }
}