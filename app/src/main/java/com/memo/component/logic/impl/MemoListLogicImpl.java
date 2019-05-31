package com.memo.component.logic.impl;

import android.widget.SimpleAdapter;
import com.memo.MainActivity;
import com.memo.component.common.Const;
import com.memo.component.logic.MemoListLogic;
import com.memo.dagger.module.Di;
import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MemoListLogicを実装.
 */
public class MemoListLogicImpl implements MemoListLogic {

    @Override
    public SimpleAdapter getListData() {
        // memoにデータを格納
        ArrayList<HashMap<String, String>> memo
                = Di.memoListService.selectMemoListData();
        ArrayList<HashMap<String, String>> memoList = this.getAdjustData(memo);
        SimpleAdapter simpleAdapter = this.createAdapter(memoList);
        return simpleAdapter;
    }

    private ArrayList<HashMap<String, String>> getAdjustData(
            ArrayList<HashMap<String, String>> memoList) {

        //データを10文字にしたものを格納するリスト
        ArrayList<HashMap<String, String>> showList = new ArrayList<>();

        for (HashMap<String, String> data : memoList) {
            String body = data.get(Const.KEY_BODY);
            int maxLength = BooleanUtils.toInteger(
                    body.length() > Const.BODY_LENGTH,
                    Const.BODY_LENGTH + 1, body.length());
            String putBody = BooleanUtils.toString(
                    body.length() > Const.BODY_LENGTH,
                    body.substring(Const.NUMBER_ZERO, maxLength)
                            + Const.OVER_BODY_LENGTH_STR, body);
            data.put(Const.KEY_BODY, putBody);
            showList.add(data);
        }
        return null;
    }

    private SimpleAdapter createAdapter(
            ArrayList<HashMap<String, String>> memoList) {
        // Adapter生成
        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                MainActivity.mainActivity, memoList, // 使用するデータ
                android.R.layout.simple_list_item_2, // 使用するレイアウト（今回はテンプレートを使う）
                new String[]{Const.KEY_BODY,Const.KEY_DATE}, // どの項目を
                new int[]{android.R.id.text1, android.R.id.text2} // どのidの項目に入れるか
        );
        return simpleAdapter;
    }
}
