package com.memo.component.service;

import android.database.sqlite.SQLiteDatabase;
import com.memo.ListActivity;
import com.memo.dagger.module.Di;

public interface MemoOpenHelper  {
    void onCreate(SQLiteDatabase db);
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    SQLiteDatabase getWritableDatabase();
}
