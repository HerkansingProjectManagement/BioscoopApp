package nl.bioscoop.mijnbios;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nl.bioscoop.biosapi.model.MovieShow;

import static nl.bioscoop.mijnbios.utils.Views.inflateLayout;

public class MovieShowPickerAdapter extends ArrayAdapter<MovieShow> {
    public MovieShowPickerAdapter(@NonNull Context context, @NonNull ArrayList<MovieShow> list){
        super(context, 0, list);
    }

    @Override @NonNull public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @NonNull View view = convertView != null ? convertView : inflateLayout(R.layout.show_picker_item, parent);
        @Nullable MovieShow movieShow = getItem(position);

        if(movieShow == null) {
            view.setVisibility(View.GONE);
        } else {
            TextView datetime = view.findViewById(R.id.datetime);
            datetime.setText(movieShow.getDatetime());
            TextView location = view.findViewById(R.id.location);
            location.setText(movieShow.getLocation());
        }

        return view;
    }
}
