package com.example.note.ood_term;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by isangjun on 2016. 11. 22..
 */

public class ReviewExpandableListViewAdapter extends BaseExpandableListAdapter {
    public ArrayList<ReviewExpandableListViewItem> child_list = new ArrayList<>();

    public ReviewExpandableListViewAdapter(ArrayList<ReviewExpandableListViewItem> items) {
        child_list = items;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_parent_cell, viewGroup, false);
        }

        TextView parentText = (TextView) view.findViewById(R.id.expandable_parent);
        parentText.setText("리뷰 보기");

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_child_cell, viewGroup, false);
        }

        TextView child_title = (TextView) view.findViewById(R.id.child_cell_title);
        TextView child_name = (TextView) view.findViewById(R.id.child_cell_blogname);

        child_title.setText(child_list.get(i1).getTitle());
        child_name.setText(child_list.get(i1).getName());

        return view;
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_list.get(i1);
    }

    @Override
    public int getChildrenCount(int i) {
        return child_list.size();
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
