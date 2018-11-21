package com.example.android.suitmedia;

/**
 * Created by Yudhistira Caraka on 11/2/2018.
 */

public class Event {

    private String nama,tanggal,keterangan;
    private int Gambar;

    public Event(String nama, String tanggal, int gambar,String keterangan) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.Gambar = gambar;
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }
}
