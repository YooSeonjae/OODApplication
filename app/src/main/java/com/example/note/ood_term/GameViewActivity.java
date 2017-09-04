package com.example.note.ood_term;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by NOTE on 2016-11-16.
 */

public class GameViewActivity extends AppCompatActivity {

    ImageView random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomgame);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_game);
        random = (ImageView) findViewById(R.id.random);

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rannum = (int) (Math.random() * 6);
                switch (rannum) {
                    case 0:
                        random.setImageResource(R.drawable.korea);
                        break;
                    case 1:
                        random.setImageResource(R.drawable.japan);
                        break;
                    case 2:
                        random.setImageResource(R.drawable.china);
                        break;
                    case 3:
                        random.setImageResource(R.drawable.easy);
                        break;
                    case 4:
                        random.setImageResource(R.drawable.fast);
                        break;
                    case 5:
                        random.setImageResource(R.drawable.usa);
                        break;
                }
            }
        });
    }
}
