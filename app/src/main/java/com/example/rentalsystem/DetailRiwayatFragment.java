package com.example.rentalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailRiwayatFragment extends Fragment {

    private LayoutInflater inflater;
    @Nullable
    private ViewGroup container;
    @Nullable
    private Bundle savedInstanceState;

    @Nullable
    public View onCreateView(
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return onCreateView(null, container, savedInstanceState);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        return onCreateView(inflater, null, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;

        return inflater.inflate(
                R.layout.fragment_detail_riwayat,
                container,
                false
        );
    }
}
