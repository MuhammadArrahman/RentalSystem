package com.example.rentalsystem.model;

public class NotifikasiModel { // Sesuaikan nama class menjadi Notifikasi
    private String judul, isi, waktu, jenis;
    private int iconRes;

    public NotifikasiModel(String judul, String isi, String waktu, String jenis, int iconRes) {
        this.judul = judul;
        this.isi = isi;
        this.waktu = waktu;
        this.jenis = jenis;
        this.iconRes = iconRes;
    }

    public String getJudul() { return judul; }
    public String getIsi() { return isi; }
    public String getWaktu() { return waktu; }
    public String getJenis() { return jenis; }
    public int getIconRes() { return iconRes; }
}