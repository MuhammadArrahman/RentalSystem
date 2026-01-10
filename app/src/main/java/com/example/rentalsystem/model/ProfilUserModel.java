package com.example.rentalsystem.model;
public class ProfilUserModel {
    private String title;
    private int iconRes;
    private String status;

    public ProfilUserModel(String title, int iconRes, String status) {
        this.title = title;
        this.iconRes = iconRes;
        this.status = status;
    }

    public String getTitle() { return title; }
    public int getIconRes() { return iconRes; }
    public String getStatus() { return status; }
}