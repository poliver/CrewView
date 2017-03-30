package xyz.philoliver.crewview.di.module;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.philoliver.crewview.network.CacheInterceptor;
import xyz.philoliver.crewview.network.OfflineCacheInterceptor;
import xyz.philoliver.crewview.network.SlackService;
import xyz.philoliver.crewview.network.TokenInterceptor;

/**
 * Created by Phil on 3/24/17.
 *
 * Module to allow for injecting of the API service and Retrofit components
 */

@Module
public class NetworkModule {

    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    SlackService provideSlackService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(SlackService.class);
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Context context,
                                      TokenInterceptor tokenInterceptor,
                                      CacheInterceptor cacheInterceptor,
                                      OfflineCacheInterceptor offlineCacheInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(tokenInterceptor)
                .addInterceptor(offlineCacheInterceptor)
                .addNetworkInterceptor(cacheInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .cache(cache)
                .build();
    }

}
