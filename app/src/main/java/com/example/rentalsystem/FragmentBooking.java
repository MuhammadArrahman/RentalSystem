package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.adapter.MobilAdapter;
import com.example.rentalsystem.model.MobilModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentBooking extends Fragment {

    private RecyclerView rvBooking;
    private List<MobilModel> mobilList = new ArrayList<>();
    private List<String> keyList = new ArrayList<>();
    private MobilAdapter adapter;
    private DatabaseReference mobilRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_fragment, container, false);

        rvBooking = view.findViewById(R.id.rvBooking);
        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MobilAdapter(mobilList, keyList, (mobil, key) -> {
            // Kirim data ke FragmentBookingDetail
            Bundle bundle = new Bundle();
            bundle.putString("merk", mobil.getMerk());
            bundle.putString("tipe", mobil.getTipe());
            bundle.putString("plat", mobil.getPlat());
            bundle.putString("harga", mobil.getHarga());
            bundle.putString("status", mobil.getStatus());

            FragmentBookingDetail detailFragment = new FragmentBookingDetail();
            detailFragment.setArguments(bundle);

            if (getParentFragmentManager() != null) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        rvBooking.setAdapter(adapter);

        mobilRef = FirebaseDatabase.getInstance().getReference("armada");
        loadData();

        return view;
    }

    private void loadData() {
        mobilRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mobilList.clear();
                keyList.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    MobilModel mobil = ds.getValue(MobilModel.class);
                    if (mobil != null) {
                        mobilList.add(mobil);
                        keyList.add(ds.getKey());
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Gagal memuat data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
