package com.example.myapplication.eight;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.myapplication.eight.StuDBHelper;
import com.example.myapplication.R;

public class SQLiteActivity extends AppCompatActivity{
    private Button create,update,insert,query,delete,Modify;
    private StuDBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        create = findViewById(R.id.createDatabase);
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.updateDatabas);
        query  = findViewById(R.id.query);
        delete = findViewById(R.id.delete);
        Modify = findViewById(R.id.update);
        //创建StuDBHelper对象
        dbHelper=new StuDBHelper(SQLiteActivity.this,"stu_db",null,1);
        //得到一个可读的SQLiteDatabase对象
        db=dbHelper.getReadableDatabase();
        //监听事件
        setListener();
    }

    private void setListener() {
        create.setOnClickListener(new CreateListener());
        update.setOnClickListener(new UpdateListener());
        insert.setOnClickListener(new InsertListener());
        Modify.setOnClickListener(new ModifyListener());
        query.setOnClickListener(new QueryListener());
        delete.setOnClickListener(new DeleteListener());
    }

    //数据库的创建
    private class CreateListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Toast.makeText(SQLiteActivity.this,"创建数据库成功",Toast.LENGTH_LONG).show();
        }
    }

    //数据插入
    private class InsertListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //插入数据SQL语句
            String sql="insert into stu_table(id,sname,sage,ssex) values(1,'zhangshan',23,'male')";//插入单条数据
//            String sql = "INSERT INTO stu_table(id,sname,sage,ssex) SELECT 2,'liming',28,'male' UNION ALL SELECT 3,'wanghong',29,'male'";插入多条数据
            //执行SQL语句
            db.execSQL(sql);
            Toast.makeText(SQLiteActivity.this,"插入数据成功!",Toast.LENGTH_LONG).show();
        }
    }

    //数据删除
    private class DeleteListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //删除SQL语句
            String sql1 = "delete from stu_table where id =1";
            //执行SQL语句
            db.execSQL(sql1);
            Toast.makeText(SQLiteActivity.this,"删除数据成功!",Toast.LENGTH_LONG).show();
        }
    }

    //数据查询
    private class QueryListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //query(表名,要想显示的列,where子句,where子句对应的条件值,分组方式,having条件,排序方式)
            Cursor cursor = db.query("stu_table", new String[]{"id","sname","sage","ssex"}, null, null, null, null, null);
            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("sname"));
                String age = cursor.getString(cursor.getColumnIndex("sage"));
                String sex = cursor.getString(cursor.getColumnIndex("ssex"));
                System.out.println("查询------->" + "姓名："+name+" "+"年龄："+age+" "+"性别："+sex);
            }
            Toast.makeText(SQLiteActivity.this,"查询数据库成功",Toast.LENGTH_LONG).show();
            //关闭数据库
            db.close();
        }
    }

    //数据的更新
    private class ModifyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //修改SQL语句
            String sql = "update stu_table set sname = 'djp' where id = 1";
            //执行SQL
            db.execSQL(sql);
            Toast.makeText(SQLiteActivity.this,"数据库更新成功",Toast.LENGTH_LONG).show();
        }
    }

    //数据库版本的更新
    private class UpdateListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 数据库版本的更新,由原来的1变为2
            StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,2);
            SQLiteDatabase db =dbHelper.getReadableDatabase();
            Toast.makeText(SQLiteActivity.this,"数据库版本更新成功",Toast.LENGTH_LONG).show();
        }
    }

}