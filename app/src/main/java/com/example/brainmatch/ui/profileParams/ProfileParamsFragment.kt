package com.example.brainmatch.ui.profileParams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.brainmatch.R
import com.example.brainmatch.databinding.FragmentProfileParamsBinding

class ProfileParamsFragment : Fragment() {
    private var _binding: FragmentProfileParamsBinding? = null
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

        val textView: TextView = binding.textProfileParams
        profileParamsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        // Add click listener to navigate to profile params
        binding.buttonProfile.setOnClickListener { view ->
            onReturnClick(view)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onReturnClick(view: View) {
        findNavController().navigate(R.id.navigation_profile)
    }
}