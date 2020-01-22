package com.example.swipebackscreensample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FirstFragment extends BaseFragment {
    private View root;
    private Button btnGoSecondFragment;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_first, container, false);
        btnGoSecondFragment = root.findViewById(R.id.btn_first_goSecondFragment);
        btnGoSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).addFragment(MainActivity.FragNames.SECOND);
            }
        });
        return root;
    }

}
