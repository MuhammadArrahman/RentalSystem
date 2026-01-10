package com.example.rentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class intro3Activity extends AppCompatActivity {

    private LinearLayout btnStart;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro3); // ⚠️ PENTING: layout ke-3

        // Inisialisasi view sesuai XML
        btnStart = findViewById(R.id.btnStart);
        tvLogin = findViewById(R.id.tvLogin);

        // Klik MULAI → Login
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro3Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Klik MASUK → Login
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro3Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Edge to Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
