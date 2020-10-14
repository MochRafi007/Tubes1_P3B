package com.example.m0317073.Adapder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.m0317073.R;

public class NavigationListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public NavigationListAdapter(Activity context,String[] itemname, Integer[] imgid) {
        super(context, R.layout.custom_row, itemname);
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_row, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_nav_menu);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon_nav_menu);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;
    }
}
