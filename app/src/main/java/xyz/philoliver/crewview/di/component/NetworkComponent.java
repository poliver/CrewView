package xyz.philoliver.crewview.di.component;

import javax.inject.Singleton;

import dagger.Component;
import xyz.philoliver.crewview.di.module.NetworkModule;
import xyz.philoliver.crewview.ui.UserListActivity;

/**
 * Created by Phil on 3/26/17.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {

    void inject(UserListActivity userListActivity);

}