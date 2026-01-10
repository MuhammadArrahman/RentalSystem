package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// IMPORT INI WAJIB ADA AGAR TIDAK MERAH
import com.example.rentalsystem.adapter.AdapterRiwayatBooking;
import com.example.rentalsystem.adapter.RiwayatBookingModel;

import java.util.ArrayList;
import java.util.List;

public class RiwayatBookingFragment extends Fragment {

    private RecyclerView rvRiwayat;
    private AdapterRiwayatBooking adapter;
    private List<RiwayatBookingModel> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riwayat_booking, container, false);

        rvRiwayat = view.findViewById(R.id.rvRiwayat);
        rvRiwayat.setLayoutManager(new LinearLayoutManager(getContext()));

        dataList = new ArrayList<>();

        // Pastikan file gambar (veloz, brio, xpander) sudah ada di folder res/drawable
        dataList.add(new RiwayatBookingModel("MPV", "Toyota Avanza Veloz", "18 Okt - 20 Okt 2023", "Rp 1.050.000", "BERJALAN", "LUNAS", R.drawable.por));
        dataList.add(new RiwayatBookingModel("CITY CAR", "Honda Brio RS", "05 Okt - 07 Okt 2023", "Rp 750.000", "SELESAI", "LUNAS", R.drawable.por));
        dataList.add(new RiwayatBookingModel("MPV", "Mitsubishi Xpander", "20 Sep - 22 Sep 2023", "Rp 1.200.000", "DIBATALKAN", "", R.drawable.por));

        adapter = new AdapterRiwayatBooking(dataList);
        rvRiwayat.setAdapter(adapter);

        return view;
    }
}