package com.example.brainmatch.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.brainmatch.R

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is profile main page"
    }
    val text: LiveData<String> = _text

    fun onProfileParamsClick(navController: NavController) {
        navController.navigate(R.id.navigation_profile_params)
    }
}