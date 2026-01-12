package com.example.rentalsystem;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rentalsystem.model.MobilModel;
import com.google.firebase.database.*;

public class FragmentEditMobil extends Fragment {

    private static final String ARG_KEY = "key_mobil";

    private EditText etNamaMobil, etMerk, etTipe, etPlat, etHarga;
    private EditText etTahun, etTransmisi, etDeskripsi, etTerakhirServis;
    private Switch switchStatus;
    private Button btnSimpan;
    private ImageView btnBack;

    private DatabaseReference mobilRef;
    private String keyMobil;

    public static FragmentEditMobil newInstance(String keyMobil) {
        FragmentEditMobil fragment = new FragmentEditMobil();
        Bundle args = new Bundle();
        args.putString(ARG_KEY, keyMobil);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_mobil, container, false);

        if (getArguments() == null) return view;
        keyMobil = getArguments().getString(ARG_KEY);

        mobilRef = FirebaseDatabase.getInstance().getReference("armada").child(keyMobil);

        // Init View
        btnBack = view.findViewById(R.id.btnBack);
        btnSimpan = view.findViewById(R.id.btnSimpan);
        switchStatus = view.findViewById(R.id.switchStatus);

        etNamaMobil = view.findViewById(R.id.etNamaMobil);
        etMerk = view.findViewById(R.id.etMerek);
        etTipe = view.findViewById(R.id.etModel);
        etPlat = view.findViewById(R.id.etPlatNomor);
        etHarga = view.findViewById(R.id.etHargaSewa);
        etTahun = view.findViewById(R.id.etTahun);
        etTransmisi = view.findViewById(R.id.etTransmisi);
        etDeskripsi = view.findViewById(R.id.etDeskripsi);
        etTerakhirServis = view.findViewById(R.id.etTerakhirServis);

        btnBack.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack()
        );

        btnSimpan.setOnClickListener(v -> simpanPerubahan());

        ambilDataDariFirebase();

        return view;
    }

    private void ambilDataDariFirebase() {
        mobilRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MobilModel mobil = snapshot.getValue(MobilModel.class);
                if (mobil == null) return;

                etNamaMobil.setText(mobil.getMerk());
                etMerk.setText(mobil.getMerk());
                etTipe.setText(mobil.getTipe());
                etPlat.setText(mobil.getPlat());
                etHarga.setText(mobil.getHarga() != null ? mobil.getHarga().replace("Rp ", "") : "");
                etTransmisi.setText(mobil.getTransmisi());
                etDeskripsi.setText(mobil.getDeskripsi());
                etTerakhirServis.setText(mobil.getInfoLainnya());
                etTahun.setText(""); // tambahkan jika ada field tahun

                switchStatus.setChecked("Tersedia".equalsIgnoreCase(mobil.getStatus()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void simpanPerubahan() {

        String merk = etMerk.getText().toString().trim();
        String tipe = etTipe.getText().toString().trim();
        String plat = etPlat.getText().toString().trim();
        String harga = etHarga.getText().toString().trim();
        String transmisi = etTransmisi.getText().toString().trim();
        String deskripsi = etDeskripsi.getText().toString().trim();
        String infoLainnya = etTerakhirServis.getText().toString().trim();
        String status = switchStatus.isChecked() ? "Tersedia" : "Tidak Tersedia";

        if (TextUtils.isEmpty(merk) || TextUtils.isEmpty(tipe) ||
                TextUtils.isEmpty(plat) || TextUtils.isEmpty(harga)) {
            Toast.makeText(getContext(), "Mohon lengkapi data utama", Toast.LENGTH_SHORT).show();
            return;
        }

        MobilModel mobil = new MobilModel(
                merk,
                tipe,
                plat,
                "Rp " + harga,
                transmisi,
                "", // BBM bisa ditambahkan
                status,
                deskripsi,
                infoLainnya,
                infoLainnya
        );

        mobilRef.setValue(mobil)
                .addOnSuccessListener(unused -> {
                    Toast.makeText(getContext(), "Data berhasil diperbarui", Toast.LENGTH_SHORT).show();
                    requireActivity().getSupportFragmentManager().popBackStack();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show()
                );
    }
}
