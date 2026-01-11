package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.NotifikasiAdapter;
import com.example.rentalsystem.model.NotifikasiModel; // Pastikan model ini ada

import java.util.ArrayList;
import java.util.List;

public class FragmentNotifikasi extends Fragment {

    private RecyclerView rvNotifikasi;
    private NotifikasiAdapter adapter;
    private List<NotifikasiModel> allNotif = new ArrayList<>();
    private List<NotifikasiModel> filteredNotif = new ArrayList<>();
    private ImageView btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifikasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Inisialisasi View
        rvNotifikasi = view.findViewById(R.id.rvNotifikasi);
        btnBack = view.findViewById(R.id.btnBack);

        // 2. Data Dummy
        loadDummyData();

        // 3. Set Adapter
        filteredNotif.addAll(allNotif);
        adapter = new NotifikasiAdapter(filteredNotif);
        rvNotifikasi.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNotifikasi.setAdapter(adapter);

        // 4. Tombol Kembali
        btnBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        // 5. Logika Filter (Sesuaikan ID tombol di XML)
        view.findViewById(R.id.btnSewa).setOnClickListener(v -> {
            filteredNotif.clear();
            filteredNotif.addAll(allNotif);
            adapter.notifyDataSetChanged();
        });

        view.findViewById(R.id.btnBooking).setOnClickListener(v -> filterData("Booking"));
        view.findViewById(R.id.rvNotifikasi).setOnClickListener(v -> filterData("Verifikasi"));
        view.findViewById(R.id.btnSimpan).setOnClickListener(v -> filterData("Sistem"));

        // 6. Muat Lebih Banyak
        view.findViewById(R.id.btnLoadMore).setOnClickListener(v ->
                Toast.makeText(getContext(), "Memuat data lama...", Toast.LENGTH_SHORT).show()
        );
    }

    private void loadDummyData() {
        allNotif.clear(); // Bersihkan agar tidak duplikat saat fragment di-recreate
        allNotif.add(new NotifikasiModel("Booking Baru", "Toyota Avanza telah dipesan oleh Budi", "15m lalu", "Booking", R.drawable.ic_lock));
        allNotif.add(new NotifikasiModel("KTP Perlu Verifikasi", "Pengguna Siska Amanda mengunggah KTP", "1h lalu", "Verifikasi", R.drawable.ic_verified));
        allNotif.add(new NotifikasiModel("Pembaruan Sistem", "Pemeliharaan server selesai tepat waktu", "Kemarin", "Sistem", R.drawable.ic_eye));
        allNotif.add(new NotifikasiModel("Booking Selesai", "Innova Reborn telah dikembalikan", "2h lalu", "Booking", R.drawable.ic_lock));
    }

    private void filterData(String kategori) {
        filteredNotif.clear();
        for (NotifikasiModel n : allNotif) {
            if (n.getJenis().equalsIgnoreCase(kategori)) {
                filteredNotif.add(n);
            }
        }
        adapter.notifyDataSetChanged();
    }
}