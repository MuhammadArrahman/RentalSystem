package com.example.rentalsystem.model;

public class BookingModel {
    private String namaPelanggan, noBooking, status, mobil, platWarna, tanggal, durasi, harga;

    public BookingModel(String namaPelanggan, String noBooking, String status, String mobil,
                        String platWarna, String tanggal, String durasi, String harga) {
        this.namaPelanggan = namaPelanggan;
        this.noBooking = noBooking;
        this.status = status;
        this.mobil = mobil;
        this.platWarna = platWarna;
        this.tanggal = tanggal;
        this.durasi = durasi;
        this.harga = harga;
    }

    // Getter
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getNoBooking() { return noBooking; }
    public String getStatus() { return status; }
    public String getMobil() { return mobil; }
    public String getPlatWarna() { return platWarna; }
    public String getTanggal() { return tanggal; }
    public String getDurasi() { return durasi; }
    public String getHarga() { return harga; }
}