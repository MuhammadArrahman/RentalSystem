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
    private EditText etNama, etEmail, etPhone, etAlamat;
    private Button btnSimpan;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_informasi_akun, container, false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // 🔹 INISIALISASI VIEW
        btnBack = view.findViewById(R.id.btnBack);
        ivFotoProfil = view.findViewById(R.id.ivFotoProfil);

        etNama = view.findViewById(R.id.etNama);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etAlamat = view.findViewById(R.id.etAlamat);

        btnSimpan = view.findViewById(R.id.btnSimpan);

        // 🔹 BACK
        btnBack.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack()
        );

        // 🔹 SIMPAN
        btnSimpan.setOnClickListener(v -> {

            if (etNama.getText().toString().trim().isEmpty()) {
                etNama.setError("Nama tidak boleh kosong");
                return;
            }

            Toast.makeText(
                    requireContext(),
                    "Data berhasil disimpan",
                    Toast.LENGTH_SHORT
            ).show();

            requireActivity()
                    .getSupportFragmentManager()
                    .popBackStack();
        });
    }
}
