package com.example.myapplication.two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.myapplication.View.MainActivity;
import com.example.myapplication.R;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends AppCompatActivity {

    // 定义一个颜色数组
    int[] colors = new int[]{R.color.red_1, R.color.green_1,R.color.purple_1, R.color.yellow_1, R.color.pink_1, R.color.blue_1};
    int[] names =new int[] {R.id.view01,R.id.view02,R.id.view03,R.id.view04,R.id.view05,R.id.view06};
    TextView[] views = new TextView[names.length];

    class MyHandler extends Handler{
        // 内部声明一个弱引用（能回收就及时回收掉），引用外部类
        private WeakReference<MainActivity> activity;
        public MyHandler(WeakReference<MainActivity> activity){this.activity=activity;}

        private int currentColor=0;

        @Override
        public void handleMessage(@NonNull Message msg) {
            // 表明消息来自于本程序所发送的
            if (msg.what == 0x123) {
                for (int i = 0, len = names.length; i < len; i++)
                {
                    views[i].setBackgroundResource(colors[(i + currentColor) % colors.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    }

    private Handler handler=new MyHandler(new WeakReference(this));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        for (int i = 0 ; i < names.length; i++) {
            views[i] = findViewById(names[i]);
        }

        // 定义一个线程周期性地改变currentColor变量值
        new Timer().schedule(new TimerTask()
        {
            @Override public void run()
            {
                // 发送一条空消息通知系统改变6个TextView组件的背景色
                handler.sendEmptyMessage(0x123);
            }
        },0, 200);
    }
}