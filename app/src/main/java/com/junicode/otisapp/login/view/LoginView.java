package com.junicode.otisapp.login.view;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void signIn(String username, String password);
    void loginError(String error);

    void goHome();

    void initializeFirebase();

}
