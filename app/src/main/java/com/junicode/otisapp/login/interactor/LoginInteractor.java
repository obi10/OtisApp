package com.junicode.otisapp.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginInteractor {
    void signIn(String username, String password, Activity activity);
    void initializeFirebase();
    void onStart();
    void onStop();
}
