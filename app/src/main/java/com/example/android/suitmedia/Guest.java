package com.example.android.suitmedia;

/**
 * Created by Yudhistira Caraka on 11/2/2018.
 */

public class Guest {

    private String name,birthday;
    int id,gambar;

    public Guest(int id,String name, String birthday,int gambar) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gambar = gambar;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
