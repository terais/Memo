package com.memo.component.controller.impl;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import com.memo.ListActivity;
import com.memo.component.controller.ListLongClick;
import com.memo.component.service.MemoOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
public class ListLongClickImpl implements ListLongClick {
    public void listLongClick(ListView listView,
                              final ArrayList<HashMap<String, String>> memo,
                              final SimpleAdapter adapter,
                              final MemoOpenHelper helper) {
//        final ArrayList<HashMap<String, String>> memo = memoList;
//        final SimpleAdapter adapter = ListActivity.simpleAdapter;
//        final MemoOpenHelper helper = ListActivity.helper;
        // リスト項目を長押しクリックした時の処理
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            /**
             * @param parent ListView
             * @param view 選択した項目
             * @param position 選択した項目の添え字
             * @param id 選択した項目のID
             */
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 選択されたビューを取得 TwoLineListItemを取得した後、text2の値を取得する
                TwoLineListItem two = (TwoLineListItem)view;
                TextView idTextView = (TextView)two.getText2();
                String idStr = (String) idTextView.getText();

                // 長押しした項目をデータベースから削除
                SQLiteDatabase db = helper.getWritableDatabase();
                try {
                    db.execSQL("DELETE FROM MEMO_TABLE WHERE uuid = '"+ idStr +"'");
                } finally {
                    db.close();
                }
                // 長押しした項目を画面から削除
                memo.remove(position);
                adapter.notifyDataSetChanged();

                // trueにすることで通常のクリックイベントを発生させない
                return true;
            }
        });
    }
}

