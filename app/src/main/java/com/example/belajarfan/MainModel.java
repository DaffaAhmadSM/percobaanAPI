package com.example.belajarfan;

public class MainModel {
    String provinsi;
    int kasus_posi, kasus_semb, kasus_meni;

    public MainModel(String provinsi, int kasus_posi, int kasus_semb, int kasus_meni) {
        this.provinsi = provinsi;
        this.kasus_posi = kasus_posi;
        this.kasus_semb = kasus_semb;
        this.kasus_meni = kasus_meni;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public int getKasus_posi() {
        return kasus_posi;
    }

    public void setKasus_posi(int kasus_posi) {
        this.kasus_posi = kasus_posi;
    }

    public int getKasus_semb() {
        return kasus_semb;
    }

    public void setKasus_semb(int kasus_semb) {
        this.kasus_semb = kasus_semb;
    }

    public int getKasus_meni() {
        return kasus_meni;
    }

    public void setKasus_meni(int kasus_meni) {
        this.kasus_meni = kasus_meni;
    }
}
