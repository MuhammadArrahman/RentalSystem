package com.example.rentalsystem;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class FragmentKtpUser extends Fragment {

    private CardView btnUploadKtp, btnUploadSelfie;
    private Button btnKirim;
    private ImageView btnBack;

    // Variabel untuk menyimpan URI gambar yang dipilih
    private Uri uriKtp, uriSelfie;

    // Flag untuk menentukan tombol mana yang sedang diklik
    private boolean isKtpSelected = true;

    public FragmentKtpUser() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout fragment_ktp_user
        return inflater.inflate(R.layout.fragment_ktp_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Inisialisasi View berdasarkan ID di XML
        btnBack = view.findViewById(R.id.btnBack);
        btnUploadKtp = view.findViewById(R.id.btnUploadKtp); // Sesuai XML
        btnUploadSelfie = view.findViewById(R.id.btnUploadSelfie); // Sesuai XML
        btnKirim = view.findViewById(R.id.btnKirimVerifikasi); // Sesuai XML

        // 2. Register Activity Result untuk Galeri
        ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        if (isKtpSelected) {
                            uriKtp = imageUri;
                            Toast.makeText(getContext(), "Foto KTP Berhasil Dipilih", Toast.LENGTH_SHORT).show();
                        } else {
                            uriSelfie = imageUri;
                            Toast.makeText(getContext(), "Foto Selfie Berhasil Dipilih", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        // 3. Logika Klik
        btnBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        btnUploadKtp.setOnClickListener(v -> {
            isKtpSelected = true;
            openGallery(galleryLauncher);
        });

        btnUploadSelfie.setOnClickListener(v -> {
            isKtpSelected = false;
            openGallery(galleryLauncher);
        });

        btnKirim.setOnClickListener(v -> {
            validateAndSend();
        });
    }

    private void openGallery(ActivityResultLauncher<Intent> launcher) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        launcher.launch(intent);
    }

    private void validateAndSend() {
        if (uriKtp == null) {
            Toast.makeText(getContext(), "Harap unggah foto KTP asli", Toast.LENGTH_SHORT).show();
            return;
        }
        if (uriSelfie == null) {
            Toast.makeText(getContext(), "Harap unggah foto selfie dengan KTP", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tampilkan loading
        btnKirim.setEnabled(false);
        btnKirim.setText("Mengirim...");

        // Simulasi pengiriman data
        btnKirim.postDelayed(() -> {
            if (isAdded()) { // Cek apakah fragment masih menempel
                Toast.makeText(getContext(), "Data Verifikasi Berhasil Dikirim!", Toast.LENGTH_LONG).show();
                getParentFragmentManager().popBackStack();
            }
        }, 2000);
    }
}