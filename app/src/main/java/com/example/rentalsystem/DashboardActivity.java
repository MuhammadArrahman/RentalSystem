package com.example.rentalsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.BottomMenuAdapter;
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

        // DEFAULT FRAGMENT (ADMIN DASHBOARD)
        if (savedInstanceState == null) {
            loadFragment(new DashboardAdminFragment());
        }

        menuList = new ArrayList<>();
        menuList.add(new MenuModel("Dashboard", R.drawable.ic_dashboard, true));
        menuList.add(new MenuModel("Verifikasi", R.drawable.ic_verify, false));
        menuList.add(new MenuModel("Armada", R.drawable.ic_car, false));
        menuList.add(new MenuModel("Pesanan", R.drawable.ic_order, false));
        menuList.add(new MenuModel("Profil", R.drawable.ic_profile, false));

        rvBottomMenu.setLayoutManager(new GridLayoutManager(this, 5));

        menuAdapter = new BottomMenuAdapter(menuList, position -> {

            for (int i = 0; i < menuList.size(); i++) {
                menuList.get(i).setActive(i == position);
            }
            menuAdapter.notifyDataSetChanged();

            switch (position) {
                case 0:
                    loadFragment(new DashboardAdminFragment());
                    break;

                case 1:
                    loadFragment(new VerifikasiFragment());
                    break;

                case 2:
                    loadFragment(new ArmadaFragment());
                    break;

                case 3:
                    loadFragment(new FragmentDetailPesan());
                    break;

                case 4:
                    loadFragment(new FragmentProfile());
                    break;
            }
        });

        rvBottomMenu.setAdapter(menuAdapter);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
