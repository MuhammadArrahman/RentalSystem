package com.example.rentalsystem;

import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.BottomMenuAdapter;
import com.example.rentalsystem.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomMenuAdapter menuAdapter;
    private List<MenuModel> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        setupBottomMenu();

        // Munculkan Dashboard pertama kali
        if (savedInstanceState == null) {
            loadFragment(new FragmentDashboard());
        }
    }

    private void setupBottomMenu() {
        RecyclerView rvMenu = findViewById(R.id.rvBottomMenu);
        rvMenu.setLayoutManager(new GridLayoutManager(this, 5));

        menuList = new ArrayList<>();
        menuList.add(new MenuModel("Dashboard", R.drawable.ic_dashboard, true));
        menuList.add(new MenuModel("Verifikasi", R.drawable.ic_verify, false));
        menuList.add(new MenuModel("Armada", R.drawable.ic_armada, false));
        menuList.add(new MenuModel("Pesanan", R.drawable.ic_order, false));
        menuList.add(new MenuModel("Profil", R.drawable.ic_profile, false));

        // Inisialisasi Adapter dengan Listener Klik
        menuAdapter = new BottomMenuAdapter(menuList, position -> {
            // Update UI Item yang aktif
            for (int i = 0; i < menuList.size(); i++) {
                menuList.get(i).setActive(i == position);
            }
            menuAdapter.notifyDataSetChanged();

            // Logika pindah fragment
            switch (position) {
                case 0: loadFragment(new FragmentDashboard()); break;
                case 1: /* loadFragment(new FragmentVerifikasi()); */ break;
                case 2: /* loadFragment(new FragmentArmada()); */ break;
                case 3: /* loadFragment(new FragmentPesanan()); */ break;
                case 4: /* loadFragment(new FragmentProfil()); */ break;
            }
        });

        rvMenu.setAdapter(menuAdapter);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}