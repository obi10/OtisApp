package com.junicode.otisapp.login.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.junicode.otisapp.home.activity.HomeActivity;
import com.junicode.otisapp.R;
import com.junicode.otisapp.login.presenter.LoginPresenter;
import com.junicode.otisapp.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private TextInputEditText username, password;
    private Button buttonLogin;
    private ProgressBar progressBarLogin;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String TAG = "LoginRepositoryImpl";

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.login);
        progressBarLogin = findViewById(R.id.progressBarLogin);

        presenter = new LoginPresenterImpl(this);

        initializeFirebase();

        this.hideProgressBar(); //hide the progressbar since beginning


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && password.getText() != null) {
                    Log.w(TAG, "valores insertados textviews: " + username.getText().toString() + password.getText().toString());
                    signIn(username.getText().toString(), password.getText().toString());
                }
            }
        });
    }

    @Override
    public void signIn(String username, String password) {
        presenter.signIn(username, password, this);
    }

    @Override
    public void enableInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
        buttonLogin.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        buttonLogin.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void initializeFirebase() {
        presenter.initializeFirebase();
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
