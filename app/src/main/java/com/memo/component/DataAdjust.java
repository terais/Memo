package com.memo.component;

import com.memo.ListActivity;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 一覧画面に表示するのはデータの最初10文字だけ。
 */
public class DataAdjust {
    public static ArrayList<HashMap<String,String>> dataAdjust(
            ArrayList<HashMap<String, String>> memoList) {
        //データを10文字にしたものを格納するリスト
        ArrayList<HashMap<String,String>> showList = new ArrayList<>();

        for(HashMap<String,String> data : memoList) {
            String body = data.get("body");

            if(body.length() > 10){
                // リストに表示するのは10文字まで
                body = body.substring(0, 11) + "...";
            }
            data.put("body",body);
            showList.add(data);
        }

        return showList;
    }
}