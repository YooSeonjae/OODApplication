package com.example.note.ood_term;

/**
 * Created by isangjun on 2016. 11. 22..
 */

public class ReviewExpandableListViewItem {
    public String title;
    public String name;
    public String link;

    public ReviewExpandableListViewItem(String title, String name, String link) {
        this.title = title;
        this.name = name;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
