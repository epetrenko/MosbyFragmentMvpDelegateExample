package com.epetrenko.mosbyexample.login;

import com.epetrenko.mosbyexample.ApplicationComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = LoginModule.class,
        dependencies = ApplicationComponent.class)
public interface LoginComponent {

    LoginPresenter presenter();

}
