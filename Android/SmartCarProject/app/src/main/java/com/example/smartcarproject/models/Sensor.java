package com.example.smartcarproject.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class Sensor {
    public int getValue() {
        return mValue;
    }

    public void setValue(int mValue) {
        this.mValue = mValue;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    @com.google.gson.annotations.SerializedName("value")
    private int mValue;

    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("type")
    private int mType;

    @com.google.gson.annotations.SerializedName("date")
    private Date mDate;


    public Sensor() {

    }

    @Override
    public String toString() {
        return getId();
    }

    public Sensor(int type, String id, int value, Date date) {
        this.setType(type);
        this.setId(id);
        this.setValue(value);
        this.setDate(date);
    }

    public static class SensorItem {
        public final String id;
        public final int type;
        public final int value;
        public final Date date;

        public SensorItem(int type, String id, int value, Date date) {
            this.type = type;
            this.value = value;
            this.id = id;
            this.date = date;
        }
    }
    public static final List<Sensor.SensorItem> ITEMS = new ArrayList<SensorItem>();
}
