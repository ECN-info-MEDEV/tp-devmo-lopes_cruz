package com.example.brainmatch.ui.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessagesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Sorry, this page is under maintenance.\nWe will be back shortly"
    }
    val text: LiveData<String> = _text
}