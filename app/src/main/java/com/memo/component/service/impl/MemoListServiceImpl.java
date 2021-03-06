package com.memo.component.service.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.memo.component.dto.MemoOpenHelperParamDto;
import com.memo.component.service.MemoListService;
import com.memo.dagger.module.Di;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoListServiceImpl implements MemoListService {

    public ArrayList<HashMap<String, String>> selectMemoListData() {

        SQLiteDatabase db = Di.memoOpenHelper.setDb(new MemoOpenHelperParamDto(Di.memoOpenHelper));

        // メモリストデータを格納する変数
        final ArrayList<HashMap<String, String>> memoList = new ArrayList<>();
        // rawQueryというSELECT専用メソッドを使用してデータを取得する
        Cursor c = db.rawQuery("SELECT uuid, body, date FROM MEMO_TABLE ORDER BY id", null);
        // Cursorの先頭行があるかどうか確認
        boolean next = c.moveToFirst();

        // 取得した全ての行をhashmap型のarraylistに格納
        while (next) {
            HashMap<String, String> data = new HashMap<>();
            // 取得したカラムの順番(0から始まる)と型を指定してデータを取得する
            String uuid = c.getString(0);
            String body = c.getString(1);
            String date = c.getString(2);
            // 引数には、(名前,実際の値)という組合せで指定　名前はSimpleAdapterの引数で使用
            data.put("body", body);
            data.put("id", uuid);
            data.put("date", date);
            memoList.add(data);
            // 次の行が存在するか確認
            next = c.moveToNext();
        }
        return memoList;
    }
}
