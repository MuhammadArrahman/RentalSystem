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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ArmadaFragment extends Fragment {

    private RecyclerView rvArmada;
    private FloatingActionButton btnTambahMobil;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_armada, container, false);

        // RecyclerView
        rvArmada = view.findViewById(R.id.rvArmada);
        rvArmada.setLayoutManager(new LinearLayoutManager(getContext()));

        // Floating Button
        btnTambahMobil = view.findViewById(R.id.btnTambahMobil);

        // Data Dummy Armada
        List<MobilModel> listMobil = new ArrayList<>();
        listMobil.add(new MobilModel(
                "TOYOTA", "Avanza Veloz", "B 1293 KJH",
                "Rp 450rb", "Tersedia", R.drawable.ic_armada
        ));
        listMobil.add(new MobilModel(
                "HONDA", "Brio Satya", "B 5678 TUI",
                "Rp 300rb", "Disewa", R.drawable.ic_armada
        ));

        // 🔥 Adapter + Click Item → Detail Mobil
        MobilAdapter adapter = new MobilAdapter(listMobil, mobil -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new DetailMobilFragment())
                    .addToBackStack(null)
                    .commit();
        });

        rvArmada.setAdapter(adapter);

        // 🔥 CLICK TAMBAH MOBIL → TambahMobilFragment
        btnTambahMobil.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new TambahMobilFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}
