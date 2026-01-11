package com.example.rentalsystem.model;

public class MenuProfilModel {

    private String title;
    private String subtitle;
    private int iconRes;
    private String bgColor; // 🔥 TAMBAHAN

    public MenuProfilModel(
            String title,
            String subtitle,
            int iconRes,
            String bgColor) {

        this.title = title;
        this.subtitle = subtitle;
        this.iconRes = iconRes;
        this.bgColor = bgColor;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getBgColor() {
        return bgColor;
    }
}
