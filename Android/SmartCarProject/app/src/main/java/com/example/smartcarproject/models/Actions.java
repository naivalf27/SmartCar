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

public class Actions {

    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    @com.google.gson.annotations.SerializedName("value")
    private String mValue;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;
    public Actions() {

    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "mId='" + mId + '\'' +
                ", mValue='" + mValue + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }

    public Actions(String mId, String mName, String mValue) {
        this.mId = mId;
        this.mValue = mValue;
        this.mName = mName;
    }
}
