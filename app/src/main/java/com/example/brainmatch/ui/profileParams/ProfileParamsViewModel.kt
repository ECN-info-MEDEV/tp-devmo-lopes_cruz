package com.example.brainmatch.ui.profileParams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileParamsViewModel : ViewModel() {
    private val _form = MutableLiveData(Form())
    val form: LiveData<Form> get() = _form

    fun updateForm(university: String, degree: String, academicYear: String, specialization: String, city: String) {
        _form.value = Form(university, degree, academicYear, specialization, city)
    }
}