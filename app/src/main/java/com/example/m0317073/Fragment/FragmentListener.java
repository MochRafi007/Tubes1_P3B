package com.example.m0317073.Fragment;

public interface FragmentListener {
    void changePage(int page);
    void closeApplication();
    void changeMessage(String tag, String bahan, String langkah, String resto);
}
