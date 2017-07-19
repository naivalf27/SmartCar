package com.example.smartcarproject.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcarproject.R;
import com.example.smartcarproject.adapter.CommandAdapter;
import com.example.smartcarproject.models.Command;
import com.example.smartcarproject.models.Connection;
import com.example.smartcarproject.models.Sensor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Remi on 19/07/2017.
 */

public class DashBoardFragment extends Fragment{

    List<Command> commandList = new ArrayList<>();
    List<Connection> connectionList = new ArrayList<>();
    List<Sensor> sensorList = new ArrayList<>();


    RecyclerView recyclerViewConnection;
    RecyclerView recyclerViewCommand;
    RecyclerView recyclerViewSensor;

    CommandAdapter commandAdapter;
    View v;

    public DashBoardFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DashBoardFragment newInstance() {
        DashBoardFragment fragment = new DashBoardFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerViewCommand = (RecyclerView) v.findViewById(R.id.recycleViewCommands);
        recyclerViewCommand.setLayoutManager(new LinearLayoutManager(getContext()));
        commandAdapter = new CommandAdapter(commandList, R.layout.cardview_command,getContext());
        recyclerViewCommand.setAdapter(commandAdapter);
        //RealmResults<News> results = realm.where(News.class).findAll();
        Command c = new Command(1,"hello", 1, new Date());
        commandList.add(0,c);
        commandAdapter.notifyDataSetChanged();
        return v;

    }

}
