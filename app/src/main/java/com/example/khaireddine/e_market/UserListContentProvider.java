package com.example.khaireddine.e_market;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static com.example.khaireddine.e_market.Contract.ALL_ITEMS;
import static com.example.khaireddine.e_market.Contract.MULTIPLE_RECORDS_MIME_TYPE;
import static com.example.khaireddine.e_market.Contract.SINGLE_RECORD_MIME_TYPE;
import static java.lang.Integer.parseInt;

/**
 * Created by Ramzi on 07/01/2018.
 */

public class UserListContentProvider extends ContentProvider {
    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private UserListOpenHelper mDB;
    private static final int URI_ALL_ITEMS_CODE = 10;
    private static final int URI_ONE_ITEM_CODE = 20;
    private static final int URI_COUNT_CODE = 30;
    @Override
    public boolean onCreate() {
        mDB = new UserListOpenHelper(getContext());
        initializeUriMatching();
        return true;
    }
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
    private void initializeUriMatching(){
        sUriMatcher.addURI(Contract.AUTHORITY, Contract.CONTENT_PATH, URI_ALL_ITEMS_CODE);
        sUriMatcher.addURI(Contract.AUTHORITY, Contract.CONTENT_PATH + "/#", URI_ONE_ITEM_CODE);
        sUriMatcher.addURI(Contract.AUTHORITY, Contract.CONTENT_PATH + "/" + Contract.COUNT, URI_COUNT_CODE );
    }
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        switch (sUriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                cursor =mDB.query(ALL_ITEMS);
                break;
            case URI_ONE_ITEM_CODE:
                cursor =mDB.query(parseInt(uri.getLastPathSegment()));
                break;
            case URI_COUNT_CODE:
                cursor = mDB.count();
                break;
            case UriMatcher.NO_MATCH:
// You should do some error handling here.
                Log.d(TAG, "NO MATCH FOR THIS URI IN SCHEME: " + uri);
                break;
            default:
// You should do some error handling here.
                Log.d(TAG, "INVALID URI - URI NOT RECOGNIZED: " + uri);
        }
        return cursor;
    }
    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                return MULTIPLE_RECORDS_MIME_TYPE;
            case URI_ONE_ITEM_CODE:
                return SINGLE_RECORD_MIME_TYPE;
            default:
                return null;
        }
    }
}
