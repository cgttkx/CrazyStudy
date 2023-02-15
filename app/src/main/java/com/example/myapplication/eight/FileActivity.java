package com.example.myapplication.eight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileActivity extends AppCompatActivity {
    public static final String FILE_NAME = "crazyit.bin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        Button write=findViewById(R.id.write1);
        Button read=findViewById(R.id.read1);
        EditText edit1 = findViewById(R.id.edit1);
        TextView edit2 = findViewById(R.id.edit2);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 将edit1中的内容写入文件中
                write(edit1.getText().toString());
                edit1.setText("");
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit2.setText(read());//读取指定文件中的内容，并显示出来
            }
        });
    }

    private String read()
    {
        try(// 打开文件输入流
            FileInputStream fis = openFileInput(FILE_NAME)) {
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder("");
            // 读取文件内容
            while ((hasRead = fis.read(buff)) > 0)
            {
                sb.append(new String(buff, 0, hasRead));
            }
            return sb.toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    private void write(String content)
    {
        try(// 以追加方式打开文件输出流
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            // 将FileOutputStream包装成PrintStream
            PrintStream ps = new PrintStream(fos)) {
            // 输出文件内容
            ps.println(content);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}