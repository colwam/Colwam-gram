package com.colwam.gram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);




    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            String test = navController.getCurrentDestination().getLabel().toString();
            switch (item.getItemId())
            {
                case R.id.homeFragment:
                    if (test.equals("fragment_camera"))
                    {
                        navController.navigate(R.id.action_cameraFragment2_to_homeFragment2);
                        test = navController.getCurrentDestination().getLabel().toString();
                        Log.d("collins",test);
                    }
                    else if (test.equals("fragment_search"))
                    {
                        navController.navigate(R.id.action_searchFragment2_to_homeFragment22);
                        test = navController.getCurrentDestination().getLabel().toString();
                        Log.d("collins",test);
                    }

                    break;
                case R.id.searchFragment:
                    if (test.equals("fragment_home"))
                    {
                        navController.navigate(R.id.action_homeFragment2_to_searchFragment2);
                        //set it to be the current destination
                        test =  navController.getCurrentDestination().getLabel().toString();
                        Log.d("collins",test);
                    }
                    else if (test.equals("fragment_camera"))
                    {
                        navController.navigate(R.id.action_cameraFragment2_to_searchFragment2);
                        test = navController.getCurrentDestination().getLabel().toString();
                    }
                    break;
                case R.id.cameraFragment:
                    if (test.equals("fragment_home"))
                    {
                        navController.navigate(R.id.action_homeFragment2_to_cameraFragment2);
                        test = navController.getCurrentDestination().getLabel().toString();
                        Log.d("collins",test);
                    }
                    else if (test.equals("fragment_search"))
                    {
                        navController.navigate(R.id.action_searchFragment2_to_cameraFragment2);
                        test = navController.getCurrentDestination().getLabel().toString();
                        Log.d("collins",test);
                    }
                    break;

            }
            return true;
        }
    };





}

