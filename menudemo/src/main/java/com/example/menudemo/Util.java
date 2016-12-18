package com.example.menudemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/15.
 */

public class Util {
    private NotificationManager nm;
    private PendingIntent contentIntent=null;
    private Notification.Builder builder;
    public static void  showDaliog(final Context context){
        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
        dlg.setTitle("对话框");
        dlg.setMessage("内容哈哈哈");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "发送Notification" + i, Toast.LENGTH_SHORT).show();
            }
        });
        dlg.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "否发送Notification" + i, Toast.LENGTH_SHORT).show();
            }
        });
        dlg.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "取消发送Notification" + i, Toast.LENGTH_SHORT).show();
            }
        });
        dlg.setCancelable(false);
        dlg.create();
        dlg.show();
    }

    public void  notifyMessage(Context context){
        //发送NotificationManager
        nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(context,context.getClass());
    //    contentIntent = PendingIntent.getActivities(context,0,notificationIntent,0);

    }



}
