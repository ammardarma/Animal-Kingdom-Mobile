package com.ammar.animalkingdom;

import android.graphics.Color;

import java.util.Random;

public class ModelHewan {
    private String gambar;
    private String namaHewan;
    private String namaLatin;
    private String status;
    private String jenisMakanan;
    private String jenisSpesies;
    private String pesebaran;
    private String makananKesukaan;
    private String deskripsi;


    public ModelHewan(String gambar, String namaHewan, String namaLatin
                      , String status, String jenisMakanan, String jenisSpesies,
                      String pesebaran, String makananKesukaan, String deskripsi) {
        this.gambar = gambar;
        this.namaHewan = namaHewan;
        this.namaLatin = namaLatin;
        this.status = status;
        this.jenisMakanan = jenisMakanan;
        this.jenisSpesies = jenisSpesies;
        this.pesebaran = pesebaran;
        this.makananKesukaan = makananKesukaan;
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public String getNamaLatin() {
        return namaLatin;
    }

    public void setNamaLatin(String namaLatin) {
        this.namaLatin = namaLatin;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getJenisMakanan() { return jenisMakanan; }

    public void setJenisMakanan(String jenisMakanan) { this.jenisMakanan = jenisMakanan; }

    public String getJenisSpesies() { return jenisSpesies; }

    public void setJenisSpesies(String jenisSpesies) { this.jenisSpesies = jenisSpesies; }

    public String getPesebaran() { return pesebaran; }

    public void setPesebaran(String pesebaran) { this.pesebaran = pesebaran; }

    public String getMakananKesukaan() { return makananKesukaan; }

    public void setMakananKesukaan(String makananKesukaan) { this.makananKesukaan = makananKesukaan; }

    public String getDeskripsi() { return deskripsi; }

    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }


}
