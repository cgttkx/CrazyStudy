package com.example.myapplication.five;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class DatatestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datatest);
    }
    public void scheme(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.crazyit.org:1234/test"));
        startActivity(intent);
    }
    public void schemeHostPort(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        startActivity(intent);
    }
    public void schemeHostPath(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:1234/mypath"));
        startActivity(intent);
    }
    public void schemeHostPortPath(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        startActivity(intent);
    }
    public void schemeHostPortPathType(View source)
    {
        Intent intent = new Intent();
        // 同时设置Intent的Data、Type属性
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath"), "abc/xyz");
        startActivity(intent);
    }
}