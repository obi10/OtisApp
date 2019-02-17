package com.junicode.otisapp.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.junicode.otisapp.login.presenter.LoginPresenter;
import com.junicode.otisapp.login.view.LoginActivity;

public class LoginRepositoryImpl implements LoginRepository {

    private LoginPresenter presenter;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    public LoginRepositoryImpl(LoginPresenter loginPresenter) {
        this.presenter = loginPresenter;
    }

    @Override
    public void signIn(String username, String password, Activity activity) {
        firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("LoginRepositoryImpl", "signInWithEmail:success");
                            presenter.loginSuccess();
                        } else {
                            Log.w("LoginRepositoryImpl", "signInWithEmail:failure", task.getException());
                            presenter.loginError("Ocurrio un error");
                        }
                    }
                });
    }

    @Override
    public void initializeFirebase() {
        firebaseAuth = FirebaseAuth.getInstance(); //java manipulates objects by reference
    }

    @Override
    public void onStart() {
        final String TAG = "LoginRepositoryImpl";

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            Log.w(TAG, "Usuario logeado " + firebaseUser.getEmail());
        }else {
            Log.w(TAG, "Usuario no logeado ");
        }

        /*
        //registers a listener to changes in the user authentication state
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Log.w(TAG, "Usuario logeado " + firebaseUser.getEmail());
                }else {
                    Log.w(TAG, "Usuario no logeado ");
                }
            }
        };
        */
        //firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        //firebaseAuth.removeAuthStateListener(authStateListener);
    }
}
