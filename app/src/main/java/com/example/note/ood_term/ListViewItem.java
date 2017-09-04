package com.example.note.ood_term;

import java.io.Serializable;

/**
 * Created by isangjun on 2016. 11. 17..
 */

public class ListViewItem implements Serializable {
    public String title;
    public String des;
    public String tel;
    public String address;

    public ListViewItem(String title, String des, String tel, String address) {
        this.title = title;
        this.des = des;
        this.tel = tel;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
