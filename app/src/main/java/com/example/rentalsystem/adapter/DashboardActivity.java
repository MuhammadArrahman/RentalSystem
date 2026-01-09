package com.example.rentalsystem.adapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import com.example.rentalsystem.model.MenuModel;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView rvBottomMenu;
    BottomMenuAdapter menuAdapter;
    List<MenuModel> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvBottomMenu = findViewById(R.id.rvBottomMenu);

        // 1. Siapkan Data
        menuList = new ArrayList<>();
        menuList.add(new MenuModel("Dashboard", R.drawable.ic_dashboard, true));
        menuList.add(new MenuModel("Verifikasi", R.drawable.ic_verify, false));
        menuList.add(new MenuModel("Armada", R.drawable.ic_car, false));
        menuList.add(new MenuModel("Pesanan", R.drawable.ic_order, false));
        menuList.add(new MenuModel("Profil", R.drawable.ic_profile, false));

        // 2. Setting LayoutManager (Horizontal dengan lebar rata)
        // GridLayoutManager dengan spanCount sesuai jumlah menu (5)
        rvBottomMenu.setLayoutManager(new GridLayoutManager(this, 5));

        // 3. Pasang Adapter
        menuAdapter = new BottomMenuAdapter(menuList);
        rvBottomMenu.setAdapter(menuAdapter);
    }
}