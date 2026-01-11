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

import com.example.rentalsystem.adapter.BottomMenuUserAdapter;
import com.example.rentalsystem.model.BottomMenuUserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomMenuUserAdapter menuAdapter;
    private List<BottomMenuUserModel> menuList;

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

        setupBottomMenuUser();

        if (savedInstanceState == null) {
            loadFragment(new FragmentDashboard());
        }
    }

    private void setupBottomMenuUser() {
        RecyclerView rvMenu = findViewById(R.id.rvBottomMenu);
        // Menggunakan 4 kolom sesuai gambar referensi Anda
        rvMenu.setLayoutManager(new GridLayoutManager(this, 4));

        menuList = new ArrayList<>();
        menuList.add(new BottomMenuUserModel("Beranda", R.drawable.ic_home, true));
        menuList.add(new BottomMenuUserModel("Booking", R.drawable.ic_booking, false));
        menuList.add(new BottomMenuUserModel("Riwayat", R.drawable.ic_history, false));
        menuList.add(new BottomMenuUserModel("Profil", R.drawable.ic_profile, false));

        menuAdapter = new BottomMenuUserAdapter(menuList, position -> {
            // Update UI Aktif
            for (int i = 0; i < menuList.size(); i++) {
                menuList.get(i).setActive(i == position);
            }
            menuAdapter.notifyDataSetChanged();

            // Pindah Fragment
            switch (position) {
                case 0: loadFragment(new FragmentDashboard()); break;
                case 1: loadFragment(new FragmentBooking()); break;
                case 2: loadFragment(new RiwayatBookingFragment()); break;
                case 3: loadFragment(new FragmentProfilUser()); break;
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