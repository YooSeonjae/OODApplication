package com.example.note.ood_term;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by isangjun on 2016. 11. 17..
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> arrayList = new ArrayList<>();
    TextView title;
    TextView tel;

    public ListViewAdapter(ArrayList<ListViewItem> item) {
        arrayList = item;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_cell, viewGroup, false);
        }

        title = (TextView) view.findViewById(R.id.cell_title);
        tel = (TextView) view.findViewById(R.id.cell_tel);

        ListViewItem item = arrayList.get(i);

        title.setText(item.getTitle());
        tel.setText(item.getTel());

        return view;
    }
}
