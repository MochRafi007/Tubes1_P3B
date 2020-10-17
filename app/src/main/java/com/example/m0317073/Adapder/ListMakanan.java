package com.example.m0317073.Adapder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.m0317073.Model.Makanan;
import com.example.m0317073.R;

import java.util.HashMap;
import java.util.List;

public class ListMakanan extends BaseExpandableListAdapter {
    private List<String> listGroup;
    private HashMap<String, List<Makanan>> listItem;
    private Context context;

    public ListMakanan(Context context, List<String> Group, HashMap<String, List<Makanan>> Item){
        listGroup = Group;
        this.context = context;
        listItem = Item;
    }


    @Override
    public int getGroupCount() {
        return  listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listItem.get(getGroup(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItem.get(getGroup(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_group, null);
        }
        TextView namaMakanan = (TextView) convertView.findViewById(R.id.namaMenu);
        namaMakanan.setText((String) getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item,null);
        }
        TextView tag = (TextView) convertView.findViewById(R.id.tag_hasil);
        TextView bahan = (TextView) convertView.findViewById(R.id.bahan_hasil);
        TextView langkah = (TextView) convertView.findViewById(R.id.langkah_hasil);
        TextView resto = (TextView) convertView.findViewById(R.id.resto_hasil);

        Makanan makanan = (Makanan) getChild(groupPosition,childPosition);
        tag.setText(makanan.getTag());
        bahan.setText(makanan.getBahan());
        langkah.setText(makanan.getLangkahMemasak());
        resto.setText(makanan.getResto());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
