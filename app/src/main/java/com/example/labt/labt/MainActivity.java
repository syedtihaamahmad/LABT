package com.example.labt.labt;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{



    private ImageView logoimageview;
    private FrameLayout frame;
    private Handler mHandler;
    private Runnable mRunnable;
    private static final int SPLASH_TIME_MS = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoimageview = (ImageView) findViewById(R.id.titleview);
        frame= (FrameLayout) findViewById(R.id.frame_layout_content_login);
        frame.setVisibility(View.GONE);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }
        final Animation logomove= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logomove);
        logomove.setFillAfter(true);
        logomove.setAnimationListener(this);

        didTapButton(logoimageview);

        mHandler = new Handler();

        mRunnable = new Runnable() {
            @Override
            public void run() {

                    logoimageview.startAnimation(logomove);                }


        };

        mHandler.postDelayed(mRunnable, SPLASH_TIME_MS);


    }


    private void init() {
        // set the toolbar

        // set the login screen fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_login,
                LoginFragment.newInstance(),
                LoginFragment.class.getSimpleName());
        fragmentTransaction.commit();

    }
    public void didTapButton(ImageView button) {
        final Animation myAnim = AnimationUtils.loadAnimation(getApplication(), R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        frame.setVisibility(View.VISIBLE);
        init();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }



}