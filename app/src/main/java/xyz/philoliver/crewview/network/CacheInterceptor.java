package xyz.philoliver.crewview.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Phil on 3/26/17.
 * <p>
 * Overrides server responses to enable local caching
 */

@Singleton
public class CacheInterceptor implements Interceptor {

    @Inject
    public CacheInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(2, TimeUnit.MINUTES)
                .build();

        // Modify response headers from servers to force caching
        return response.newBuilder()
                .removeHeader("Pragma") // this header will prevent response caching
                .header("Cache-Control", cacheControl.toString())
                .build();
    }

}
