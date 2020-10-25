package com.example.m0317073.MainPresenter;


import com.example.m0317073.Model.Menu;

import java.util.LinkedList;
import java.util.List;

public class MainPresenter {
    protected List<Menu> foodList;
    protected IMainActivity ui;

    public MainPresenter(IMainActivity active){
        this.ui = active;
        this.foodList = new LinkedList<Menu>();
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


}
