package com.colwam.gram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.settings)
            Toast.makeText(getApplicationContext(), "settings selected", Toast.LENGTH_SHORT).show();
        else if(id == R.id.search)
            Toast.makeText(getApplicationContext(), "search is clicked", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "upload file big man", Toast.LENGTH_SHORT).show();
        return true;
    }

}

