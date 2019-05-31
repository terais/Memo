package com.memo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.memo.component.controller.MemoListController;
import com.memo.dagger.module.Di;

/**
 * MainActivityクラス.
 * app実行時に呼び出されるクラス.
 */
public class MainActivity extends AppCompatActivity {

    public static MainActivity mainActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mainActivity = this;
            int resultCode = Di.commonLogic.displaySprash();
            if (resultCode < 0) {
                throw new Exception();
            }
            Intent intent = new Intent(this, Di.create.getClass());
            this.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
