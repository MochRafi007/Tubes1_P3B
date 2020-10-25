package com.example.m0317073.MainPresenter;


import com.example.m0317073.Fragment.FragmentListener;
import com.example.m0317073.Model.Menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainPresenter {
    protected List<Menu> foodList;
    protected IMainActivity ui;
    protected FragmentListener listener;

    public MainPresenter(IMainActivity active, FragmentListener fragmentListener){
        this.ui = active;
        this.foodList = new LinkedList<Menu>();
        this.listener = fragmentListener;
    }

    public void deleteList(int position) throws JSONException{
        this.foodList.remove(position);
        this.ui.updateList(this.foodList);
    }

    public void addList(String namaMakan, String tag, String bahan, String langkahMasak, String lokasi) throws JSONException, IOException {
        Menu food = new Menu(namaMakan, tag, bahan, langkahMasak, lokasi);
        this.foodList.add(food);
        this.ui.updateList(this.foodList);
        this.updateStorageJSON();
    }

    public void updateStorageJSON() throws JSONException, IOException {
        JSONArray jsonArray = new JSONArray();
        for(Menu menu : this.foodList){
            JSONObject detailMenu = new JSONObject();
            detailMenu.put("namaMenu", menu.getNama_menu());
            detailMenu.put("tag", menu.getTag());
            detailMenu.put("bahan", menu.getBahan());
            detailMenu.put("langkah", menu.getLangkah_masak());
            detailMenu.put("resto", menu.getTersedia());
            JSONObject itemMenu = new JSONObject();
            itemMenu.put("menu", detailMenu);
            jsonArray.put(itemMenu);
        }
        this.ui.saveFile(jsonArray.toString());
    }

    public String randomMenu(){
        Random random = new Random();
        int urutan = random.nextInt(this.foodList.size());
        return this.foodList.get(urutan).getNama_menu();
    }

    public void detailsMenu(Menu menu, int position){
        this.listener.getDetailsMenu(menu, position);
    }

    public void changePage(int position){
        this.listener.changePage(position);
    }

    public void editMenu(Menu menu, int position) throws JSONException, IOException {
        this.deleteList(position);
        this.foodList.add(position, menu);
        this.updateStorageJSON();
        this.ui.updateList(this.foodList);
    }
}
