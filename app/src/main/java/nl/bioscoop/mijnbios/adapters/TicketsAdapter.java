package nl.bioscoop.mijnbios.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import nl.bioscoop.biosapi.model.Ticket;
import nl.bioscoop.mijnbios.R;
import nl.bioscoop.mijnbios.utils.DateTime;
import nl.bioscoop.mijnbios.utils.Views;

public class TicketsAdapter extends ArrayAdapter<Ticket> {
    public TicketsAdapter(@NonNull Context context, @NonNull ArrayList<Ticket> list){
        super(context, 0, list);
    }

    @Override @NonNull public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @NonNull View view = convertView != null ? convertView : Views.inflateLayout(R.layout.activity_main_ticket_item, parent);
        @Nullable Ticket ticket = getItem(position);

        if(ticket == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
            View card = view.findViewById(R.id.card);
            card.setOnClickListener(view1 -> ((ListView) parent).performItemClick(convertView, position, position));

            TextView seat = view.findViewById(R.id.seat);
            String[] seats = ticket.getSeat().split(",");
            seat.setText(seats.length > 1 ? seats[seats.length - 1] + "-" + seats[0] : seats[0]);

            TextView movieTitle = view.findViewById(R.id.movieTitle);
            movieTitle.setText(ticket.getShow().getMovie().getTitle());

            TextView datetime = view.findViewById(R.id.datetime);
            datetime.setText(DateTime.format(ticket.getShow().getDatetime(), DateFormat.MEDIUM, DateFormat.SHORT, " - ", true, Locale.getDefault()));
        }

        return view;
    }
}
