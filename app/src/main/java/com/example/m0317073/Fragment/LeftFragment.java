package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.m0317073.R;

public class LeftFragment extends Fragment implements View.OnClickListener {
    private Button home;
    private Button page2;
    private Button exit;
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
    public static LeftFragment newInstance(String title){
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    public LeftFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_left, container, false);
        this.home = view.findViewById(R.id.btn_home);
        this.page2 = view.findViewById(R.id.btn_page2);
        this.exit = view.findViewById(R.id.btn_exit);

        this.home.setOnClickListener(this);
        this.page2.setOnClickListener(this);
        this.exit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==this.home.getId()){
            listener.changePage(1);
            getActivity().setTitle("Makan Apa");
        }
        else if(v.getId()==this.page2.getId()){
            listener.changePage(2);
            getActivity().setTitle("Page 2");
        }
        else if(v.getId()==this.exit.getId()){
            listener.closeApplication();
        }
    }
}
