package com.example.myapplication.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.myapplication.R;

public class ToggleButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        ToggleButton toggle = findViewById(R.id.toggle);
        Switch switcher = findViewById(R.id.switcher);
        LinearLayout test = findViewById(R.id.test);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 设置LinearLayout垂直布局
                    test.setOrientation(LinearLayout.VERTICAL);
                    toggle.setChecked(true);
                    switcher.setChecked(true);
                } else {
                    // 设置LinearLayout水平布局
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    toggle.setChecked(false);
                    switcher.setChecked(false);
                }
            }
        };
        //为按钮添加监听器
        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);
    }
}

