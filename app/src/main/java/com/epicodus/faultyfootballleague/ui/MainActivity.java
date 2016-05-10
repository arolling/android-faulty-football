package com.epicodus.faultyfootballleague.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.epicodus.faultyfootballleague.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.headerTextView) TextView mHeaderTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface face = Typeface.createFromAsset(getAssets(), "Sports Jersey.ttf");
        mHeaderTextView.setTypeface(face);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.action_logout:
                //logout();
                break;
            case R.id.action_signup:
                Intent signUpIntent = new Intent(this, CreateAccountActivity.class);
                startActivity(signUpIntent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    protected void logout() {
//        mFirebaseRef.unauth();
//        todo: remove current search from shared preferences?
//        takeUserToLoginScreenOnUnAuth();
//    }
//
//    private void takeUserToLoginScreenOnUnAuth() {
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }
}
