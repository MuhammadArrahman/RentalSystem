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

        // Inflate layout fragment
        View view = inflater.inflate(R.layout.fragment_lupa_password, container, false);

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi View
        EditText etEmail = view.findViewById(R.id.etEmailForgot);
        Button btnSend = view.findViewById(R.id.btnSend);
        ImageView btnBack = view.findViewById(R.id.btnBack);

        // 1. Tombol kirim reset password
        btnSend.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();

            if (email.isEmpty()) {
                etEmail.setError("Email wajib diisi");
                etEmail.requestFocus();
                return;
            }

            mAuth.sendPasswordResetEmail(email)
                    .addOnSuccessListener(unused ->
                            Toast.makeText(getContext(), "Email reset password berhasil dikirim", Toast.LENGTH_LONG).show()
                    )
                    .addOnFailureListener(e ->
                            Toast.makeText(getContext(), "Gagal mengirim email: " + e.getMessage(), Toast.LENGTH_LONG).show()
                    );
        });

        // 2. Tombol back → Memicu onBackPressed di LoginActivity
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                // 1. Sembunyikan Container Fragment yang ada di LoginActivity
                getActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);

                // 2. Hapus fragment ini dari backstack
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}