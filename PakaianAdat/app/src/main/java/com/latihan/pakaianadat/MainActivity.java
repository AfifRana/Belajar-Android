package com.latihan.pakaianadat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Pakaian> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        list.addAll(Data_pakaian.getPakaian());
        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PakaianAdapter pakaianAdapter = new PakaianAdapter(list);
        recyclerView.setAdapter(pakaianAdapter);

        pakaianAdapter.setOnItemClickCallback(new PakaianAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Pakaian pakaian) {
                showSelectedPakaian(pakaian);
            }
        });
    }

    private void showSelectedPakaian(Pakaian pakaian) {
        Intent intentDetail = new Intent(MainActivity.this, Detail.class);
        intentDetail.putExtra(Detail.nama, pakaian.getNama());
        intentDetail.putExtra(Detail.keterangan, pakaian.getKeterangan());
        intentDetail.putExtra(Detail.foto, pakaian.getGambar());
        startActivity(intentDetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int select){
        switch (select){
            case R.id.Menu:
                Intent menuProfil = new Intent(MainActivity.this, Profil.class);
                startActivity(menuProfil);
                break;
        }
    }

}
