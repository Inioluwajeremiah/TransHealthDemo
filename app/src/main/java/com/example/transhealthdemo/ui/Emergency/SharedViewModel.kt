package com.example.transhealthdemo.ui.Emergency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transhealthdemo.data.Emergency


class SharedViewModel :ViewModel(){

    private var emergency: MutableLiveData<Emergency>? = null
    fun getEmergency(): LiveData<Emergency>? {
        if (emergency == null) {
            emergency = MutableLiveData<Emergency>()
            loadUsers()
        }
        return emergency
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }








}