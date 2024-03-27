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
import androidx.core.content.ContextCompat
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
        // Watches TODO TODO TODO
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
        profileParamsViewModel.form.observe(viewLifecycleOwner) { form ->
            universityEditText.setText(form.university)
            degreeEditText.setText(form.degree)
            academicYearEditText.setText(form.academicYear)
            specializationEditText.setText(form.specialization)
            cityEditText.setText(form.city)
        }
        // Add click listener to navigate to profile params
        setupButton(R.id.button_profile)
        return root
    }

    private fun setupButton(buttonId: Int) {
        // Get reference to the button
        val button = binding.root.findViewById<Button>(buttonId)
        button.setOnClickListener {
            // Change the button background to green when clicked
            button.setBackgroundResource(R.drawable.rounded_button_highlight)
            // After a delay, change the button background back to black
            Handler(Looper.getMainLooper()).postDelayed({
                button.setBackgroundResource(R.drawable.rounded_button)
                if (buttonId == R.id.button_profile) {
                    // If the profile button was clicked, navigate to the profile page
                    findNavController().navigate(R.id.navigation_profile)
                }
            }, 150)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onReturnClick() {
        findNavController().navigate(R.id.navigation_profile)
    }
}