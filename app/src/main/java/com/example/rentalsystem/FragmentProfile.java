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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Gunakan layout fragment_profil yang sudah kita buat sebelumnya
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        rvPengaturan = view.findViewById(R.id.rvPengaturanAkun);
        rvPengaturan.setLayoutManager(new LinearLayoutManager(getContext()));

        prepareData();

        adapter = new MenuProfilAdapter(list);
        rvPengaturan.setAdapter(adapter);

        // Contoh fungsi Logout
        view.findViewById(R.id.btnLogout).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Keluar dari akun...", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private void prepareData() {
        list = new ArrayList<>();
        // Data menu sesuai desain: Judul, Subjudul, Ikon, Warna Latar Lingkaran
        list.add(new MenuProfilModel("Informasi Akun", "Detail profil dan data diri", R.drawable.ic_user, "#EFF8FF")); // Biru muda
        list.add(new MenuProfilModel("Ubah Kata Sandi", "Perbarui keamanan akun", R.drawable.ic_lock, "#FFF4ED"));    // Oranye muda
        list.add(new MenuProfilModel("Notifikasi", "Atur preferensi pemberitahuan", R.drawable.ic_bell, "#F9F5FF")); // Ungu muda
    }
}