package com.memo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.ArrayList;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.memo.component.dto.*;
import com.memo.dagger.module.Di;

public class ListActivity extends AppCompatActivity {

    //メインであるListActivityのインスタンスはコンポネントでよく使うのでゲッター用意
    public static ListActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQLiteDatabase db = null;
        try {
            instance = this;
            //メモっ娘を１秒表示
            Di.sprash.sprash();//time);

            // スプラッシュthemeを通常themeに変更する
            setTheme(R.style.AppTheme);

            setContentView(R.layout.activity_list);

            db = Di.memoOpenHelper.setDb(new MemoOpenHelperParamDto(Di.memoOpenHelper));

            // memoにデータを格納
            ArrayList<HashMap<String, String>> memo
                    = Di.selectData.selectData(db);

            // Adapter生成
            SimpleAdapter simpleAdapter = Di.createAdapter.createAdapter(
                    new CreateAdapterParamDto(
                            Di.dataAdjust.dataAdjust(new DataAdjustParamDto(memo)),
                            this));

            // idがmemoListのListViewを取得
            ListView listView = findViewById(R.id.memoList);
            listView.setAdapter(simpleAdapter);

            // リスト項目をクリックした時の処理(メモ画面に遷移)
            Di.listClick.listClick(new ListClickParamDto(listView, this, memo));

            // リスト項目を長押しクリックした時の処理(削除)
            Di.listLongClick.listLongClick(new ListLongClickParamDto(
                    listView, memo, simpleAdapter, Di.memoOpenHelper, this));

            //新規作成ボタン押下処理(メモ画面へ遷移)
            Di.newEntry.newEntry(new NewEntryParamDto(this));

            //検索ボタン押下処理(ダイアログ表示。OKが押されたら検索実行)
            Di.findWord.findWord(new FindWordParamDto(
                    this, simpleAdapter));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}