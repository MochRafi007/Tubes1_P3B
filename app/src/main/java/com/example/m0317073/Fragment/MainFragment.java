package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.R;

import java.util.Random;

public class MainFragment extends Fragment {
    public FragmentListener listener;
    private MainPresenter mainPresenter;
    private TextView textView;
    private Button btnClickMe;
    public SecondFragment secondFragment;
    private ListMakanan listMakanan;
    private TextView random;


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
        this.listMakanan = new ListMakanan(getActivity(),mainPresenter);
        this.btnClickMe = view.findViewById(R.id.btn_cari);
        this.textView = view.findViewById(R.id.tv_makan_apa);
        this.secondFragment = new SecondFragment(mainPresenter);
        this.random = view.findViewById(R.id.random);
       // this.textView = view.findViewById(R.id.tvResult);


        this.btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    String menu = mainPresenter.randomMenu();

                    //basic duplicate prevention
                    int i = 0;
                    while(i<3){
                        if(random.getText().equals(menu)){
                            menu = mainPresenter.randomMenu();
                            i++;
                        }else{
                            break;
                        }
                    }

                    random.setText(menu);

                ResultDialogFragment rdf=new ResultDialogFragment(mainPresenter);
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                rdf.show(ft,"Hari ini kita makan : "+"\n"+random.getText().toString());

            }
        });
        return view;
    }


}
