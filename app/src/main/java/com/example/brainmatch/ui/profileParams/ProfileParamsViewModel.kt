package com.example.brainmatch.ui.profileParams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileParamsViewModel : ViewModel() {
    private val _form = MutableLiveData(Form())
    val form: LiveData<Form> get() = _form

    fun updateUniversity(university: String) {
        _form.value = _form.value?.copy(university = university)
    }

    fun updateDegree(degree: String) {
        _form.value = _form.value?.copy(degree = degree)
    }

    fun updateAcademicYear(academicYear: String) {
        _form.value = _form.value?.copy(academicYear = academicYear)
    }

    fun updateSpecialization(specialization: String) {
        _form.value = _form.value?.copy(specialization = specialization)
    }

    fun updateCity(city: String) {
        _form.value = _form.value?.copy(city = city)
    }
    fun updateForm(university: String, degree: String, academicYear: String, specialization: String, city: String) {
        _form.value = Form(university, degree, academicYear, specialization, city)
    }
}