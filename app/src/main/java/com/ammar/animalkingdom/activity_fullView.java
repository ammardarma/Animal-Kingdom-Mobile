package com.ammar.animalkingdom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import maes.tech.intentanim.CustomIntent;

public class activity_fullView extends AppCompatActivity {

ImageView vGambar;
TextView vNamaHewan;
TextView vNamaLatin;
TextView vStatus;
TextView vJenisMakanan;
TextView vJenisSpesies;
TextView vPesebaran;
TextView vMakananKesukaan;
TextView vDeskripsi;
LinearLayout LLbg;
ImageView imageStatus,imageMakananKesukaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        vGambar = (ImageView) findViewById(R.id.gambar);
        vNamaHewan = (TextView) findViewById(R.id.namaHewan);
        vNamaLatin = (TextView) findViewById(R.id.namaLatin);
        vStatus = (TextView) findViewById(R.id.status);
        vJenisMakanan = (TextView) findViewById(R.id.jenisMakanan);
        vJenisSpesies = (TextView) findViewById(R.id.jenisSpesies);
        vPesebaran = (TextView) findViewById(R.id.pesebaran);
        vMakananKesukaan = (TextView) findViewById(R.id.makananKesukaan);
        vDeskripsi = (TextView) findViewById(R.id.deskripsi);
        LLbg = (LinearLayout) findViewById(R.id.viewLLbg);
        imageStatus = (ImageView) findViewById(R.id.imagestatus);
        imageMakananKesukaan = (ImageView) findViewById(R.id.imagemakanankesukaan);



        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();

            Glide.with(activity_fullView.this)
                    .load(bundle.getString("gambar"))
                    .fitCenter()
                    .placeholder(R.drawable.ic_launcher_background)
                    .apply(RequestOptions.circleCropTransform())
                    .into(vGambar);

            LLbg.setBackgroundResource(R.drawable.fullview_bg);


            GradientDrawable drawable = (GradientDrawable) LLbg.getBackground();
            RandomColor randomColor = new RandomColor();
            drawable.setColor(randomColor.getRandomColorCode());


            vNamaHewan.setText(bundle.getString("namaHewan"));
            vNamaLatin.setText("("+bundle.getString("namaLatin")+")");
            vStatus.setText(bundle.getString("status"));
            if(String.valueOf(bundle.getString("status").toLowerCase().trim()).equals("hewan liar")) {
                imageStatus.setImageDrawable(getResources().getDrawable(R.drawable.statusno));
            }
            vJenisMakanan.setText(bundle.getString("jenisMakanan"));
            if(String.valueOf(bundle.getString("jenisMakanan")).toLowerCase().trim().equals("omnivora")){
                imageMakananKesukaan.setImageDrawable(getResources().getDrawable(R.drawable.omnivora));
            }else if(String.valueOf(bundle.getString("jenisMakanan")).toLowerCase().trim().equals("herbivora")){
                imageMakananKesukaan.setImageDrawable(getResources().getDrawable(R.drawable.herbivora));
            }
            vJenisSpesies.setText(bundle.getString("jenisSpesies"));
            vPesebaran.setText(bundle.getString("pesebaran"));
            vMakananKesukaan.setText(bundle.getString("makananKesukaan"));
            vDeskripsi.setText(bundle.getString("deskripsi"));
        }

    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "bottom-to-up");
    }
}