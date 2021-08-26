    package com.example.transhealthdemo.ui.Emergency;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.transhealthdemo.R;
import com.example.transhealthdemo.databinding.FragmentEmergencyRequestBinding;

public class EmergencyRequest extends Fragment {



    //ui widgets
    Spinner spinner_health_issue;
    EditText edt_health_issue_desc;
    Button btn_call_ambulance;
    TextView tv_call_consultant;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentEmergencyRequestBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_emergency__request, container, false);
        SharedViewModel viewModel = new ViewModelProvider(this).get(SharedViewModel.class);


        //init ui

        spinner_health_issue = binding.spinnerHealthIssue ;
        edt_health_issue_desc = binding.edtDesc ;
        btn_call_ambulance = binding.btnCallAnAmbulance ;
        tv_call_consultant = binding.tvMeetAConsultant ;




        //Populating the Health issue spinner
        implementSpinner(spinner_health_issue);




        viewModel.getEmergency().observe(getViewLifecycleOwner(), users -> {
            // update UI
        });

        btn_call_ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_emergency_request_to_emergency_status);
            }
        });
        tv_call_consultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_emergency_request_to_consultation);
            }
        });


        return binding.getRoot();
    }



    //Implement Spinner
    void implementSpinner(Spinner spinner){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.health_issues_text, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    //call a consultant
    void callConsultant(){


    }
}