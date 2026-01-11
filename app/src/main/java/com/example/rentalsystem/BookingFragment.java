package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.adapter.AdapterBooking;
import com.example.rentalsystem.model.BookingModel;
import java.util.ArrayList;
import java.util.List;

public class BookingFragment extends Fragment {
    private RecyclerView rvBooking;
    private List<BookingModel> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. INFLATE layout yang baru saja Anda kirim (yang ada rvBooking-nya)
        View view = inflater.inflate(R.layout.item_booking, container, false);

        // 2. Inisialisasi RecyclerView (Sekarang tidak akan NULL)
        rvBooking = view.findViewById(R.id.rvBooking);

        // 3. Pasang LayoutManager (Wajib agar list muncul)
        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
