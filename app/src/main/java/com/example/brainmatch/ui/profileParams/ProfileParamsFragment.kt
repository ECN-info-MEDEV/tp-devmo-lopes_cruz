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

        val textView: TextView = binding.textProfileParams
        profileParamsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}