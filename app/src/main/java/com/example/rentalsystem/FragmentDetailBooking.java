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
import com.example.rentalsystem.adapter.BookingAdapter;
import com.example.rentalsystem.model.BookingModel;
import java.util.ArrayList;
import java.util.List;

public class FragmentDetailBooking extends Fragment {
    private TextView tabPending, tabBerjalan, tabSelesai;
    private RecyclerView rvBooking;
    private List<BookingModel> listData;
    private BookingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Pastikan nama layout ini adalah layout yang berisi tab dan recyclerview
        View view = inflater.inflate(R.layout.item_booking, container, false);

        tabPending = view.findViewById(R.id.tabPending);
        tabBerjalan = view.findViewById(R.id.tabBerjalan);
        tabSelesai = view.findViewById(R.id.tabSelesai);
        rvBooking = view.findViewById(R.id.rvBooking);

        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));
        listData = new ArrayList<>();

        // Default: Tampilkan Pending
        updateTabUI(tabPending);
        showPendingData();

        tabPending.setOnClickListener(v -> { updateTabUI(tabPending); showPendingData(); });
        tabBerjalan.setOnClickListener(v -> { updateTabUI(tabBerjalan); showBerjalanData(); });
        tabSelesai.setOnClickListener(v -> { updateTabUI(tabSelesai); showSelesaiData(); });

        return view;
    }

    private void showPendingData() {
        listData.clear();
        // Parameter: namaUser, id, status, mobil, plat, tgl, durasi, harga, gambar
        listData.add(new BookingModel("Budi Santoso", "#BK-2023001", "Pending", "Toyota Avanza Veloz", "B 1923 UOD • Hitam", "20 Nov - 22 Nov 2023", "2 Hari", "Rp 900.000", R.drawable.ic_placeholder));
        refreshAdapter();
    }

    private void showBerjalanData() {
        listData.clear();
        listData.add(new BookingModel("Siti Aminah", "#BK-2023014", "Sedang Sewa", "Innova Zenix Hybrid", "D 5678 ABC • Putih", "18 Nov - 19 Nov 2023", "1 Hari", "Rp 650.000", R.drawable.ic_placeholder));
        refreshAdapter();
    }

    private void showSelesaiData() {
        listData.clear();
        listData.add(new BookingModel("Andi Pratama", "#BK-2023005", "Selesai", "Honda Brio RS", "F 9012 DEF • Kuning", "10 Nov - 12 Nov 2023", "2 Hari", "Rp 400.000", R.drawable.ic_placeholder));
        refreshAdapter();
    }

    private void refreshAdapter() {
        adapter = new BookingAdapter(listData);
        rvBooking.setAdapter(adapter);
    }

    private void updateTabUI(TextView activeTab) {
        TextView[] tabs = {tabPending, tabBerjalan, tabSelesai};
        for (TextView t : tabs) {
            t.setBackgroundColor(Color.TRANSPARENT);
            t.setTextColor(Color.parseColor("#666666"));
            t.setTypeface(null, Typeface.NORMAL);
        }
        activeTab.setBackgroundResource(R.drawable.bg_tab_active); // Buat file ini di drawable
        activeTab.setTextColor(Color.parseColor("#175CD3"));
        activeTab.setTypeface(null, Typeface.BOLD);
    }
}