package com.example.myapplication.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.example.myapplication.R;

public class MatrixView extends View {
    // 初始的图片资源
    private Bitmap bitmap;
    // Matrix 实例
    private Matrix bmMatrix = new Matrix();
    // 设置倾斜度
    float sx;
    // 位图宽和高
    private int bmWidth;
    private int bmHeight;
    // 缩放比例
    float scale = 1.0f;
    // 判断缩放还是旋转
    boolean isScale;

    public MatrixView(Context context){
        super(context);
        //获得位图
        bitmap=((BitmapDrawable)context.getResources().getDrawable(R.drawable.a,context.getTheme())).getBitmap();
        // 获得位图宽
        bmWidth = bitmap.getWidth();
        // 获得位图高
        bmHeight = bitmap.getHeight();
        // 使当前视图获得焦点
        this.setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 重置Matrix
        bmMatrix.reset();
        if (!isScale)
        {
            // 倾斜Matrix
            bmMatrix.setSkew(sx, 0f);
        }
        else
        {
            // 缩放Matrix
            bmMatrix.setScale(scale, scale);
        }
        // 根据原始位图和Matrix创建新图片
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bmWidth, bmHeight, bmMatrix, true);
        // 绘制新位图
        canvas.drawBitmap(bitmap2, bmMatrix, null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_A:
                isScale=false;
                sx+=0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_D:
                isScale=false;
                sx-=0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_W:
                isScale=true;
                if(scale<2.0)scale+=0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_S:
                isScale=true;
                if(scale>0.5)scale-=0.1;
                postInvalidate();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
