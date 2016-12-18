package com.example.a07_activitytransferdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/12/18.
 */
public class NewActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("new","111111111111111111111111");
        Intent intent=getIntent();
        String msg=intent.getStringExtra("msg");
       Log.d("msg", intent.getStringExtra("msg")+"----------------");
    }
}
