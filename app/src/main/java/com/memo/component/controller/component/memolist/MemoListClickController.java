package com.memo.component.controller.component.memolist;

import android.widget.ListView;

public interface MemoListClickController {
    /**
     * メモリスト画面.
     * メモリストクリック.
     * @param listView 画面情報ListView.
     * @return resultCode 結果コード.
     */
    int listClick(ListView listView);
}
