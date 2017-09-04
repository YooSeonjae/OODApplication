package com.example.note.ood_term;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by isangjun on 2016. 11. 17..
 */

public class ListViewActivity extends AppCompatActivity {
    String name;
    final String DAEJEON = "대전";
    XmlNaverAPI api;
    ArrayList<ListViewItem> item = new ArrayList<>();
    ListView listView;
    ListViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Intent intent = getIntent();
        name = " 궁동 " + intent.getStringExtra("name");

        setTitle(name);

        listView = (ListView) findViewById(R.id.list_view1);

        new ASyncData().execute();

    }



    public class ASyncData extends AsyncTask<String , String, ArrayList<ListViewItem>> {
        @Override
        protected ArrayList<ListViewItem> doInBackground(String... strings) {

            api = new XmlNaverAPI(DAEJEON + name);
            item = api.downloadStoreData();


            return item;
        }

        @Override
        protected void onPostExecute(ArrayList<ListViewItem> listViewItems) {
            super.onPostExecute(listViewItems);

            adapter = new ListViewAdapter(item);
            adapter.notifyDataSetChanged();

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListViewActivity.this, DetailViewActivity.class);
                    intent.putExtra("class", "ListView");
                    intent.putExtra("item", item.get(i));

                    startActivity(intent);
                }
            });
        }
    }
}
