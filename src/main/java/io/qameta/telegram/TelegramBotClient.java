package io.qameta.telegram;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface TelegramBotClient {

    @GET("getMe")
    Call<Response<User>> getMe();

    @FormUrlEncoded
    @POST("sendMessage")
    Call<Response<Message>> sendMessage(
            @Field("chat_id") int id,
            @Field("text") String text);

    @FormUrlEncoded
    @POST("sendMessage")
    Call<Response<Message>> sendMessage(
            @Field("chat_id") int id,
            @Field("text") String text,
            @Field("reply_markup") String keyboard);

    @FormUrlEncoded
    @POST("getupdates")
    Call<Response<List<Update>>> getUpdates(
            @Field("offset") int offset,
            @Field("limit") int limit,
            @Field("timeout") int timeout);

}
