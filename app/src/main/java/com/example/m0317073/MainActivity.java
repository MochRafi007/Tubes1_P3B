package com.example.m0317073;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.Fragment.DetailMenuFragment;
import com.example.m0317073.Fragment.FragmentListener;
import com.example.m0317073.Fragment.MainFragment;
import com.example.m0317073.Fragment.MakeMenuFragment;
import com.example.m0317073.Fragment.SecondFragment;
import com.example.m0317073.MainPresenter.IMainActivity;
import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;

import java.util.List;


public class MainActivity extends AppCompatActivity implements FragmentListener,  IMainActivity {
    private Toolbar toolbar;
    private ListView listView;
    private ListMakanan listMakanan;
    private DrawerLayout drawer;
    private SecondFragment secondFragment;
    private DetailMenuFragment detailMenuFragment;
    private MainPresenter mainPresenter;
    private MainFragment mainFragment;
    public FragmentManager fragmentManager;
    private MakeMenuFragment makeMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listView = this.findViewById(R.id.list);
        this.mainPresenter = new MainPresenter(this);
        this.mainFragment = new MainFragment(mainPresenter);
        this.secondFragment = new SecondFragment(mainPresenter);
        this.makeMenuFragment= new MakeMenuFragment(mainPresenter);
        this.fragmentManager = this.getSupportFragmentManager();
        this.detailMenuFragment = new DetailMenuFragment();

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

            }else{
                ft.add(R.id.fragment_container, this.mainFragment);
            }
            if(this.secondFragment.isAdded()){
                this.drawer.closeDrawers();
                ft.hide(this.secondFragment);
            }
        }else if(page==2){
            if(this.secondFragment.isAdded()){
                this.drawer.closeDrawers();
                ft.show(this.secondFragment);
            }else{
                ft.add(R.id.fragment_container, this.secondFragment)
                        .addToBackStack(null);
            }
            if(this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
        }
        else if(page==3){
            if(this.makeMenuFragment.isAdded()){
                ft.show(this.makeMenuFragment);
            }else{
                ft.add(R.id.fragment_container, this.makeMenuFragment)
                        .addToBackStack(null);
            }
            if(this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
        }


        ft.commit();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    public void changeMessage(String tag, String bahan, String langkah, String resto) {
        detailMenuFragment.setMessage(tag,bahan,langkah,resto);
    }

    @Override
    public void updateList(List<Menu> foodList) {
        this.listMakanan.update(foodList);
    }

    @Override
    public void resetAddForm() {

    }
}