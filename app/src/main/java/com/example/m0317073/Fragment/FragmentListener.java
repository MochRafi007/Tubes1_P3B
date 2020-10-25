package com.example.m0317073.Fragment;

import com.example.m0317073.Model.Menu;

public interface FragmentListener {
    void changePage(int page);
    void closeApplication();
    void getDetailsMenu(Menu menu, int position);
}
