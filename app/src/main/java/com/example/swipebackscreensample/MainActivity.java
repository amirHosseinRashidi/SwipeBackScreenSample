package com.example.swipebackscreensample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    HomeFragment homeFragment = new HomeFragment();
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();



    public enum FragNames {
        HOME,
        FIRST,
        SECOND
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(FragNames.HOME);

    }


    public void addFragment(FragNames fragNames) {
        switch (fragNames) {
            case HOME:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_container, homeFragment).commit();
                break;
            case FIRST:
                getSupportFragmentManager().beginTransaction().add(R.id.fl_main_container, firstFragment).addToBackStack("firstFragment").commit();
                break;
            case SECOND:
                getSupportFragmentManager().beginTransaction().add(R.id.fl_main_container, secondFragment).addToBackStack("secondFragment").commit();
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments.size() > 0) {
            BaseFragment currentFragment = (BaseFragment) getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() - 1);
            if (currentFragment!=homeFragment)
                currentFragment.onDragEvent((ViewGroup) currentFragment.getView(), ev);

        }
        return super.dispatchTouchEvent(ev);
    }

}
