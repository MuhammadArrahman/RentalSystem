package com.example.rentalsystem;

import android.os.Bundle;
import android.util.Patterns;
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

public class FragmentLupaPassword extends Fragment {

    private EditText etEmail;
    private Button btnKirim;
    private ImageView btnBack;

    public FragmentLupaPassword() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lupa_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Inisialisasi View
        btnBack = view.findViewById(R.id.btnBack);
        etEmail = view.findViewById(R.id.etEmailForgot);
        btnKirim = view.findViewById(R.id.btnKirimKode);

        // 2. Logika Tombol Kembali
        btnBack.setOnClickListener(v -> {
            if (getParentFragmentManager() != null) {
                getParentFragmentManager().popBackStack();
            }
        });

        // 3. Logika Tombol Kirim Kode
        btnKirim.setOnClickListener(v -> {
            handleForgotPassword();
        });
    }

    private void handleForgotPassword() {
        String email = etEmail.getText().toString().trim();

        // Validasi Input
        if (email.isEmpty()) {
            etEmail.setError("Email tidak boleh kosong");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Format email tidak valid");
            etEmail.requestFocus();
            return;
        }

        // Simulasi Proses Kirim (Bisa disambungkan ke API/Firebase)
        btnKirim.setEnabled(false);
        btnKirim.setText("Mengirim...");

        // Delay simulasi 2 detik
        etEmail.postDelayed(() -> {
            Toast.makeText(getContext(), "Kode verifikasi telah dikirim ke " + email, Toast.LENGTH_LONG).show();

            // Opsional: Pindah ke Fragment Verifikasi OTP
            // navigateToOtpFragment();

            btnKirim.setEnabled(true);
            btnKirim.setText("Kirim Kode Verifikasi  ➤");
        }, 2000);
    }
}