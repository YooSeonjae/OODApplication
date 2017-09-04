package com.example.note.ood_term;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity {
    static final String clientId = "pCjoxHCn4MPi8uZ0Zww0";
    static final String clientSecret = "5k9yYZ8ZwP";

    ImageView tasteButton, kindButton, favoriteButton, gameButton, infoButton, adviceButton;

    private long l_BackKey_RepeatTimer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);


        tasteButton = (ImageView) findViewById(R.id.fastbutton);
        tasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                intent.putExtra("name", "맛집");
                startActivity(intent);
            }
        });

        kindButton = (ImageView) findViewById(R.id.usabutton);
        kindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KindViewActivity.class);
                startActivity(intent);
            }
        });

        favoriteButton = (ImageView) findViewById(R.id.chinabutton);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoriteViewActivity.class);
                startActivity(intent);
            }
        });

        gameButton = (ImageView) findViewById(R.id.koreabutton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameViewActivity.class);
                startActivity(intent);
            }
        });

        adviceButton = (ImageView) findViewById(R.id.easybutton);
        adviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdviceViewActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onButtonClicked(View v) {
        Intent infoButton;
        infoButton = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cnuis.cnu.ac.kr/jsp/etc/weekMenuFrame.jsp"));

        startActivity(infoButton);

    }

    @Override
    public void onBackPressed() {
        if((System.currentTimeMillis() - l_BackKey_RepeatTimer) < 1500){
            finish();
        }
        else {
            l_BackKey_RepeatTimer = System.currentTimeMillis();
            Toast.makeText(this, "'뒤로' 버튼을 한번 더 눌러서 종료하세요.", Toast.LENGTH_SHORT).show();
        }
    }

}
