package com.example.rentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class intro3Activity extends AppCompatActivity {

    private LinearLayout btnStart;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);

        // Init View
        btnStart = findViewById(R.id.btnStart);
        tvLogin = findViewById(R.id.tvLogin);

        // Safety check (PENTING)
        if (btnStart == null || tvLogin == null) {
            Toast.makeText(this,
                    "ID btnStart atau tvLogin tidak ditemukan",
                    Toast.LENGTH_LONG).show();
            return;
        }

        // MULAI → Login
        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(intro3Activity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // MASUK → Login
        tvLogin.setOnClickListener(v -> {
            Intent intent = new Intent(intro3Activity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
