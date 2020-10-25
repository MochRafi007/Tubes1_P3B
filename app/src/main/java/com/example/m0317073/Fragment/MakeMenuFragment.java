package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MakeMenuFragment extends Fragment implements View.OnClickListener {
    EditText namaMenu;
    EditText tag;
    EditText bahan;
    EditText langkah;
    EditText resto;
    FloatingActionButton fab;
    private FragmentListener listener;
    ListMakanan listMakanan;
    ListView listView;
    MainPresenter mainPresenter;

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


    public MakeMenuFragment(MainPresenter mainPresenter)
    {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_make_menu, container, false);
        this.namaMenu = view.findViewById(R.id.make_namaMenu);
        this.tag = view.findViewById(R.id.make_tag);
        this.bahan = view.findViewById(R.id.make_bahan);
        this.langkah = view.findViewById(R.id.make_step);
        this.resto = view.findViewById(R.id.make_resto);
        this.fab = view.findViewById(R.id.fab_edit);
        fab.setOnClickListener(this);
        listView = view.findViewById(R.id.list_view_menu);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == this.fab.getId()){
            if(!this.namaMenu.getText().toString().equals("") && !this.tag.getText().toString().equals("")
                && !this.bahan.getText().toString().equals("") && !this.langkah.getText().toString().equals("")
                    && !this.resto.getText().toString().equals("")){
                this.mainPresenter.addList(this.namaMenu.getText().toString(), this.tag.getText().toString(), this.bahan.getText().toString(), this.langkah.getText().toString(), this.resto.getText().toString());
                View view1 = getActivity().getCurrentFocus();
                if (view1 != null) {
                    InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                listener.changePage(2);
            }
            this.namaMenu.setText("");
            this.tag.setText("");
            this.bahan.setText("");
            this.langkah.setText("");
            this.resto.setText("");
        }
    }
}
