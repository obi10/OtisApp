package com.junicode.otisapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.junicode.otisapp.work.SingleFragmentActivity;
import com.junicode.otisapp.work.fragment.InfoWorkFragment;


public class InfoWorkActivity extends SingleFragmentActivity {

    public static final String EXTRA_WORK_ID = "com.junicode.otisapp.work_id";

    public static Intent newIntent(Context packageContext, String trabajoId) {
        Intent intent = new Intent(packageContext, InfoWorkActivity.class);
        intent.putExtra(EXTRA_WORK_ID, trabajoId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new InfoWorkFragment();
    }
}
