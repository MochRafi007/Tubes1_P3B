package com.example.m0317073;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment {
    private FragmentListener listener;
    private EditText etText;
    private Button btnClickMe;

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
    public MainFragment(){

    }
    public static MainFragment newInstance(String title){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_fragment, container, false);
        this.btnClickMe = view.findViewById(R.id.btn_clickme);
        this.etText = view.findViewById(R.id.et_text);

        this.btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultDialogFragment rdf=new ResultDialogFragment();
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                rdf.show(ft,"The result is : "+"\n"+etText.getText().toString());

//                String input = etText.getText().toString();
//                if(!input.isEmpty()){
//                    listener.changeMessage(input);
//                    View view1 = getActivity().getCurrentFocus();
//                    if (view1 != null) {
//                        InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                        im.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                    }
//                    etText.setText(null);
//                }
//
//                listener.changePage(1);
            }
        });
        return view;
    }
}
