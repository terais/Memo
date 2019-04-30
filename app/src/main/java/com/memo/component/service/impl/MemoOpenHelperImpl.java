package com.memo.component.service.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.memo.component.dto.SelectDataParamDto;
import com.memo.component.service.MemoOpenHelper;

public class MemoOpenHelperImpl extends SQLiteOpenHelper implements MemoOpenHelper {

    // データベース名
    static final private String DBName = "MEMO_DB";
    // データベースのバージョン(2,3と挙げていくとonUpgradeメソッドが実行される)
    static final private int VERSION = 1;

    // コンストラクタ　以下のように呼ぶこと
    public MemoOpenHelperImpl(Context context){
        super(context, DBName, null, VERSION);
    }

    // データベースが作成された時に実行される処理
    // データベースはアプリを開いた時に存在しなかったら作成され、すでに存在していれば何もしない
    /**
     * テーブルを作成する
     * execSQLメソッドにCREATET TABLE命令を文字列として渡すことで実行される
     * 引数で指定されているものの意味は以下の通り
     * 引数1 ・・・ id：列名 , INTEGER：数値型 , PRIMATY KEY：テーブル内の行で重複無し , AUTOINCREMENT：1から順番に振っていく
     * 引数2 ・・・ uuid：列名 , TEXT：文字列型
     * 引数3 ・・・ body：列名 , TEXT：文字列型
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MEMO_TABLE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "uuid TEXT, " +
                "body TEXT)");
    }

    // データベースをバージョンアップした時に実行される処理
    /**
     * テーブルを削除する
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MEMO_TABLE");

        // 新しくテーブルを作成する
        onCreate(db);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public SQLiteDatabase setDb(SelectDataParamDto selectDataParamDto) {
        SQLiteDatabase db = selectDataParamDto.getHelper().getWritableDatabase();
        return db;
    }

    public void dbClose(SQLiteDatabase db) {
        db.close();
    }
}

