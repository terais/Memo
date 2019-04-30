package com.memo.component.other.impl;

import android.widget.SimpleAdapter;
import com.memo.ListActivity;
import com.memo.component.other.CreateAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateAdapterImpl implements CreateAdapter {
    public SimpleAdapter createAdapter(ArrayList<HashMap<String,String>> memoList, ListActivity instance) {
        // Adapter生成
        final SimpleAdapter simpleAdapter = new SimpleAdapter(instance,//ListActivity.instance,
                memoList, // 使用するデータ
                android.R.layout.simple_list_item_2, // 使用するレイアウト（今回はテンプレートを使う）
                new String[]{"body","id"}, // どの項目を
                new int[]{android.R.id.text1, android.R.id.text2} // どのidの項目に入れるか
        );

        return simpleAdapter;
    }
}
