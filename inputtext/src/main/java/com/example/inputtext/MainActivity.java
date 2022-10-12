package com.example.inputtext;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private  SharedPreferences shuanshuan;
    private EditText username;
    private String dbPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);


        dbPath = getFilesDir()+"/test1.db";
        Button button3 = findViewById(R.id.bu3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(dbPath, Context.MODE_PRIVATE, null);
                String sql = "create table  IF NOT EXISTS user" +
                        " (" +
                        "id int primary key," +
                        "username char(30) not null unique," +
                        "truename char(30) not null" +
                        ")";
//                sqLiteDatabase.execSQL(sql);
//
//                sqLiteDatabase.execSQL("insert into user(id,username,truename) values(12,'SD001.sc','舒翔')");
//实例化常量值
//                ContentValues cValue = new ContentValues();
////添加用户名
//                cValue.put("id",145);
//                cValue.put("username","xiaoming");
////添加密码
//                cValue.put("truename","01005");
//                long user = sqLiteDatabase.insert("user", null, cValue);
//                Toast.makeText(MainActivity.this,String.valueOf(user),Toast.LENGTH_SHORT).show();


                Cursor cursor = sqLiteDatabase.query ("user",null,null,null,null,null,null);
                //判断游标是否为空
                if(cursor.moveToFirst()) {
//遍历游标
                    for(int i=0;i<cursor.getCount();i++){
                        cursor.move(i);
//获得ID
                        int id = cursor.getInt(0);
//获得用户名
                        String username=cursor.getString(1);
//获得密码
                        String password=cursor.getString(2);
                        Toast.makeText(MainActivity.this,username,Toast.LENGTH_SHORT).show();
//输出用户信息 System.out.println(id+":"+sname+":"+snumber);
                    }
                }


                if(sqLiteDatabase.isOpen())sqLiteDatabase.close();
            }
        });


        Button button2 = findViewById(R.id.bu2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuanshuan = getSharedPreferences("shuanshuan", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = shuanshuan.edit();
                edit.putString("name","huangwei");
                edit.commit();
                Map<String, ?> all = shuanshuan.getAll();
                Toast.makeText(MainActivity.this,all.toString(),Toast.LENGTH_SHORT).show();
            }
        });
         Button button = findViewById(R.id.bu);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                 builder.setTitle("提醒");
                 builder.setMessage("请不要搞我");
                 builder.setPositiveButton("干掉我吧",(dialog,which)->{

                 });
                 builder.setNegativeButton("不要不要",(dialog,which)->{

                 });
                 AlertDialog alertDialog = builder.create();
                 alertDialog.show();
             }
         });

        username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        password.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b)
        {
            if(username.getText().length()<0 || username.getText().length()>11)
            {
                username.requestFocus();
                Toast.makeText(MainActivity.this,"请输入11位",Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(username.getText()))
            {
                username.requestFocus();
                Toast.makeText(MainActivity.this,"请不能为空",Toast.LENGTH_SHORT).show();
            }
        }
    }
}