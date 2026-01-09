package com.example.rentalsystem.model;

public class MenuModel {
    private String title;
    private int icon;
    private boolean isActive;

    public MenuModel(String title, int icon, boolean isActive) {
        this.title = title;
        this.icon = icon;
        this.isActive = isActive;
    }

    // Tambahkan method Getter di bawah ini untuk memperbaiki error
    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}