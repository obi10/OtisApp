package com.junicode.otisapp.work.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.junicode.otisapp.SingleFragmentActivity;
import com.junicode.otisapp.work.fragment.NewPostFragment;

public class NewPostActivity extends SingleFragmentActivity {

    public static final String EXTRA_PHOTO_PATH_TEMP = "com.junicode.otisapp.photo_path_temp";


    public static Intent newIntent(Context packageContext, String photoPathTemp) {
        Intent intent = new Intent(packageContext, NewPostActivity.class);
        intent.putExtra(EXTRA_PHOTO_PATH_TEMP, photoPathTemp);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String photoPathTemp = (String) getIntent().getSerializableExtra(EXTRA_PHOTO_PATH_TEMP);
        return NewPostFragment.newInstance(photoPathTemp);
    }
}
