package com.epetrenko.mosbyexample.main;

import com.epetrenko.mosbyexample.ApplicationComponent;
import com.epetrenko.mosbyexample.ApplicationModule;

import dagger.Component;

@Component(
        modules = ApplicationModule.class,
        dependencies = ApplicationComponent.class)
public interface MainComponent {

    MainPresenter presenter();

}
