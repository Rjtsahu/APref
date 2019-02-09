package com.sahurjt.apref;


import android.content.Context;
import android.content.SharedPreferences;

final class PrefBase {


    private static final int SP_MODE = Context.MODE_PRIVATE;
    private static final String EMPTY_STRING = "";
    private Context appContext;
    private String fileName;

    PrefBase(Context appContext, String fileName) {
        this.appContext = appContext;
        this.fileName = fileName;
    }

    private SharedPreferences getPreferences() {
        return appContext.getSharedPreferences(fileName, SP_MODE);
    }

    private SharedPreferences.Editor getPreferenceEditor() {
        return getPreferences().edit();
    }

    public String getString(String key) {
        return getPreferences().getString(key, EMPTY_STRING);
    }

    public boolean saveString(String key, String value) {
        return getPreferenceEditor().putString(key, value).commit();
    }

    public boolean clearPreferences() {
        return getPreferenceEditor().clear().commit();
    }

    //// TODO: create a callback event,which will notify if some data is commited
}
