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

import com.example.rentalsystem.adapter.MobilAdapter;
import com.example.rentalsystem.model.MobilModel;

import java.util.ArrayList;
import java.util.List;
public class ArmadaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Menggunakan layout yang berisi RecyclerView
        View view = inflater.inflate(R.layout.fragment_verifikasi, container, false);

        // Inisialisasi RecyclerView sesuai ID di XML
        RecyclerView rv = view.findViewById(R.id.rvVerifikasiList);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        // Menyiapkan Data Mobil
        List<MobilModel> listMobil = new ArrayList<>();
        listMobil.add(new MobilModel("TOYOTA", "Avanza Veloz", "B 1293 KJH", "Rp 450rb", "Tersedia", R.drawable.ic_armada));
        listMobil.add(new MobilModel("HONDA", "Brio Satya", "B 5678 TUI", "Rp 300rb", "Disewa", R.drawable.ic_armada));
        listMobil.add(new MobilModel("MITSUBISHI", "Xpander", "D 9901 AB", "Rp 500rb", "Servis", R.drawable.ic_armada));

        // Memasang Adapter
        rv.setAdapter(new MobilAdapter(listMobil));

        return view;
    }
}