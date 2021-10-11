package com.akashyadav.kindredassignment.api;

import com.akashyadav.kindredassignment.model.SearchModel;
import com.akashyadav.kindredassignment.model.imageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.akashyadav.kindredassignment.api.ApiUtilities.API_KEY;

public abstract class ApiInterface {
    @Headers("Authorization: Client-ID" + API_KEY)
    @GET("/photos")
    public abstract Call<List<imageModel>> getImages(
            @Query("page") int page,
            @Query("per_page") int perPage
    ); 


    @Headers("Authorization: Client-ID" + API_KEY)
    @GET("/search/photos")
    abstract Call<SearchModel> searchImages(
            @Query("query") String query

    );


    public abstract Call<SearchModel> searchImage(String query);
}
