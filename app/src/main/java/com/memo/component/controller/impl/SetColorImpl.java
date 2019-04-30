package com.memo.component.controller.impl;

import android.graphics.Color;
import android.view.View;
import android.widget.SimpleAdapter;
import com.memo.ListActivity;
import com.memo.component.controller.SetColor;

public class SetColorImpl implements SetColor {

    public SimpleAdapter.ViewBinder searchWord(final String targetWord) {
        //viewのbgカラーを変更するメソッド（いつかコンポネントとして切り出したい...）
        SimpleAdapter.ViewBinder mViewBinder = new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                    view.setBackgroundColor(Color.WHITE);
                    if (textRepresentation.contains(targetWord)) {
                        view.setBackgroundColor(Color.BLUE);
                    }
                //trueだとなぜか壊れる。
                return false;
            }
        };
        return mViewBinder;
    }
}
