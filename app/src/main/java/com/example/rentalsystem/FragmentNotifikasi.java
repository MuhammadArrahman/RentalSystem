package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.NotifikasiAdapter;
import com.example.rentalsystem.model.NotifikasiModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentNotifikasi extends Fragment {

    private RecyclerView rvNotifikasi;
    private NotifikasiAdapter adapter;
    private final List<NotifikasiModel> allNotif = new ArrayList<>();
    private final List<NotifikasiModel> filteredNotif = new ArrayList<>();
    private ImageView btnBack;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notifikasi, container, false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // 🔹 INIT VIEW
        rvNotifikasi = view.findViewById(R.id.rvNotifikasi);
        btnBack = view.findViewById(R.id.btnBack);

        rvNotifikasi.setLayoutManager(
                new LinearLayoutManager(requireContext())
        );

        // 🔹 LOAD DATA
        loadDummyData();
        filteredNotif.addAll(allNotif);

        adapter = new NotifikasiAdapter(filteredNotif);
        rvNotifikasi.setAdapter(adapter);

        // 🔹 BACK
        btnBack.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack()
        );

        // 🔹 FILTER BUTTON
        view.findViewById(R.id.btnSemua)
                .setOnClickListener(v -> showAll());

        view.findViewById(R.id.btnBooking)
                .setOnClickListener(v -> filterData("Booking"));

        view.findViewById(R.id.btnVerifikasi)
                .setOnClickListener(v -> filterData("Verifikasi"));

        view.findViewById(R.id.btnSistem)
                .setOnClickListener(v -> filterData("Sistem"));

        // 🔹 LOAD MORE
        view.findViewById(R.id.btnLoadMore)
                .setOnClickListener(v ->
                        Toast.makeText(
                                requireContext(),
                                "Memuat data lama...",
                                Toast.LENGTH_SHORT
                        ).show()
                );
    }

    // ================= DATA =================

    private void loadDummyData() {
        allNotif.clear();

        allNotif.add(new NotifikasiModel(
                "Booking Baru",
                "Toyota Avanza telah dipesan oleh Budi",
                "15 menit lalu",
                "Booking",
                R.drawable.ic_lock
        ));

        allNotif.add(new NotifikasiModel(
                "KTP Perlu Verifikasi",
                "Pengguna Siska Amanda mengunggah KTP",
                "1 jam lalu",
                "Verifikasi",
                R.drawable.ic_verified
        ));

        allNotif.add(new NotifikasiModel(
                "Pembaruan Sistem",
                "Pemeliharaan server selesai tepat waktu",
                "Kemarin",
                "Sistem",
                R.drawable.ic_eye
        ));

        allNotif.add(new NotifikasiModel(
                "Booking Selesai",
                "Innova Reborn telah dikembalikan",
                "2 jam lalu",
                "Booking",
                R.drawable.ic_lock
        ));
    }

    private void showAll() {
        filteredNotif.clear();
        filteredNotif.addAll(allNotif);
        adapter.notifyDataSetChanged();
    }

    private void filterData(String kategori) {
        filteredNotif.clear();
        for (NotifikasiModel notif : allNotif) {
            if (notif.getJenis().equalsIgnoreCase(kategori)) {
                filteredNotif.add(notif);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
