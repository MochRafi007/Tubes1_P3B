package com.example.m0317073.MainPresenter;


import com.example.m0317073.Adapder.ListMakanan;
import com.example.m0317073.Fragment.FragmentListener;
import com.example.m0317073.Model.Menu;

import java.util.LinkedList;
import java.util.List;

public class MainPresenter {
    protected List<Menu> foodList;
    protected IMainActivity ui;
    protected FragmentListener listener;

    public MainPresenter(IMainActivity active, FragmentListener fragmentListener){
        this.ui = active;
        this.foodList = new LinkedList<Menu>();
        this.listener = fragmentListener;
    }

//    public void loadData(){
////        this.foodList.addAll(Arrays.asList(MockFood.foodObjectArr));
////        this.ui.updateList(this.foodList);
////    }

    public void deleteList(int position){
        this.foodList.remove(position);
        this.ui.updateList(this.foodList);
    }

    public void addList(String namaMakan, String tag, String bahan, String langkahMasak, String lokasi){
        Menu food = new Menu(namaMakan, tag, bahan, langkahMasak, lokasi);
        this.foodList.add(food);
        this.ui.updateList(this.foodList);
        this.ui.resetAddForm();
    }

    public void detailsMenu(Menu menu, int position){
        this.listener.getDetailsMenu(menu, position);
    }

    public void changePage(int position){
        this.listener.changePage(position);
    }

}
