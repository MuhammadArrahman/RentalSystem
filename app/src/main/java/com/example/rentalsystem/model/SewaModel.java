package com.example.rentalsystem.model;

public class SewaModel {
    private String namaMobil;
    private String penyewa;
    private String durasi;
    private String jam;
    private String status;
    private int iconMobil;

    public SewaModel(String namaMobil, String penyewa, String durasi, String jam, String status, int iconMobil) {
        this.namaMobil = namaMobil;
        this.penyewa = penyewa;
        this.durasi = durasi;
        this.jam = jam;
        this.status = status;
        this.iconMobil = iconMobil;
    }

    // Getter (Harus ada agar Adapter bisa mengambil data)
    public String getNamaMobil() { return namaMobil; }
    public String getPenyewa() { return penyewa; }
    public String getDurasi() { return durasi; }
    public String getJam() { return jam; }
    public String getStatus() { return status; }
    public int getIconMobil() { return iconMobil; }
}