package com.example.mysubmission;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class AboutActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        ImageView photoReceived;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        photoReceived = findViewById(R.id.img_about_photo);

        Glide.with(this)
                .load(R.drawable.afif)
                .into(photoReceived);
    }
}
