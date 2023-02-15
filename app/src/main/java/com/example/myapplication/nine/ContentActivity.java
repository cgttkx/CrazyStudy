package com.example.myapplication.nine;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContentActivity extends AppCompatActivity{
    private EditText word,detail,key;
    private Button insert,search;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        // 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可
        // 数据库文件自动会保存在程序的数据文件夹的databases目录下
        dbHelper = new MyDatabaseHelper(this, "myDict.db3", 1);
        word=findViewById(R.id.word);
        detail=findViewById(R.id.detail);
        key=findViewById(R.id.key);
        insert=findViewById(R.id.insert1);
        search=findViewById(R.id.search);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入
                String word1 = word.getText().toString();
                String detail1 = detail.getText().toString();
                // 插入单词记录
                insertData(dbHelper.getReadableDatabase(), word1, detail1);
                // 显示提示信息
                Toast.makeText(ContentActivity.this,"单词添加成功", Toast.LENGTH_LONG).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入
                String key1 = key.getText().toString();
                // 执行查询
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                        "select * from dict where word like ? or detail like ?",
                        new String[] { "%" + key1 + "%", "%" + key1 + "%" });
                // 创建一个Bundle对象
                Bundle data = new Bundle();
                data.putSerializable("data", converCursorToList(cursor));
                // 创建一个Intent
                Intent intent = new Intent(ContentActivity.this, ResultActivity.class);
                intent.putExtras(data);
                // 启动Activity
                startActivity(intent);
            }
        });
    }


    private ArrayList<Map<String, String>> converCursorToList(Cursor cursor)
    {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        // 遍历Cursor结果集
        while (cursor.moveToNext())
        {
            // 将结果集中的数据存入ArrayList中
            Map<String, String> map = new HashMap<>();
            // 取出查询记录中第2列、第3列的值
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            result.add(map);
        }
        return result;
    }

    private void insertData(SQLiteDatabase db, String word, String detail)
    {
        // 执行插入语句
        db.execSQL("insert into dict values(null , ? , ?)", new String[]{word, detail});
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        // 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        dbHelper.close();
    }
}