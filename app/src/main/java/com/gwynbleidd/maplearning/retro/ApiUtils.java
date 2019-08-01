package com.gwynbleidd.maplearning.retro;

public class ApiUtils {
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/directions/";


    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }

}
