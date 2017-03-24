package multiaccessmenu.example.com.multiacessmenu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class BaseActivity extends AppCompatActivity {

    // Toolbar
    private Boolean toolbarHideStatus = false; // true if must hide toolbar/menu
    private String toolbarTitle = "Base Activity";

    // Side Menu Navigation Drawer
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {

        // View of  BaseActivity
        DrawerLayout baseView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);

        // Activity container in activity_base
        FrameLayout activityContainer = (FrameLayout) baseView.findViewById(R.id.activity_content);



        // Inject new layout (layoutResID) into layout in activity_base container
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        // Call parent super method
        super.setContentView(baseView);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Check if toolbar must show or hide
        if(!this.toolbarHideStatus) {
            setSupportActionBar(toolbar);
            setTitle(this.toolbarTitle);
        } else {
            toolbar.setVisibility(View.GONE);
        }

        // Setting up Drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_container);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Side Menu/Navigaton
        NavigationView navView = (NavigationView) findViewById(R.id.navigationView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                // Intent variable for checking where user clicked to go
                Intent myIntent = null;

                // Check which option user has clicked
                if(id == R.id.nav_main) {
                    // Redirects to Main Activity
                    myIntent = new Intent(getApplicationContext(), MainActivity.class);
                } else if(id == R.id.nav_opt1) {
                    // Redirects to Option 1 Activity
                    myIntent = new Intent(getApplicationContext(), Option1Activity.class);
                } else if(id == R.id.nav_opt2) {
                    // Redirects to Option 2 Activity
                    myIntent = new Intent(getApplicationContext(), Option2Activity.class);
                }

                // Starts Selected Activity
                startActivity(myIntent);
                finish();

                // Close Side Menu Nagivation Drawer
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_container);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    protected void hideToolbar(Boolean option) {
        this.toolbarHideStatus = option;
    }

    protected void setToolbarTitle(String value) {
        this.toolbarTitle = value;
    }
}
