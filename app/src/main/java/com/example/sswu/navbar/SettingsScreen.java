package com.example.sswu.navbar;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

public  class SettingsScreen extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_screen);
        SwitchPreference switchPreference = (SwitchPreference) findPreference("switch_active");
        switchPreference.setEnabled(false);
    }
}