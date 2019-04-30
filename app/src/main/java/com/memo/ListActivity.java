package com.memo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.ArrayList;

import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.memo.component.service.MemoOpenHelper;
import com.memo.dagger.module.Di;
import org.apache.commons.lang3.ObjectUtils;

public class ListActivity extends AppCompatActivity {

    //メインであるListActivityのインスタンスはコンポネントでよく使うのでゲッター用意
    public static ListActivity instance = null;

    // MemoOpenHelperクラスを定義（これもゲッター用意）
    public static MemoOpenHelper helper = null;

    //画面とデータのアダプター（これもゲッター用意）
    public static SimpleAdapter simpleAdapter = null;

    //データ格納用（ゲッター用意しちゃおう）
    public static ArrayList<HashMap<String, String>> memoList = new ArrayList<>();

    //検索HITフラグ
    public static ArrayList<String> hit = new ArrayList<>();

    //クソダサカウンター作戦（simpleAdapterがゴミクソだからいけないんだ）
    private static int kdCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        //メモっ娘を１秒表示
        Di.sprash.sprash();

        // スプラッシュthemeを通常themeに変更する
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_list);

        // データベースから値を取得する
        helper = ObjectUtils.defaultIfNull(helper, Di.memoOpenHelper);

        // memoListにデータを格納
        memoList = Di.selectData.selectData(helper);

        // Adapter生成
        simpleAdapter = Di.createAdapter.createAdapter(Di.dataAdjust.dataAdjust(memoList), this);

        // idがmemoListのListViewを取得
        ListView listView = findViewById(R.id.memoList);
        listView.setAdapter(simpleAdapter);

        // リスト項目をクリックした時の処理(メモ画面に遷移)
        Di.listClick.listClick(listView);

        // リスト項目を長押しクリックした時の処理(削除)
        Di.listLongClick.listLongClick(listView);

        //新規作成ボタン押下処理(メモ画面へ遷移)
        Di.newEntry.newEntry();

        //検索ボタン押下処理(ダイアログ表示。OKが押されたら検索実行)
        Di.findWord.findWord(instance);

        kdCounter = 0;
    }
    //viewのbgカラーを変更するメソッド（いつかコンポネントとして切り出したい...）
    public static SimpleAdapter.ViewBinder mViewBinder = new SimpleAdapter.ViewBinder() {
        @Override
        public boolean setViewValue(View view, Object data,
                                    String textRepresentation) {

            //memoListのbodyだけを見比べる
            if(kdCounter % 2 != 0) {
                for(String id : hit) {
                    if(textRepresentation.contains(id)) {
                        view.setBackgroundColor(Color.BLUE);
                    } else {
                        view.setBackgroundColor(Color.WHITE);
                    }
                }
            }
            kdCounter++;
            //trueだとなぜか壊れる。
            return false;
        }
    };
}