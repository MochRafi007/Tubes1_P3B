package com.example.m0317073.Adapder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.m0317073.R;

import java.util.List;

public class MenuItemAdapter extends ArrayAdapter<Menu> {

    public MenuItemAdapter(Context context, List<Menu> dataMenu) {
        super(context, R.layout.fragment_second, dataMenu);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // mengambil data student dari list
        Menu menu = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =  inflater.inflate(R.layout.fragment_make_menu,null);

//        TextView nama_menu = view.findViewById(R.id.fullname_tv);
//        nama.setText(menu.getNamaDepan()+""+menu.getNamaBelakang());
//
//        TextView pendidikan = view.findViewById(R.id.jenjang_tv);
//        pendidikan.setText(student.getPendidikan());
//
//        TextView gender = view.findViewById(R.id.gender_tv);
//        gender.setText(student.getGender());
//
//        TextView noHp = view.findViewById(R.id.noHp_tv);
//        noHp.setText(student.getNoHp());



        return view;
    }
}
