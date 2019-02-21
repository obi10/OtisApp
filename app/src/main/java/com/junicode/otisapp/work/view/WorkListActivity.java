package com.junicode.otisapp.work.view;

import android.support.v4.app.Fragment;

import com.junicode.otisapp.work.SingleFragmentActivity;
import com.junicode.otisapp.work.fragment.WorkListFragment;

public class WorkListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new WorkListFragment();
    }
}











