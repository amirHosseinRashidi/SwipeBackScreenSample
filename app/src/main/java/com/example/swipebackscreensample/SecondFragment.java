package com.example.swipebackscreensample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class SecondFragment extends BaseFragment {
    private View root;


    private String[] names = {
            "Amir1",
            "Amir2",
            "Amir3",
            "Amir4",
            "Amir5",
            "Amir6"
    };

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_second, container, false);
        ListView listView = root.findViewById(R.id.listview);

        listView.setAdapter(new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,names));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), ""+i, Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

}
