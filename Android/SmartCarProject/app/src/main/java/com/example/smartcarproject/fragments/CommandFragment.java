package com.example.smartcarproject.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartcarproject.R;

/**
 * Created by Remi on 19/07/2017.
 */

public class CommandFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;

    }

    public static CommandFragment newInstance() {

        CommandFragment f = new CommandFragment();
/*        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);*/

        return f;
    }



}