package com.example.brainmatch.ui.profileParams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.brainmatch.databinding.FragmentProfileParamsBinding

class ProfileParamsFragment : Fragment() {

    private var _binding: FragmentProfileParamsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileParamsViewModel =
            ViewModelProvider(this).get(ProfileParamsViewModel::class.java)

        _binding = FragmentProfileParamsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Get references to the EditTexts
        val universityEditText = binding.universityEditText
        val degreeEditText = binding.degreeEditText
        val academicYearEditText = binding.academicYearEditText
        val specializationEditText = binding.specializationEditText
        val cityEditText = binding.cityEditText

        // Observe changes in the form data
        profileParamsViewModel.form.observe(viewLifecycleOwner) { form ->
            // Update UI elements with the new form data
            binding.universityLabel.text = form.university
            binding.degreeLabel.text = form.degree
            binding.academicYearLabel.text = form.academicYear
            binding.specializationLabel.text = form.specialization
            binding.cityLabel.text = form.city
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}