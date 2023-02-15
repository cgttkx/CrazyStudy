package com.example.myapplication.four.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.myapplication.four.BookManager;


public class BookListFragment extends ListFragment {

    private Callbacks mCallbacks;
    // 定义一个回调接口，该Fragment所在Activity需要实现该接口
    // 该Fragment将通过该接口与它所在的Activity交互
    public interface Callbacks
    {
        void onItemSelected(int id);
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // 为该ListFragment设置Adapter
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, android.R.id.text1, BookManager.ITEMS));  // ①
    }
    // 当该Fragment被添加、显示到它所在的Context时，回调该方法
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // 如果Activity没有实现Callbacks接口，抛出异常
        if (!(context instanceof Callbacks))
        {
            throw new IllegalStateException("BookListFragment所在的Activity必须实现Callbacks接口!");
        }
        // 把该Activity当成Callbacks对象
        mCallbacks = (Callbacks) context;
    }
    // 当该Fragment从它所属的Activity中被删除时回调该方法
    @Override public void onDetach()
    {
        super.onDetach();
        // 将mCallbacks赋为null
        mCallbacks = null;
    }
    // 当用户单击某列表项时激发该回调方法
    @Override
    public void onListItemClick(ListView listView, View view, int position, long id)
    {
        super.onListItemClick(listView, view, position, id);
        // 激发mCallbacks的onItemSelected方法
        mCallbacks.onItemSelected(BookManager.ITEMS.get(position).id);
    }
    // 为自适应手机和平板电脑屏幕的方法
    public void setActivateOnItemClick(boolean activateOnItemClick)
    {
        getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }
}
