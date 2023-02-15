package com.example.myapplication.seven;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.View.DrawBoardView;


public class DrawBoardActivity extends AppCompatActivity {
    private DrawBoardView drawBoardView;
    private BlurMaskFilter blur;
    private EmbossMaskFilter emboss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout line = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        // 获取创建的宽度和高度
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        // 创建一个DrawBoardView，该DrawView的宽度、高度与该Activity保持相同
        drawBoardView = new DrawBoardView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        line.addView(drawBoardView);
        setContentView(line);
        //模糊效果
        emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6f, 4.2f);
        //浮雕效果
        blur = new BlurMaskFilter(8f, BlurMaskFilter.Blur.NORMAL);
    }

    // 负责创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // 加载R.menu.menu_main对应的菜单，并添加到menu中
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        // 判断单击的是哪个菜单项，并有针对性地做出响应
        switch (mi.getItemId())
        {
            case R.id.red:
//                drawBoardView.paint.setColor(Color.RED);

                mi.setChecked(true);
                break;
            case R.id.green:
//                drawBoardView.paint.setColor(Color.GREEN);
                mi.setChecked(true);
                break;
            case R.id.blue:
//                drawBoardView.paint.setColor(Color.BLUE);
                mi.setChecked(true);
                break;
            case R.id.width_1:
//                drawBoardView.paint.setStrokeWidth(1f);
                break;
            case R.id.width_3:
//                drawBoardView.paint.setStrokeWidth(3f);
                break;
            case R.id.width_5:
//                drawBoardView.paint.setStrokeWidth(5f);
                break;
            case R.id.blur:
//                drawBoardView.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
//                drawBoardView.paint.setMaskFilter(emboss);
                break;
        }
        return true;
    }
}