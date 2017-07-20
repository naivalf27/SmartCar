package com.example.smartcarproject.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.smartcarproject.R;
import com.example.smartcarproject.models.Actions;

import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ViewHolder> {

    List<Actions> listCommandItem;
    int rowLayout;

    public ActionsAdapter(List<Actions> items, int row) {
        listCommandItem = items;
        this.rowLayout = row;
    }

    @Override
    public ActionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_command, parent, false);
        return new ActionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mIdView.setText(listCommandItem.get(position).getmId());
        String count = String.valueOf(listCommandItem.get(position).getmName());
        holder.mCountView.setText(count);
        String type = String.valueOf(listCommandItem.get(position).getmValue());
        holder.mTypeView.setText(type);
    }

    @Override
    public int getItemCount() {
        return listCommandItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mTypeView;
        public final TextView mCountView;
        public final TextView mDateView;

        public final CardView cv;

        public ViewHolder(View view) {

            super(view);
            cv = (CardView) view.findViewById(R.id.cardCommand);
            mView = view;

            mIdView = (TextView) view.findViewById(R.id.nameCommand);
            mDateView = (TextView) view.findViewById(R.id.dateCommand);
            mCountView = (TextView) view.findViewById(R.id.countCommand);
            mTypeView = (TextView) view.findViewById(R.id.typeCommand);
        }
    }

    public void add(Actions item) {
        listCommandItem.add(item); // on insère le nouvel objet dans notre       liste d'article lié à l'adapter
        this.notifyDataSetChanged(); // on notifie à l'adapter ce changement
    }

    public void clear() {
        listCommandItem.clear(); // on insère le nouvel objet dans notre       liste d'article lié à l'adapter
        this.notifyDataSetChanged(); // on notifie à l'adapter ce changement
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
