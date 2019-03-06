package com.junicode.otisapp.home.activity;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.junicode.otisapp.R;
import com.junicode.otisapp.SingleFragmentActivity;
import com.junicode.otisapp.home.fragment.HomeFragment;

public class HomeActivity extends SingleFragmentActivity {

    @Override
    protected void showToolBar(){
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    protected Fragment createFragment() {
        return new HomeFragment();
    }
}
