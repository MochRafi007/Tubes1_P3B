package com.example.m0317073.Model;

public class Makanan {
    private String namaMenu;
    private String tag;
    private String bahan;
    private String langkahMemasak;
    private String resto;

    public Makanan (String namaMenu, String tag, String bahan, String langkahMemasak, String resto){
        this.namaMenu = namaMenu;
        this.tag = tag;
        this.bahan = bahan;
        this.langkahMemasak = langkahMemasak;
        this.resto = resto;
    }

    public String getBahan() {
        return bahan;
    }

    public String getLangkahMemasak() {
        return langkahMemasak;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getResto() {
        return resto;
    }

    public String getTag() {
        return tag;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public void setLangkahMemasak(String langkahMemasak) {
        this.langkahMemasak = langkahMemasak;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public void setResto(String resto) {
        this.resto = resto;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
