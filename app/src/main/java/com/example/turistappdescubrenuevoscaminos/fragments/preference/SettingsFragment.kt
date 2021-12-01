package com.example.turistappdescubrenuevoscaminos.fragments.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.turistappdescubrenuevoscaminos.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}