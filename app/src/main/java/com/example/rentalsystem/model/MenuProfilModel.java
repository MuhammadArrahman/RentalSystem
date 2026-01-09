package com.example.rentalsystem.model;

public class MenuProfilModel {
    private String judul, subJudul;
    private int ikon;
    private String warnaHex;

    public MenuProfilModel(String judul, String subJudul, int ikon, String warnaHex) {
        this.judul = judul;
        this.subJudul = subJudul;
        this.ikon = ikon;
        this.warnaHex = warnaHex;
    }

    public String getJudul() { return judul; }
    public String getSubJudul() { return subJudul; }
    public int getIkon() { return ikon; }
    public String getWarnaHex() { return warnaHex; }
}

