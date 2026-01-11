package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.ProfilUserAdapter;
import com.example.rentalsystem.model.ProfilUserModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentProfilUser extends Fragment {

    private RecyclerView rvMenuProfile;
    private ProfilUserAdapter adapter;
    private List<ProfilUserModel> menuData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profil_user, container, false);

        rvMenuProfile = view.findViewById(R.id.rvMenuProfile);

        menuData = new ArrayList<>();
        menuData.add(new ProfilUserModel("Informasi Akun", R.drawable.ic_user_blue, null));
        menuData.add(new ProfilUserModel("Verifikasi KTP", R.drawable.ic_id_card, "Terverifikasi"));

        // ===== ADAPTER + CLICK HANDLER =====
        adapter = new ProfilUserAdapter(menuData, item -> {
            Fragment fragment = null;

            if (item.getTitle().equals("Informasi Akun")) {
                fragment = new FragmentInformasiAkun();
            }
            else if (item.getTitle().equals("Verifikasi KTP")) {
                fragment = new FragmentKtpUser();
            }

            if (fragment != null) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        rvMenuProfile.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMenuProfile.setAdapter(adapter);

        return view;
    }
}
