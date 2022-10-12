package com.example.chapter01.utils;

import android.content.Context;

public class Utils {
    public static int dptopx(Context context, float dp)
    {
        int px = 0;
        // 获取当前手机的像素密度（一个dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp*scale+0.5f);
    }
}
