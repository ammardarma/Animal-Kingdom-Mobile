 package com.ammar.animalkingdom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import maes.tech.intentanim.CustomIntent;

 public class SubHome extends AppCompatActivity{
    JSONArray arrayGambar;
    Context context;
    TextView penjelasanTxt;
    TextView judulTxt;
    LinearLayout LLbg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_home);
        RecyclerView teamsView = findViewById(R.id.recycle_view);
        penjelasanTxt = findViewById(R.id.subjudul);
        judulTxt = findViewById(R.id.judul);
        LLbg = findViewById(R.id.LLbg);;

        Bundle bundle = getIntent().getExtras();
        LLbg.setBackgroundResource(R.drawable.layout_bg);

        GradientDrawable drawable = (GradientDrawable) LLbg.getBackground();
        RandomColor randomColor = new RandomColor();
        drawable.setColor(getResources().getColor(R.color.identity));


        Intent intent = getIntent();
        String jsonArray = intent.getStringExtra("jsonArray");
        penjelasanTxt.setText(intent.getStringExtra("penjelasan"));
        judulTxt.setText(intent.getStringExtra("judul"));

        try {
            JSONArray ArrayGambar = new JSONArray(jsonArray);
            arrayGambar = ArrayGambar;
        } catch (JSONException e) {
            e.printStackTrace();
        }


        List<ModelHewan> hewans = new ArrayList<>();

        for(int i = 0; i < arrayGambar.length(); i++){
            try {
                JSONObject dataobj = arrayGambar.getJSONObject(i);
                hewans.add(new ModelHewan(dataobj.getString("gambar").trim(),
                                        dataobj.getString("nama").trim(),
                                        dataobj.getString("namaLatin").trim(),
                                        dataobj.getString("status").trim(),
                                        dataobj.getString("jenisMakanan").trim(),
                                        dataobj.getString("jenisSpesies").trim(),
                                        dataobj.getString("pesebaran").trim(),
                                        dataobj.getString("makananKesukaan").trim(),
                                        dataobj.getString("Deskripsi").trim()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(hewans, new Comparator<ModelHewan>() {
            @Override
            public int compare(ModelHewan o1, ModelHewan o2) {
                return o1.getNamaHewan().compareTo(o2.getNamaHewan());
            }
        });

        ImageAdapter adapter = new ImageAdapter(this, hewans);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);
    }

     @Override
     public void onBackPressed() {
         super.onBackPressed();
         Intent intent = new Intent(SubHome.this, homeActivity.class);
         startActivity(intent);
         CustomIntent.customType(this, "right-to-left");
         finish();
     }
 }