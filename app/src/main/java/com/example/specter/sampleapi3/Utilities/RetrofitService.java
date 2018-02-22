package com.example.specter.sampleapi3.Utilities;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by specter on 2/20/18.
 */

public interface RetrofitService {

    @GET("app-events.json")
    Call<JsonObject> getEventlist();

}
