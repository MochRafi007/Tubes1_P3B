package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.R;

public class DetailMenuFragment extends Fragment {
    private TextView namaMenu;
    private TextView tag;
    private TextView bahan;
    private TextView langkah;
    private TextView resto;
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
    public DetailMenuFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detil_makan, container, false);
        this.namaMenu = view.findViewById(R.id.namaMenu);
        this.tag = view.findViewById(R.id.tags);
        this.bahan = view.findViewById(R.id.bahans);
        this.langkah = view.findViewById(R.id.langkahs);
        this.resto = view.findViewById(R.id.restos);
        return view;
    }

    public void setMessage(String tag, String bahan, String langkah, String resto){
        this.tag.setText(tag);
        this.bahan.setText(bahan);
        this.langkah.setText(langkah);
        this.resto.setText(resto);
    }
}
