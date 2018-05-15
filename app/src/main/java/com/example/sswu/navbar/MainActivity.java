package com.example.sswu.navbar;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout) findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        /*Fragment fragment = new SettingsScreen();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.dl, fragment, "settings_fragment");
            fragmentTransaction.commit();
        } else {
            fragment = getFragmentManager().findFragmentByTag("settings_fragment");
        }*/

        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.myprofile) {
                    Toast.makeText(MainActivity.this, "MyProfile", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.settings) {

                    startActivity(new Intent(MainActivity.this, SettingActivity.class));
                    return true;
                    //Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.editprofile) {
                    Toast.makeText(MainActivity.this, "EditProfile", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        SharedPreferences shardPref = PreferenceManager.getDefaultSharedPreferences(this);
        String choose = shardPref.getString("list_preference", "-1");
        Toast.makeText(this, choose, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences shardPref = PreferenceManager.getDefaultSharedPreferences(this);
        String choose = shardPref.getString("list_preference", "-1");
        Toast.makeText(this, choose, Toast.LENGTH_SHORT).show();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    /*public static class SettingsScreen extends PreferenceFragment{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting_screen);
            SwitchPreference switchPreference = (SwitchPreference) findPreference("switch_active");
            switchPreference.setEnabled(false);
        }
    }*/

}
