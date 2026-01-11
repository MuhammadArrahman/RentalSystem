package com.example.rentalsystem.model;

public class RiwayatBookingModel {
    private String kategori;
    private String nama;
    private String tanggal;
    private String harga;
    private String status;
    private String statusBayar;
    private int gambarRes;

    public RiwayatBookingModel(String kategori, String nama, String tanggal, String harga, String status, String statusBayar, int gambarRes) {
        this.kategori = kategori;
        this.nama = nama;
        this.tanggal = tanggal;
        this.harga = harga;
        this.status = status;
        this.statusBayar = statusBayar;
        this.gambarRes = gambarRes;
    }

    // Getter (Sangat penting agar tidak error 'Cannot resolve method')
    public String getKategori() { return kategori; }
    public String getNama() { return nama; }
    public String getTanggal() { return tanggal; }
    public String getHarga() { return harga; }
    public String getStatus() { return status; }
    public String getStatusBayar() { return statusBayar; }
    public int getGambarRes() { return gambarRes; }
}