package com.example.rentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegisterLink, tvForgotPassword;
    private ImageView btnBack;

    private FirebaseAuth mAuth;
    private DatabaseReference userRef;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        userRef = FirebaseDatabase.getInstance().getReference("users");

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegisterLink = findViewById(R.id.tvRegisterLink);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        btnBack = findViewById(R.id.btnBack);

        setupPasswordToggle();

        btnLogin.setOnClickListener(v -> loginUser());
        tvRegisterLink.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));
        tvForgotPassword.setOnClickListener(v -> openForgotPasswordFragment());
        btnBack.setOnClickListener(v -> onBackPressed());
    }

    private void openForgotPasswordFragment() {
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new FragmentLupaPassword())
                .addToBackStack(null)
                .commit();
    }

    private void loginUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Email & password wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser user = mAuth.getCurrentUser();
                    if (user == null) return;

                    checkUserRole(user.getUid(), user.isEmailVerified());
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show());
    }

    private void checkUserRole(String uid, boolean emailVerified) {
        userRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                String role = snapshot.child("Role").getValue(String.class);

                if ("Admin".equalsIgnoreCase(role)) {
                    // 🔥 ADMIN LANGSUNG KE DASHBOARD
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    finish();
                    return;
                }

                // 👤 USER WAJIB VERIFIKASI EMAIL
                if (!emailVerified) {
                    Toast.makeText(LoginActivity.this,
                            "Silakan verifikasi email Anda",
                            Toast.LENGTH_LONG).show();
                    mAuth.signOut();
                    return;
                }

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(LoginActivity.this,
                        "Gagal membaca role", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupPasswordToggle() {
        etPassword.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP &&
                    etPassword.getCompoundDrawables()[2] != null) {

                int width = etPassword.getCompoundDrawables()[2].getBounds().width();
                if (event.getRawX() >= (etPassword.getRight() - width)) {
                    togglePassword();
                    return true;
                }
            }
            return false;
        });
    }

    private void togglePassword() {
        if (isPasswordVisible) {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            etPassword.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_lock, 0, R.drawable.ic_eye_of, 0);
        } else {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            etPassword.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_lock, 0, R.drawable.ic_eye, 0);
        }
        isPasswordVisible = !isPasswordVisible;
        etPassword.setSelection(etPassword.getText().length());
    }
}
