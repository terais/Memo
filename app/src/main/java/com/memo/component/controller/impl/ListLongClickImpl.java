package com.memo.component.controller.impl;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import com.memo.ListActivity;
import com.memo.component.controller.ListLongClick;
import com.memo.component.dto.ListLongClickParamDto;
import com.memo.dagger.module.Di;

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
                String idStr = listLongClickParamDto.getMemo().get(position).get("id");
                // 長押しした項目をデータベースから削除
                SQLiteDatabase db = listLongClickParamDto.getHelper().getWritableDatabase();

                db.execSQL("DELETE FROM MEMO_TABLE WHERE uuid = '"+ idStr +"'");

                // 長押しした項目を画面から削除
                listLongClickParamDto.getMemo().remove(position);
                listLongClickParamDto.getAdapter().notifyDataSetChanged();

                Intent intent = new Intent(
                        listLongClickParamDto.getListActivity(),new ListActivity().getClass());
                listLongClickParamDto.getListActivity().startActivity(intent);

                // trueにすることで通常のクリックイベントを発生させない
                return true;
            }
        });
    }
}

