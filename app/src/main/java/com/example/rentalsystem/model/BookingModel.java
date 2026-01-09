package com.example.rentalsystem.model;

public class BookingModel {
    private String namaUser, bookingId, status, namaMobil, platWarna, tanggal, durasi, harga;

    public BookingModel(String namaUser, String bookingId, String status, String namaMobil, String platWarna, String tanggal, String durasi, String harga) {
        this.namaUser = namaUser;
        this.bookingId = bookingId;
        this.status = status;
        this.namaMobil = namaMobil;
        this.platWarna = platWarna;
        this.tanggal = tanggal;
        this.durasi = durasi;
        this.harga = harga;
    }

    // Getters yang diperlukan oleh Adapter
    public String getNamaUser() { return namaUser; }
    public String getStatus() { return status; }
    public String getNamaMobil() { return namaMobil; }
    public String getBookingId() { return bookingId; } // Tambahkan ini
    public String getPlatWarna() { return platWarna; } // Tambahkan ini
    public String getTanggal() { return tanggal; }     // Tambahkan ini
    public String getDurasi() { return durasi; }       // Tambahkan ini
    public String getHarga() { return harga; }         // Tambahkan ini
}