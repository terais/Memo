package com.memo.component.other.impl;

import com.memo.component.other.Sprash;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;

/**
 * アプリ起動時にメモっ娘を表示する時間を操作するメソッド
 */
public class SprashImpl implements Sprash {
    @Override
    public void sprash() throws InterruptedException {
        //メモっ娘を１秒表示
        Thread.sleep(2000);
    }
}
