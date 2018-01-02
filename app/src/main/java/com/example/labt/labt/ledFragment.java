package com.example.labt.labt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by tihaam on 12/17/17.
 */
public class ledFragment extends Fragment {
    ToggleButton b1,b2,b3,b4,b5;
    public static ledFragment newInstance() {
        Bundle args = new Bundle();
        ledFragment fragment = new ledFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.led_fragment, container, false);
        bindViews(fragmentView);
        return fragmentView;
    }

    private void bindViews(View view) {
        b1 = (ToggleButton) view.findViewById(R.id.toggleButton);
        b2 = (ToggleButton) view.findViewById(R.id.toggleButton2);
        b3 = (ToggleButton) view.findViewById(R.id.toggleButton3);
        b4 = (ToggleButton) view.findViewById(R.id.toggleButton4);
        b5 = (ToggleButton) view.findViewById(R.id.toggleButton5);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {

        b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    WebView mWebview ;
                    mWebview  = new WebView(getActivity());

                    mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript


                    mWebview.setWebViewClient(new WebViewClient() {
                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getActivity(), description, Toast.LENGTH_SHORT).show();
                        }
                    });

                    mWebview .loadUrl("http://192.168.43.52/led_off");


                } else {
                    WebView mWebview ;
                    mWebview  = new WebView(getActivity());

                    mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript


                    mWebview.setWebViewClient(new WebViewClient() {
                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getActivity(), description, Toast.LENGTH_SHORT).show();
                        }
                    });

                    mWebview .loadUrl("http://192.168.43.52/led_on");
                }
            }
        });
        b2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabledw
                } else {
                    // The toggle is disabled
                }
            }
        });

        b3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });

        b4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });

        b5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });



    }
}
