
package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Instania";
    public static final String TABLE_NAME_1 = "enrol";

    //Enrol table column names
    private static final String ID_1 = "id";
    private static final String PHONE_1 = "phone";
    private static final String NAME_1 = "name";
    private static final String ADDRESS_1 = "address";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String DbEntries =
                "CREATE TABLE " +UserTable.Users.TABLE_NAME+ " (" +
                        UserTable.Users.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        UserTable.Users.COLUMN_FULL_NAME + " TEXT," +
                        UserTable.Users.COLUMN_EMAIL + " TEXT,"  +
                        UserTable.Users.COLUMN_BIRTHDATE + " DATE," +
                        UserTable.Users.COLUMN_MOBILE + " INTEGER, " +
                        UserTable.Users.COLUMN_PASSWORD + " TEXT, " +
                        UserTable.Users.COLUMN_REG_DATE + " )";

        sqLiteDatabase.execSQL(DbEntries);

        String TABLE_CREATE_QRY = "CREATE TABLE " +TABLE_NAME_1+ " " +
                "("
                +ID_1+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                +PHONE_1 + " INTEGER,"
                +NAME_1 + " TEXT,"
                +ADDRESS_1 + " TEXT" +
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QRY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME_1;
        // Drop older table if existed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate( sqLiteDatabase);
    }

    public void registerUser(UserModel userModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserTable.Users.COLUMN_FULL_NAME, userModel.getFullName());
        contentValues.put(UserTable.Users.COLUMN_EMAIL, userModel.getEmail());
        contentValues.put(UserTable.Users.COLUMN_MOBILE, userModel.getMobile());
        contentValues.put(UserTable.Users.COLUMN_MOBILE, userModel.getMobile());
        contentValues.put(UserTable.Users.COLUMN_BIRTHDATE, userModel.getBrithDate());
        contentValues.put(UserTable.Users.COLUMN_REG_DATE, userModel.getRegDate());
        contentValues.put(UserTable.Users.COLUMN_PASSWORD, userModel.getPassword());

        sqLiteDatabase.insert(UserTable.Users.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public void addEnrol(Enrol enrol) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PHONE_1, enrol.getPhone());
        contentValues.put(NAME_1, enrol.getName());
        contentValues.put(ADDRESS_1, enrol.getAddress());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME_1,null,contentValues);
        // close database
        sqLiteDatabase.close();
    }
}

