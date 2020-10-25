package com.example.m0317073.Adapder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;
import com.example.m0317073.R;

import java.util.ArrayList;
import java.util.List;

public class ListMakanan extends BaseAdapter {
    private List<Menu> listItems;
    private Activity activity;
    private MainPresenter mainPresenter;

    public ListMakanan(Activity activity, MainPresenter mainPresenter){
        this.activity = activity;
        this.listItems = new ArrayList<>();
        this.mainPresenter = mainPresenter;
    }
    public void update(List<Menu> foods) {
        this.listItems.clear();
        this.listItems.addAll((foods));
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.list_item_group, parent, false);
            viewHolder = new ViewHolder(convertView,this.mainPresenter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView((Menu) this.getItem(i),i);
        return convertView;

    }

    private class ViewHolder{
        protected TextView namaMenu;
        protected MainPresenter mainPresenter;
        protected int position;

        public ViewHolder(View convertView, MainPresenter mainPresenter) {
            this.namaMenu = convertView.findViewById(R.id.namaMenu);
            this.mainPresenter = mainPresenter;
        }


        public void updateView(Menu food, int position){
            this.position = position;
            this.namaMenu.setText((food.getNama_menu()));
        }
    }


}
