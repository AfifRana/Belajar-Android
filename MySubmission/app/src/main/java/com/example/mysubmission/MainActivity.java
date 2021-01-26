package com.example.mysubmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mysubmission.adapter.ListFoodAdapter;
import com.example.mysubmission.model.Food;
import com.example.mysubmission.model.FoodsData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Food> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(FoodsData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListFoodAdapter listFoodAdapter = new ListFoodAdapter(list);
        rvHeroes.setAdapter(listFoodAdapter);

        listFoodAdapter.setOnItemClickCallback(new ListFoodAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Food data) {
                showSelectedHero(data);
            }
        });
    }

    private void showSelectedHero(Food data) {
        Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
        moveIntent.putExtra(MoveActivity.EXTRA_NAME, data.getName());
        moveIntent.putExtra(MoveActivity.EXTRA_PRICE, data.getPrice());
        moveIntent.putExtra(MoveActivity.EXTRA_FROM, data.getFrom());
        moveIntent.putExtra(MoveActivity.EXTRA_NOTES, data.getNotes());
        moveIntent.putExtra(MoveActivity.EXTRA_PHOTO, data.getPhoto());
        startActivity(moveIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_about:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
    }
}