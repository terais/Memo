package com.memo.component.controller.impl;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.memo.MainActivity;
import com.memo.R;
import com.memo.component.controller.MemoListController;
import com.memo.dagger.module.Di;

/**
 * MemoListControllerを実装.
 */
public class MemoListControllerImpl extends AppCompatActivity implements MemoListController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_list);
            ListView listView = findViewById(R.id.memoList);

            SimpleAdapter simpleAdapter = Di.memoListLogic.getListData();
            listView.setAdapter(simpleAdapter);

            int resulrCode = Di.memoListClickController.listClick(listView);
            if (resulrCode < 0) {
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
