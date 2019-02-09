package com.sahurjt.apref;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.gson.Gson;

final class JsonHelper {

    @Nullable
    public static <T> T fromJsonString(String jsonString, Class<T> toModel) {
        Gson gson = new Gson();
        try {
            return gson.fromJson(jsonString, toModel);
        } catch (Exception e) {
            Log.d("library-pref",
                    String.format("Error in mapping JsonString:%s with model:%s", jsonString, toModel));
            return null;
        }
    }


    public static <T> String toJsonString(T object, Class<T> fromModel) {
        Gson gson = new Gson();

        try {
            return gson.toJson(object, fromModel);
        } catch (Exception e) {
            Log.d("library-pref",
                    String.format("Error in creating json of :%s", fromModel));
            return "";
        }
    }
}