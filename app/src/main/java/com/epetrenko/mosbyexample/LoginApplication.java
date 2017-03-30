package com.epetrenko.mosbyexample;

import android.app.Application;

public class LoginApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.create();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
