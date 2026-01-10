package com.example.rentalsystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.adapter.DashboardAdapter;
import com.example.rentalsystem.model.DashboardModel;
import java.util.ArrayList;
import java.util.List;

public class FragmentDashboard extends Fragment {

    private RecyclerView rvDashboard;
    private DashboardAdapter adapter;
    private List<DashboardModel> listMobil;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_booking, container, false);

        rvDashboard = view.findViewById(R.id.rvDashboard);
        rvDashboard.setLayoutManager(new LinearLayoutManager(getContext()));

        listMobil = new ArrayList<>();
        listMobil.add(new DashboardModel("Honda Civic RS", "Automatic", "5 Kursi", "Rp 450rb", R.drawable.Porsche));
        listMobil.add(new DashboardModel("Tesla Model 3", "Automatic", "Electric", "Rp 1.2jt", R.drawable.Porsche));
        listMobil.add(new DashboardModel("Toyota Rush", "Manual", "7 Kursi", "Rp 350rb", R.drawable.Porsche));
        listMobil.add(new DashboardModel("Mitsubishi Pajero", "Automatic", "Diesel", "Rp 650rb", R.drawable.Porsche));

        adapter = new DashboardAdapter(listMobil);
        rvDashboard.setAdapter(adapter);

        return view;
    }
}