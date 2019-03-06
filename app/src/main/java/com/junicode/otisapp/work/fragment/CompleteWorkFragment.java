package com.junicode.otisapp.work.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.junicode.otisapp.R;
import com.junicode.otisapp.model.Post;
import com.junicode.otisapp.model.PostLab;
import com.junicode.otisapp.model.Trabajo;
import com.junicode.otisapp.model.TrabajoLab;
import com.junicode.otisapp.work.activity.NewPostActivity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CompleteWorkFragment extends Fragment {

    private static final String ARG_WORK_ID = "work_id";
    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_DATA_POST = 2;
    private String photoPathTemp = "";

    private Trabajo mTrabajo;

    private TextView mEstadoActualTextView;
    private TextView mFechaTerminoTextView;
    private EditText mObservacionTextView;
    private FloatingActionButton mCameraFloatingActionButton;

    private RecyclerView mPhotosRecyclerView;
    private PostAdapter mPostAdapter;

    private PostLab mPostLab;

    public static CompleteWorkFragment newInstance(String trabajoId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_WORK_ID, trabajoId);

        CompleteWorkFragment fragment = new CompleteWorkFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String trabajoId = (String) getArguments().getSerializable(ARG_WORK_ID);
        mTrabajo = TrabajoLab.get(getActivity()).getTrabajo(trabajoId);

        mPostLab = new PostLab();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_complete_work, container, false);

        //showToolBar(v, true);

        mEstadoActualTextView = v.findViewById(R.id.textViewEstadoActual);
        mEstadoActualTextView.setText(mTrabajo.getNombre());

        mFechaTerminoTextView = v.findViewById(R.id.textViewFechaTermino);
        //set the current hour

        mObservacionTextView = v.findViewById(R.id.editTextObservacion);

        mPhotosRecyclerView = v.findViewById(R.id.photos_recycler_view);
        mPhotosRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mCameraFloatingActionButton = v.findViewById(R.id.fabCamera);
        mCameraFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        updateUI();

        return v;
    }

    public void showToolBar(View v, boolean upButton){
        Toolbar toolbar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private void takePicture() {
        Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intentTakePicture.resolveActivity(getActivity().getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(getActivity(), "com.junicode.otisapp", photoFile);
                intentTakePicture.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intentTakePicture, REQUEST_CAMERA); //return to the activity (onActivityResult)
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyMMdd_HH-mm-ss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File photo = File.createTempFile(imageFileName, ".jpg", storageDir);

        photoPathTemp = "file:" + photo.getAbsolutePath();

        return photo;
    }

    //getting results from fragments
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) { //happens before onResume
        if (requestCode == REQUEST_CAMERA && resultCode == getActivity().RESULT_OK) {
            Log.d("CompleteWorkActivity", "CAMERA OK");

            Intent intent = NewPostActivity.newIntent(getActivity(), photoPathTemp);
            startActivityForResult(intent, REQUEST_DATA_POST);
        }
        if (requestCode == REQUEST_DATA_POST && resultCode == getActivity().RESULT_OK) {
            Post newPost = (Post) data.getSerializableExtra("DATA_POST");
            this.mPostLab.addPost(newPost);
        }

    }


    //manage the recycler view
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        List<Post> listaPosts = mPostLab.getPosts();

        if (mPostAdapter == null) {
            mPostAdapter = new PostAdapter(listaPosts);
            mPhotosRecyclerView.setAdapter(mPostAdapter);
        }
        else { //when the activity was stopped or paused
            int lastPosition = this.mPostLab.getLastPosition();
            if (lastPosition > 0)
                mPostAdapter.notifyItemInserted(lastPosition);
        }
    }

    private class PostHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mPhotoPostImageView;

        private Post mPost;

        public PostHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mPhotoPostImageView = itemView.findViewById(R.id.photo_post_image_view);
        }

        public void bindPost(Post post) {
            mPost = post;
            Log.d("CompleteWorkActivity", "photo_path" + mPost.getPhotoPath());
            if (post.getPhotoPath() != null) Picasso.get().load(post.getPhotoPath()).into(mPhotoPostImageView);
        }

        @Override
        public void onClick(View v) {
            //open NewPostActivity (see and edit the post)
        }
    }

    private class PostAdapter extends RecyclerView.Adapter<PostHolder> {
        private List<Post> mPosts;

        public PostAdapter(List<Post> posts) {
            mPosts = posts;
        }

        @Override
        public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_post, parent, false);
            return new PostHolder(view);
        }

        @Override
        public void onBindViewHolder(PostHolder holder, int position) {
            Post post = mPosts.get(position);
            holder.bindPost(post);
        }

        @Override
        public int getItemCount() {
            return mPosts.size();
        }
    }

}
