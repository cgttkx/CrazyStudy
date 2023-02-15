package com.example.myapplication.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    //如果View是在Java中new()出来的，则调用第一个构造函数
    public DrawView(Context context){super(context);}
    //如果View是在.xml中声明加载的，则调用第二个构造函数
    public DrawView(Context context, AttributeSet set){super(context,set);}
    //第三个构造函数通常是我们自己在构造函数中主动调用的
    public DrawView(Context context, AttributeSet set, int defStyleAttr) { super(context,set,defStyleAttr);}

    private Paint paint=new Paint();
    private float currentX=40f;
    private float currentY=50f;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15f,paint);
    }

    // 当发生触摸屏幕事件时触发该方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 修改currentX、currentY两个属性
        currentX = event.getX();
        currentY = event.getY();
        // 通知当前组件重绘自己
        invalidate();
        // 返回true表明该处理方法已经处理该事件
        return true;

    }
}
