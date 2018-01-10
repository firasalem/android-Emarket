package com.example.khaireddine.e_market;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.khaireddine.e_market.Contract.ALL_ITEMS;
import static com.example.khaireddine.e_market.Contract.UserList.KEY_CARDNUMBER;
import static com.example.khaireddine.e_market.Contract.UserList.KEY_EMAIL;
import static com.example.khaireddine.e_market.Contract.UserList.KEY_ID;
import static com.example.khaireddine.e_market.Contract.UserList.KEY_PASSWORD;
import static com.example.khaireddine.e_market.Contract.UserList.KEY_PHONENUMBER;
import static com.example.khaireddine.e_market.Contract.UserList.KEY_USERNAME;
import static com.example.khaireddine.e_market.Contract.UserList.USER_LIST_TABLE;

/**
 * Created by Khaireddine on 24/12/2017.
 */

public class UserListOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = UserListOpenHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userlist";
    private static final String USER_LIST_TABLE_CREATE = "CREATE TABLE " + USER_LIST_TABLE + " (" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_USERNAME + " TEXT"+
            KEY_EMAIL + " TEXT" +
            KEY_PASSWORD + " TEXT" +
            KEY_PHONENUMBER + "TEXT" + KEY_CARDNUMBER +"TEXT );";
    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;

       public UserListOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //Method  onCreate
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(USER_LIST_TABLE_CREATE);
    }

     public Cursor query(int position) {
        String query;
         if (position != ALL_ITEMS) {
             position++; // Because database starts counting at 1.
             query ="SELECT * FROM " + USER_LIST_TABLE +
                " ORDER BY " + KEY_USERNAME + " ASC " +
                "LIMIT " + position + ",1";
     } else {
        query = "SELECT * FROM " + USER_LIST_TABLE
                + " ORDER BY " + KEY_USERNAME + " ASC ";
    }
    Cursor cursor = null;

         try {
             if (mReadableDB == null) {
                 mReadableDB = this.getReadableDatabase();
             }
             cursor = mReadableDB.rawQuery(query, null);
         } catch (Exception e) {
             Log.d(TAG, "QUERY EXCEPTION! " + e);
         } finally {
             return cursor;
         }
    }
    //Method onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(UserListOpenHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + USER_LIST_TABLE);
        onCreate(db);
    }
    public long insert(String user,String password,String phone,String card,String mail)
    {
        long newId = 0;
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user);
        values.put(KEY_PASSWORD,password);
        values.put(KEY_PHONENUMBER, phone);
        values.put(KEY_CARDNUMBER,card);
        values.put(KEY_EMAIL, mail);
        try {
            if (mWritableDB == null) {
                mWritableDB = getWritableDatabase();
            }
            newId = mWritableDB.insert(USER_LIST_TABLE, null, values);
        } catch (Exception e) {
            Log.d(TAG, "INSERT EXCEPTION! " + e.getMessage());
        }
        return newId;
    }

    public Cursor count(){
        MatrixCursor cursor = new MatrixCursor(new String[] {Contract.CONTENT_PATH});
        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            int count = (int) DatabaseUtils.queryNumEntries(mReadableDB, USER_LIST_TABLE);
            cursor.addRow(new Object[]{count});
        } catch (Exception e) {
            Log.d(TAG, "EXCEPTION " + e);
        }
        return cursor;
    }
}
