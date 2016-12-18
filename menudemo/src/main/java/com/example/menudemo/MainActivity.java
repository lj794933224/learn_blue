package com.example.menudemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.example.menudemo.R.id.toolbar;

public class MainActivity extends AppCompatActivity {
    private NotificationManager nm;
    private PendingIntent contentIntent=null;
    private Notification.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.showDaliog(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void showDaliog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("对话框");
        dlg.setMessage("内容哈哈哈");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "确定按钮点击了" + i, Toast.LENGTH_SHORT).show();

            }
        });
        dlg.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "否按钮点击了" + i, Toast.LENGTH_SHORT).show();
            }
        });
        dlg.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "取消按钮点击了" + i, Toast.LENGTH_SHORT).show();
            }
        });
        dlg.setCancelable(false);
        dlg.create();
        dlg.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "选择第1个" + item.getTitle(), Toast.LENGTH_SHORT).show();
                notifyMessage();
                break;
            case R.id.action_settings2:
                Toast.makeText(MainActivity.this, "选择第2个" + item.getTitle(), Toast.LENGTH_SHORT).show();
                notifyMessage();
                break;
            case R.id.action_settings3:
                Toast.makeText(MainActivity.this, "选择第3个" + item.getTitle(), Toast.LENGTH_SHORT).show();
                notifyMessage();
                break;
            case R.id.action_settings4:
                Toast.makeText(MainActivity.this, "选择第4个" + item.getTitle(), Toast.LENGTH_SHORT).show();
                notifyMessage();
                break;

        }
        return true;
    }

    public void  notifyMessage(){
        //发送NotificationManager
        nm=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(this,MainActivity.class);
        contentIntent = PendingIntent.getActivity(MainActivity.this,0,notificationIntent,0);
        builder = new Notification.Builder(MainActivity.this);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("这是Noticontent标题")
                .setContentText("这是Notifi内容");
        Notification n=builder.getNotification();
        n.defaults=Notification.DEFAULT_SOUND;
        nm.notify(100,n);
    }
}
