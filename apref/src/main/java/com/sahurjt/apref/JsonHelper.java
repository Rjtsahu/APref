package com.sahurjt.apref;

import com.google.gson.Gson;

final class JsonHelper {

    public static <T> T fromJsonString(String jsonString, Class<T> toModel) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, toModel);
    }


    public static <T> void toJsonString(String jsonString, Class<T> fromModel) {
        Gson gson = new Gson();
        gson.toJson(jsonString, fromModel);
    }
}
