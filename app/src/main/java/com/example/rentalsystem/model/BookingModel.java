package com.example.rentalsystem.model;

public class BookingModel {
    private String kategori, nama, harga, kursi, transmisi, bbm;
    private int gambarRes;

    public BookingModel(String kategori, String nama, String harga, String kursi, String transmisi, String bbm, int gambarRes) {
        this.kategori = kategori;
        this.nama = nama;
        this.harga = harga;
        this.kursi = kursi;
        this.transmisi = transmisi;
        this.bbm = bbm;
        this.gambarRes = gambarRes;
    }

    // Getter untuk Adapter
    public String getKategori() { return kategori; }
    public String getNama() { return nama; }
    public String getHarga() { return harga; }
    public String getKursi() { return kursi; }
    public String getTransmisi() { return transmisi; }
    public String getBbm() { return bbm; }
    public int getGambarRes() { return gambarRes; }
}