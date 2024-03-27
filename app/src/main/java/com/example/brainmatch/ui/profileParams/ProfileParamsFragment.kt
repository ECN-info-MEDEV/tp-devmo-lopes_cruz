package com.example.brainmatch.ui.profileParams

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.TextWatcher
import android.text.Editable
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.brainmatch.R
import com.example.brainmatch.databinding.FragmentProfileParamsBinding

class ProfileParamsFragment : Fragment() {
    private var _binding: FragmentProfileParamsBinding? = null

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
        val profileParamsViewModel = ViewModelProvider(requireActivity()).get(ProfileParamsViewModel::class.java)

        _binding = FragmentProfileParamsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize the EditTexts
        universityEditText = binding.universityEditText
        degreeEditText = binding.degreeEditText
        academicYearEditText = binding.academicYearEditText
        specializationEditText = binding.specializationEditText
        cityEditText = binding.cityEditText

        val formTextWatcher = object : TextWatcher {
            var oldText: String = ""

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                oldText = s.toString()
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // This space intentionally left blank
            }

            override fun afterTextChanged(s: Editable) {
                if (oldText != s.toString()) {
                    profileParamsViewModel.updateForm(
                        universityEditText.text.toString(),
                        degreeEditText.text.toString(),
                        academicYearEditText.text.toString(),
                        specializationEditText.text.toString(),
                        cityEditText.text.toString()
                    )
                }
            }
        }

        // Add the FormTextWatcher to each EditText
        universityEditText.addTextChangedListener(formTextWatcher)
        degreeEditText.addTextChangedListener(formTextWatcher)
        academicYearEditText.addTextChangedListener(formTextWatcher)
        specializationEditText.addTextChangedListener(formTextWatcher)
        cityEditText.addTextChangedListener(formTextWatcher)

        // Observe changes in the form data
        // ONLY if they have changed so the cursor move with the text
        profileParamsViewModel.form.observe(viewLifecycleOwner) { form ->
            if (universityEditText.text.toString() != form.university) {
                universityEditText.setText(form.university)
            }
            if (degreeEditText.text.toString() != form.degree) {
                degreeEditText.setText(form.degree)
            }
            if (academicYearEditText.text.toString() != form.academicYear) {
                academicYearEditText.setText(form.academicYear)
            }
            if (specializationEditText.text.toString() != form.specialization) {
                specializationEditText.setText(form.specialization)
            }
            if (cityEditText.text.toString() != form.city) {
                cityEditText.setText(form.city)
            }
        }
        // Add click listener to navigate to profile params
        binding.buttonProfile.setOnClickListener { view ->
            setupButton()
            onReturnClick()
        }
        return root
    }

    private fun setupButton() {
        val buttonId = R.id.button_profile
        val button = binding.root.findViewById<Button>(buttonId)
        button.setBackgroundResource(R.drawable.rounded_button_highlight)
        Handler(Looper.getMainLooper()).postDelayed({
            button.setBackgroundResource(R.drawable.rounded_button)
        }, 150)
    }

    private fun onReturnClick() {
        findNavController().navigate(R.id.navigation_profile)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
