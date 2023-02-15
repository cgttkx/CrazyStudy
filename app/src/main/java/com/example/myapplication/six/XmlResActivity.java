package com.example.myapplication.six;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class XmlResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_res);

        Button  analysis=findViewById(R.id.analysis);
        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 根据XML资源的ID获取解析该资源的解析器
                //通过Resource.getXML()方法获得XML原始文件，得到XMLResourceParser对象，
                // getXml()方法返回XmlResourceParser对象
                // XmlResourceParser是XmlPullParser的子类
                XmlResourceParser xrp=getResources().getXml(R.xml.books);
                try{
                    StringBuilder sb=new StringBuilder();
                    // 还没有到XML文档的结尾处
                    while (xrp.getEventType()!=XmlResourceParser.END_DOCUMENT){
                        // 如果遇到开始标签
                        if(xrp.getEventType()==XmlResourceParser.START_TAG){
                            // 获取该标签的标签名
                            String tagName=xrp.getName();
                            // 如果遇到book标签
                            if(tagName.equals("book")){
                                // 根据属性名来获取属性值
                                String bookName=xrp.getAttributeValue(null,"price");
                                sb.append("价格：");
                                sb.append(bookName);
                                // 根据属性索引来获取属性值
                                String bookPrice = xrp.getAttributeValue(1);
                                sb.append("	出版日期：");
                                sb.append(bookPrice);
                                sb.append(" 书名：");
                                // 获取文本节点的值
                                sb.append(xrp.nextText());
                            }
                            sb.append("\n");
                        }
                        // 获取解析器的下一个事件
                        xrp.next();
                    }
                    TextView show = findViewById(R.id.show);
                    show.setText(sb.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}