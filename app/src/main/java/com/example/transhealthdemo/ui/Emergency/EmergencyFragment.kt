package com.example.transhealthdemo.ui.Emergency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.transhealthdemo.R

class EmergencyFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // navController = findNavController( R.id.emergency_navHost)



        return inflater.inflate(R.layout.fragment_emergency, container, false)
    }
}