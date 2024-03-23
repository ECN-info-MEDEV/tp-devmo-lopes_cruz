package com.example.brainmatch.ui.profileParams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.TextWatcher
import android.text.Editable
import androidx.fragment.app.Fragment
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.brainmatch.databinding.FragmentProfileParamsBinding

class ProfileParamsFragment : Fragment() {

    private var _binding: FragmentProfileParamsBinding? = null
    private lateinit var profileParamsViewModel: ProfileParamsViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Declare the EditTexts
    private lateinit var universityEditText: EditText
    private lateinit var degreeEditText: EditText
    private lateinit var academicYearEditText: EditText
    private lateinit var specializationEditText: EditText
    private lateinit var cityEditText: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileParamsViewModel =
            ViewModelProvider(this).get(ProfileParamsViewModel::class.java)

        _binding = FragmentProfileParamsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize the EditTexts
        universityEditText = binding.universityEditText
        degreeEditText = binding.degreeEditText
        academicYearEditText = binding.academicYearEditText
        specializationEditText = binding.specializationEditText
        cityEditText = binding.cityEditText

        // Add TextWatchers to the EditTexts
        universityEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                profileParamsViewModel.updateUniversity(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No action needed here
            }
        })
        degreeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                profileParamsViewModel.updateDegree(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No action needed here
            }
        })
        academicYearEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                profileParamsViewModel.updateAcademicYear(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No action needed here
            }
        })
        specializationEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                profileParamsViewModel.updateSpecialization(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No action needed here
            }
        })
        cityEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                profileParamsViewModel.updateCity(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No action needed here
            }
        })

        // Observe changes in the form data
        profileParamsViewModel.form.observe(viewLifecycleOwner) { form ->
            universityEditText.setText(form.university)
            degreeEditText.setText(form.degree)
            academicYearEditText.setText(form.academicYear)
            specializationEditText.setText(form.specialization)
            cityEditText.setText(form.city)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}