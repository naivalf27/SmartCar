package com.example.smartcarproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.smartcarproject.R;
import com.example.smartcarproject.models.Connection;

import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class ConnectionAdapter extends RecyclerView.Adapter<ConnectionAdapter.ViewHolder> {

    List<Connection.ConnectionItem> listConnectionItem;

    public ConnectionAdapter(List<Connection.ConnectionItem> items) {
        listConnectionItem = items;
    }

    @Override
    public ConnectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_connection, parent, false);
        return new ConnectionAdapter.ViewHolder(view);
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
        public final TextView mDateView;

        public Connection.ConnectionItem mItem;

        public ViewHolder(View view) {

            super(view);
            mView = view;

            mIdView = (TextView) view.findViewById(R.id.ssidConnection);
            mDateView = (TextView) view.findViewById(R.id.dateConnection);
        }
    }
}
