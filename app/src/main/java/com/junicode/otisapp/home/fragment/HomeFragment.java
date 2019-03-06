package com.junicode.otisapp.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.junicode.otisapp.R;
import com.junicode.otisapp.model.TrabajoLab;
import com.junicode.otisapp.work.activity.WorkListActivity;

public class HomeFragment extends Fragment {

    private Button mVigentesButton;
    private Button mPendientesButton;
    private Button mEmergenciaButton;
    private Button mCulminadosButton;

    private TrabajoLab trabajosVigentes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //trabajosVigentes =

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mVigentesButton = v.findViewById(R.id.vigentes_button);
        mVigentesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = WorkListActivity.newIntent(getActivity(), trabajosVigentes);
                startActivity(intent);
            }
        });

        return v;
    }

}
