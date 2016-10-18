package io.qameta.telegram;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelegramClientBuilder {

    public static final String ENDPOINT = "https://api.telegram.org";

    public static TelegramBotClient createBotClient(String token) {
        return createBotClient(ENDPOINT, token);
    }

    public static TelegramBotClient createBotClient(String host, String token) {
        String baseUrl = String.format("%s/bot%s/", host, token);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build();
        return retrofit.create(TelegramBotClient.class);
    }
}
