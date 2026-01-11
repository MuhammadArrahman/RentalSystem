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

import com.example.rentalsystem.adapter.DashboardAdapter;
import com.example.rentalsystem.model.DashboardModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentDashboard extends Fragment {

    private RecyclerView rvDashboard;
    private DashboardAdapter adapter;
    private List<DashboardModel> listMobil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. FIX: Pastikan inflate layout utama (fragment_dashboard), bukan layout item
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // 2. Inisialisasi RecyclerView dari layout fragment_dashboard
        rvDashboard = view.findViewById(R.id.rvDashboard);

        // Cek null untuk menghindari crash jika ID rvDashboard tidak ditemukan
        if (rvDashboard != null) {
            rvDashboard.setLayoutManager(new LinearLayoutManager(getContext()));

            // 3. Persiapkan Data
            listMobil = new ArrayList<>();
            listMobil.add(new DashboardModel("Honda Civic RS", "Automatic", "5 Kursi", "Rp 450rb", R.drawable.por));
            listMobil.add(new DashboardModel("Tesla Model 3", "Automatic", "Electric", "Rp 1.2jt", R.drawable.por));
            listMobil.add(new DashboardModel("Toyota Rush", "Manual", "7 Kursi", "Rp 350rb", R.drawable.por));
            listMobil.add(new DashboardModel("Mitsubishi Pajero", "Automatic", "Diesel", "Rp 650rb", R.drawable.por));

            // 4. Set Adapter
            adapter = new DashboardAdapter(listMobil);
            rvDashboard.setAdapter(adapter);
        }

        return view;
    }
}