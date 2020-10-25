package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;
import com.example.m0317073.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;

import java.io.IOException;

public class EditMenuFragment extends Fragment implements View.OnClickListener {
    TextView judul;
    EditText namaMenu;
    EditText tag;
    EditText bahan;
    EditText langkah;
    EditText resto;
    FloatingActionButton editButton;
    MainPresenter mainPresenter;
    FragmentListener fragmentListener;
    Menu menu;
    int position;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + "must implement FragmentListener");
        }
    }

    public EditMenuFragment(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
    }

    public void setMenu(Menu menu, int position) {
        this.menu = menu;
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_menu, container,false);
        this.judul = view.findViewById(R.id.namaMenu);
        this.namaMenu = view.findViewById(R.id.make_namaMenu_edit);
        this.tag = view.findViewById(R.id.make_tag_edit);
        this.bahan = view.findViewById(R.id.make_bahan_edit);
        this.langkah = view.findViewById(R.id.make_step_edit);
        this.resto = view.findViewById(R.id.make_resto_edit);
        this.editButton = view.findViewById(R.id.fab_edit_btn);

        this.judul.setText(this.menu.getNama_menu());
        this.namaMenu.setText(this.menu.getNama_menu());
        this.tag.setText(this.menu.getTag());
        this.bahan.setText(this.menu.getBahan());
        this.langkah.setText(this.menu.getLangkah_masak());
        this.resto.setText(this.menu.getTersedia());
        this.editButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == editButton.getId()){
            this.menu.setNama_menu(this.namaMenu.getText().toString());
            this.menu.setTag(this.tag.getText().toString());
            this.menu.setBahan(this.bahan.getText().toString());
            this.menu.setLangkah_masak(this.langkah.getText().toString());
            this.menu.setTersedia(this.resto.getText().toString());
            try {
                this.mainPresenter.editMenu(this.menu, this.position);
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getContext(),"Sukses terupdate", Toast.LENGTH_LONG).show();
            this.fragmentListener.changePage(2);
        }
    }

    public void reset(){
        this.judul.setText(this.menu.getNama_menu());
        this.namaMenu.setText(this.menu.getNama_menu());
        this.tag.setText(this.menu.getTag());
        this.bahan.setText(this.menu.getBahan());
        this.langkah.setText(this.menu.getLangkah_masak());
        this.resto.setText(this.menu.getTersedia());
    }
}
