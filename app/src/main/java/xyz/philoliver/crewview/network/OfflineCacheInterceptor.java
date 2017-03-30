package xyz.philoliver.crewview.network;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xyz.philoliver.crewview.util.DeviceUtils;

/**
 * Created by Phil on 3/26/17.
 * <p>
 * Sets the caching behavior based on the current network availability
 */

@Singleton
public class OfflineCacheInterceptor implements Interceptor {

    private Context context;

    @Inject
    public OfflineCacheInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // If device has no network connection, add the cache control header
        if (!DeviceUtils.isNetworkConnected(context)) {
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxStale(5, TimeUnit.DAYS) // Accept cached data up to 5 days old
                    .build();

            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();
        }

        return chain.proceed(request);
    }

}
