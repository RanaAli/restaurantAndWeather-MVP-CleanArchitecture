package com.app.data.net;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RanaAli on 8/6/17.
 */

public class RestClient {
    private static final String BASE_URL_RESTAURANTS = "https://developers.zomato.com/api/v2.1/";
    private static final String BASE_URL_WEATHER = "http://dataservice.accuweather.com/forecasts/v1/daily/";

    private static Retrofit retrofitRestaurant;
    private static Retrofit retrofitWeather;

    private static final String RESTAURANT_USER_KEY_HEADER = "user-key";
    private static final String RESTAURANT_USER_KEY_VALUE = "b04429430278934050cbcdb287292469";

    static {
        // enable logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient clientWeather = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        retrofitWeather = getRestClient(clientWeather, BASE_URL_WEATHER);

        OkHttpClient clientRestaurant = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder().addHeader(
                            RESTAURANT_USER_KEY_HEADER, RESTAURANT_USER_KEY_VALUE).build();
                    return chain.proceed(request);
                })
                .build();
        retrofitRestaurant = getRestClient(clientRestaurant, BASE_URL_RESTAURANTS);
    }

    @NonNull
    private static Retrofit getRestClient(OkHttpClient client, String url) {
        return new Retrofit
                .Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static <T> T getRestaurantService(Class<T> serviceClass) {
        return retrofitRestaurant.create(serviceClass);
    }

    public static <T> T getWeatherService(Class<T> serviceClass) {
        return retrofitWeather.create(serviceClass);
    }
}
