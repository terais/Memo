package com.memo.component.service.component.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.memo.component.dto.MemoOpenHelperParamDto;
import com.memo.component.service.component.ConnectionDBService;


public class ConnectionDBServiceImpl extends SQLiteOpenHelper implements ConnectionDBService {

    // データベース名
    static final private String DBName = "MEMO_DB";
    // データベースのバージョン(2,3と挙げていくとonUpgradeメソッドが実行される)
    static final private int VERSION = 1;

    // コンストラクタ　以下のように呼ぶこと
    public ConnectionDBServiceImpl(Context context){
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
                "body TEXT," +
                "date TEXT)");
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

    public SQLiteDatabase setDb(MemoOpenHelperParamDto memoOpenHelperParamDto) {
        SQLiteDatabase db = memoOpenHelperParamDto.getHelper().getWritableDatabase();

        //DB更新しても継承メソッド動かないから自分で作っとく
        String query = "SELECT COUNT(*) FROM sqlite_master WHERE type='table' AND name='MEMO_TABLE';";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        String result = c.getString(0);
        if (result.equals("0")) onCreate(db);
        return db;
    }

    public void dbClose(SQLiteDatabase db) {
        db.close();
    }
}
