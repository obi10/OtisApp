package com.junicode.otisapp.work.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.junicode.otisapp.SingleFragmentActivity;
import com.junicode.otisapp.work.fragment.CompleteWorkFragment;

public class CompleteWorkActivity extends SingleFragmentActivity {

    public static final String EXTRA_WORK_ID = "com.junicode.otisapp.work_id";

    public static Intent newIntent(Context packageContext, String trabajoId) {
        Intent intent = new Intent(packageContext, CompleteWorkActivity.class);
        intent.putExtra(EXTRA_WORK_ID, trabajoId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String trabajoId = (String) getIntent().getSerializableExtra(EXTRA_WORK_ID);
        return CompleteWorkFragment.newInstance(trabajoId);
    }

}
