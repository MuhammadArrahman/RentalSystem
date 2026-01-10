package com.example.rentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class intro2Activity extends AppCompatActivity {

    private FloatingActionButton fabNext;
    private TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro2);

        // Inisialisasi view
        fabNext = findViewById(R.id.fabNext);
        tvSkip = findViewById(R.id.tvSkip);

        // Klik tombol Next → ke halaman intro selanjutnya
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro2Activity.this, introActivity.class);
                startActivity(intent);
            }
        });

        // Klik Skip → langsung ke Login
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro2Activity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // supaya tidak bisa kembali ke intro
            }
        });

        // Edge to Edge padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
