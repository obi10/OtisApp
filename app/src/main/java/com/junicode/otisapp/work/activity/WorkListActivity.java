package com.junicode.otisapp.work.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.junicode.otisapp.SingleFragmentActivity;
import com.junicode.otisapp.model.TrabajoLab;
import com.junicode.otisapp.work.fragment.WorkListFragment;

public class WorkListActivity extends SingleFragmentActivity {
    public static final String EXTRA_TRABAJO_LIST = "com.junicode.otisapp.trabajo_list";

    public static Intent newIntent(Context packageContext, TrabajoLab trabajoLab) {
        Intent intent = new Intent(packageContext, WorkListActivity.class);
        intent.putExtra(EXTRA_TRABAJO_LIST, trabajoLab);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        TrabajoLab trabajoLab = (TrabajoLab) getIntent().getSerializableExtra(EXTRA_TRABAJO_LIST);
        return WorkListFragment.newInstance(trabajoLab);
    }
}











