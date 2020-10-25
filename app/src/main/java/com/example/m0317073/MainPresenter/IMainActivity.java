package com.example.m0317073.MainPresenter;

import com.example.m0317073.Model.Menu;

import java.io.IOException;
import java.util.List;

public interface IMainActivity {
    void updateList(List<Menu> foodList);
    void saveFile(String menu) throws IOException;
    String readFile();
}
