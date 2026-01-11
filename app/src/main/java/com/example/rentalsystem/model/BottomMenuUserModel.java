package com.example.rentalsystem.model;

public class BottomMenuUserModel {

    private String title;
    private int icon;
    private boolean active;

    public BottomMenuUserModel(String title, int icon, boolean active) {
        this.title = title;
        this.icon = icon;
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
