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

import com.example.rentalsystem.adapter.AdapterRiwayatBooking;
import com.example.rentalsystem.model.RiwayatBookingModel;

import java.util.ArrayList;
import java.util.List;

public class RiwayatBookingFragment extends Fragment {

    private RecyclerView rvRiwayat;
    private AdapterRiwayatBooking adapter;
    private List<RiwayatBookingModel> dataList;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_riwayat_booking,
                container,
                false
        );

        rvRiwayat = view.findViewById(R.id.rvRiwayat);
        rvRiwayat.setLayoutManager(new LinearLayoutManager(requireContext()));

        dataList = new ArrayList<>();

        // 🔹 DATA DUMMY
        dataList.add(new RiwayatBookingModel(
                "MPV",
                "Toyota Avanza Veloz",
                "18 Okt - 20 Okt 2023",
                "Rp 1.050.000",
                "BERJALAN",
                "LUNAS",
                R.drawable.por
        ));

        dataList.add(new RiwayatBookingModel(
                "CITY CAR",
                "Honda Brio RS",
                "05 Okt - 07 Okt 2023",
                "Rp 750.000",
                "SELESAI",
                "LUNAS",
                R.drawable.por
        ));

        dataList.add(new RiwayatBookingModel(
                "MPV",
                "Mitsubishi Xpander",
                "20 Sep - 22 Sep 2023",
                "Rp 1.200.000",
                "DIBATALKAN",
                "",
                R.drawable.por
        ));

        // 🔥 ADAPTER + LISTENER (FRAGMENT NAVIGATION)
        adapter = new AdapterRiwayatBooking(
                dataList,
                new AdapterRiwayatBooking.OnRiwayatClickListener() {

                    @Override
                    public void onItemClick(RiwayatBookingModel model) {
                        // 👉 KLIK CARD → DETAIL RIWAYAT
                        openFragment(new DetailRiwayatFragment());
                    }

                    @Override
                    public void onActionClick(RiwayatBookingModel model) {
                        // 👉 KLIK TOMBOL
                        if (model.getStatus().equalsIgnoreCase("SELESAI")) {
                            openFragment(new SewaMobilFragment());
                        } else {
                            openFragment(new EreceiptFragment());
                        }
                    }
                }
        );

        rvRiwayat.setAdapter(adapter);

        return view;
    }

    // 🔁 HELPER NAVIGASI FRAGMENT
    private void openFragment(Fragment fragment) {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
