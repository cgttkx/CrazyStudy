package com.example.myapplication.four;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.myapplication.R;

public class BundleActivity extends AppCompatActivity {
    private EditText name1,passwd1;
    private Button register;
    private RadioButton male1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);

        name1=findViewById(R.id.name1);
        passwd1=findViewById(R.id.passwd1);
        register=findViewById(R.id.register);
        male1=findViewById(R.id.male1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name =name1.getText().toString();
//                String passwd =passwd1.getText().toString();
                String gender = male1.isChecked() ? "男 " : "女";
                Person p = new Person(name1.getText().toString(), passwd1.getText().toString(), gender);
                // 创建一个Bundle对象
                Bundle data =new Bundle();
//                data.putString("name",name);
//                data.putString("passwd",passwd);
//                data.putString("gender",gender);
                data.putSerializable("person", p);
                // 创建一个Intent
                Intent intent = new Intent(BundleActivity.this, ResultActivity.class);
                intent.putExtras(data);
                // 启动intent对应的Activity
                startActivity(intent);
            }
        });
    }
}