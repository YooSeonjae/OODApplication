package com.example.note.ood_term;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by isangjun on 2016. 11. 17..
 */

public class XmlNaverAPI {
    public String searchData;

    public XmlNaverAPI(String searchData) {
        this.searchData = searchData;
    }

    public ArrayList<ListViewItem> downloadStoreData() {
        BufferedReader br = null;

        ArrayList<ListViewItem> item = new ArrayList<>();
        String title = null, description = null, telephone = null, address = null;

        try {
            String text = URLEncoder.encode(searchData, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/local.xml?query=" + text;
            URL url = new URL(apiURL);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", MainActivity.clientId);
            con.setRequestProperty("X-Naver-Client-Secret", MainActivity.clientSecret);
            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(br);

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();

                        if (tag.equals("item")) {
                            title = null;
                            address = null;
                        }
                        if (tag.equals("title")) {
                            title = xpp.nextText();
                        }
                        if (tag.equals("description")) {
                            String str = xpp.nextText();

                            if(str == "") {
                                description = "설명이 없습니다.";
                            } else {
                                description = str;
                            }
                        }
                        if (tag.equals("telephone")) {
                            telephone = xpp.nextText();
                        }
                        if (tag.equals("address")) {
                            address = xpp.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tag = xpp.getName();

                        if (tag.equals("item")) {
                            if(title != null) {
                                item.add(new ListViewItem(title, description, telephone, address));
                            }
                        }
                        break;
                }

                eventType = xpp.next();
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        };

        return item;
    }

    public ArrayList<ReviewExpandableListViewItem> downloadReviewData() {
        BufferedReader br = null;

        ArrayList<ReviewExpandableListViewItem> item = new ArrayList<>();
        String title = null, link = null, bloggername = null;

        try {
            String text = URLEncoder.encode(searchData, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query=" + text;
            URL url = new URL(apiURL);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", MainActivity.clientId);
            con.setRequestProperty("X-Naver-Client-Secret", MainActivity.clientSecret);
            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(br);

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();

                        if (tag.equals("item")) {
                            title = null;
                            link = null;
                            bloggername = null;
                        }
                        if (tag.equals("title")) {
                            title = xpp.nextText();
                            title = title.replaceAll("<b>", " ");
                            title = title.replaceAll("</b>", " ");
                        }
                        if (tag.equals("link")) {
                            link = xpp.nextText();
                        }
                        if (tag.equals("bloggername")) {
                            bloggername = xpp.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tag = xpp.getName();

                        if (tag.equals("item")) {
                            if(title != null) {
                                item.add(new ReviewExpandableListViewItem(title, bloggername, link));
                            }
                        }
                        break;
                }

                eventType = xpp.next();
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        };

        return item;
    }

}
