package com.sahurjt.apref;

import android.content.Context;

public class APref<T> {

    private static final String DEFAULT_FILE_NAME = "APref";
    private static String customFileName;

    private static Context mApplicationContext;
    private PrefBase mSharedPreferenceBase;
    private Class<T> mClassType;
    public T object;


    private APref(Class<T> classType) {
        this.mClassType = classType;
        mSharedPreferenceBase = new PrefBase(mApplicationContext, customFileName);
        this.object = getObject();
    }

    /**
     * Method to initialize library instance, this should be called from application class.
     **/
    public static void init(Context applicationContext) {
        if (mApplicationContext != null) return;
        init(applicationContext, DEFAULT_FILE_NAME);
    }

    public static void init(Context applicationContext, String customFileName) {
        if (mApplicationContext != null) return;
        mApplicationContext = applicationContext;
        APref.customFileName = customFileName;
    }


    @SuppressWarnings("unchecked")
    public static <T> APref<T> getInstance(Class<T> classType) {
        return new APref<>(classType);
    }

    /**
     * Gets the content from shared_preference populated over model T
     */
    private T getObject() {
        return JsonHelper.fromJsonString(mSharedPreferenceBase.getString(getClassName()), this.mClassType);
    }

    /**
     * Gets the class name for generic model
     */
    private String getClassName() {
        return this.mClassType.getSimpleName();
    }

    /**
     * Resets the current state of object to it initial form if @param toBaseModel is true,
     * else retains last saved data from shared preference file.
     */
    public void reset(boolean toBaseModel) {
        if (toBaseModel) {
            try {
                this.object = mClassType.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            this.object = this.getObject();
        }
    }

    /**
     * Saved the changes made on this.object to file system.
     * */
    public void commit() {
        mSharedPreferenceBase.setString(this.getClassName(),JsonHelper.toJsonString(this.object,this.mClassType));
    }

}
