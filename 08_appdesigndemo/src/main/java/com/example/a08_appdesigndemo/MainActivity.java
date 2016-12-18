package com.example.a08_appdesigndemo;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUES_SELECT_BT_CODE = 0x1001;
    private static final int REQUES_BT_ENABLE_CODE = 0x1002;
    private static final String Tag = MainActivity.class.getName();
    private ListView mListView;
    private Button mEt;
    private BluetoothAdapter mBluetoothAdapter
    private Parcelable[] mRemoteDevice;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> mChatContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.main_list_view);
        mEt = (Button) findViewById(R.id.send_Btn);

        mChatContent = new ArrayList<>();
        mAdapter = new ArrayAdapter<String>(this, android.support.v7.appcompat.R.layout.abc_action_bar_title_item, mChatContent);
        mListView.setAdapter(mAdapter);

//        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
//        bluetoothAdapter.enable();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUES_BT_ENABLE_CODE && resultCode == RESULT_OK) {

        } else if (requestCode == REQUES_SELECT_BT_CODE && resultCode == RESULT_OK) {
            mRemoteDevice=data.getParcelableArrayExtra("DEVICE");
            if (mRemoteDevice==null){
                return;

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean opneDevice() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            System.out.println("没有蓝牙设备");
            Toast.makeText(this, "该设备没有蓝牙设备", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUES_BT_ENABLE_CODE);
        } else {

        }
        return true;
    }
    private  void startServiceAsService(){
        TaskService.
    }

}
