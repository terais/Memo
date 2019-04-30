package com.memo.component.service;

import android.database.sqlite.SQLiteDatabase;

public interface MemoOpenHelper  {
    void onCreate(SQLiteDatabase db);
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    SQLiteDatabase getWritableDatabase();
}
