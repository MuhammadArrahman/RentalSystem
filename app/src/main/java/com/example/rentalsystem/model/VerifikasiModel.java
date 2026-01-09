package com.example.rentalsystem.model;

public class VerifikasiModel {
    private String nama;
    private String nik;
    private String waktu;
    private String tglLahir;
    private String statusKawin;
    private int fotoKtp; // resource id gambar

    public VerifikasiModel(String nama, String nik, String waktu, String tglLahir, String statusKawin, int fotoKtp) {
        this.nama = nama;
        this.nik = nik;
        this.waktu = waktu;
        this.tglLahir = tglLahir;
        this.statusKawin = statusKawin;
        this.fotoKtp = fotoKtp;
    }

    // Getters
    public String getNama() { return nama; }
    public String getNik() { return nik; }
    public String getWaktu() { return waktu; }
    public String getTglLahir() { return tglLahir; }
    public String getStatusKawin() { return statusKawin; }
    public int getFotoKtp() { return fotoKtp; }
}