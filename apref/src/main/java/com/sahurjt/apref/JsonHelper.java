package com.sahurjt.apref;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;

final class JsonHelper {

    @Nullable
    static <T> T fromJsonString(String jsonString, Class<T> toModel) {
        Gson gson = new Gson();
        T data = gson.fromJson(jsonString, toModel);

        if (data == null) {
            try {
                return toModel.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return data;
        }
    }


    static <T> String toJsonString(T object, Class<T> fromModel) {
        Gson gson = new Gson();

        try {
            return gson.toJson(object, fromModel);
        } catch (Exception e) {
            Log.e("library-pref",
                    String.format("Error in creating json of :%s", fromModel));
            return "";
        }
    }
}
