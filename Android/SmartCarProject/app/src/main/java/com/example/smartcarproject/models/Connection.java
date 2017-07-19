package com.example.smartcarproject.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class Connection {

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }


    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("date")
    private Date mDate;

    public Connection() {

    }

    @Override
    public String toString() {
        return getId();
    }

    public Connection(String id, Date date) {;
        this.setId(id);
        this.setDate(date);
    }
    public static class ConnectionItem {
        public final String id;
        public final Date date;

        public ConnectionItem(String id, Date date) {
            this.id = id;
            this.date = date;
        }
    }
    public static final List<Connection.ConnectionItem> ITEMS = new ArrayList<ConnectionItem>();

}
