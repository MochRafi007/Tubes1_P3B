package com.example.m0317073;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.Fragment.DetailMenuFragment;
import com.example.m0317073.Fragment.EditMenuFragment;
import com.example.m0317073.Fragment.FragmentListener;
import com.example.m0317073.Fragment.MainFragment;
import com.example.m0317073.Fragment.MakeMenuFragment;
import com.example.m0317073.Fragment.SecondFragment;
import com.example.m0317073.MainPresenter.IMainActivity;
import com.example.m0317073.MainPresenter.MainPresenter;
import com.example.m0317073.Model.Menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity implements FragmentListener,  IMainActivity {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private MainFragment mainFragment;
    private SecondFragment secondFragment;
    private MakeMenuFragment makeMenuFragment;
    private DetailMenuFragment detailMenuFragment;
    private EditMenuFragment editMenuFragment;
    private MainPresenter mainPresenter;
    static final String FILE_NAME = "menu.txt";
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainPresenter = new MainPresenter(this, this);
        this.mainFragment = new MainFragment(mainPresenter);
        this.secondFragment = new SecondFragment(mainPresenter);
        this.makeMenuFragment= new MakeMenuFragment(mainPresenter, this);
        this.detailMenuFragment = new DetailMenuFragment(mainPresenter);
        this.editMenuFragment = new EditMenuFragment(mainPresenter);

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

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment instanceof EditMenuFragment){
            this.changePage(2);
            this.reset();
        }
        else if (fragment instanceof DetailMenuFragment){
            this.changePage(2);
            this.resetDetails();
        }
        else {
            super.onBackPressed();
        }
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
            if(this.makeMenuFragment.isAdded()){
                ft.hide(this.makeMenuFragment);
            }
            if (this.detailMenuFragment.isAdded()){
                ft.hide(this.detailMenuFragment);
            }
            if (this.editMenuFragment.isAdded()){
                ft.hide(this.editMenuFragment);
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
            if (this.makeMenuFragment.isAdded()){
                ft.hide(this.makeMenuFragment);
            }
            if (this.detailMenuFragment.isAdded()){
                ft.hide(this.detailMenuFragment);
            }
            if (this.editMenuFragment.isAdded()){
                ft.hide(this.editMenuFragment);
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
            if (this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
            if (this.detailMenuFragment.isAdded()){
                ft.hide(this.detailMenuFragment);
            }
            if (this.editMenuFragment.isAdded()){
                ft.hide(this.editMenuFragment);
            }
        }
        else if (page==4){
            if (this.detailMenuFragment.isAdded()){
                this.resetDetails();
                ft.show(this.detailMenuFragment);
            }else {
                ft.add(R.id.fragment_container, this.detailMenuFragment)
                        .addToBackStack(null);
            }
            if (this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
            if (this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
            if (this.makeMenuFragment.isAdded()){
                ft.hide(this.makeMenuFragment);
            }
            if (this.editMenuFragment.isAdded()){
                ft.hide(this.editMenuFragment);
            }
        }
        else if (page==5){
            if (this.editMenuFragment.isAdded()){
                this.reset();
                ft.show(this.editMenuFragment);
            }else {
                ft.add(R.id.fragment_container, this.editMenuFragment)
                        .addToBackStack(null);
            }
            if (this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
            if (this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
            if (this.makeMenuFragment.isAdded()){
                ft.hide(this.makeMenuFragment);
            }
            if (this.detailMenuFragment.isAdded()){
                ft.hide(this.detailMenuFragment);
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
    public void getDetailsMenu(Menu menu, int position) {
        this.detailMenuFragment.setMenu(menu, position);
        this.editMenuFragment.setMenu(menu, position);
    }

    @Override
    public void reset() {
        this.editMenuFragment.reset();
    }

    public void resetDetails(){
        this.detailMenuFragment.reset();
    }

    @Override
    public void updateList(List<Menu> foodList) {
        this.secondFragment.updateList(foodList);
    }


    @Override
    public void saveFile(String menu) {
        File fileMenu = new File(this.getFilesDir(), FILE_NAME);
        try (FileOutputStream fileOutput = openFileOutput(FILE_NAME, MODE_PRIVATE)) {
            if (!fileMenu.exists()){
                fileMenu.createNewFile();
            }
            fileOutput.write(menu.getBytes());
            fileOutput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readFile() {
        File fileMenu = new File(this.getFilesDir(), FILE_NAME);
        try(FileInputStream fileInputStream = new FileInputStream(fileMenu)) {
            int menu;
            String message = "";
            while ((menu = fileInputStream.read())!= -1){
                message=message+(char)menu;
            }
            return message;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}