package com.example.note.ood_term;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteViewActivity extends AppCompatActivity {
    public static ArrayList<FavoriteListViewItem> items = new ArrayList<>();
    ListView listView;
    FavoriteListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);

        setTitle("즐겨찾기");

        listView = (ListView) findViewById(R.id.favorite_list);

        adapter = new FavoriteListViewAdapter(items);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FavoriteViewActivity.this, DetailViewActivity.class);
                intent.putExtra("class", "FavoriteListView");
                intent.putExtra("item", items.get(i).getItem());

                startActivity(intent);
            }
        });
   }
}
