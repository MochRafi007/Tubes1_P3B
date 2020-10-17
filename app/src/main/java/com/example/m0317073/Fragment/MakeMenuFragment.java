package com.example.m0317073.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.m0317073.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MakeMenuFragment extends Fragment {
    Button plus;


    public MakeMenuFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_make_menu, container, false);

        return view;
    }

}
