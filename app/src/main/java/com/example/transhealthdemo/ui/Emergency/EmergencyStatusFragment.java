package com.example.transhealthdemo.ui.Emergency;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.transhealthdemo.R;
import com.example.transhealthdemo.databinding.FragmentEmergencyRequestBinding;
import com.example.transhealthdemo.databinding.FragmentEmergencyStatusBinding;

public class EmergencyStatusFragment extends Fragment {
    //viewmodel
    SharedViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      FragmentEmergencyStatusBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_emergency_status, container, false);

        //initComponents and ui
        initComponents(binding.getRoot());

        binding.btnCancelCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: implement a dialog , ( are u sure u want to cancel
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_emergency_status_to_emergency_request);
            }
        });



        return binding.getRoot();
    }

    private void initComponents(View root) {
        viewModel= new SharedViewModel();
    }


}