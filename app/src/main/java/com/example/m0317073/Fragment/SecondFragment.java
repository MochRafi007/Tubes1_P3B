package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.Model.Makanan;
import com.example.m0317073.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondFragment extends Fragment {
    private FragmentListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + "must implement FragmentListener");
        }
    }

    public SecondFragment(){

    }

    ExpandableListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        listView = (ExpandableListView) view.findViewById(R.id.expand_list);

        final List<String> listGroup = new ArrayList<>();
        listGroup.add("Menu 1");
        listGroup.add("Menu 2");
        listGroup.add("Menu 3");

        List<Makanan> listItem1 = new ArrayList<>();
        List<Makanan> listItem2 = new ArrayList<>();
        List<Makanan> listItem3 = new ArrayList<>();
        listItem1.add(new Makanan("Menu 1", "Ikan", "Telur dan Susu", "Panjang", "Bandung"));
        listItem2.add(new Makanan("Menu 2", "Ikan", "Telur dan Susu", "Panjang", "Bandung"));
        listItem3.add(new Makanan("Menu 3", "Ikan", "Telur dan Susu", "Panjang", "Bandung"));

        final HashMap<String, List<Makanan>> lstItemsGroup = new HashMap<>();
        lstItemsGroup.put(listGroup.get(0), listItem1);
        lstItemsGroup.put(listGroup.get(1), listItem2);
        lstItemsGroup.put(listGroup.get(2), listItem1);

        final ListMakanan listMakanan = new ListMakanan(getActivity(),listGroup,lstItemsGroup);
        listView.setAdapter(listMakanan);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.changePage(3);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Menu");
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
