package com.memo.component.service;

import android.database.sqlite.SQLiteDatabase;
import com.memo.component.dto.MemoOpenHelperParamDto;

public interface MemoOpenHelper  {
    void onCreate(SQLiteDatabase db);
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    SQLiteDatabase getWritableDatabase();
    SQLiteDatabase setDb(MemoOpenHelperParamDto memoOpenHelperParamDto);
    void dbClose(SQLiteDatabase db);
}
