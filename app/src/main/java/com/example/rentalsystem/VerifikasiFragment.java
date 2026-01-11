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

import com.example.rentalsystem.adapter.VerifikasiAdapter;
import com.example.rentalsystem.model.VerifikasiModel;

import java.util.ArrayList;
import java.util.List;

public class VerifikasiFragment extends Fragment {

    public static VerifikasiFragment newInstance(String status) {
        VerifikasiFragment fragment = new VerifikasiFragment();
        Bundle args = new Bundle();
        args.putString("STATUS_KEY", status);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_verifikasi, container, false);

        // Default status
        String status = "Menunggu";
        if (getArguments() != null) {
            status = getArguments().getString("STATUS_KEY", "Menunggu");
        }

        RecyclerView rv = view.findViewById(R.id.rvVerifikasiList);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new VerifikasiAdapter(generateData(status)));

        return view;
    }

    private List<VerifikasiModel> generateData(String filter) {
        List<VerifikasiModel> data = new ArrayList<>();

        if ("Menunggu".equals(filter)) {
            data.add(new VerifikasiModel(
                    "Budi Santoso",
                    "3201123456780001",
                    "2 jam lalu",
                    "12-05-1990",
                    "Kawin",
                    R.drawable.sample_ktp
            ));
            data.add(new VerifikasiModel(
                    "Siti Aminah",
                    "3174123456780002",
                    "5 jam lalu",
                    "20-08-1995",
                    "Belum Kawin",
                    R.drawable.sample_ktp
            ));
        }

        return data;
    }
}
