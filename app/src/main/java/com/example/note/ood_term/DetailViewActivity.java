package com.example.note.ood_term;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by isangjun on 2016. 11. 21..
 */

public class DetailViewActivity extends AppCompatActivity {
    TextView des;
    TextView tel;
    TextView address;

    boolean isSelected = false;
    String sourceIntent;
    ListViewItem list_item;

    ExpandableListView list_view;
    ReviewExpandableListViewAdapter adapter;

    String name;
    final String DAEJEON = "대전";
    XmlNaverAPI api;
    ArrayList<ReviewExpandableListViewItem> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        des = (TextView) findViewById(R.id.detail_des);
        tel = (TextView) findViewById(R.id.detail_tel);
        address = (TextView) findViewById(R.id.detail_address);

        Intent intent = getIntent();

        sourceIntent = intent.getStringExtra("class");
        list_item = (ListViewItem) intent.getSerializableExtra("item");

        name = list_item.getTitle();

        setTitle(list_item.getTitle());

        des.setText(list_item.getDes());
        tel.setText(list_item.getTel());
        address.setText(list_item.getAddress());

        new ASyncData().execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        if (sourceIntent.equals("ListView")) {
            inflater.inflate(R.menu.activity_detail_favorite, menu);

        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                if (!isSelected) {
                    item.setIcon(R.drawable.ic_star_24dp);

                    final View view = getLayoutInflater().inflate(R.layout.dialog_rating, null);

                    AlertDialog.Builder builder = new AlertDialog.Builder(DetailViewActivity.this);

                    builder.setTitle("평점을 남겨주세요.")
                            .setView(view)
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
                                    FavoriteViewActivity.items.add(new FavoriteListViewItem(list_item, Float.toString(ratingBar.getRating())));
                                }
                            })
                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                    isSelected = true;
                } else {
                    item.setIcon(R.drawable.ic_star_border_24dp);

                    int index = 0;
                    while(index < FavoriteViewActivity.items.size()) {
                        if(FavoriteViewActivity.items.get(index).getItem().equals(list_item)) {
                            FavoriteViewActivity.items.remove(index);
                            break;
                        } else {
                            index++;
                        }
                    }

                    isSelected = false;
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class ASyncData extends AsyncTask<String , String, ArrayList<ReviewExpandableListViewItem>> {
        @Override
        protected ArrayList<ReviewExpandableListViewItem> doInBackground(String... strings) {

            api = new XmlNaverAPI(DAEJEON + name);
            item = api.downloadReviewData();

            return item;
        }

        @Override
        protected void onPostExecute(ArrayList<ReviewExpandableListViewItem> listViewItems) {
            super.onPostExecute(listViewItems);

            list_view = (ExpandableListView) findViewById(R.id.expandable_list);
            adapter = new ReviewExpandableListViewAdapter(item);

            adapter.notifyDataSetChanged();

            list_view.setAdapter(adapter);
        }
    }
}
