package com.example.rentalsystem;

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
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentInformasiAkun extends Fragment {

    private ImageView btnBack;
    private ShapeableImageView imgProfile;
    private FloatingActionButton btnFoto;
    private EditText etNama, etEmail, etPhone, etTanggalLahir, etAlamat;
    private Button btnSimpan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Ganti R.layout.fragment_informasi_akun dengan nama file XML Anda yang benar
        return inflater.inflate(R.layout.fragment_informasi_akun, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // INISIALISASI - Harus sama persis dengan ID di XML
        btnBack = view.findViewById(R.id.btnBack);
        imgProfile = view.findViewById(R.id.imgProfile);
        btnFoto = view.findViewById(R.id.btnFoto);
        etNama = view.findViewById(R.id.etNama);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etTanggalLahir = view.findViewById(R.id.TanggalLahirEt);
        etAlamat = view.findViewById(R.id.alamatEt);
        btnSimpan = view.findViewById(R.id.btnSimpan);

        // Mencegah Crash: Cek jika ada view yang tidak ditemukan
        if (etPhone == null || etAlamat == null || btnSimpan == null) {
            Toast.makeText(getContext(), "Error: Ada ID yang salah di XML!", Toast.LENGTH_LONG).show();
            return;
        }

        btnBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        btnSimpan.setOnClickListener(v -> {
            if (etNama.getText().toString().isEmpty()) {
                etNama.setError("Nama tidak boleh kosong");
            } else {
                Toast.makeText(getContext(), "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                getParentFragmentManager().popBackStack();
            }
        });
    }
}