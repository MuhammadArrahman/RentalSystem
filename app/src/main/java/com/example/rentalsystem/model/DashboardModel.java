package com.example.rentalsystem.model;

public class DashboardModel {
    private String nama, transmisi, fitur, harga;
    private int gambarRes;

    public DashboardModel(String nama, String transmisi, String fitur, String harga, int gambarRes) {
        this.nama = nama;
        this.transmisi = transmisi;
        this.fitur = fitur;
        this.harga = harga;
        this.gambarRes = gambarRes;
    }

    public String getNama() { return nama; }
    public String getTransmisi() { return transmisi; }
    public String getFitur() { return fitur; }
    public String getHarga() { return harga; }
    public int getGambarRes() { return gambarRes; }
}