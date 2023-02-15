package com.example.myapplication.eight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedPreferencesActivity extends AppCompatActivity {
    private SharedPreferences preferences,preferences1;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        //获取只能被本应用程序读写的SharedPreferences对象
        preferences=getSharedPreferences("crazyit", Context.MODE_PRIVATE);
        //获取Editor对象
        editor=preferences.edit();

        Button write=findViewById(R.id.write);
        Button read=findViewById(R.id.read);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 " + "hh:mm:ss");
                // 存入当前时间
                editor.putString("time", sdf.format(new Date()));
                // 存入一个随机数
                editor.putInt("random", (int) (Math.random() * 100));
                // 提交所有存入的数据
                editor.apply();

            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 读取字符串数据
                String time = preferences.getString("time", null);
                // 读取int类型的数据
                int randNum = preferences.getInt("random", 0);
                String result = time == null ? "您暂时还未写入数据" : "写入时间为：" + time + "\n上次生成的随机数为：" + randNum;
                Toast.makeText(SharedPreferencesActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        // 读取SharedPreferences里的count数据
        int count = preferences.getInt("count", 0);
        // 显示程序以前使用的次数
        Toast.makeText(this, "程序以前被使用了" + count + "次。", Toast.LENGTH_LONG).show();
        // 存入数据
        editor.putInt("count", ++count);
        // 提交修改
        editor.apply();
    }
}