package com.example.m0317073.MainPresenter;

import com.example.m0317073.Model.Menu;

import java.util.List;

public interface IMainActivity {
    void updateList(List<Menu> foodList);
    void resetAddForm();
}
