package com.example.admin.bookingfilm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main extends AppCompatActivity {

    ArrayList<Film> filmList = new ArrayList<Film>();
    FilmAdapter  adapter;
    ListView listView;
    private int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        addMovies();

        adapter = new FilmAdapter(this, R.layout.row,filmList);
        listView = (ListView) findViewById(R.id.mylist);
        listView.setAdapter(adapter);
    }

    private void addMovies() {
        filmList.add( new Film(129,R.drawable.marvel,"Dai Uy Marvel"));
        filmList.add( new Film(100,R.drawable.hai_phuong,"Hai Phuong"));
        filmList.add( new Film(115,R.drawable.vu_quy_dai_nao,"Dai Nao Vu Quy"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if (id == R.id.addBar){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
           // filmList.add(new Film(120,R.drawable.marvel, "Demo"));
           // adapter.notifyDataSetChanged();
            return true;
        }
        return  super.onOptionsItemSelected(item);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());

             int i = Integer.parseInt((inputStream.toString()));

                Film m = new Film(120,i,"Demo");
                filmList.add(m);
                adapter.notifyDataSetChanged();

            }catch (IOException ex){
                ex.printStackTrace();
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
            }
        }
    }
}
