package com.example.a04_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.a04_list_view.R.id.tv_msg;

/**
 * Created by Administrator on 2016/12/14.
 */

public class MyAdapter extends BaseAdapter {
    private List<HashMap<String, Object>> mDataSet;
    private Context mContext;
    //转换器，将xml中的文件装换成控件对象
    private LayoutInflater mInflater;
    public List<HashMap<String,Object>> getDataSet(){
                  return mDataSet;
    }

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        this.mDataSet = new ArrayList<>();
        HashMap<String, Object> map;
        for (int i = 0; i < 30; i++) {
        map=new HashMap<>();
            map.put("img",R.mipmap.icon_img);
            map.put("time","19:32");
            map.put("message","聊天内容"+i);
            mDataSet.add(map);
        }
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /*
    返回数据集合的数量
     */
    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*
    用于将循环器中的将要显示的项进行数据组装
    listview会将移除显示区域的View放到循环器中，等待GetView来组装
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        /**
         * i 表示要组装的数据集合中第几个数据
         * view表示循环器中待用的对象，（可为null）
         * viewGroup:表示listview的父控对象
         */
        //判断循环器的对象是否为空，如果为null,表示ListView刚刚初始化
        //如果不为空，说明是循环器中可用的对象
        if (view==null){
            //将layout文件中的控件转换成可用的控件对象
            view=mInflater.inflate(R.layout.chat_list_view,null);
            ImageView image=(ImageView) view.findViewById(R.id.imageView);
            TextView tv_time=(TextView)view.findViewById(R.id.tvTime);
            TextView tv_msg=(TextView)view.findViewById(R.id.tv_msg);
            view.setTag(new Holder(image,tv_time,tv_msg));
        }
        //重复使用存在的项

        //将i处的数据组装到该项中，返回
        Holder h=(Holder) view.getTag();
        h.image.setImageResource((Integer) mDataSet.get(i).get("img"));
        h.tv_time.setText((String) mDataSet.get(i).get("time"));
        h.tv_msg.setText((String) mDataSet.get(i).get("message"));

        return view;
    }
    private class Holder{
        ImageView image;
        TextView tv_time;
        TextView tv_msg;
        public Holder(ImageView image, TextView tv_time,TextView tv_msg){
            this.image=image;
            this.tv_msg=tv_msg;
            this.tv_time=tv_time;
        }
    }
}
