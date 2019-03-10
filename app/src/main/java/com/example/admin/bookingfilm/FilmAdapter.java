package com.example.admin.bookingfilm;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 10/03/2019.
 */
public class FilmAdapter extends ArrayAdapter {

    Activity activity;
    int resource;
    ArrayList<Film> film;

    public FilmAdapter(Activity _activity, int _resource, ArrayList<Film> _film) {
        super(_activity, _resource, _film);
        activity = _activity;
        resource = _resource;
        film = _film;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View row = inflater.inflate(R.layout.row, null);

        Film f = film.get(position);

        ImageView img = (ImageView) row.findViewById(R.id.imgField);
        TextView time = (TextView) row.findViewById(R.id.timeField);
        TextView title = (TextView) row.findViewById(R.id.titleField);

        img.setImageResource(f.getImage());
        time.setText(f.getTime() + " minutes");
        title.setText(f.getTitle());
        return  row;
    }
}
