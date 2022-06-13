package com.ammar.animalkingdom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.royrodriguez.transitionbutton.TransitionButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStar;
    TransitionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    void initView() {
        btnNext = findViewById(R.id.next);
        btnStar = findViewById(R.id.star);
        btnNext.setOnClickListener(this);
        btnStar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.next){
            btnNext.startAnimation();
            btnNext.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                @Override
                public void onAnimationStopEnd() {
                    Intent intent = new Intent(MainActivity.this, homeActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }else if(v.getId() == R.id.star){
            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6281211557242"));
            startActivity(intent2);
        }
    }
}