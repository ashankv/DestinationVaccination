package org.destvac.destinationvacctionation;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Ashank on 9/23/2015.
 */
public class Speech extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speech_activity);

        mToolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);


        mDrawer = (NavigationView) findViewById(R.id.speech_drawer);
        mDrawer.setNavigationItemSelectedListener(Speech.this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setScrimColor(Color.parseColor("#33000000"));
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent = null;
        if(menuItem.getItemId() == R.id.speech_page){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        if(menuItem.getItemId() == R.id.home_page){
            Intent facintent = new Intent(Speech.this, MainActivity.class);
            startActivity(facintent);
        }

        if(menuItem.getItemId() == R.id.poem){
            Intent facintent = new Intent(Speech.this, Poem.class);
            startActivity(facintent);
        }

        if(menuItem.getItemId() == R.id.contact){
            Intent facintent = new Intent(Speech.this, Contact.class);
            startActivity(facintent);
        }


        return false;
    }



}
