package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailMobilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_mobil, container, false);

        // 🔙 Tombol Back
        view.findViewById(R.id.btnBack).setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack()
        );

        // ✏️ Tombol Edit → ke FragmentEditMobil
        view.findViewById(R.id.btnEdit).setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new FragmentEditMobil())
                    .addToBackStack(null) // supaya bisa kembali
                    .commit();
        });

        return view;
    }
}
