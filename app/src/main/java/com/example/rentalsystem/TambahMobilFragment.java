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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahMobilFragment extends Fragment {

    private EditText etNamaMobil, etMerek, etModel, etPlatNomor,
            etHargaSewa, etTahun, etTransmisi,
            etDeskripsi, etTerakhirServis;
    private Switch switchStatus;
    private Button btnSimpan;
    private ImageView btnBack;

    private DatabaseReference mobilRef;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tambah_mobil, container, false);

        mobilRef = FirebaseDatabase.getInstance().getReference("armada");

        btnBack = view.findViewById(R.id.btnBack);
        btnSimpan = view.findViewById(R.id.btnSimpan);
        switchStatus = view.findViewById(R.id.switchStatus);

        etNamaMobil = view.findViewById(R.id.etNamaMobil);
        etMerek = view.findViewById(R.id.etMerek);
        etModel = view.findViewById(R.id.etModel);
        etPlatNomor = view.findViewById(R.id.etPlatNomor);
        etHargaSewa = view.findViewById(R.id.etHargaSewa);
        etTahun = view.findViewById(R.id.etTahun);
        etTransmisi = view.findViewById(R.id.etTransmisi);
        etDeskripsi = view.findViewById(R.id.etDeskripsi);
        etTerakhirServis = view.findViewById(R.id.etTerakhirServis);

        btnBack.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack()
        );

        btnSimpan.setOnClickListener(v -> simpanMobil());

        return view;
    }

    private void simpanMobil() {

        if (etMerek.getText().toString().isEmpty() ||
                etModel.getText().toString().isEmpty() ||
                etPlatNomor.getText().toString().isEmpty() ||
                etHargaSewa.getText().toString().isEmpty()) {

            Toast.makeText(getContext(),
                    "Lengkapi data utama",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        MobilModel mobil = new MobilModel(
                etMerek.getText().toString().trim(),
                etModel.getText().toString().trim(),
                etPlatNomor.getText().toString().trim(),
                "Rp " + etHargaSewa.getText().toString().trim(),
                etTransmisi.getText().toString().trim(),
                "-",
                switchStatus.isChecked() ? "Tersedia" : "Tidak Tersedia",
                etDeskripsi.getText().toString().trim(),
                "-",
                etTerakhirServis.getText().toString().trim()
        );

        mobilRef.push().setValue(mobil)
                .addOnSuccessListener(unused -> {
                    Toast.makeText(getContext(),
                            "Mobil berhasil ditambahkan",
                            Toast.LENGTH_SHORT).show();
                    requireActivity().getSupportFragmentManager().popBackStack();
                });
    }
}
