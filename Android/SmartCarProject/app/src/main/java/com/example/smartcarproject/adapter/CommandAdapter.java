package com.example.smartcarproject.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcarproject.R;
import com.example.smartcarproject.models.Command;

import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class CommandAdapter extends RecyclerView.Adapter<CommandAdapter.ViewHolder> {

    List<Command> listCommandItem;
    int rowLayout;

    public CommandAdapter(List<Command> items, int row) {
        listCommandItem = items;
        this.rowLayout = row;
    }

    @Override
    public CommandAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_command, parent, false);
        return new CommandAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mIdView.setText(listCommandItem.get(position).getId());
        holder.mCountView.setText(listCommandItem.get(position).getCount());
        holder.mDateView.setText(listCommandItem.get(position).getDate().toString());
        holder.mTypeView.setText(listCommandItem.get(position).getType());

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

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
