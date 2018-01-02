package com.example.labt.labt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText mETxtEmail, mETxtPassword;
    private Button mBtnLogin;


    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        bindViews(fragmentView);
        return fragmentView;
    }

    private void bindViews(View view) {
        mETxtEmail = (EditText) view.findViewById(R.id.edit_text_email_id);
        mETxtPassword = (EditText) view.findViewById(R.id.edit_text_password);
        mBtnLogin = (Button) view.findViewById(R.id.button_login);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {

        mBtnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId) {
            case R.id.button_login:
                onLogin(view);
                break;
        }
    }

    private void onLogin(View view) {

        String emailId = mETxtEmail.getText().toString();
        if (TextUtils.isEmpty(emailId)) {
            mETxtEmail.setError("Email required");
            return;
        }
        String password = mETxtPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mETxtPassword.setError("Password required");
            return;
        }

       if(emailId.equals("Tihaam")&&password.equals("labt123"))
       {
           onLoginSuccess();
           startActivity(new Intent(getContext(),ledActivity.class));

       }
       else
           onLoginFailure();
    }


    public void onLoginSuccess() {

        Toast.makeText(getActivity(),"Successfully Logined",Toast.LENGTH_SHORT).show();

    }

    public void onLoginFailure() {
        Toast.makeText(getActivity(),"Login Failed",Toast.LENGTH_SHORT).show();
    }

}