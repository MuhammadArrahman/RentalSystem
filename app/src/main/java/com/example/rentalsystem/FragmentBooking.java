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

public class FragmentBooking extends Fragment {

    private TextView tabPending, tabBerjalan, tabSelesai;
    private RecyclerView rvBooking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // FIX: Gunakan layout fragment_booking yang baru
        View view = inflater.inflate(R.layout.booking_item, container, false);

        // Inisialisasi View
        tabPending = view.findViewById(R.id.tabPending);
        tabBerjalan = view.findViewById(R.id.tabBerjalan);
        tabSelesai = view.findViewById(R.id.tabSelesai);
        rvBooking = view.findViewById(R.id.rvBooking);

        // Setup RecyclerView
        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));

        // Logika Klik Tab
        tabPending.setOnClickListener(v -> switchTab(tabPending));
        tabBerjalan.setOnClickListener(v -> switchTab(tabBerjalan));
        tabSelesai.setOnClickListener(v -> switchTab(tabSelesai));

        return view;
    }

    private void switchTab(TextView selectedTab) {
        resetTabStyles(tabPending);
        resetTabStyles(tabBerjalan);
        resetTabStyles(tabSelesai);

        selectedTab.setBackgroundResource(R.drawable.bg_tab_active);
        selectedTab.setTextColor(Color.parseColor("#175CD3"));
        selectedTab.setTypeface(null, Typeface.BOLD);

        // Di sini Anda bisa memanggil data dari API/Database berdasarkan status
    }

    private void resetTabStyles(TextView textView) {
        textView.setBackground(null);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setTypeface(null, Typeface.NORMAL);
    }
}