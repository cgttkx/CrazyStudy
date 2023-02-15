package com.example.myapplication.three;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_num;
    private Button js;
    //定义一个线程类
    class CalThread extends Thread{
        private Handler mHandler;

        @Override
        public void run() {
            //创建Looper对象（主线程中系统已初始化一个Looper对象，不用创建）
            Looper.prepare();

            mHandler=new Handler(){
                //定义消息处理方法
                @Override
                public void handleMessage(@NonNull Message msg) {
                    if (msg.what == 0x123) {
                        int upper = msg.getData().getInt("upper");
                        List<Integer> nums = new ArrayList<Integer>();
                        // 计算从2开始、到upper的所有质数
                        outer:
                        for (int i = 2; i <= upper; i++) {
                            // 用i除以从2开始、到i的平方根的所有数
                            int j = 2;
                            while (j <= Math.sqrt(i)) {
                                // 如果可以整除，则表明这个数不是质数
                                if (i != 2 && i % j == 0) {
                                    continue outer;
                                }
                                j++;
                            }
                            nums.add(i);
                        }
                        // 使用Toast显示统计出来的所有质数
                        Toast.makeText(HandlerActivity.this, nums.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            };
            //启动Looper
            Looper.loop();
        }
    }

    private CalThread calThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        et_num=findViewById(R.id.et_num);
        js=findViewById(R.id.js);
        js.setOnClickListener(this);

        calThread = new CalThread();
        // 启动新线程
        calThread.start();

    }

    @Override
    public void onClick(View v) {
        // 创建消息
        Message msg =new Message();
        msg.what=0x123;
        Bundle bundle=new Bundle();
        //将键值对数据存放到bundle对象中
        bundle.putInt("upper",Integer.parseInt(et_num.getText().toString()));//Integer.parseInt()：将整型数据Integer转换为基本数据类型int
        msg.setData(bundle);
        // 向新线程中的Handler发送消息
        calThread.mHandler.sendMessage(msg);
    }
}