package com.example.transhealthdemo.ui.diet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transhealthdemo.R;
import com.example.transhealthdemo.ui.healthplug.HealthPlugAdapter;

public class DietFragment extends Fragment {

    View view;
    RecyclerView diet_recview;
    DietRecAdapter dietRecAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_diet, container, false);
        diet_recview = view.findViewById(R.id.diet_rec);
        diet_recview.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        dietRecAdapter = new DietRecAdapter(getContext());
        diet_recview.setAdapter(dietRecAdapter);
        return view;
    }
}