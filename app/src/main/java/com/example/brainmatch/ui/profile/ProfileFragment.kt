package com.example.brainmatch.ui.profile

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.brainmatch.R
import com.example.brainmatch.databinding.FragmentProfileBinding
import androidx.navigation.fragment.findNavController
import android.content.Intent

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    // Binding variable : accessing views in the layout
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    // Method called when the view is created
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textProfile
        profileViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        // Setup buttons with their respective IDs
        setupButton(R.id.button_profile_params, R.id.button_icon_1, R.id.button_text_1)
        setupButton(R.id.button_share, R.id.button_icon_2, R.id.button_text_2)
        setupButton(R.id.button_useless_1, R.id.button_icon_3, R.id.button_text_3)
        setupButton(R.id.button_useless_2, R.id.button_icon_4, R.id.button_text_4)
        return root
    }

    private fun setupButton(buttonId: Int, iconId: Int, textId: Int) {
        val button = binding.root.findViewById<LinearLayout>(buttonId)
        val icon = button.findViewById<ImageView>(iconId)
        val text = button.findViewById<TextView>(textId)
        button.setOnClickListener {
            text.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            icon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            // After a delay, change the text color and icon color back to the original color
            Handler(Looper.getMainLooper()).postDelayed({
                text.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                icon.clearColorFilter()
                if (buttonId == R.id.button_profile_params) {
                    // If the profile params button was clicked, navigate to the profile params page
                    profileViewModel.onProfileParamsClick(findNavController())
                } else if (buttonId == R.id.button_share) {
                    // If the share button was clicked, create and start a share intent
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Hey! Join me on BrainMatch. My username is @user123. \n\n Download the app now: https://www.brainmatch.com")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    startActivity(shareIntent)
                }
            }, 150)
        }
    }
    // Override onDestroyView method which is called when the fragment's view is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}