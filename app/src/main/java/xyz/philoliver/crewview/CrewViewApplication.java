package xyz.philoliver.crewview;

import android.app.Application;
import android.content.Context;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import xyz.philoliver.crewview.di.component.DaggerNetworkComponent;
import xyz.philoliver.crewview.di.component.NetworkComponent;
import xyz.philoliver.crewview.di.module.NetworkModule;


/**
 * Created by Phil on 3/26/17.
 */

public class CrewViewApplication extends Application {

    protected NetworkComponent networkComponent;

    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(getString(R.string.base_url)))
                .build();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.lato_regular))
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public static NetworkComponent getNetworkComponent(Context context) {
        CrewViewApplication crewViewApplication = (CrewViewApplication) context.getApplicationContext();
        return crewViewApplication.networkComponent;
    }

}
