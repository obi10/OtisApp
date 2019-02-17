package com.junicode.otisapp.login.presenter;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.junicode.otisapp.login.interactor.LoginInteractor;
import com.junicode.otisapp.login.interactor.LoginInteractorImpl;
import com.junicode.otisapp.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView) {
        this.view = loginView;
        interactor = new LoginInteractorImpl(this);
    }
    @Override
    public void signIn(String username, String password, Activity activity) {
        view.disableInputs();
        view.showProgressBar();

        interactor.signIn(username, password, activity);
    }

    @Override
    public void loginSuccess() {
        view.goHome();
        view.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        view.enableInputs();
        view.hideProgressBar();
        view.loginError(error);
    }

    @Override
    public void initializeFirebase() {
        interactor.initializeFirebase();
    }

    @Override
    public void onStart() {
        interactor.onStart();
    }

    @Override
    public void onStop() {
        interactor.onStop();
    }

}
