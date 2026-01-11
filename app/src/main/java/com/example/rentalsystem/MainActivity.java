package com.example.rentalsystem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.BottomMenuAdapter;
import com.example.rentalsystem.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Konfigurasi Window Insets agar tidak tertutup Status Bar / Navigation Bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1️⃣ Setup Bottom Menu RecyclerView
        setupBottomMenu();

        // 2️⃣ LOAD FRAGMENT PERTAMA KALI (ARMADA)
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new ArmadaFragment())
                    .commit();
        }
    }

    private void setupBottomMenu() {
        RecyclerView rvMenu = findViewById(R.id.rvBottomMenu);

        // Grid 5 kolom (sesuai jumlah menu)
        rvMenu.setLayoutManager(new GridLayoutManager(this, 5));

        // Data Menu Bottom
        List<MenuModel> menus = new ArrayList<>();
        menus.add(new MenuModel("Dashboard", R.drawable.ic_dashboard, false));
        menus.add(new MenuModel("Verifikasi", R.drawable.ic_verify, false));
        menus.add(new MenuModel("Armada", R.drawable.ic_armada, true)); // aktif default
        menus.add(new MenuModel("Pesanan", R.drawable.ic_order, false));
        menus.add(new MenuModel("Profil", R.drawable.ic_profile, false));

        BottomMenuAdapter adapter = new BottomMenuAdapter(menus);
        rvMenu.setAdapter(adapter);
    }
}
