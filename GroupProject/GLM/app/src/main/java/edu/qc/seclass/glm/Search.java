package edu.qc.seclass.glm;

import android.app.Activity;
import android.content.SharedPreferences;

public class Search {
    SharedPreferences sharedPreferences;

    public Search(Activity activity) {
        sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);

    }

    public void setSearch(String search) {
        sharedPreferences.edit().putString("search", search).commit();
    }

    public String getSearch() {
        return sharedPreferences.getString("search", "Hello");
    }
}
