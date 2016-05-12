package com.epicodus.faultyfootballleague.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.faultyfootballleague.R;
import com.epicodus.faultyfootballleague.adapters.PlayerListAdapter;
import com.epicodus.faultyfootballleague.models.Player;
import com.epicodus.faultyfootballleague.services.NFLArrestService;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerListFragment extends Fragment {
    private String mSearch;
    public ArrayList<Player> mPlayers = new ArrayList<>();
    private PlayerListAdapter mAdapter;
    @Bind(R.id.playerRecyclerView) RecyclerView mRecyclerView;


    public PlayerListFragment() {
        // Required empty public constructor
    }

    public static PlayerListFragment newInstance(String search){
        PlayerListFragment playerListFragment = new PlayerListFragment();
        Bundle args = new Bundle();
        args.putString("search", search);
        playerListFragment.setArguments(args);
        return playerListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mSearch = getArguments().getString("search", "smith");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);
        ButterKnife.bind(this, view);
        getPlayers(mSearch);
        return view;
    }

    public void getPlayers(String search){
        final NFLArrestService nflArrestService = new NFLArrestService();
        nflArrestService.searchPlayers(search, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) { e.printStackTrace(); }

            @Override
            public void onResponse(Call call, Response response) {
                mPlayers = nflArrestService.processPlayers(response);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new PlayerListAdapter(getContext(), mPlayers);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }

}
