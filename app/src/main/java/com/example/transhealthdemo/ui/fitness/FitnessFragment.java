package com.example.transhealthdemo.ui.fitness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transhealthdemo.R;
import com.example.transhealthdemo.ui.diet.DietRecAdapter;

public class FitnessFragment extends Fragment {

    View root;
    RecyclerView fit_recyclerView;
    FitnessAdapter fitnessAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fitness_fragment, container, false);

        fit_recyclerView = root.findViewById(R.id.fit_rec);
        fitnessAdapter = new FitnessAdapter(getContext());
        fit_recyclerView.setLayoutManager(new GridLayoutManager(root.getContext(), 3));
        fit_recyclerView.setAdapter(fitnessAdapter);
        return root;
    }



}