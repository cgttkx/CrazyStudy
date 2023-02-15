package com.example.myapplication.eight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.myapplication.R;

public class GestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    // 定义手势检测器变量
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        // 创建手势检测器
        detector = new GestureDetector(this, this);
    }
    // 将该Activity上的触碰事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent me)
    {
        return detector.onTouchEvent(me);
    }
    //按下
    @Override
    public boolean onDown(MotionEvent e)
    {
        Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show();
        return false;
    }
    //按住（在长按之前）
    @Override
    public void onShowPress(MotionEvent e)
    {
        Toast.makeText(this, "onShowPress", Toast.LENGTH_SHORT).show();
    }
    //抬起
    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
        Toast.makeText(this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
        return false;
    }
    //滚动（滑动）
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
    {
        Toast.makeText(this, "onScroll", Toast.LENGTH_SHORT).show();
        return false;
    }
    //长按
    @Override
    public void onLongPress(MotionEvent e)
    {
        Toast.makeText(this, "onLongPress", Toast.LENGTH_SHORT).show();
    }
    //投掷（迅速移动并松开）
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        Toast.makeText(this, "onFling", Toast.LENGTH_SHORT).show();
        return false;
    }
}