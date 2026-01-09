package com.example.rentalsystem;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import java.util.ArrayList;

public class FragmentBooking extends Fragment {

    private TextView tabPending, tabBerjalan, tabSelesai;
    private RecyclerView rvBooking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_booking, container, false);

        // Inisialisasi View
        tabPending = view.findViewById(R.id.tabPending);
        tabBerjalan = view.findViewById(R.id.tabBerjalan);
        tabSelesai = view.findViewById(R.id.tabSelesai);
        rvBooking = view.findViewById(R.id.rvBooking);

        // Setup RecyclerView
        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));
        // Setup Adapter Anda di sini...

        // Logika Klik Tab
        tabPending.setOnClickListener(v -> switchTab(tabPending));
        tabBerjalan.setOnClickListener(v -> switchTab(tabBerjalan));
        tabSelesai.setOnClickListener(v -> switchTab(tabSelesai));

        return view;
    }

    private void switchTab(TextView selectedTab) {
        // Reset semua tab ke gaya default (tidak aktif)
        resetTabStyles(tabPending);
        resetTabStyles(tabBerjalan);
        resetTabStyles(tabSelesai);

        // Set tab yang diklik menjadi aktif
        selectedTab.setBackgroundResource(R.drawable.bg_tab_active);
        selectedTab.setTextColor(Color.parseColor("#175CD3"));
        selectedTab.setTypeface(null, Typeface.BOLD);

        // Contoh: Panggil data berbeda berdasarkan tab
        // updateListData(selectedTab.getText().toString());
    }

    private void resetTabStyles(TextView textView) {
        textView.setBackground(null);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setTypeface(null, Typeface.NORMAL);
    }
}