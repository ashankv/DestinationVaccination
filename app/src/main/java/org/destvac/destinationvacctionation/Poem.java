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
 * Created by Ashank on 9/25/2015.
 */
public class Poem extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poem_activity);

        mToolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);


        mDrawer = (NavigationView) findViewById(R.id.poem_drawer);
        mDrawer.setNavigationItemSelectedListener(Poem.this);
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
            Intent poemSpeech = new Intent(Poem.this, Speech.class);
            startActivity(poemSpeech);
        }

        if(menuItem.getItemId()==R.id.home_page) {
            Intent poemHome = new Intent(Poem.this, MainActivity.class);
            startActivity(poemHome);
        }

        if(menuItem.getItemId() == R.id.poem){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        if(menuItem.getItemId() == R.id.contact)  {
            Intent poemContact = new Intent(Poem.this, Contact.class);
            startActivity(poemContact);
        }

        return false;
    }
}
