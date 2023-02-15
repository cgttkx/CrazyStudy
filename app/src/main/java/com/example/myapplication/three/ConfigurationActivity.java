package com.example.myapplication.three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class ConfigurationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView ori,navigation,touch,mnc;
    private Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        ori = findViewById(R.id.ori);
        navigation = findViewById(R.id.navigation);
        touch = findViewById(R.id.touch);
        mnc = findViewById(R.id.mnc);
        bn = findViewById(R.id.bn);
        bn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 获取系统的Configuration对象
        Configuration cfg=getResources().getConfiguration();
        //orientation：获取屏幕方向；ORIENTATION_LANDSCAPE —— 横向屏幕
        String screen=cfg.orientation==Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
        String mncCode = cfg.mnc + "";//mnc：获取移动信号的网络码
        String naviName =cfg.orientation==Configuration.NAVIGATION_NONAV ? "没有方向控制" :
                (cfg.orientation == Configuration.NAVIGATION_WHEEL)? "滚轮控制方向" :
                (cfg.orientation == Configuration.NAVIGATION_DPAD) ? "方向键控制方向":
                                "轨迹球控制方向";
        String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH? "无触摸屏": "支持触摸屏";

        ori.setText(screen);
        mnc.setText(mncCode);
        navigation.setText(naviName);
        touch.setText(touchName);
    }
}