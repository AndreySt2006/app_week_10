package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import org.json.*;
import java.io.*;
import java.util.*;

public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("movies.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonStr = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStr.append(line);
            }
            reader.close();

            JSONArray jsonArray = new JSONArray(jsonStr.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String title = "";
                String yearStr = "";
                String genre = obj.optString("genre", "Unknown");
                String poster = obj.optString("poster", "unknown_poster"); // Use "unknown_poster" as per Movie class

                try {
                    title = obj.getString("title");
                } catch (Exception e) {
                    title = "Unknown movie name"; // Corrected the incomplete string
                }

                try {
                    yearStr = obj.getString("year");
                } catch (Exception e) {
                    yearStr = null; // Set to null to be handled by Movie constructor
                }

                movies.add(new Movie(title, yearStr, genre, poster));
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error: JSON file not found!", e);
            handleJsonException(e);
        } catch (JSONException | IOException e) {
            Log.e(TAG, "Error reading JSON file!", e);
            handleJsonException(e);
        }
        return movies;
    }

    public static void handleJsonException(Exception e) {
        e.printStackTrace();
    }
}