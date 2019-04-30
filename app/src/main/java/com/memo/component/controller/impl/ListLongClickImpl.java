package com.memo.component.controller.impl;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import com.memo.component.controller.ListLongClick;
import com.memo.component.dto.ListLongClickParamDto;

public class ListLongClickImpl implements ListLongClick {
    public void listLongClick(final ListLongClickParamDto listLongClickParamDto) {
        // リスト項目を長押しクリックした時の処理
        listLongClickParamDto.getListView()
                .setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
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
                SQLiteDatabase db = listLongClickParamDto.getHelper().getWritableDatabase();
                try {
                    db.execSQL("DELETE FROM MEMO_TABLE WHERE uuid = '"+ idStr +"'");
                } finally {
                    db.close();
                }
                // 長押しした項目を画面から削除
                listLongClickParamDto.getMemo().remove(position);
                listLongClickParamDto.getAdapter().notifyDataSetChanged();

                // trueにすることで通常のクリックイベントを発生させない
                return true;
            }
        });
    }
}

