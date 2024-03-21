package com.example.brainmatch.ui.profileParams

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileParamsViewModel : ViewModel() {
    private val _form = MutableLiveData<Form>()
    val form: MutableLiveData<Form>
        get() = _form

    init {
        _form.value = Form("", "", "", "", "")
    }

    fun updateForm(university: String, degree: String, academicYear: String, specialization: String, city: String) {
        _form.value = Form(university, degree, academicYear, specialization, city)
    }
}