package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.R;

public class MainFragment extends Fragment {
    public FragmentListener listener;
    private MainPresenter mainPresenter;
    private TextView textView;
    private Button btnClickMe;
    public SecondFragment secondFragment;

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
    public MainFragment(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment, container, false);
        this.btnClickMe = view.findViewById(R.id.btn_cari);
        this.textView = view.findViewById(R.id.tv_makan_apa);
        this.secondFragment = new SecondFragment(mainPresenter);
        this.btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultDialogFragment rdf=new ResultDialogFragment();
                FragmentTransaction ft=getFragmentManager().beginTransaction();

                if(v==btnClickMe)
                {
                    listener.changePage(2);
                }
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Makan Apa");
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
