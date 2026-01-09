package com.example.rentalsystem;

import android.os.Bundle;
import android.text.TextUtils;
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

import com.google.android.material.textfield.TextInputLayout;

public class FragmentUbahSandi extends Fragment {

    private EditText etSandiLama, etSandiBaru, etKonfirmasiSandi;
    private Button btnPerbarui;
    private ImageView btnBack;

    public FragmentUbahSandi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout XML yang Anda berikan
        return inflater.inflate(R.layout.fragment_ubah_sandi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi View
        btnBack = view.findViewById(R.id.btnBack);
        btnPerbarui = view.findViewById(R.id.btnPerbarui); // Tambahkan ID ini di XML Button Anda

        // Mengambil EditText dari dalam TextInputLayout
        etSandiLama = ((TextInputLayout) view.findViewById(R.id.tilSandiLama)).getEditText();
        etSandiBaru = ((TextInputLayout) view.findViewById(R.id.tilSandiBaru)).getEditText();
        etKonfirmasiSandi = ((TextInputLayout) view.findViewById(R.id.tilKonfirmasiSandi)).getEditText();

        // Tombol Kembali
        btnBack.setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        });

        // Tombol Perbarui
        btnPerbarui.setOnClickListener(v -> validateAndSubmit());
    }

    private void validateAndSubmit() {
        String sandiLama = etSandiLama.getText().toString().trim();
        String sandiBaru = etSandiBaru.getText().toString().trim();
        String konfirmasi = etKonfirmasiSandi.getText().toString().trim();

        // 1. Validasi Kosong
        if (TextUtils.isEmpty(sandiLama) || TextUtils.isEmpty(sandiBaru) || TextUtils.isEmpty(konfirmasi)) {
            Toast.makeText(getContext(), "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. Validasi Panjang Karakter (Minimal 8 sesuai panduan)
        if (sandiBaru.length() < 8) {
            etSandiBaru.setError("Kata sandi minimal 8 karakter");
            return;
        }

        // 3. Validasi Kesamaan Kata Sandi Baru
        if (!sandiBaru.equals(konfirmasi)) {
            etKonfirmasiSandi.setError("Konfirmasi kata sandi tidak cocok");
            return;
        }

        // 4. Simulasi API Call / Proses Update
        prosesUpdateSandi(sandiLama, sandiBaru);
    }

    private void prosesUpdateSandi(String lama, String baru) {
        // Di sini Anda bisa memanggil API Retrofit atau Firebase
        Toast.makeText(getContext(), "Kata sandi berhasil diperbarui!", Toast.LENGTH_LONG).show();

        // Kembali ke layar sebelumnya setelah sukses
        if (getFragmentManager() != null) {
            getFragmentManager().popBackStack();
        }
    }
}