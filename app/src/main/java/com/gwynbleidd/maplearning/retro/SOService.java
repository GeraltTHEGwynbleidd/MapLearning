package com.gwynbleidd.maplearning.retro;

import com.gwynbleidd.maplearning.retro.Pojo.MapDirObj;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {
    @GET("json")
    Call<MapDirObj> getDirections(@Query("origin") String origin, @Query("destination") String destination , @Query("key") String key);
}
