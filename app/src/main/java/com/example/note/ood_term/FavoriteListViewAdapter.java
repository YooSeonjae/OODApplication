package com.example.note.ood_term;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by isangjun on 2016. 11. 21..
 */

public class FavoriteListViewAdapter extends BaseAdapter {
    public ArrayList<FavoriteListViewItem> items;
    TextView title;
    TextView rating;

    public FavoriteListViewAdapter(ArrayList<FavoriteListViewItem> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.favorite_list_cell, viewGroup, false);
        }

        title = (TextView) view.findViewById(R.id.favorite_title);
        rating = (TextView) view.findViewById(R.id.favorite_rating);

        FavoriteListViewItem item = items.get(i);

        title.setText(item.getItem().getTitle());
        rating.setText(item.getRating());

        return view;
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
