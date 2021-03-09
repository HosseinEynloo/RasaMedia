package com.rasa.computerman.WebService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static final String BASE_URL = "http://79.175.155.143/Bakh/api/";
    // public static final String BASE_URL = "http://185.8.175.220/computerman/api/";
    private static Retrofit retrofit = null;
//    private static UserProfile userProfile;

    public static Retrofit getClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS).addInterceptor(loggingInterceptor)
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request.Builder ongoing = chain.request().newBuilder();
//                        if (userProfile.get_KEY_JWT( "-1")!=null) {
//                            Log.d("TAG" ,"Authorization: "+"Bearer "+ userProfile.get_KEY_JWT("-1"));
//                            ongoing.addHeader("Authorization", "Bearer "+userProfile.get_KEY_JWT("-1"));
//                            //ongoing.addHeader("DeviceId", Value.getDeviceId(App.getContext()));
//                        }
//                        return chain.proceed(ongoing.build());
//                    }
//                })
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    public Retrofit getRetrofitNoLog() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS).build();
                /*.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder ongoing = chain.request().newBuilder();
                        if (UserInfo.get_KEY_JWT(context, "-1")!=null) {
                            Log.d("" ,"Authorization: "+"Bearer "+ UserInfo.get_KEY_JWT(context, "-1"));
                            ongoing.addHeader("Authorization", "Bearer "+UserInfo.get_KEY_JWT(context, "-1"));
                            //ongoing.addHeader("DeviceId", Value.getDeviceId(App.getContext()));
                        }
                        return chain.proceed(ongoing.build());
                    }
                })
                .build();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

}
