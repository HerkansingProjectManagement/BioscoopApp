package nl.bioscoop.mijnbios;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nl.bioscoop.biosapi.model.movie.MoviePoster;
import nl.bioscoop.mijnbios.utils.Images;

import static nl.bioscoop.mijnbios.utils.Views.inflateLayout;

public class MovieAdapter extends ArrayAdapter<MoviePoster> {
    public MovieAdapter(@NonNull Context context, @NonNull ArrayList<MoviePoster> list){
        super(context, 0, list);
    }

    @Override @NonNull public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @NonNull View view = convertView != null ? convertView : inflateLayout(R.layout.movie_griditem, parent);
        @Nullable MoviePoster movie = getItem(position);

        if(movie == null) {
            view.setVisibility(View.GONE);
        } else {
            TextView movieTitle = view.findViewById(R.id.title);
            movieTitle.setText(movie.getTitle());

            Images.loadImage(movie.getPoster(), view.findViewById(R.id.poster));
        }

        return view;
    }
}
