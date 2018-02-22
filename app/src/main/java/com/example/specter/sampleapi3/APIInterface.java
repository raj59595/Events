package com.example.specter.sampleapi3;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by specter on 2/20/18.
 */

public interface APIInterface {

    @GET("app-events.json")
    Call<JsonObject> getEventlist();

}
