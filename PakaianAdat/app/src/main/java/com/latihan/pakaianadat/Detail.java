package com.latihan.pakaianadat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {
    TextView textViewName, textViewKeterangan;
    public static final String nama = "Nama" ;
    public static final String keterangan = "Keterangan" ;
    public static final String foto = "";

    ImageView imgPakaian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewName = findViewById(R.id.namaPakaian);
        textViewKeterangan = findViewById(R.id.tvKeterangan);
        imgPakaian = findViewById(R.id.gbrDetail);

        textViewName.setText(getIntent().getStringExtra(nama));
        textViewKeterangan.setText(getIntent().getStringExtra(keterangan));

        Glide.with(this)
                .load(getIntent().getStringExtra(foto))
                .into(imgPakaian);

    }
}
