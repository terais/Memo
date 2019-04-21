package com.memo.component;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.memo.ListActivity;
import com.memo.R;

public class NewEntry {
    public static void newEntry() {
        // idがnewButtonのボタンを取得
        Button newButton = ListActivity.getInstance().findViewById(R.id.newButton);
        // clickイベント追加
        newButton.setOnClickListener(new View.OnClickListener() {
            /**
             * 新規作成するボタン処理
             */
            @Override
            public void onClick(View v) {
                // CreateMemoActivityへ遷移
                Intent intent = new Intent(ListActivity.getInstance(), com.memo.Create.class);
                intent.putExtra("id", "");
                ListActivity.getInstance().startActivity(intent);
            }
        });
    }
}
