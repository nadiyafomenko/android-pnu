package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = item -> {
        Fragment selectedItem = null;

        switch (item.getItemId()) {
            case R.id.home:
                selectedItem = new HomeFragment();
                break;
            case R.id.search:
                selectedItem = new SearchFragment();
                break;
            case R.id.list:
                selectedItem = new ListFragment();
                break;

        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedItem)
                .commit();

        return true;
    };

}