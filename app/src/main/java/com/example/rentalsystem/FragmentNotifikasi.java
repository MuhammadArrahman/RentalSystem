package com.example.rentalsystem;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.NotifikasiAdapter;

public class FragmentNotifikasi extends Fragment {

    private RecyclerView rvNotifikasi;
    private NotifikasiAdapter adapter;
    private List<Notifikasi> allNotif = new ArrayList<>();
    private List<Notifikasi> filteredNotif = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifikasi, container, false);

        rvNotifikasi = view.findViewById(R.id.rvNotifikasi);

        // 1. Data Dummy
        loadDummyData();

        // 2. Set Adapter (Tampilkan "Semua" secara default)
        filteredNotif.addAll(allNotif);
        adapter = new NotifikasiAdapter(filteredNotif);
        rvNotifikasi.setAdapter(adapter);

        // 3. Logika Filter (Contoh untuk tombol "Booking")
        view.findViewById(R.id.btnFilterBooking).setOnClickListener(v -> filterData("Booking"));

        return view;
    }

    private void loadDummyData() {
        allNotif.add(new Notifikasi("Booking Baru", "Toyota Avanza telah dipesan...", "15m lalu", "Booking", R.drawable.ic_booking));
        allNotif.add(new Notifikasi("KTP Perlu Verifikasi", "Pengguna Siska Amanda mengunggah KTP", "1h lalu", "Verifikasi", R.drawable.ic_verifikasi));
        allNotif.add(new Notifikasi("Pembaruan Sistem", "Pemeliharaan server selesai", "Kemarin", "Sistem", R.drawable.ic_system));
    }

    private void filterData(String kategori) {
        filteredNotif.clear();
        for (Notifikasi n : allNotif) {
            if (n.getJenis().equalsIgnoreCase(kategori)) {
                filteredNotif.add(n);
            }
        }
        adapter.notifyDataSetChanged();
    }
}