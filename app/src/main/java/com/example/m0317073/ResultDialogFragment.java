package com.example.m0317073;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class ResultDialogFragment extends DialogFragment {
    private TextView textView;

    public ResultDialogFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_result_dialog, container, false);
        this.textView = view.findViewById(R.id.tvResult);
        this.textView.setText(getTag());
        return view;
    }
}
