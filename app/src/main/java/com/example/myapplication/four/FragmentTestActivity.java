package com.example.myapplication.four;


import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.R;
import com.example.myapplication.four.fragments.BookDetailFragment;
import com.example.myapplication.four.fragments.BookListFragment;

public class FragmentTestActivity extends FragmentActivity implements BookListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //getSupportFragmentManager()就是获取所在fragment的父容器的管理器
        ((BookListFragment)getSupportFragmentManager().findFragmentById(R.id.book_list)).setActivateOnItemClick(true);
    }
    // 实现Callbacks接口必须实现的方法
    @Override
    public void onItemSelected(int id)
    {
        // 创建Bundle，准备向Fragment传入参数
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailFragment.ITEM_ID, id);
        // 创建BookDetailFragment对象
        BookDetailFragment fragment = new BookDetailFragment();
        // 向Fragment传入参数
        fragment.setArguments(arguments);
        // 使用fragment替换book_detail_container容器当前显示的Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
    }
}