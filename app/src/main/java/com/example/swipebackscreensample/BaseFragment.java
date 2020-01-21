package com.example.swipebackscreensample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";


    public void enableOnDragBack(final View view) {

        view.setOnTouchListener(new View.OnTouchListener() {
            float dX;
            float defaultX;
            float rawX = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        dX = v.getX() - event.getRawX();
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "\nrawX location: " + event.getRawX());
                        Log.i(TAG, "\nview.X: " + v.getX() );
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        int width = displayMetrics.widthPixels;
                        if (event.getRawX() < width/2)
                            v.animate().x(defaultX).setDuration(110).start();
                        else {
                            v.animate().x(width).setDuration(110).setListener(new AnimatorListenerAdapter() {
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


                        if (v.getX() >= -3) {
                            v.animate()
                                    .x(event.getRawX() + dX)
                                    .setDuration(0)
                                    .start();
                        }

//                            Log.d("SwipeTest", "\nfalseX " + tv_false.getX() + "  vX:" + v.getTranslationX() + "\nTrueX " + tv_true.getX());
//                            Log.d("SwipeTest", "\n\nevent.getRawX(): " + event.getRawX());

                        break;
                    default:
                        return false;
                }
                return true;
            }

        });
    }
}
