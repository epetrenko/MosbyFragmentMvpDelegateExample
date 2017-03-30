package com.epetrenko.mosbyexample.login;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epetrenko.mosbyexample.LoginApplication;
import com.epetrenko.mosbyexample.R;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;

public class LoginDialogFragment extends AppCompatDialogFragment implements LoginView,
        MvpDelegateCallback<LoginView, LoginPresenter> {

    LoginPresenter presenter;

    private FragmentMvpDelegate<LoginView, LoginPresenter> delegate =
            new FragmentMvpDelegateImpl<>(this, this, false, false);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        delegate.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        delegate.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        delegate.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        delegate.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        delegate.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        delegate.onStop();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        delegate.onDetach();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        delegate.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        delegate.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return DaggerLoginComponent.builder()
                .applicationComponent(LoginApplication.getApplicationComponent())
                .build()
                .presenter();
    }

    @Override
    public LoginPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public LoginView getMvpView() {
        return this;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AppCompatDialog dialog = new AppCompatDialog(getActivity(), getTheme());
        dialog.setTitle(R.string.dialog_title);
        return dialog;
    }
}
