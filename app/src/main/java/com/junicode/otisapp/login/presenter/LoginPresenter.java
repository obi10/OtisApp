package com.junicode.otisapp.login.presenter;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginPresenter {

    void signIn(String username, String password, Activity activity);
    void loginSuccess();
    void loginError(String error);

    void initializeFirebase();
    void onStart();
    void onStop();
}
