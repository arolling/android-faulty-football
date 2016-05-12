package com.epicodus.faultyfootballleague.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.faultyfootballleague.R;
import com.epicodus.faultyfootballleague.models.Player;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/12/16.
 */
public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder> {
    private ArrayList<Player> mPlayers = new ArrayList<>();
    private Context mContext;

    public PlayerListAdapter(Context context, ArrayList<Player> players){
       mContext = context;
        mPlayers = players;
    }

    @Override
    public PlayerListAdapter.PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_item, parent, false);
        PlayerViewHolder viewHolder = new PlayerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlayerListAdapter.PlayerViewHolder holder, int position) {
        holder.bindPlayer(mPlayers.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.positionTextView) TextView mPositionTextView;
        @Bind(R.id.arrestCountTextView) TextView mArrestCountTextView;

        public PlayerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindPlayer(Player player) {
            mNameTextView.setText(player.getName());
            mPositionTextView.setText(player.getPosition());
            mArrestCountTextView.setText("Arrest Count: " + player.getArrestCount());
        }

    }


}

