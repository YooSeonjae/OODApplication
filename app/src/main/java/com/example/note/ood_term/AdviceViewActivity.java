package com.example.note.ood_term;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by NOTE on 2016-11-16.
 */

public class AdviceViewActivity extends AppCompatActivity {
    ImageView tasteButton, kindButton, favoriteButton, gameButton, infoButton, adviceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_advice);
        tasteButton = (ImageView) findViewById(R.id.fastbutton);
        tasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviceViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "맛집");
                startActivity(intent);
            }
        });

        kindButton = (ImageView) findViewById(R.id.usabutton);
        kindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviceViewActivity.this, KindViewActivity.class);
                startActivity(intent);
            }
        });

        favoriteButton = (ImageView) findViewById(R.id.chinabutton);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviceViewActivity.this, FavoriteViewActivity.class);
                startActivity(intent);
            }
        });

        gameButton = (ImageView) findViewById(R.id.koreabutton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviceViewActivity.this, GameViewActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onButtonClicked(View v) {
        Intent infoButton;
        infoButton = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cnuis.cnu.ac.kr/jsp/etc/weekMenuFrame.jsp"));
        startActivity(infoButton);

    }
}
