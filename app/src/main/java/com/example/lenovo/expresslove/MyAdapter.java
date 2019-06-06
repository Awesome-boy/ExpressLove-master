package com.example.lenovo.expresslove;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zt on 2019/5/20.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> listDates;

    public MyAdapter(Context context, List<String> listDates) {
        this.mContext=context;
        this.listDates=listDates;
    }

    @Override
    public int getCount() {
        return listDates.size();
    }

    @Override
    public Object getItem(int position) {
        return listDates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=LayoutInflater .from(mContext).inflate(R.layout.item_view,null);
        TextView tv_text=view.findViewById(R.id.tv_text);
        tv_text.setText(listDates.get(position));
        return view;
    }
}
