package com.memo.component.controller.impl;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.memo.R;
import com.memo.component.controller.NewEntry;
import com.memo.component.dto.NewEntryParamDto;
import com.memo.dagger.module.Di;

public class NewEntryImpl implements NewEntry {
        public void newEntry(final NewEntryParamDto newEntryParamDto) {

            // idがnewButtonのボタンを取得
            Button newButton = newEntryParamDto
                    .getListActivity().findViewById(R.id.newButton);
            // clickイベント追加
            newButton.setOnClickListener(new View.OnClickListener() {
                /**
                 * 新規作成するボタン処理
                 */
                @Override
                public void onClick(View v) {
                    // CreateMemoActivityへ遷移
                    Intent intent = new Intent(
                            newEntryParamDto.getListActivity(), Di.create.getClass());
                    intent.putExtra("id", "");
                    newEntryParamDto.getListActivity().startActivity(intent);
                }
            });
        }
    }

