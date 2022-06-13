package com.ammar.animalkingdom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.royrodriguez.transitionbutton.TransitionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import maes.tech.intentanim.CustomIntent;

public class homeActivity extends AppCompatActivity implements View.OnClickListener  {
    TransitionButton btnMamalia, btnAves, btnPisces, btnReptil, btnAmfibi;
    JSONArray arrayMamalia;
    JSONArray arrayAves;
    JSONArray arrayPisces;
    JSONArray arrayAmfibi;
    JSONArray arrayReptil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        getData();
    }

    private void initView() {
        btnMamalia = findViewById(R.id.startMamalia);
        btnAves = findViewById(R.id.startAves);
        btnPisces = findViewById(R.id.startPisces);
        btnReptil = findViewById(R.id.startReptil);
        btnAmfibi = findViewById(R.id.startAmphibi);

        btnMamalia.setOnClickListener(this);
        btnAves.setOnClickListener(this);
        btnPisces.setOnClickListener(this);
        btnReptil.setOnClickListener(this);
        btnAmfibi.setOnClickListener(this);
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://ammardarma.github.io/Android-main/db.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonPost = new JSONObject(response);
                    JSONArray ArrayMamalia = jsonPost.getJSONArray("mamalia");
                    JSONArray ArrayAves = jsonPost.getJSONArray("aves");
                    JSONArray ArrayPisces = jsonPost.getJSONArray("pisces");
                    JSONArray ArrayAmfibi = jsonPost.getJSONArray("amfibi");
                    JSONArray ArrayReptil = jsonPost.getJSONArray("reptil");

                    arrayMamalia = ArrayMamalia;
                    arrayAves = ArrayAves;
                    arrayPisces = ArrayPisces;
                    arrayAmfibi = ArrayAmfibi;
                    arrayReptil = ArrayReptil;



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Error Response", error.toString());
                }
            });
        queue.add(stringRequest);
        }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.startMamalia) {
            btnMamalia.startAnimation();
            btnMamalia.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                @Override
                public void onAnimationStopEnd() {
                    Intent intent = new Intent(homeActivity.this, SubHome.class);
                    intent.putExtra("jsonArray", arrayMamalia.toString());
                    intent.putExtra("judul", "Mamalia");
                    intent.putExtra("penjelasan", "Ciri khas dari mammalia adalah kelenjar susu. Susu dihasilkan oleh kelenjar (mammae) yang terdapat  di daerah perut atau dada. Mammalia disebut juga hewan menyusui karena menyusui anaknya.");
                    startActivity(intent);
                    CustomIntent.customType(homeActivity.this, "left-to-right");
                    finish();
                }
            });
        }else if(v.getId() == R.id.startAves) {
            btnAves.startAnimation();
            btnAves.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                @Override
                public void onAnimationStopEnd() {
                    Intent intent = new Intent(homeActivity.this, SubHome.class);
                    intent.putExtra("jsonArray", arrayAves.toString());
                    intent.putExtra("judul", "Aves");
                    intent.putExtra("penjelasan", "Aves memiliki suhu badan homoiterm (suhu badan tetap, tidak terpengaruh suhu lingkungan). Memiliki tubuh berbulu yang membentuk sayap dan digunakan untuk terbang. Tulangnya berongga sehingga ringan. Berkembang biak secara bertelur (ovipar) dan pembuahan di dalam tubuh. Telur aves bercangkang dan memiliki kuning telur yang besar. ");
                    startActivity(intent);
                    CustomIntent.customType(homeActivity.this, "left-to-right");
                    finish();
                }
            });
        }else if(v.getId() == R.id.startPisces){
            btnPisces.startAnimation();
            btnPisces.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                @Override
                public void onAnimationStopEnd() {
                    Intent intent = new Intent(homeActivity.this, SubHome.class);
                    intent.putExtra("jsonArray", arrayPisces.toString());
                    intent.putExtra("judul", "Pisces");
                    intent.putExtra("penjelasan", "Pisces memiliki habitat di air dengan alat pernafasan berupa insang. Hewan ini mempunyai sirip yang berfungsi menentukan arah gerak di dalam air dan memiliki gurat sisi untuk mengetahui tekanan air. Termasuk hewan berdarah dingin (poikiloterm), yaitu suhu tubuh disesuaikan dengan lingkungan. Pisces berkembang biak dengan bertelur (ovipar). ");
                    startActivity(intent);
                    CustomIntent.customType(homeActivity.this, "left-to-right");
                    finish();
                }
            });
        }else if(v.getId() == R.id.startAmphibi){
            btnAmfibi.startAnimation();
            btnAmfibi.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                @Override
                public void onAnimationStopEnd() {
                    Intent intent = new Intent(homeActivity.this, SubHome.class);
                    intent.putExtra("jsonArray", arrayAmfibi.toString());
                    intent.putExtra("judul", "Amfibi");
                    intent.putExtra("penjelasan", "Amphibia merupakan hewan yang dapat hidup pada dua habitat, yaitu darat dan air, namun tidak semua jenis Amphibia hidup di dua tempat kehidupan. Beberapa jenis katak, salamander, dan caecilian ada yang hanya hidup di air dan ada hanya di darat. Namun habitatnya secara keseluruhan dekat dengan air dan tempat yang lembap seperti rawa dan hutan hujan tropis. Hewan ini bernafas dengan insang, paru-paru dan memiliki suhu badan poikiloterm, berkembang biak dengan bertelur (ovipar) dan pembuahan terjadi di luar tubuh (eksternal).");
                    startActivity(intent);
                    CustomIntent.customType(homeActivity.this, "left-to-right");
                    finish();
                }
            });
        }else if(v.getId() == R.id.startReptil){
            btnReptil.startAnimation();
            btnReptil.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                @Override
                public void onAnimationStopEnd() {
                    Intent intent = new Intent(homeActivity.this, SubHome.class);
                    intent.putExtra("jsonArray", arrayReptil.toString());
                    intent.putExtra("judul", "Reptil");
                    intent.putExtra("penjelasan", "Reptilia (dalam bahasa latin, reptil = melata) memiliki kulit bersisik yang terbuat dari zat tanduk (keratin). Sisik berfungsi mencegah kekeringan. Ciri lain yang dimiliki oleh sebagian besar reptil adalah anggota tubuh berjari lima, bernapas dengan paru-paru, jantung beruang tiga atau empat, menggunakan energi lingkungan untuk mengatur suhu tubuhnya sehingga tergolong hewan poikiloterm, fertilisasi secara internal, menghasilkan telur sehingga tergolong ovipar dengan telur bercangkang.");
                    startActivity(intent);
                    CustomIntent.customType(homeActivity.this, "left-to-right");
                    finish();
                }
            });
            
        }
    }
}