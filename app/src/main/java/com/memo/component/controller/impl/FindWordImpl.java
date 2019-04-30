package com.memo.component.controller.impl;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.memo.ListActivity;
import com.memo.R;
import com.memo.component.controller.FindWord;
import com.memo.component.service.MemoOpenHelper;
import com.memo.dagger.module.Di;

import java.util.ArrayList;
import java.util.HashMap;

public class FindWordImpl implements FindWord {
    /**
     * ダイアログでOKボタンが押されたら検索ワードをリターン
     */
    public void findWord(ListActivity listActivity,
                         final ArrayList<HashMap<String, String>> memoList,
                         final SimpleAdapter adapter,
                         final  SimpleAdapter.ViewBinder mViewBinder) {

        // idがfindButtonのボタンを取得
        Button findButton = listActivity.findViewById(R.id.findButton);
        //clickイベント追加
        findButton.setOnClickListener(new View.OnClickListener() {
            /**
             * ダイアログ生成
             */
            @Override
            public void onClick(View v) {
                //文字入力フォームのビューを作成
                final EditText editView = new EditText(ListActivity.instance);

                // ダイアログ生成  AlertDialogのBuilderクラスを指定してインスタンス化
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.instance);
                // タイトル設定
                dialog.setTitle("検索");
                //入力フォーム
                dialog.setView(editView);

                // OKボタン処理(色変えて再表示)
                dialog.setPositiveButton("検索", new DialogInterface.OnClickListener(){

                    /**
                     * 入力された文字列をwordに設定
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String word = editView.getText().toString();

                        //HITしたIDを入れるリスト
                        ArrayList<String> hit = new ArrayList<>();

                        //検索文字列とmemoListを比較してHITしたらIDを控える
                        for(HashMap<String,String> data : memoList) {
                            String body = data.get("body");

                            if(body.contains(word)) {
                                hit.add(data.get("id"));
                            }
                        }
                        ListActivity.instance.hit = hit;

                        //引数に検索文字
                        adapter.setViewBinder(Di.setColor.searchWord(word));
                        // idがmemoListのListViewを取得
                        ListView listView = ListActivity.instance.findViewById(R.id.memoList);
                        //背景色を変えてから再表示
                        listView.setAdapter(adapter);

                    }
                });

                // NGボタン作成
                dialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 何もしないで閉じる
                    }
                });

                // ダイアログ表示
                dialog.create().show();

            }

        });
    }
}
