package com.example.skypals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatDelegate

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        // Find the Switch button in the fragment's layout
        val switchDarkMode: Switch = view.findViewById(R.id.switchDarkMode)

        // Set an initial checked state based on the current theme
        switchDarkMode.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Handle dark mode switching
        switchDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            val nightMode = if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(nightMode)
            requireActivity().recreate() // Restart the activity to apply the new theme.
        }

        return view
    }
}