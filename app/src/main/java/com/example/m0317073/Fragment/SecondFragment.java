package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.MainPresenter.IMainActivity;
import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;
import com.example.m0317073.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class SecondFragment extends Fragment implements IMainActivity {
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
        listView = view.findViewById(R.id.list);
        this.mainPresenter = new MainPresenter(this);
        this.listMakanan = new ListMakanan(getActivity(),this.mainPresenter);
        this.listView.setAdapter(this.listMakanan);
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

    @Override
    public void updateList(List<Menu> foodList) {
        this.listMakanan.update(foodList);
    }

    @Override
    public void resetAddForm() {

    }
}
