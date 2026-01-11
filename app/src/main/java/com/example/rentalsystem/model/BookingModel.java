package com.example.rentalsystem.model;

public class BookingModel {
    private String namaUser, bookingId, status, namaMobil, platWarna, tanggal, durasi, harga;
    private int gambar;

    public BookingModel(String namaUser, String bookingId, String status, String namaMobil,
                        String platWarna, String tanggal, String durasi, String harga, int gambar) {
        this.namaUser = namaUser;
        this.bookingId = bookingId;
        this.status = status;
        this.namaMobil = namaMobil;
        this.platWarna = platWarna;
        this.tanggal = tanggal;
        this.durasi = durasi;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String getNamaUser() { return namaUser; }
    public String getBookingId() { return bookingId; }
    public String getStatus() { return status; }
    public String getNamaMobil() { return namaMobil; }
    public String getPlatWarna() { return platWarna; }
    public String getTanggal() { return tanggal; }
    public String getDurasi() { return durasi; }
    public String getHarga() { return harga; }
    public int getGambar() { return gambar; }
}