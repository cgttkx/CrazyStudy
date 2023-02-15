package com.example.myapplication.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    private String[] names = new String[]{"虎头", "弄玉", "虎脑", "葬花"};
    private String[] descs = new String[]{"可爱的小孩", "擅长音乐的女孩", "擅长文学的女性", "浪漫主义诗人"};
    private int[] imageIds = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                new String[]{"personName", "header", "desc"},
                new int[]{R.id.name, R.id.header, R.id.desc});

        ListView list=findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

    }

}