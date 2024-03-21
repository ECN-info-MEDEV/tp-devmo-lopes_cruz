package com.example.brainmatch.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Sorry,\nthis page is under maintenance.\nWe will be back shortly"
    }
    val text: LiveData<String> = _text
}