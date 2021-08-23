package com.example.transhealthdemo.ui.fitness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.transhealthdemo.R;

public class FitnessFragment extends Fragment {

    View root;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fitness_fragment, container, false);
        final TextView textView = root.findViewById(R.id.fitness_text);
        return root;
    }

}