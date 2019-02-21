package com.junicode.otisapp.work.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junicode.otisapp.InfoWorkActivity;
import com.junicode.otisapp.R;
import com.junicode.otisapp.model.Trabajo;
import com.junicode.otisapp.model.TrabajoLab;


public class InfoWorkFragment extends Fragment {

    private Trabajo mTrabajo;

    private TextView mNumMaquinaTextView;
    private TextView mTipoMaquinaTextView;
    private TextView mEdificioTextView;
    private TextView mDireccionTextView;
    private TextView mContactoTextView;
    private TextView mTelefonoTextView;
    private TextView mFechaInicioTextView;
    private TextView mFechaLimiteTextView;
    private TextView mDescripcionTextView;

    /*
    private Button mHerramientaButton;
    private Button mMaterialButton;
    private Button mConcluirButton;
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String trabajoId = (String) getActivity().getIntent().getSerializableExtra(InfoWorkActivity.EXTRA_WORK_ID);
        mTrabajo = TrabajoLab.get(getActivity()).getTrabajo(trabajoId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_work, container, false);

        mNumMaquinaTextView = v.findViewById(R.id.textViewNumeroMaquina);
        mNumMaquinaTextView.setText(mTrabajo.getObjMaquina().getNumMaquina()); //nullObjectReference
        mTipoMaquinaTextView = v.findViewById(R.id.textViewTipoMaquina);
        mTipoMaquinaTextView.setText(mTrabajo.getObjMaquina().getNombre());
        mEdificioTextView = v.findViewById(R.id.textViewEdificio);
        mEdificioTextView.setText(mTrabajo.getObjMaquina().getObjEdificio().getNombre());
        mDireccionTextView = v.findViewById(R.id.textViewDireccion);
        mDireccionTextView.setText(mTrabajo.getObjMaquina().getObjEdificio().getDireccion());
        mContactoTextView = v.findViewById(R.id.textViewContacto);
        mContactoTextView.setText(mTrabajo.getObjMaquina().getObjEdificio().getObjContacto().getNombre() + " " +
                mTrabajo.getObjMaquina().getObjEdificio().getObjContacto().getApellido());
        mTelefonoTextView = v.findViewById(R.id.textViewTelefono);
        mTelefonoTextView.setText(mTrabajo.getObjMaquina().getObjEdificio().getObjContacto().getTelefono());
        mFechaInicioTextView = v.findViewById(R.id.textViewFechaInicio);
        mFechaInicioTextView.setText(mTrabajo.getFechaInicio().toString());
        mFechaLimiteTextView = v.findViewById(R.id.textViewFechaLimite);
        mFechaLimiteTextView.setText(mTrabajo.getFechaLimite().toString());
        mDescripcionTextView = v.findViewById(R.id.textViewDescripcion);
        mDescripcionTextView.setText(mTrabajo.getDescripcion());

        return v;
    }

}
