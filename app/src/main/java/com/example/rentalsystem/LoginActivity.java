package com.example.rentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegisterLink, tvForgotPassword;
    private ImageView btnBack;

    private FirebaseAuth mAuth;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        // Init View
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegisterLink = findViewById(R.id.tvRegisterLink);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        btnBack = findViewById(R.id.btnBack);

        setupPasswordToggle();

        // Login
        btnLogin.setOnClickListener(v -> loginUser());

        // Pindah ke Register
        tvRegisterLink.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));

        // Forgot Password
        tvForgotPassword.setOnClickListener(v -> resetPassword());

        // Back
        btnBack.setOnClickListener(v -> finish());
    }

    // ================= LOGIN =================
    private void loginUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email wajib diisi");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password wajib diisi");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        FirebaseUser user = mAuth.getCurrentUser();

                        if (user != null && !user.isEmailVerified()) {
                            Toast.makeText(this,
                                    "Silakan verifikasi email terlebih dahulu",
                                    Toast.LENGTH_LONG).show();
                            mAuth.signOut();
                            return;
                        }

                        Toast.makeText(this,
                                "Login berhasil",
                                Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(this, MainActivity.class));
                        finish();

                    } else {
                        Toast.makeText(this,
                                "Login gagal: Email atau password salah",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    // ================= RESET PASSWORD =================
    private void resetPassword() {
        String email = etEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Masukkan email terlebih dahulu");
            return;
        }

        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this,
                                "Link reset password telah dikirim ke email",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this,
                                "Gagal mengirim email reset",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // ================= TOGGLE PASSWORD =================
    private void setupPasswordToggle() {
        etPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;

            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >=
                        (etPassword.getRight()
                                - etPassword.getCompoundDrawables()[DRAWABLE_RIGHT]
                                .getBounds().width())) {
                    togglePassword();
                    return true;
                }
            }
            return false;
        });
    }

    private void togglePassword() {
        if (isPasswordVisible) {
            etPassword.setInputType(
                    InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
            etPassword.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_lock, 0, R.drawable.ic_eye_of, 0);
            isPasswordVisible = false;
        } else {
            etPassword.setInputType(
                    InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            etPassword.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_lock, 0, R.drawable.ic_eye, 0);
            isPasswordVisible = true;
        }
        etPassword.setSelection(etPassword.getText().length());
    }
}
