package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentInformasiAkun extends Fragment {

    private ImageView btnBack, ivFotoProfil;
    private EditText etNama, etEmail, etTelepon, etAlamat;
    private Button btnSimpan;

    public FragmentInformasiAkun() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout yang sudah Anda buat
        return inflater.inflate(R.layout.activity_informasi_akun, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Inisialisasi View
        btnBack = view.findViewById(R.id.btnBack);
        ivFotoProfil = view.findViewById(R.id.ivFotoProfil);
        etNama = view.findViewById(R.id.etNama); // Pastikan ID di XML sesuai
        etEmail = view.findViewById(R.id.etEmail);
        etTelepon = view.findViewById(R.id.etTelepon);
        etAlamat = view.findViewById(R.id.etAlamat);
        btnSimpan = view.findViewById(R.id.btnSimpan);

        // 2. Logika Tombol Kembali
        btnBack.setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack(); // Kembali ke fragment sebelumnya (Profil)
            }
        });

        // 3. Logika Ganti Foto (Opsional)
        ivFotoProfil.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Buka Galeri/Kamera...", Toast.LENGTH_SHORT).show();
        });

        // 4. Logika Tombol Simpan
        btnSimpan.setOnClickListener(v -> {
            simpanData();
        });
    }

    private void simpanData() {
        String nama = etNama.getText().toString().trim();
        String alamat = etAlamat.getText().toString().trim();

        if (nama.isEmpty() || alamat.isEmpty()) {
            Toast.makeText(getContext(), "Nama dan Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            // Simulasi proses simpan
            Toast.makeText(getContext(), "Perubahan berhasil disimpan!", Toast.LENGTH_SHORT).show();

            // Kembali ke layar profil setelah sukses
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        }
    }
}