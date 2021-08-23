package com.example.transhealthdemo.ui.healthplug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transhealthdemo.R;

public class HealthplugFragment extends Fragment {

    View view;
    RecyclerView hp_recview;

    HealthPlugAdapter healthPlugAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_healthplug, container, false);
        hp_recview = view.findViewById(R.id.healthplug_rec);
        hp_recview .setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        healthPlugAdapter = new HealthPlugAdapter(getContext());
        hp_recview.setAdapter(healthPlugAdapter);
        return view;
    }
}