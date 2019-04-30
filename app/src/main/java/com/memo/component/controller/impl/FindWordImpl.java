package com.memo.component.controller.impl;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.memo.R;
import com.memo.component.controller.FindWord;
import com.memo.component.dto.FindWordParamDto;
import com.memo.component.dto.SetColorParamDto;
import com.memo.dagger.module.Di;

public class FindWordImpl implements FindWord {
    /**
     * ダイアログでOKボタンが押されたら検索ワードをリターン
     */
    public void findWord(final FindWordParamDto findWordParamDto) {
        // idがfindButtonのボタンを取得
        Button findButton = findWordParamDto.getListActivity().findViewById(R.id.findButton);
        //clickイベント追加
        findButton.setOnClickListener(new View.OnClickListener() {
            /**
             * ダイアログ生成
             */
            @Override
            public void onClick(View v) {
                //文字入力フォームのビューを作成
                final EditText editView
                        = new EditText(findWordParamDto.getListActivity());

                // ダイアログ生成  AlertDialogのBuilderクラスを指定してインスタンス化
                AlertDialog.Builder dialog
                        = new AlertDialog.Builder(findWordParamDto.getListActivity());
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

                        //引数に検索文字
                        findWordParamDto.getAdapter().setViewBinder(
                                Di.setColor.searchWord(new SetColorParamDto(word)));
                        // idがmemoListのListViewを取得
                        ListView listView
                                = findWordParamDto.getListActivity().findViewById(R.id.memoList);
                        //背景色を変えてから再表示
                        listView.setAdapter(findWordParamDto.getAdapter());

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
