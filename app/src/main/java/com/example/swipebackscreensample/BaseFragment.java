package com.example.swipebackscreensample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";
    float dX;


    public void onDragEvent(final ViewGroup view, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                break;

            case MotionEvent.ACTION_UP:
                Log.i(TAG, "\nrawX location: " + event.getRawX());
                Log.i(TAG, "\nview.X: " + view.getX());
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels;
                if (view.getX() < width / 3)
                    view.animate().x(0).setDuration(80).start();
                else {
                    view.animate().x(width).setDuration(80).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                            getActivity().getSupportFragmentManager().popBackStack();
                        }
                    }).start();
                }
                break;

            case MotionEvent.ACTION_MOVE:
//                        Log.i(TAG, "\nv.getX location: " + v.getX());
//                        Log.i(TAG, "\nrawX location: " + event.getRawX());
//                        Log.i(TAG, "\nDX location: " + (v.getX() - event.getRawX()));


                if (view.getX() > -1) {
                    view.animate()
                            .x(event.getRawX() + dX)
                            .setDuration(0)
                            .start();
                }

//                            Log.d("SwipeTest", "\nfalseX " + tv_false.getX() + "  vX:" + v.getTranslationX() + "\nTrueX " + tv_true.getX());
//                            Log.d("SwipeTest", "\n\nevent.getRawX(): " + event.getRawX());

                break;
            default:

        }


    }

}
