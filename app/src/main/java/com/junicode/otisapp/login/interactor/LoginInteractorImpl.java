package com.junicode.otisapp.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.junicode.otisapp.login.presenter.LoginPresenter;
import com.junicode.otisapp.login.repository.LoginRepository;
import com.junicode.otisapp.login.repository.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.presenter = loginPresenter;
        repository = new LoginRepositoryImpl(loginPresenter);
    }

    @Override
    public void signIn(String username, String password, Activity activity) {
        repository.signIn(username, password, activity);
    }

    @Override
    public void initializeFirebase() {
        repository.initializeFirebase();
    }

    @Override
    public void onStart() {
        repository.onStart();
    }

    @Override
    public void onStop() {
        repository.onStop();
    }
}
