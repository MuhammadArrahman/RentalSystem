package com.example.rentalsystem;

import static java.security.AccessController.getContext;

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
import java.util.Collections;
import java.util.List;

public class BookingFragment extends Fragment {
    private RecyclerView rvBooking;
    private List<BookingModel> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_item, container, false);

        rvBooking = view.findViewById(R.id.rvBooking);
        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        list.add(new BookingModel("MPV LUXURY", "Modern Hybrid Series", "Rp 850k", "7 Kursi", "Matic", "Hybrid", R.drawable.por));
        list.add(new BookingModel("EV FUTURE", "Electric Compact", "Rp 1.2jt", "5 Kursi", "Elektrik", "451 Km", R.drawable.por));
        list.add(new BookingModel("SPORT SEDAN", "M Performance Edition", "Rp 2.5jt", "5 Kursi", "Matic", "Pertalite", R.drawable.por));

        rvBooking.setAdapter(new AdapterBooking(Collections.singletonList((BookingModel) list)));
        return view;
    }
}