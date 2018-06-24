package nl.bioscoop.mijnbios.model.movie;

import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class MoviePoster extends Movie {
    private @NonNull String title;
    private @NonNull String poster;

    public MoviePoster(@NonNull JSONObject json) throws JSONException {
        this(json.getInt("id"), json.getString("title"), json.getString("poster"));
    }

    public MoviePoster(int id, @NonNull String title, @NonNull String poster) {
        super(id);
        this.title = title;
        this.poster = poster;
    }

    @NonNull public String getTitle() {
        return title;
    }

    @NonNull public String getPoster() {
        return poster;
    }
}