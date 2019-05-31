package com.memo.component.service.component;

import android.database.sqlite.SQLiteDatabase;
import com.memo.component.dto.MemoOpenHelperParamDto;

public interface ConnectionDBService {
    void onCreate(SQLiteDatabase db);
    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    SQLiteDatabase getWritableDatabase();
    SQLiteDatabase setDb(MemoOpenHelperParamDto memoOpenHelperParamDto);
    void dbClose(SQLiteDatabase db);
}
