package com.epicodus.faultyfootballleague.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.epicodus.faultyfootballleague.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.loginHeaderTextView) TextView mLoginHeaderTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Typeface face = Typeface.createFromAsset(getAssets(), "Sports Jersey.ttf");
        mLoginHeaderTextView.setTypeface(face);
    }
}
