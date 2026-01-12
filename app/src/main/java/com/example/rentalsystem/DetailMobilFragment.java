package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rentalsystem.model.MobilModel;
import com.google.firebase.database.*;

public class DetailMobilFragment extends Fragment {

    private static final String ARG_KEY = "key_mobil";

    private TextView tvMerk, tvTipe, tvPlat, tvHarga, tvStatus;
    private ImageView imgMobil;
    private Button btnEdit;
    private DatabaseReference mobilRef;
    private String keyMobil;

    public static DetailMobilFragment newInstance(String key) {
        DetailMobilFragment fragment = new DetailMobilFragment();
        Bundle b = new Bundle();
        b.putString(ARG_KEY, key);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_mobil, container, false);

        // Init view
        tvMerk = view.findViewById(R.id.tvMerk);
        tvTipe = view.findViewById(R.id.tvTipe);
        tvPlat = view.findViewById(R.id.tvPlat);
        tvHarga = view.findViewById(R.id.tvHarga);
        tvStatus = view.findViewById(R.id.tvStatus);
        imgMobil = view.findViewById(R.id.imgMobil);
        btnEdit = view.findViewById(R.id.btnEdit);

        if (getArguments() != null) {
            keyMobil = getArguments().getString(ARG_KEY);
            mobilRef = FirebaseDatabase.getInstance().getReference("armada").child(keyMobil);
        }

        view.findViewById(R.id.btnBack).setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack()
        );

        btnEdit.setOnClickListener(v -> bukaHalamanEdit());

        ambilData();

        return view;
    }

    private void ambilData() {
        mobilRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                MobilModel mobil = snapshot.getValue(MobilModel.class);
                if (mobil == null) return;

                tvMerk.setText(mobil.getMerk());
                tvTipe.setText(mobil.getTipe());
                tvPlat.setText(mobil.getPlat());
                tvHarga.setText(mobil.getHarga());
                tvStatus.setText(mobil.getStatus());

                // Placeholder gambar
                imgMobil.setImageResource(R.drawable.ic_armada);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    // =========================
    // Buka Fragment Edit
    // =========================
    private void bukaHalamanEdit() {
        if (keyMobil == null) return;

        FragmentEditMobil fragment = FragmentEditMobil.newInstance(keyMobil);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
