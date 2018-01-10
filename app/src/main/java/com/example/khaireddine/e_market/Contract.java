package com.example.khaireddine.e_market;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Ramzi on 07/01/2018.
 */

public final class Contract
{
    private Contract() {}
    private static final String DATABASE_NAME = "userlist";
    public static final int ALL_ITEMS = -2;
    public static final String COUNT = "count";
    public static final String AUTHORITY =
            "com.android.example.e_market.provider";
    public static final String CONTENT_PATH = "words";
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);
    public static final Uri ROW_COUNT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + COUNT);
    static final String SINGLE_RECORD_MIME_TYPE =
            "vnd.android.cursor.item/vnd.com.example.provider.words";
    static final String MULTIPLE_RECORDS_MIME_TYPE =
            "vnd.android.cursor.item/vnd.com.example.provider.words";

    public static abstract class UserList implements BaseColumns {
        public static final String USER_LIST_TABLE = "user_entries";
        public static final String KEY_ID = "id";
        public static final String KEY_USERNAME = "username";
        public static final String KEY_EMAIL = "Email";
        public static final String KEY_PASSWORD = "password";
        public static final String KEY_PHONENUMBER="";
        public static final String KEY_CARDNUMBER="";
    }

}
