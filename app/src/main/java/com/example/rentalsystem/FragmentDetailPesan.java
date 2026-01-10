package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetailPesan extends Fragment {

    private ImageView btnBack;
    private Button btnEReceipt, btnSewaLagi;

    public FragmentDetailPesan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_pesan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi View
        btnBack = view.findViewById(R.id.btnBack);
        btnEReceipt = view.findViewById(R.id.btnEReceipt);
        btnSewaLagi = view.findViewById(R.id.btnSewaLagi);

        // Logika Klik
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        btnEReceipt.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Membuka E-Receipt...", Toast.LENGTH_SHORT).show();
            // Navigasi ke Fragment Receipt atau tampilkan PDF
        });

        btnSewaLagi.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Memulai pesanan baru...", Toast.LENGTH_SHORT).show();
            // Logika untuk kembali ke halaman pencarian mobil
        });
    }
}