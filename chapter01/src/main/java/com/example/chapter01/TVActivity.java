package com.example.chapter01;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter01.utils.Utils;

public class TVActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        TextView tv2 = findViewById(R.id.tv2);
//        tv1.setTextColor(Color.BLUE);
//        tv1.setBackgroundResource(R.color.purple_700);
        // 通过以下方式设置布局宽高用的单位是px，如有必要，要自己转换一下dp到px
       ViewGroup.LayoutParams layoutParams = tv2.getLayoutParams();
       layoutParams.width = Utils.dptopx(this,100);
       layoutParams.height = Utils.dptopx(this,100);
       tv2.setBackgroundResource(R.color.black);
       tv2.setLayoutParams(layoutParams);


    }
}
