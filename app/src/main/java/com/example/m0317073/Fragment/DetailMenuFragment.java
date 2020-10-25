package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;
import com.example.m0317073.R;

public class DetailMenuFragment extends Fragment {
    private TextView namaMenu;
    private TextView tag;
    private TextView bahan;
    private TextView langkah;
    private TextView resto;
    private Menu menu;
    private int position;
    MainPresenter mainPresenter;
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
    public DetailMenuFragment(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
    }
    public void setMenu(Menu menu, int position){
        this.menu = menu;
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detil_makan, container, false);
        this.namaMenu = view.findViewById(R.id.detil_namaMenu);
        this.tag = view.findViewById(R.id.tags);
        this.bahan = view.findViewById(R.id.bahans);
        this.langkah = view.findViewById(R.id.langkahs);
        this.resto = view.findViewById(R.id.restos);

        this.namaMenu.setText(this.menu.getNama_menu());
        this.tag.setText(this.menu.getTag());
        this.bahan.setText(this.menu.getBahan());
        this.langkah.setText(this.menu.getLangkah_masak());
        this.resto.setText(this.menu.getTersedia());
        return view;
    }

    public void reset(){
        this.namaMenu.setText(this.menu.getNama_menu());
        this.tag.setText(this.menu.getTag());
        this.bahan.setText(this.menu.getBahan());
        this.langkah.setText(this.menu.getLangkah_masak());
        this.resto.setText(this.menu.getTersedia());
    }
}
