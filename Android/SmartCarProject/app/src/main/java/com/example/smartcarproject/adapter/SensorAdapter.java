package com.example.smartcarproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.smartcarproject.R;
import com.example.smartcarproject.models.Sensor;

import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {

    List<Sensor.SensorItem> listConnectionItem;

    public SensorAdapter(List<Sensor.SensorItem> items) {
        listConnectionItem = items;
    }

    @Override
    public SensorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_sensor, parent, false);
        return new SensorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = listConnectionItem.get(position);
        holder.mIdView.setText(listConnectionItem.get(position).id);
        holder.mDateView.setText(listConnectionItem.get(position).date.toString());
    }

    @Override
    public int getItemCount() {
        return listConnectionItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView mIdView;
        public final TextView mValueView;
        public final TextView mNameView;
        public final TextView mDateView;

        public Sensor.SensorItem mItem;

        public ViewHolder(View view) {

            super(view);
            mView = view;

            mIdView = (TextView) view.findViewById(R.id.nameSensor);
            mDateView = (TextView) view.findViewById(R.id.dateSensor);
            mValueView = (TextView) view.findViewById(R.id.valueSensor);
            mNameView = (TextView) view.findViewById(R.id.nameSensor);
        }
    }
}