package com.junicode.otisapp.work.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junicode.otisapp.InfoWorkActivity;
import com.junicode.otisapp.R;
import com.junicode.otisapp.model.Trabajo;
import com.junicode.otisapp.model.TrabajoLab;

import java.util.List;

public class WorkListFragment extends Fragment {

    private RecyclerView mWorkCorrectivoRecyclerView;
    private RecyclerView mWorkPreventivoRecyclerView;
    private TrabajoAdapter mAdapterCorrectivo;
    private TrabajoAdapter mAdapterPreventivo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_work_list, container, false);

        mWorkCorrectivoRecyclerView = v.findViewById(R.id.work_correctivo_recycler_view);
        mWorkPreventivoRecyclerView = v.findViewById(R.id.work_preventivo_recycler_view);

        //LayoutManager handles the positioning of items and also defines the scrolling behavior
        mWorkCorrectivoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWorkPreventivoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI() {
        TrabajoLab trabajoLab = TrabajoLab.get(getActivity());
        List<Trabajo> listaTrabajosCorrectivos = trabajoLab.getTrabajosXTipo('c');
        List<Trabajo> listaTrabajosPreventivos = trabajoLab.getTrabajosXTipo('p');

        mAdapterCorrectivo = new TrabajoAdapter(listaTrabajosCorrectivos);
        mWorkCorrectivoRecyclerView.setAdapter(mAdapterCorrectivo);

        mAdapterPreventivo = new TrabajoAdapter(listaTrabajosPreventivos);
        mWorkPreventivoRecyclerView.setAdapter(mAdapterPreventivo);
    }

    private class TrabajoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;

        private Trabajo mTrabajo;

        public TrabajoHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = itemView.findViewById(R.id.list_item_work_title_text_view);
        }

        public void bindTrabajo(Trabajo trabajo) {
            mTrabajo = trabajo;
            mTitleTextView.setText(mTrabajo.getNombre());
        }

        @Override
        public void onClick(View v) {
            Intent intent = InfoWorkActivity.newIntent(getActivity(), mTrabajo.getIdTrabajo());
            startActivity(intent);
        }
    }

    private class TrabajoAdapter extends RecyclerView.Adapter<TrabajoHolder> {
        private List<Trabajo> mTrabajos;

        public TrabajoAdapter(List<Trabajo> trabajos) {
            mTrabajos = trabajos;
        }

        @Override
        public TrabajoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_work, parent, false);
            return new TrabajoHolder(view);
        }

        @Override
        public void onBindViewHolder(TrabajoHolder holder, int position) {
            Trabajo trabajo = mTrabajos.get(position);
            holder.bindTrabajo(trabajo);
        }

        @Override
        public int getItemCount() {
            return mTrabajos.size();
        }
    }

}
