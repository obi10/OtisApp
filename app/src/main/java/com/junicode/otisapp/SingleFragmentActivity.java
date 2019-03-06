package com.junicode.otisapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.junicode.otisapp.home.activity.HomeActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity { //AppCompatActivity supports library's fragment implementation

    private Toolbar toolbar;

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showToolBar();

        //FragmentManager is responsible for managing your fragments and adding their views to the activity's view hierarchy
        FragmentManager fm = getSupportFragmentManager(); //we are using the support library
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            //creates and commits a fragment transaction
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    protected void showToolBar(){
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_navigate_before); //after the setDisplayHomeAsUpEnabled
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent i = new Intent(this, HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                return true;
            case R.id.nav_perfil:
                Toast.makeText(this, "perfil activity!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_salir:
                Toast.makeText(this, "salir!",
                        Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
