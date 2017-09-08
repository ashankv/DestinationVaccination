package org.destvac.destinationvacctionation;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    Button btnPoem;
    Button btnSpeech;
    Button btnContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPoem =(Button) findViewById(R.id.btnPoem);
        btnContact = (Button) findViewById(R.id.btnContact);
        btnSpeech = (Button) findViewById(R.id.btnSpeech);

        mToolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);


        mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setScrimColor(Color.parseColor("#33000000"));
        mDrawerToggle.syncState();

        btnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnSpeechIntent = new Intent(MainActivity.this, Speech.class);
                startActivity(btnSpeechIntent);
            }
        });

        btnPoem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnPoemIntent =  new Intent(MainActivity.this, Poem.class);
                startActivity(btnPoemIntent);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnContactIntent =  new Intent(MainActivity.this, Contact.class);
                startActivity(btnContactIntent);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent = null;
        if(menuItem.getItemId() == R.id.home_page){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        if(menuItem.getItemId() == R.id.speech_page){
            Intent facintent = new Intent(MainActivity.this, Speech.class);
            startActivity(facintent);
        }

        if(menuItem.getItemId() == R.id.poem){
            Intent facintent = new Intent(MainActivity.this, Poem.class);
            startActivity(facintent);
        }

        if(menuItem.getItemId() == R.id.contact){
            Intent facintent = new Intent(MainActivity.this, Contact.class);
            startActivity(facintent);
        }


        return false;
    }
}
