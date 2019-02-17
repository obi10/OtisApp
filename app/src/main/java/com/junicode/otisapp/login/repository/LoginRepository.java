package com.junicode.otisapp.login.repository;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginRepository {
    void signIn(String username, String password, Activity activity);
    void initializeFirebase();
    void onStart();
    void onStop();
}
