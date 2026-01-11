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

import com.google.firebase.auth.FirebaseAuth;

public class FragmentLupaPassword extends Fragment {

    private EditText etEmail;
    private Button btnKirim;
    private ImageView btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lupa_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnBack = view.findViewById(R.id.btnBack);
        etEmail = view.findViewById(R.id.etEmailForgot);
        btnKirim = view.findViewById(R.id.btnKirimKode);

        btnBack.setOnClickListener(v ->
                getParentFragmentManager().popBackStack()
        );

        btnKirim.setOnClickListener(v -> sendResetEmail());
    }

    private void sendResetEmail() {
        String email = etEmail.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email tidak boleh kosong");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Format email tidak valid");
            return;
        }

        btnKirim.setEnabled(false);
        btnKirim.setText("Mengirim...");

        FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnSuccessListener(unused -> {
                    Toast.makeText(getContext(),
                            "Link reset password dikirim ke email",
                            Toast.LENGTH_LONG).show();
                    getParentFragmentManager().popBackStack();
                })
                .addOnFailureListener(e -> {
                    btnKirim.setEnabled(true);
                    btnKirim.setText("Kirim Kode Verifikasi  ➤");
                    Toast.makeText(getContext(),
                            "Gagal: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                });
    }
}
