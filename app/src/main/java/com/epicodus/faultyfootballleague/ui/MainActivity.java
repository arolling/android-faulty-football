package com.epicodus.faultyfootballleague.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.epicodus.faultyfootballleague.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SearchFragment.SearchDialogListener {
    @Bind(R.id.headerTextView) TextView mHeaderTextView;
    @Bind(R.id.searchSpinner) Spinner mSearchSpinner;
    @Bind(R.id.searchButton) Button mSearchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.searchChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSearchSpinner.setAdapter(adapter);

        Typeface face = Typeface.createFromAsset(getAssets(), "Sports Jersey.ttf");
        mHeaderTextView.setTypeface(face);

        mSearchButton.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch(mSearchSpinner.getSelectedItem().toString()){
            case "Player":
                showPlayerSearchDialog();
                break;
            case "Crime":
                //showCrimeSearchDialog();
                break;
            default:
                break;
        }
    }

    private void showPlayerSearchDialog(){
        FragmentManager fm = getSupportFragmentManager();
        SearchFragment searchFragment = SearchFragment.newInstance("Search Player Name");
        searchFragment.show(fm, "fragment_search");
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
        intent.putExtra("inputText", inputText);
        intent.putExtra("searchChoice", mSearchSpinner.getSelectedItem().toString());
        startActivity(intent);
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
