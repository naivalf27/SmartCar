package com.example.smartcarproject.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.smartcarproject.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class Command {

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
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

    @com.google.gson.annotations.SerializedName("count")
    private int mCount;

    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("type")
    private int mType;

    @com.google.gson.annotations.SerializedName("updatedDate")
    private Date mDate;


    public Command() {

    }

    @Override
    public String toString() {
        return getId();
    }

    public Command(int type, String id, int count, Date date) {
        this.setType(type);
        this.setId(id);
        this.setCount(count);
        this.setDate(date);
    }




}
