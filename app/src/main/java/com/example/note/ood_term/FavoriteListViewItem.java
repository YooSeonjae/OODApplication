package com.example.note.ood_term;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by isangjun on 2016. 11. 21..
 */

public class FavoriteListViewItem implements Serializable {
    public ListViewItem item;
    public String rating;

    public FavoriteListViewItem(ListViewItem item, String rating) {
        this.item = item;
        this.rating = rating;
    }

    public ListViewItem getItem() {
        return item;
    }

    public void setItem(ListViewItem item) {
        this.item = item;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
