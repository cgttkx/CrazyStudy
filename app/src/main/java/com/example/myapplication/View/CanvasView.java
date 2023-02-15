package com.example.myapplication.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

public class CanvasView extends View {

    public CanvasView(Context context, AttributeSet attr){super(context,attr);}
    // 定义画笔
    private Paint paint = new Paint();
    //rect保存矩形的四个整数坐标。矩形是由四条边（左、上、右、下）的坐标表示
    private RectF rect = new RectF();
    //线性渐变
    private LinearGradient mShader = new LinearGradient(0f, 0f, 40f, 60f,
            new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},
            null, Shader.TileMode.REPEAT);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 把整张画布绘制成白色
        canvas.drawColor(Color.WHITE);
        // 去锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        //画笔填充风格
        paint.setStyle(Paint.Style.STROKE);
        //画笔笔触宽度
        paint.setStrokeWidth(4f);
        int viewWidth = this.getWidth();
        // 绘制圆形
        canvas.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        // 绘制正方形
        canvas.drawRect(10f, viewWidth / 5 + 20, viewWidth / 5 + 10, viewWidth * 2 / 5 + 20, paint);
        // 绘制矩形
        canvas.drawRect(10f, viewWidth * 2 / 5 + 30, viewWidth / 5 + 10, viewWidth / 2 + 30, paint);
        rect.set(10f, viewWidth / 2 + 40, 10 + viewWidth / 5, viewWidth * 3 / 5 + 40);
        // 绘制圆角矩形
        canvas.drawRoundRect(rect, 15f, 15f, paint);
        rect.set(10f, viewWidth * 3 / 5 + 50, 10 + viewWidth / 5, viewWidth * 7 / 10 + 50);
        // 绘制椭圆
        canvas.drawOval(rect, paint);

        //定义一个Path对象
        Path path1 = new Path();
        // 使用一个Path对象封闭成一个三角形
        //移动下一次操作的起点位置
        path1.moveTo(10f, viewWidth * 9 / 10 + 60);
        //添加上一个点到当前点之间的直线到Path
        path1.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10 + 60);
        path1.lineTo(viewWidth / 10 + 10, viewWidth * 7 / 10 + 60);
        //连接第一个点连接到最后一个点，形成一个闭合区域
        path1.close();
        // 根据Path进行绘制，绘制三角形
        canvas.drawPath(path1, paint);
        Path path2 = new Path();
        // 使用一个Path对象封闭成一个五角形
        path2.moveTo(10 + viewWidth / 15, viewWidth * 9 / 10 + 70);
        path2.lineTo(10 + viewWidth * 2 / 15, viewWidth * 9 / 10 + 70);
        path2.lineTo(10 + viewWidth / 5, viewWidth + 70);
        path2.lineTo(10 + viewWidth / 10, viewWidth * 11 / 10 + 70);
        path2.lineTo(10f, viewWidth + 70);
        path2.close();
        // 根据Path进行绘制，绘制五角形
        canvas.drawPath(path2, paint);
        // ----------设置填充风格后绘制----------
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        // 绘制圆形
        canvas.drawCircle(viewWidth * 3 / 10 + 20, viewWidth / 10 + 10, viewWidth / 10, paint);
        // 绘制正方形
        canvas.drawRect(viewWidth / 5 + 20, viewWidth / 5 + 20,
                viewWidth * 2 / 5 + 20, viewWidth * 2 / 5 + 20, paint);
        // 绘制矩形
        canvas.drawRect(viewWidth / 5 + 20, viewWidth * 2 / 5 + 30,
                viewWidth * 2 / 5 + 20, viewWidth / 2 + 30, paint);
        rect.set(viewWidth / 5 + 20, viewWidth / 2 + 40,
                20 + viewWidth * 2 / 5, viewWidth * 3 / 5 + 40);
        // 绘制圆角矩形
        canvas.drawRoundRect(rect, 15f, 15f, paint);
        rect.set(20 + viewWidth / 5, viewWidth * 3 / 5 + 50,
                20 + viewWidth * 2 / 5, viewWidth * 7 / 10 + 50);
        // 绘制椭圆
        canvas.drawOval(rect, paint);
        Path path3 = new Path();
        // 使用一个Path对象封闭成一个三角形
        path3.moveTo(20 + viewWidth / 5, viewWidth * 9 / 10 + 60);
        path3.lineTo(viewWidth * 2 / 5 + 20, viewWidth * 9 / 10 + 60);
        path3.lineTo(viewWidth * 3 / 10 + 20, viewWidth * 7 / 10 + 60);
        path3.close();
        // 根据Path进行绘制，绘制三角形
        canvas.drawPath(path3, paint);
        // 使用一个Path对象封闭成一个五角形
        Path path4 = new Path();
        path4.moveTo(20 + viewWidth * 4 / 15, viewWidth * 9 / 10 + 70);
        path4.lineTo(20 + viewWidth / 3, viewWidth * 9 / 10 + 70);
        path4.lineTo(20 + viewWidth * 2 / 5, viewWidth + 70);
        path4.lineTo(20 + viewWidth * 3 / 10, viewWidth * 11 / 10 + 70);
        path4.lineTo(20 + viewWidth / 5, viewWidth + 70);
        path4.close();
        // 根据Path进行绘制，绘制五角形
        canvas.drawPath(path4, paint);
        // ----------设置渐变器后绘制----------
        // 为Paint设置渐变器
        paint.setShader(mShader);
        // 设置阴影
        paint.setShadowLayer(25f, 20f, 20f, Color.GRAY);
        // 绘制圆形
        canvas.drawCircle(viewWidth / 2 + 30, viewWidth / 10 + 10, viewWidth / 10, paint);
        // 绘制正方形
        canvas.drawRect(viewWidth * 2 / 5 + 30, viewWidth / 5 + 20,
                viewWidth * 3 / 5 + 30, viewWidth * 2 / 5 + 20, paint);
        // 绘制矩形
        canvas.drawRect(viewWidth * 2 / 5 + 30, viewWidth * 2 / 5 + 30,
                viewWidth * 3 / 5 + 30, viewWidth / 2 + 30, paint);
        rect.set((viewWidth * 2 / 5 + 30), viewWidth / 2 + 40, 30 + viewWidth * 3 / 5,
                viewWidth * 3 / 5 + 40);
        // 绘制圆角矩形
        canvas.drawRoundRect(rect, 15f, 15f, paint);
        rect.set(30 + viewWidth * 2 / 5, viewWidth * 3 / 5 + 50, 30 + viewWidth * 3 / 5,
                viewWidth * 7 / 10 + 50);
        // 绘制椭圆
        canvas.drawOval(rect, paint);
        Path path5 = new Path();
        // 使用一个Path对象封闭成一个三角形
        path5.moveTo(30 + viewWidth * 2 / 5, viewWidth * 9 / 10 + 60);
        path5.lineTo(viewWidth * 3 / 5 + 30, viewWidth * 9 / 10 + 60);
        path5.lineTo(viewWidth / 2 + 30, viewWidth * 7 / 10 + 60);
        path5.close();
        // 根据Path进行绘制，绘制三角形
        canvas.drawPath(path5, paint);
        Path path6 = new Path();
        // 使用一个Path对象封闭成一个五角形
        path6.moveTo(30 + viewWidth * 7 / 15, viewWidth * 9 / 10 + 70);
        path6.lineTo(30 + viewWidth * 8 / 15, viewWidth * 9 / 10 + 70);
        path6.lineTo(30 + viewWidth * 3 / 5, viewWidth + 70);
        path6.lineTo(30 + viewWidth / 2, viewWidth * 11 / 10 + 70);
        path6.lineTo(30 + viewWidth * 2 / 5, viewWidth + 70);
        path6.close();
        // 根据Path进行绘制，绘制五角形
        canvas.drawPath(path6, paint);
        // ----------设置字符大小后绘制----------
        paint.setTextSize(48f);
        paint.setShader(null);
        // 绘制7个字符串
        canvas.drawText(getResources().getString(R.string.circle),
                60 + viewWidth * 3 / 5, viewWidth / 10 + 10, paint);
        canvas.drawText(getResources().getString(R.string.square),
                60 + viewWidth * 3 / 5, viewWidth * 3 / 10 + 20, paint);
        canvas.drawText(getResources().getString(R.string.rect),
                60 + viewWidth * 3 / 5, viewWidth * 1 / 2 + 20, paint);
        canvas.drawText(getResources().getString(R.string.round_rect),
                60 + viewWidth * 3 / 5, viewWidth * 3 / 5 + 30, paint);
        canvas.drawText(getResources().getString(R.string.oval),
                60 + viewWidth * 3 / 5, viewWidth * 7 / 10 + 30, paint);
        canvas.drawText(getResources().getString(R.string.triangle),
                60 + viewWidth * 3 / 5, viewWidth * 9 / 10 + 30, paint);
        canvas.drawText(getResources().getString(R.string.pentagon),
                60 + viewWidth * 3 / 5, viewWidth * 11 / 10 + 30, paint);
    }
}
