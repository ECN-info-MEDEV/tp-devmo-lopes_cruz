package com.example.brainmatch.ui.profileParams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileParamsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is profile parameters Fragment"
    }
    val text: LiveData<String> = _text
}