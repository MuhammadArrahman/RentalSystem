package com.example.rentalsystem;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Calendar;
import java.util.Locale;

public class FragmentEditMobil extends Fragment {

    private EditText etNama, etMerek, etModel, etPlat, etHarga, etTahun, etTransmisi, etDeskripsi, etServis;
    private Button btnSimpan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_mobil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi View - Informasi Utama
        etNama = view.findViewById(R.id.etNamaMobil);
        etMerek = view.findViewById(R.id.etMerek);
        etModel = view.findViewById(R.id.etModel);
        etPlat = view.findViewById(R.id.etPlatNomor);
        etHarga = view.findViewById(R.id.etHargaSewa);

        // Inisialisasi View - Spesifikasi & Detail
        etTahun = view.findViewById(R.id.etTahun);
        etTransmisi = view.findViewById(R.id.etTransmisi);
        etDeskripsi = view.findViewById(R.id.etDeskripsi);
        etServis = view.findViewById(R.id.etTerakhirServis);

        btnSimpan = view.findViewById(R.id.btnSimpan);

        // Aksi klik kalender untuk Terakhir Servis
        etServis.setOnClickListener(v -> showDatePicker());

        btnSimpan.setOnClickListener(v -> {
            // Logika simpan data
            String namaMobil = etNama.getText().toString();
            if (namaMobil.isEmpty()) {
                etNama.setError("Nama mobil harus diisi");
            } else {
                Toast.makeText(getActivity(), "Data " + namaMobil + " berhasil diperbarui", Toast.LENGTH_SHORT).show();
            }
        });

        // Tombol Back
        view.findViewById(R.id.btnBack).setOnClickListener(v -> requireActivity().onBackPressed());
    }

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                (view, year1, monthOfYear, dayOfMonth) -> {
                    // Format tanggal DD/MM/YYYY
                    String date = String.format(Locale.getDefault(), "%02d/%02d/%d", dayOfMonth, (monthOfYear + 1), year1);
                    etServis.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }
}