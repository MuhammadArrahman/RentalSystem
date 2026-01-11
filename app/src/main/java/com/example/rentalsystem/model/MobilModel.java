package com.example.rentalsystem.model;

public class MobilModel {

    private String merk;
    private String tipe;
    private String plat;
    private String harga;
    private String status;
    private int iconMobil; // ✅ TAMBAH

    // WAJIB untuk Firebase
    public MobilModel() {
    }

    // ✅ CONSTRUCTOR LENGKAP (FIX)
    public MobilModel(String merk, String tipe, String plat,
                      String harga, String status, int iconMobil) {
        this.merk = merk;
        this.tipe = tipe;
        this.plat = plat;
        this.harga = harga;
        this.status = status;
        this.iconMobil = iconMobil;
    }

    public String getMerk() {
        return merk;
    }

    public String getTipe() {
        return tipe;
    }

    public String getPlat() {
        return plat;
    }

    public String getHarga() {
        return harga;
    }

    public String getStatus() {
        return status;
    }

    public int getIconMobil() {
        return iconMobil;
    }
}
