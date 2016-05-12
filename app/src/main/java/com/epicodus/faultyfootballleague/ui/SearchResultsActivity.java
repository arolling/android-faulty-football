package com.epicodus.faultyfootballleague.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.faultyfootballleague.R;

public class SearchResultsActivity extends AppCompatActivity {
    private String mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        mSearch = intent.getStringExtra("inputText");
        String searchChoice = intent.getStringExtra("searchChoice");
        if(searchChoice.equals("Player")){
            createPlayersFragment();
        }
    }

    private void createPlayersFragment(){

    }


}
