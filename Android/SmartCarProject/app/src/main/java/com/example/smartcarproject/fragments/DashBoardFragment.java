package com.example.smartcarproject.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcarproject.Activities.MainActivity;
import com.example.smartcarproject.R;
import com.example.smartcarproject.adapter.ActionsAdapter;
import com.example.smartcarproject.models.Actions;
import com.example.smartcarproject.models.Connection;
import com.example.smartcarproject.models.Sensor;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Remi on 19/07/2017.
 */

public class DashBoardFragment extends Fragment{

    List<Connection> connectionList = new ArrayList<Connection>();
    List<Sensor> sensorList = new ArrayList<Sensor>();

    private MobileServiceTable<Actions> mCommandTable;

    RecyclerView recyclerViewConnection;
    RecyclerView recyclerViewCommand;
    RecyclerView recyclerViewSensor;

    ActionsAdapter commandAdapter;
    View v;

    public DashBoardFragment() {
    }

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

        mCommandTable = MainActivity.mClient.getTable(Actions.class);

        Actions c = new Actions("id", "action1", "value 1");

        addItem(c);

        recyclerViewCommand = (RecyclerView) v.findViewById(R.id.recycleViewCommands);
        recyclerViewCommand.setLayoutManager(new LinearLayoutManager(getContext()));
        commandAdapter = new ActionsAdapter(new ArrayList<Actions>(), R.layout.cardview_command);
        recyclerViewCommand.setAdapter(commandAdapter);
        //RealmResults<News> results = realm.where(News.class).findAll();
        //Command c = new Command(1,"hello", 1, new Date());
        //commandList.add(0,c);
        commandAdapter.notifyDataSetChanged();
        return v;

    }

    /**
     * Refresh the list with the items in the Table
     */
    private void refreshCommandItemsFromTable() {

        // Get the items that weren't marked as completed and add them in the
        // adapter

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    final List<Actions> results = refreshCommandsFromMobileServiceTable();

                    //Offline Sync
                    //final List<ToDoItem> results = refreshItemsFromMobileServiceTableSyncTable();

                    ((MainActivity) getActivity()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (Actions item : results) {
                                commandAdapter.add(item);
                            }
                        }
                    });
                } catch (final Exception e){
                    ((MainActivity) getActivity()).createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }
        };

        runAsyncTask(task);
    }

    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }

    private List<Actions> refreshCommandsFromMobileServiceTable() throws ExecutionException, InterruptedException {
        return mCommandTable.where().field("id").execute().get();
    }

    /**
     * Add an item to the Mobile Service Table
     *
     * @param item
     *            The item to Add
     */
    public Actions addCommandItemInTable(Actions item) throws ExecutionException, InterruptedException {
        Actions c = mCommandTable.insert(item).get();
        return c;
    }

    public void addItem(final Actions c) {
        if (MainActivity.mClient == null) {
            return;
        }


        // Insert the new item
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final Actions entity = addCommandItemInTable(c);

                    ((MainActivity) getActivity()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            commandAdapter.add(entity);
                        }
                    });
                } catch (final Exception e) {
                    ((MainActivity) getActivity()).createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };

        runAsyncTask(task);
    }
}
