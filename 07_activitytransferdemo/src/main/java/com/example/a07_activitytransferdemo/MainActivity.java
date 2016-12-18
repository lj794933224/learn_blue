package com.example.a07_activitytransferdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("msg", "helloworld你好世界");
        startActivity(intent);

    }

    public void onStartService(View view) {
        System.out.println("onStartService启动服务了+++++++++++++++");
        //启动后台服务
        startService(new Intent(this,MyService.class));
    }

    public void onStopService(View view) {
        System.out.println("onStopService，停止服务------");
        //停止服务
        stopService(new Intent(this,MyService.class));
    }
}
