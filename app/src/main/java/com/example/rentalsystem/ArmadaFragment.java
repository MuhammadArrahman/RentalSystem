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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ArmadaFragment extends Fragment {

    private RecyclerView rvArmada;
    private FloatingActionButton btnTambahMobil;

    private final List<MobilModel> listMobil = new ArrayList<>();
    private final List<String> listKey = new ArrayList<>();

    private MobilAdapter adapter;
    private DatabaseReference mobilRef;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_armada, container, false);

        // Init View
        rvArmada = view.findViewById(R.id.rvArmada);
        btnTambahMobil = view.findViewById(R.id.btnTambahMobil);

        rvArmada.setLayoutManager(new LinearLayoutManager(getContext()));

        // Adapter dengan KEY Firebase
        adapter = new MobilAdapter(
                listMobil,
                listKey,
                (mobil, key) -> {

                    DetailMobilFragment fragment =
                            DetailMobilFragment.newInstance(key);

                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .addToBackStack(null)
                            .commit();
                }
        );

        rvArmada.setAdapter(adapter);

        // Firebase Reference
        mobilRef = FirebaseDatabase.getInstance().getReference("armada");

        loadData();

        // Tambah Mobil
        btnTambahMobil.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new TambahMobilFragment())
                        .addToBackStack(null)
                        .commit()
        );

        return view;
    }

    private void loadData() {
        mobilRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                listMobil.clear();
                listKey.clear();

                for (DataSnapshot data : snapshot.getChildren()) {

                    MobilModel mobil = data.getValue(MobilModel.class);

                    if (mobil != null) {
                        listMobil.add(mobil);
                        listKey.add(data.getKey()); // 🔑 simpan key Firebase
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Optional: log error
            }
        });
    }
}
