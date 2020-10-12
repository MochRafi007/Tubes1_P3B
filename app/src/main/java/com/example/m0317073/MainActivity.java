package com.example.m0317073;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private SecondFragment secondFragment;
    private MainFragment mainFragment;
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainFragment = new MainFragment();
        this.secondFragment = new SecondFragment();
        this.fragmentManager = this.getSupportFragmentManager();

        //Toolbar
        this.drawer = findViewById(R.id.drawer_layout);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawer.addDrawerListener(abdt);
        abdt.syncState();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.mainFragment)
                .addToBackStack(null)
                .commit();
    }


    public void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page==1){
            if(this.mainFragment.isAdded()){
                ft.show(this.mainFragment);
                this.drawer.closeDrawers();
            }else{
                ft.add(R.id.fragment_container, this.mainFragment);
            }
            if(this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
        }else if(page==2){
            if(this.secondFragment.isAdded()){
                ft.show(this.secondFragment);
                this.drawer.closeDrawers();
            }else{
                ft.add(R.id.fragment_container, this.secondFragment)
                        .addToBackStack(null);
            }
            if(this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}