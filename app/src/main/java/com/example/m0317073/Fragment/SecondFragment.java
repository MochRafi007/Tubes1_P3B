package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;
import com.example.m0317073.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;

import java.util.List;


public class SecondFragment extends Fragment {
    private FragmentListener listener;
    private ListMakanan listMakanan;
    private MainPresenter mainPresenter;
    private ListView listView;

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

    public SecondFragment(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        this.listView = view.findViewById(R.id.list_view_menu);
        this.listMakanan = new ListMakanan(getActivity(),this.mainPresenter);
        this.listView.setAdapter(this.listMakanan);

        try {
            this.mainPresenter.loadData();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.changePage(3);
            }
        });
        return view;
    }

    public void updateList(List<Menu> foodList) {
        this.listMakanan.update(foodList);
    }

}
