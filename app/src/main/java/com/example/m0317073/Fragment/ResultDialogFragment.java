package com.example.m0317073.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.R;

public class ResultDialogFragment extends DialogFragment {
    private TextView textView;
    private MainPresenter mainPresenter;
    public ResultDialogFragment(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_result_dialog, container, false);
        this.textView = view.findViewById(R.id.tvResult);
       // String menu = mainPresenter.randomMenu();
     //   this.textView.setText(menu);
        this.textView.setText(getTag());
        return view;
    }
}
