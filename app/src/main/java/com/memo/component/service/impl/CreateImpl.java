package com.memo.component.service.impl;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.memo.R;
import com.memo.component.service.Create;
import com.memo.component.service.MemoOpenHelper;
import com.memo.dagger.module.Di;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class CreateImpl extends AppCompatActivity implements Create {
    // MemoOpenHelperクラスを定義
    MemoOpenHelper helper = null;
    // id
    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // データベースから値を取得する
        helper = ObjectUtils.defaultIfNull(helper, Di.memoOpenHelper);

        // ListActivityからインテントを取得
        Intent intent = this.getIntent();
        // 値を取得
        id = intent.getStringExtra("id");

        // 画面に表示
        // 編集の場合 データベースから値を取得して表示
        // データベースを取得する
        SQLiteDatabase db = helper.getWritableDatabase();
        String queryFalse = BooleanUtils.toString(id.equals("")," AND 1=0","");
        try {
            // rawQueryというSELECT専用メソッドを使用してデータを取得する
            Cursor c = db.rawQuery(
                    "SELECT body FROM MEMO_TABLE WHERE uuid = '" + id + "'" + queryFalse,
                    null);
            // Cursorの先頭行があるかどうか確認
            boolean next = c.moveToFirst();
            // 取得した全ての行を取得
            while (next) {
                // 取得したカラムの順番(0から始まる)と型を指定してデータを取得する
                String dispBody = c.getString(0);
                EditText body = findViewById(R.id.body);
                body.setText(dispBody, TextView.BufferType.NORMAL);
                next = c.moveToNext();
            }
        } finally {
            // finallyは、tryの中で例外が発生した時でも必ず実行される
            // dbを開いたら確実にclose
            db.close();
        }

        // idがregisterのボタンを取得
        Button registerButton = findViewById(R.id.register);
        // clickイベント追加
        registerButton.setOnClickListener(new View.OnClickListener() {
            /**
             * 登録ボタン処理
             */
            @Override
            public void onClick(View v) {
                // 入力内容を取得する
                EditText body = findViewById(R.id.body);
                String bodyStr = body.getText().toString();

                // データベースに保存する
                SQLiteDatabase db = helper.getWritableDatabase();
                boolean registCheck = StringUtils.isBlank(id);
                String insertQuery = "INSERT into MEMO_TABLE(uuid, body) VALUES('" +
                        UUID.randomUUID().toString() + "', '" + bodyStr + "')";
                String updateQuery = "UPDATE MEMO_TABLE SET body = '" +
                        bodyStr + "' WHERE uuid = '" + id + "'";
                try {
                    String query = BooleanUtils.toString(registCheck, insertQuery, updateQuery);
                    db.execSQL(query);
                } finally {
                    // finallyは、tryの中で例外が発生した時でも必ず実行される
                    // dbを開いたら確実にclose
                    db.close();
                }
                // 保存後に一覧へ戻る
                Intent intent = new Intent(CreateImpl.this, com.memo.ListActivity.class);
                startActivity(intent);
            }
        });

        // idがbackのボタンを取得
        Button backButton = findViewById(R.id.back);
        // clickイベント追加
        backButton.setOnClickListener(new View.OnClickListener() {
            /**
             * 戻るボタン処理
             */
            @Override
            public void onClick(View v) {
                // 保存せずに一覧へ戻る
                finish();
            }
        });
    }
}
