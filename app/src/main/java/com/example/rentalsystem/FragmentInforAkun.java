package com.example.rentalsystem;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Calendar;

public class FragmentInforAkun extends Fragment {

    private EditText etNama, etEmail, etPhone, etTanggalLahir, etAlamat;
    private Button btnSimpan;
    private ImageView btnBack;
    private FloatingActionButton btnGantiFoto; // Diubah ke FloatingActionButton sesuai XML

    public FragmentInforAkun() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_infor_akun, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Inisialisasi View Berdasarkan ID di XML Anda
        btnBack = view.findViewById(R.id.btnBack);
        btnGantiFoto = view.findViewById(R.id.btnFoto); // ID di XML: btnFoto

        etNama = view.findViewById(R.id.etNama); // ID di XML: etNama
        etEmail = view.findViewById(R.id.etEmail); // ID di XML: etEmail
        etPhone = view.findViewById(R.id.etPhone); // ID di XML: etPhone
        etTanggalLahir = view.findViewById(R.id.TanggalLahirEt); // ID di XML: TanggalLahirEt
        etAlamat = view.findViewById(R.id.alamatEt); // ID di XML: alamatEt

        btnSimpan = view.findViewById(R.id.btnSimpan); // ID di XML: btnSimpan

        // 2. Tombol Kembali
        btnBack.setOnClickListener(v -> {
            if (getParentFragmentManager() != null) {
                getParentFragmentManager().popBackStack();
            }
        });

        // 3. Fitur Pilih Tanggal (DatePicker)
        etTanggalLahir.setOnClickListener(v -> showDatePicker());

        // 4. Tombol Ganti Foto
        btnGantiFoto.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Membuka Galeri...", Toast.LENGTH_SHORT).show();
        });

        // 5. Tombol Simpan Perubahan
        btnSimpan.setOnClickListener(v -> {
            performSaveAction();
        });
    }

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                (view, year1, monthOfYear, dayOfMonth) -> {
                    // Format tanggal MM/DD/YYYY sesuai hint XML
                    String selectedDate = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year1;
                    etTanggalLahir.setText(selectedDate);
                }, year, month, day);
        datePickerDialog.show();
    }
    private void performSaveAction() {
        String nama = etNama.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (nama.isEmpty()) {
            etNama.setError("Nama tidak boleh kosong");
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email tidak boleh kosong");
            return;
        }
        // Simulasikan proses simpan
        Toast.makeText(getContext(), "Perubahan Berhasil Disimpan", Toast.LENGTH_SHORT).show();
    }
}