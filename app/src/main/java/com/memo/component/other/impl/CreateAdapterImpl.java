package com.memo.component.other.impl;

import android.widget.SimpleAdapter;
import com.memo.component.dto.CreateAdapterParamDto;
import com.memo.component.other.CreateAdapter;

public class CreateAdapterImpl implements CreateAdapter {
    public SimpleAdapter createAdapter(
            CreateAdapterParamDto createAdapterParamDto) {
        // Adapter生成
        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                createAdapterParamDto.getInstance(),
                createAdapterParamDto.getMemo(), // 使用するデータ
                android.R.layout.simple_list_item_2, // 使用するレイアウト（今回はテンプレートを使う）
                new String[]{"body","id"}, // どの項目を
                new int[]{android.R.id.text1, android.R.id.text2} // どのidの項目に入れるか
        );
        return simpleAdapter;
    }
}
