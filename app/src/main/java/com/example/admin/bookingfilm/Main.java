package com.example.admin.bookingfilm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    ArrayList<Film> filmList = new ArrayList<Film>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        addMovies();

        FilmAdapter  adapter = new FilmAdapter(this, R.layout.row,filmList);
        listView = (ListView) findViewById(R.id.mylist);
        listView.setAdapter(adapter);
    }

    private void addMovies() {
        filmList.add( new Film(129,R.drawable.marvel,"Dai Uy Marvel"));
        filmList.add( new Film(100,R.drawable.hai_phuong,"Hai Phuong"));
        filmList.add( new Film(115,R.drawable.vu_quy_dai_nao,"Dai Nao Vu Quy"));
    }
}
