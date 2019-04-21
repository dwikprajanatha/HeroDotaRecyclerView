package com.example.n.belajarswitchview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailHeroes extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_hero);
        getIncomingIntent();

    }

    private void getIncomingIntent() {

        if(getIntent().hasExtra("hero_name") && getIntent().hasExtra("hero_bio") && getIntent().hasExtra("hero_pic")){

            String heroName = getIntent().getStringExtra("hero_name");
            String heroBio = getIntent().getStringExtra("hero_bio");
            String heroPic = getIntent().getStringExtra("hero_pic");

            setHeroData(heroName,heroPic,heroBio);

        }

    }

    private void setHeroData(String heroName, String heroPic, String heroBio) {

        TextView heading = findViewById(R.id.detail_hero_name);
        heading.setText(heroName);

        TextView bio = findViewById(R.id.detail_hero_bio);
        bio.setText(heroBio);

        ImageView pic = findViewById(R.id.detail_hero_pic);

        Glide.with(this)
                .asBitmap()
                .load(heroPic)
                .into(pic);

    }
}
