package com.memo.component.service;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * メモリスト画面Service.
 */
public interface MemoListService {
    /**
     * 初期表示メモリストデータ取得.
     * @return 初期表示メモリストデータ.
     */
    ArrayList<HashMap<String, String>> selectMemoListData();
}
