package com.epicodus.faultyfootballleague.services;

import android.util.Log;

import com.epicodus.faultyfootballleague.Constants;
import com.epicodus.faultyfootballleague.models.Player;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 5/12/16.
 */
public class NFLArrestService {


    public void searchPlayers(String name, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.NFL_ARREST_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(Constants.NFL_PLAYER_PATH_SEGMENT);
        urlBuilder.addPathSegment(Constants.NFL_SEARCH_PATH_SEGMENT);
        urlBuilder.addQueryParameter(Constants.TERM_QUERY, name);
        String url = urlBuilder.build().toString();

        Log.v("url", url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Player> processPlayers(Response response){
        ArrayList<Player> foundPlayers = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            Log.v("response: ", jsonData);
            if(response.isSuccessful()){
                JSONArray playersJSON = new JSONArray(jsonData);
                for (int i=0 ; i < playersJSON.length() ; i++) {
                    JSONObject athleteJSON = playersJSON.getJSONObject(i);
                    String name = athleteJSON.getString("Name");
                    String position = athleteJSON.getString("Position");
                    int arrestCount = athleteJSON.getInt("arrest_count");
                    Player player = new Player(name, position, arrestCount);
                    foundPlayers.add(player);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return foundPlayers;
    }
}
