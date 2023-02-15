package com.example.myapplication.three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends AppCompatActivity {
    private TextView show;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        show=findViewById(R.id.show);
        pb=findViewById(R.id.progressBar);
    }

    class DownTask extends AsyncTask<URL, Integer, String>{
        private ProgressBar progressBar;
        // 定义记录已经读取行的数量
        int hasRead = 0;
        Context mContext;
        public DownTask(Context context, ProgressBar progressBar){
            mContext = context;
            this.progressBar = progressBar;
        }
        //后台线程将要完成的任务
        @Override
        protected String doInBackground(URL... urls) {
            StringBuilder sb=new StringBuilder();
            try {
                URLConnection conn = urls[0].openConnection();
                // 打开conn连接对应的输入流，并将它包装成BufferedReader
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
                String line=br.readLine();
                while((line!=null)){
                    sb.append(line + "\n");
                    hasRead++;
                    publishProgress(hasRead);
                    Thread.sleep(100);
                }
                return sb.toString();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        //doInBackground()方法执行完调用
        @Override
        protected void onPostExecute(String s) {
            // 返回HTML页面的内容
            show.setText(s);
            // 设置进度条不可见
            progressBar.setVisibility(View.INVISIBLE);
        }
        //执行后台耗时操作前被调用
        @Override
        protected void onPreExecute() {
            // 设置进度条可见
            progressBar.setVisibility(View.VISIBLE);
            // 设置进度条的当前值
            progressBar.setProgress(0);
            // 设置该进度条的最大进度值
            progressBar.setMax(100);
        }
        //doInBackground()方法调用publishProgress()方法更新任务后执行
        @Override
        protected void onProgressUpdate(Integer... values) {
            // 更新进度
            show.setText("已经读取了【" + values[0] + "】行！");
            progressBar.setProgress(values[0]);
        }
    }

    // 重写该方法，为界面上的按钮提供事件响应方法
    public void download(View source) throws MalformedURLException
    {
        DownTask task = new DownTask(this, pb);
        task.execute(new URL("http://y.l6bxs.com:7658/down/sscom_v5.13.1_downyi.com.zip"));
    }

}