package com.example.m0317073.Adapder;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;
import com.example.m0317073.R;

import org.json.JSONException;

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
    public void update(List<Menu> menu) {
        this.listItems.clear();
        this.listItems.addAll(menu);
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
        viewHolder.updateView((Menu)this.getItem(i),i);
        return convertView;

    }

    private class ViewHolder implements View.OnClickListener{
        protected MainPresenter presenter;
        protected TextView namaMenu;
        protected int position;
        private Menu menu;
        private Button edit;
        private Button delete;

        public ViewHolder(View convertView, MainPresenter mainPresenter) {
            this.namaMenu = convertView.findViewById(R.id.namaMenu);
            this.edit = convertView.findViewById(R.id.editDetail);
            this.delete = convertView.findViewById(R.id.deleteMakanan);
            this.presenter = mainPresenter;
            this.delete.setOnClickListener(this);
            this.edit.setOnClickListener(this);
        }


        public void updateView(Menu food, int position){
            this.position = position;
            this.namaMenu.setOnClickListener(this);
            this.namaMenu.setText((food.getNama_menu()));
            this.menu = food;
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == namaMenu.getId()){
                Log.d("size", "onClick: " + getItem(position));
                this.presenter.detailsMenu(this.menu, this.position);
                this.presenter.changePage(4);
            }
            else if(v.getId() == delete.getId()){
                try {
                    presenter.deleteList(position);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if (v.getId() == edit.getId()){
                this.presenter.detailsMenu(this.menu, position);
                this.presenter.changePage(5);
            }
        }
    }


}
