package com.junicode.otisapp.work.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.junicode.otisapp.R;
import com.junicode.otisapp.model.Post;
import com.squareup.picasso.Picasso;

public class NewPostFragment extends Fragment {

    private static final String ARG_PHOTO_PATH_TEMP = "photo_path_temp";

    private String photoPath;

    private ImageView imgPhoto;
    private TextInputEditText mComentarioTextInputEditText;
    private Button mNewPostButton;
    private Button mCancelPostButton;

    public static NewPostFragment newInstance(String photoPathTemp) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO_PATH_TEMP, photoPathTemp);

        NewPostFragment fragment = new NewPostFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoPath = (String) getArguments().getSerializable(ARG_PHOTO_PATH_TEMP);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_post, container, false);

        imgPhoto = v.findViewById(R.id.imgPhoto);
        if (photoPath !=null) {
            Picasso.get().load(photoPath).into(imgPhoto);
        }

        mComentarioTextInputEditText = v.findViewById(R.id.editComment);

        mNewPostButton = v.findViewById(R.id.btnNewPost);
        mNewPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doNewPost();
            }
        });

        mCancelPostButton = v.findViewById(R.id.btnCancelPost);
        mCancelPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelPost();
            }
        });

        return v;
    }

    public void doNewPost() {
        String comentario = mComentarioTextInputEditText.getText().toString();

        Post newPost = new Post(this.photoPath, comentario);

        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA_POST", newPost);

        Intent i = new Intent();
        i.putExtras(bundle);

        returnResult(i);
    }

    public void cancelPost() {

    }

    public void returnResult(Intent returnIntent) {
        getActivity().setResult(Activity.RESULT_OK, returnIntent);
        getActivity().finish();
    }

}
