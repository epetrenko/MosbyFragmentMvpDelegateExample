package com.epetrenko.mosbyexample.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.epetrenko.mosbyexample.LoginApplication;
import com.epetrenko.mosbyexample.R;
import com.epetrenko.mosbyexample.login.LoginDialogFragment;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return DaggerMainComponent.builder()
                .applicationComponent(LoginApplication.getApplicationComponent())
                .build()
                .presenter();
    }

    @NonNull
    @Override
    public MainPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(@NonNull MainPresenter presenter) {
        this.presenter = presenter;
    }

    @OnClick(R.id.show_dialog_button)
    public void onShowDialogBtnClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(new LoginDialogFragment(), null)
                .commit();
    }
}
