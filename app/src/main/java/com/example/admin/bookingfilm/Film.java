package com.example.admin.bookingfilm;

/**
 * Created by Admin on 10/03/2019.
 */
public class Film {
    private String title;
    private int image;
    private int time;

    public Film(int _time, int _image, String _title) {
        this.time = _time;
        this.image = _image;
        this.title = _title;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
