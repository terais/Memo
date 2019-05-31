package com.memo.component.logic;

import android.widget.SimpleAdapter;

/**
 * メモリスト画面Logic.
 */
public interface MemoListLogic {

    /**
     * 初期表示リストデータ取得.
     * @return simplAdapter 初期表示リストデータ.
     */
    SimpleAdapter getListData();
}
