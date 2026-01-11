package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.MenuProfilAdapter;
import com.example.rentalsystem.model.MenuProfilModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentProfile extends Fragment {

    private RecyclerView rvPengaturan;
    private MenuProfilAdapter adapter;
    private List<MenuProfilModel> list;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_profile,
                container,
                false
        );

        rvPengaturan = view.findViewById(R.id.rvPengaturanAkun);
        rvPengaturan.setLayoutManager(new LinearLayoutManager(requireContext()));

        prepareData();

        adapter = new MenuProfilAdapter(list, model -> {

            Fragment targetFragment = null;

            switch (model.getTitle()) {
                case "Informasi Akun":
                    targetFragment = new FragmentInformasiAkun();
                    break;

                case "Ubah Kata Sandi":
                    targetFragment = new FragmentUbahSandi();
                    break;

                case "Notifikasi":
                    targetFragment = new FragmentNotifikasi();
                    break;
            }

            if (targetFragment != null) {
                openFragment(targetFragment);
            }
        });

        rvPengaturan.setAdapter(adapter);

        view.findViewById(R.id.btnLogout).setOnClickListener(v ->
                Toast.makeText(
                        requireContext(),
                        "Logout berhasil",
                        Toast.LENGTH_SHORT
                ).show()
        );

        return view;
    }

    private void prepareData() {
        list = new ArrayList<>();
        list.add(new MenuProfilModel(
                "Informasi Akun",
                "Detail profil dan data diri",
                R.drawable.ic_user,
                "#EFF8FF"
        ));
        list.add(new MenuProfilModel(
                "Ubah Kata Sandi",
                "Perbarui keamanan akun",
                R.drawable.ic_lock,
                "#FFF4ED"
        ));
        list.add(new MenuProfilModel(
                "Notifikasi",
                "Atur preferensi pemberitahuan",
                R.drawable.ic_bell,
                "#F9F5FF"
        ));
    }

    private void openFragment(Fragment fragment) {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
