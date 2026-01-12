package com.example.rentalsystem.model;

public class MobilModel {

    private String merk;
    private String tipe;
    private String plat;
    private String harga;
    private String transmisi;
    private String bbm;
    private String status;
    private String deskripsi;
    private String infoLainnya;
    private String terakhirServis;

    public MobilModel() {} // Wajib Firebase

    public MobilModel(String merk, String tipe, String plat, String harga, String transmisi,
                      String bbm, String status, String deskripsi, String infoLainnya,
                      String terakhirServis) {
        this.merk = merk;
        this.tipe = tipe;
        this.plat = plat;
        this.harga = harga;
        this.transmisi = transmisi;
        this.bbm = bbm;
        this.status = status;
        this.deskripsi = deskripsi;
        this.infoLainnya = infoLainnya;
        this.terakhirServis = terakhirServis;
    }

    // GETTER
    public String getMerk() { return merk; }
    public String getTipe() { return tipe; }
    public String getPlat() { return plat; }
    public String getHarga() { return harga; }
    public String getTransmisi() { return transmisi; }
    public String getBbm() { return bbm; }
    public String getStatus() { return status; }
    public String getDeskripsi() { return deskripsi; }
    public String getInfoLainnya() { return infoLainnya; }
    public String getTerakhirServis() { return terakhirServis; }
}
