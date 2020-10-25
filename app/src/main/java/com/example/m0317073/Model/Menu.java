package com.example.m0317073.Model;

import java.io.Serializable;

public class Menu implements Serializable {
    private long id;
    private String nama_menu;
    private String tag;
    private String bahan;
    private String langkah_masak;
    private String tersedia;

    public Menu(String namaMakan, String tag, String bahan, String langkahMasak, String lokasi) {
        this.nama_menu = namaMakan;
        this.tag = tag;
        this.bahan = bahan;
        this.langkah_masak = langkahMasak;
        this.tersedia = lokasi;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public void setLangkah_masak(String langkah_masak) {
        this.langkah_masak = langkah_masak;
    }

    public void setTersedia(String tersedia) {
        this.tersedia = tersedia;
    }

    public long getId() {
        return id;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public String getTag() {
        return tag;
    }

    public String getBahan() {
        return bahan;
    }

    public String getLangkah_masak() {
        return langkah_masak;
    }

    public String getTersedia() {
        return tersedia;
    }
}
