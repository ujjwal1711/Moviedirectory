package volley.com.volleyapplication.app.moviedirectory.Util;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by UjjwalNUtsav on 25-03-2018.
 */

public class Pref {

    SharedPreferences sharedPreferences;

    public Pref(Activity activity) {
        sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);

    }

    public void setSearch(String search) {
        sharedPreferences.edit().putString("search", search).commit();
    }

    public String getSearch() {
        return sharedPreferences.getString("search", "Batman");
    }

}
