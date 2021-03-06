package com.memo.component.controller.component.memolist.impl;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.memo.component.common.Const;
import com.memo.component.controller.component.memolist.MemoListClickController;
import com.memo.component.dto.ListClickParamDto;
import com.memo.dagger.module.Di;

public class MemoListClickControllerImpl implements MemoListClickController {

    @Override
    public int listClick(ListView listView){

        int resultCode = Const.NOMAL_CODE;

        return resultCode;
    }

    public void listClick(final ListClickParamDto listClickParamDto) {
        // リスト項目をクリックした時の処理
        listClickParamDto.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener(){
            /**
             * @param parent ListView
             * @param view 選択した項目
             * @param position 選択した項目の添え字
             * @param id 選択した項目のID
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // インテント作成  第二引数にはパッケージ名からの指定で、遷移先クラスを指定
                Intent intent = new Intent(
                        listClickParamDto.getListActivity(), Di.create.getClass());
                String isStr = listClickParamDto.getMemo().get(position).get("id");
                // 値を引き渡す (識別名, 値)の順番で指定します
                intent.putExtra("id", isStr);
                // Activity起動
                listClickParamDto.getListActivity().startActivity(intent);
            }
        });
    }
}
