package com.epicodus.faultyfootballleague.services;

import android.util.Log;

import com.epicodus.faultyfootballleague.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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
}
