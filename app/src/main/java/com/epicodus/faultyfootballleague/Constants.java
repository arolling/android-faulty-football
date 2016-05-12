package com.epicodus.faultyfootballleague;

/**
 * Created by Guest on 5/10/16.
 */
public class Constants {
    public static final String NFL_ARREST_BASE_URL = "http://nflarrest.com/api/v1/";

    public static final String NFL_CRIME_PATH_SEGMENT = "crime";
    public static final String NFL_TOP_PLAYERS_PATH_SEGMENT = "topPlayers";
    public static final String NFL_TOP_TEAMS_PATH_SEGMENT = "topTeams";
    public static final String NFL_TOP_CRIMES_PATH_SEGMENT = "topCrimes";
    public static final String NFL_TIMELINE_PATH_SEGMENT = "timeline";
    public static final String NFL_ARREST_DETAILS_PATH_SEGMENT = "arrests";
    public static final String NFL_TEAM_PATH_SEGMENT = "team";
    public static final String NFL_SEARCH_PATH_SEGMENT = "search";
    public static final String NFL_PLAYER_PATH_SEGMENT = "player";


    public static final String START_DATE_QUERY = "start_date";
    public static final String END_DATE_QUERY = "end_date";
    public static final String LIMIT_QUERY = "limit";
    public static final String TERM_QUERY = "term";

    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String KEY_USER_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String FIREBASE_PROPERTY_SEARCHES = "searches";

}
