package xyz.philoliver.crewview.network;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xyz.philoliver.crewview.BuildConfig;

/**
 * Created by Phil on 3/26/17.
 * <p>
 * This Interceptor will add the API token to every request URL as a query parameter
 */

@Singleton
public class TokenInterceptor implements Interceptor {

    @Inject
    public TokenInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("token", BuildConfig.API_KEY)
                .build();

        request.newBuilder()
                .url(httpUrl)
                .build();

        return chain.proceed(request);
    }

}
