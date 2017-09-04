package com.example.note.ood_term;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by NOTE on 2016-11-16.
 */

public class KindViewActivity extends AppCompatActivity {

    ImageView koreaButton, chinaButton, usaButton, japanButton, fastButton, easyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kind_layout);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_list);
        koreaButton = (ImageView) findViewById(R.id.koreabutton);
        koreaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KindViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "한식");
                startActivity(intent);
            }
        });

        chinaButton = (ImageView) findViewById(R.id.chinabutton);
        chinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KindViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "중식");
                startActivity(intent);
            }
        });

        usaButton = (ImageView) findViewById(R.id.usabutton);
        usaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KindViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "양식");
                startActivity(intent);
            }
        });

        japanButton = (ImageView) findViewById(R.id.japanbutton);
        japanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KindViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "일식");
                startActivity(intent);
            }
        });

        fastButton = (ImageView) findViewById(R.id.fastbutton);
        fastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KindViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "패스트푸드");
                startActivity(intent);
            }
        });

        easyButton = (ImageView) findViewById(R.id.easybutton);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KindViewActivity.this, ListViewActivity.class);
                intent.putExtra("name", "분식");
                startActivity(intent);
            }
        });
    }
}