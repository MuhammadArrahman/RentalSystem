package com.example.rentalsystem.model;

public class MobilModel {
    private String merk, tipe, plat, harga, status;
    private int iconMobil;

    public MobilModel(String merk, String tipe, String plat, String harga, String status, int iconMobil) {
        this.merk = merk;
        this.tipe = tipe;
        this.plat = plat;
        this.harga = harga;
        this.status = status;
        this.iconMobil = iconMobil;
    }

    // Getter wajib ada agar Adapter bisa membaca data
    public String getMerk() { return merk; }
    public String getTipe() { return tipe; }
    public String getPlat() { return plat; }
    public String getHarga() { return harga; }
    public String getStatus() { return status; }
    public int getIconMobil() { return iconMobil; }
}