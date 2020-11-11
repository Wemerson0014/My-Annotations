package com.estudo.my_annotations;

import android.content.Context;
import android.content.SharedPreferences;

public class AnnotationPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String MY_PREFERENCE = "annotation.preference";
    private final String PREFERENCE_KEY = "my_annotations";

    public AnnotationPreferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(MY_PREFERENCE, 0);
        editor = preferences.edit();
    }

    public void saveAnnotation(String annotation) {
        editor.putString(PREFERENCE_KEY, annotation);
        editor.apply();
    }

    public String getAnnotation() {
        return preferences.getString(PREFERENCE_KEY, "");
    }
}
