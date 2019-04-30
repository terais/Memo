package com.memo.component.other.impl;

import com.memo.component.other.Sprash;

/**
 * アプリ起動時にメモっ娘を表示する時間を操作するメソッド
 */
public class SprashImpl implements Sprash {
    @Override
    public void sprash() {
        //メモっ娘を１秒表示
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
}
