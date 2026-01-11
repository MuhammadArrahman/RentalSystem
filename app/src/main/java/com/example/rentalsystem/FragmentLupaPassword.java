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

import com.google.firebase.auth.FirebaseAuth;

public class FragmentLupaPassword extends Fragment {

    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_lupa_password,
                container,
                false
        );

        // Firebase
        mAuth = FirebaseAuth.getInstance();

        // View
        EditText etEmail = view.findViewById(R.id.etEmailForgot);
        Button btnSend = view.findViewById(R.id.btnSend);
        ImageView btnBack = view.findViewById(R.id.btnBack);

        // Kirim reset password
        btnSend.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();

            if (email.isEmpty()) {
                etEmail.setError("Email wajib diisi");
                etEmail.requestFocus();
                return;
            }

            mAuth.sendPasswordResetEmail(email)
                    .addOnSuccessListener(unused ->
                            Toast.makeText(
                                    getContext(),
                                    "Email reset password berhasil dikirim",
                                    Toast.LENGTH_LONG
                            ).show()
                    )
                    .addOnFailureListener(e ->
                            Toast.makeText(
                                    getContext(),
                                    e.getMessage(),
                                    Toast.LENGTH_LONG
                            ).show()
                    );
        });

        // Back ke Login
        btnBack.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack()
        );

        return view;
    }
}
