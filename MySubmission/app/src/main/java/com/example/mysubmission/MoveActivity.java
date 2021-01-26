package com.example.mysubmission;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MoveActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_FROM = "extra_from";
    public static final String EXTRA_NOTES = "extra_notes";
    public static final String EXTRA_PHOTO = "extra_photo";

    TextView tvNameReceived, tvPriceReceived, tvNotesReceived, tvFromReceived;
    ImageView photoReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ListViewHolder holder = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        tvNameReceived = findViewById(R.id.tv_detail_name);
        tvPriceReceived = findViewById(R.id.tv_detail_price);
        tvFromReceived = findViewById(R.id.tv_detail_from);
        tvNotesReceived = findViewById(R.id.tv_detail_notes);
        photoReceived = findViewById(R.id.img_detail_photo);

        tvNameReceived.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvPriceReceived.setText(getIntent().getStringExtra(EXTRA_PRICE));
        tvFromReceived.setText(getIntent().getStringExtra(EXTRA_FROM));
        tvNotesReceived.setText(getIntent().getStringExtra(EXTRA_NOTES));

        Glide.with(this)
                .load(getIntent().getStringExtra(EXTRA_PHOTO))
                .into(photoReceived);

        Button btnBuy = findViewById(R.id.buy_button);
        btnBuy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_button:
                Toast.makeText(this, "Kamu membeli " + tvNameReceived.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}