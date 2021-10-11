package com.akashyadav.kindredassignment.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    public static final  String BASE_URL = "https://api.unsplash.com";
    public static final  String API_KEY = "2-NtJwNDy3jUy7gt69WQ2la9H7sGBpvqkbNnbU_KR-Y";

    public  static Retrofit retrofit = null;

    public  static ApiInterface getApiInterface(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
