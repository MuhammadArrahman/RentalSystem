package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class FragmentBookingDetail extends Fragment {

    private ImageView btnBack;
    private LinearLayout layoutOnline, layoutCash;
    private MaterialButton btnKonfirmasi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_detail, container, false);

        btnBack = view.findViewById(R.id.btnBack);
        layoutOnline = view.findViewById(R.id.layoutOnline);
        layoutCash = view.findViewById(R.id.layoutCash);
        btnKonfirmasi = view.findViewById(R.id.btnKonfirmasi);

        TextView tvMerk = view.findViewById(R.id.tvMerkMobilDetail);
        TextView tvTipe = view.findViewById(R.id.tvTipeMobilDetail);
        TextView tvHarga = view.findViewById(R.id.tvHargaMobilDetail);

        Bundle bundle = getArguments();
        if (bundle != null) {
            tvMerk.setText(bundle.getString("merk"));
            tvTipe.setText(bundle.getString("tipe"));
            tvHarga.setText(bundle.getString("harga"));
        }

        btnBack.setOnClickListener(v -> {
            if (getParentFragmentManager() != null) {
                getParentFragmentManager().popBackStack();
            }
        });

        setupPaymentSelection();

        btnKonfirmasi.setOnClickListener(v ->
                Toast.makeText(getContext(), "Pesanan Berhasil Dikonfirmasi!", Toast.LENGTH_SHORT).show()
        );

        return view;
    }

    private void setupPaymentSelection() {
        layoutOnline.setOnClickListener(v -> {
            layoutOnline.setBackgroundResource(R.drawable.bg_payment_selected);
            layoutCash.setBackgroundResource(R.drawable.bg_input_field);
        });

        layoutCash.setOnClickListener(v -> {
            layoutCash.setBackgroundResource(R.drawable.bg_payment_selected);
            layoutOnline.setBackgroundResource(R.drawable.bg_input_field);
        });
    }
}
