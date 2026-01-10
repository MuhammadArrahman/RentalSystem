package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class FragmentBookingDetail extends Fragment {

    private ImageView btnBack;
    private LinearLayout layoutOnline, layoutCash;
    private MaterialButton btnKonfirmasi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_detail, container, false);

        // Inisialisasi View
        btnBack = view.findViewById(R.id.btnBack);
        layoutOnline = view.findViewById(R.id.layoutOnline); // Pastikan ID ini ada di XML Anda
        layoutCash = view.findViewById(R.id.layoutCash);     // Pastikan ID ini ada di XML Anda
        btnKonfirmasi = view.findViewById(R.id.btnKonfirmasi);

        // Fungsi Tombol Kembali
        btnBack.setOnClickListener(v -> {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        });

        // Logika Pindah Metode Pembayaran
        setupPaymentSelection();

        // Fungsi Tombol Konfirmasi
        btnKonfirmasi.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Pesanan Berhasil Dikonfirmasi!", Toast.LENGTH_SHORT).show();
            // Di sini Anda bisa menambahkan logika pindah ke halaman Invoice/Success
        });

        return view;
    }

    private void setupPaymentSelection() {
        // Default: Online terpilih (sesuai XML Anda)

        layoutOnline.setOnClickListener(v -> {
            // Ubah background ke biru (selected)
            layoutOnline.setBackgroundResource(R.drawable.bg_payment_selected);
            // Ubah background cash ke abu-abu (unselected)
            layoutCash.setBackgroundResource(R.drawable.bg_input_field);
        });

        layoutCash.setOnClickListener(v -> {
            // Ubah background ke biru (selected)
            layoutCash.setBackgroundResource(R.drawable.bg_payment_selected);
            // Ubah background online ke abu-abu (unselected)
            layoutOnline.setBackgroundResource(R.drawable.bg_input_field);
        });
    }
}