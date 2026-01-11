package com.example.rentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPhone, etPassword;
    private Button btnRegister;
    private TextView tvLoginLink;
    private ImageView btnBack;
    private CheckBox cbTerms;

    private FirebaseAuth mAuth;
    private DatabaseReference userRef;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 🔥 Firebase
        mAuth = FirebaseAuth.getInstance();
        userRef = FirebaseDatabase.getInstance().getReference("users");

        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLoginLink = findViewById(R.id.tvLoginLink);
        btnBack = findViewById(R.id.btnBack);
        cbTerms = findViewById(R.id.cbTerms);

        setupPasswordToggle();

        btnRegister.setOnClickListener(v -> registerUser());

        tvLoginLink.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));

        btnBack.setOnClickListener(v -> finish());
    }

    // ================= REGISTER + SAVE TO REALTIME DB =================
    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email wajib diisi");
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Nomor HP wajib diisi");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password wajib diisi");
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password minimal 6 karakter");
            return;
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(this,
                    "Anda harus menyetujui Syarat & Ketentuan",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user == null) return;

                        String uid = user.getUid();

                        // 📦 DATA USER
                        Map<String, Object> userData = new HashMap<>();
                        userData.put("email", email);
                        userData.put("phone", phone);
                        userData.put("verified", false);
                        userData.put("createdAt", System.currentTimeMillis());
                        userData.put("Role","User");

                        // 🔥 SIMPAN KE REALTIME DATABASE
                        userRef.child(uid).setValue(userData)
                                .addOnSuccessListener(unused -> sendVerificationEmail(user))
                                .addOnFailureListener(e ->
                                        Toast.makeText(this,
                                                "Gagal menyimpan data user",
                                                Toast.LENGTH_SHORT).show());
                    } else {
                        Toast.makeText(this,
                                "Registrasi gagal: " + task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    // ================= EMAIL VERIFICATION =================
    private void sendVerificationEmail(FirebaseUser user) {
        user.sendEmailVerification()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this,
                                "Registrasi berhasil! Silakan cek email untuk verifikasi.",
                                Toast.LENGTH_LONG).show();

                        mAuth.signOut();
                        startActivity(new Intent(this, LoginActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this,
                                "Gagal mengirim email verifikasi",
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
                    0, 0, R.drawable.ic_eye_of, 0);
            isPasswordVisible = false;
        } else {
            etPassword.setInputType(
                    InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            etPassword.setCompoundDrawablesWithIntrinsicBounds(
                    0, 0, R.drawable.ic_eye, 0);
            isPasswordVisible = true;
        }
        etPassword.setSelection(etPassword.getText().length());
    }
}
