package com.example.myapplication.seven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;

import com.example.myapplication.R;
import com.example.myapplication.View.MatrixView;

public class MatrixActivity extends AppCompatActivity {
    private MatrixView matrixView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matrixView=new MatrixView(this);
        setContentView(matrixView);
    }
}