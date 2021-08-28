package com.example.transhealthdemo.uiComponent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.transhealthdemo.R;


public class ConsultantCard extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_card, container, false);

        ImageView consultant_image =view.findViewById(R.id.img_consultant_passport);

        consultant_image.setImageResource(R.drawable.ic_passport);


        return view;
    }
}