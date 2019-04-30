package com.memo.component.controller.impl;

import android.graphics.Color;
import android.view.View;
import android.widget.SimpleAdapter;
import com.memo.ListActivity;
import com.memo.component.controller.SetColor;

public class SetColorImpl implements SetColor {

    public SimpleAdapter.ViewBinder searchWord() {
        //viewのbgカラーを変更するメソッド（いつかコンポネントとして切り出したい...）
        SimpleAdapter.ViewBinder mViewBinder = new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                for (String id : ListActivity.hit) {
                    view.setBackgroundColor(Color.WHITE);
                    if (textRepresentation.contains(id)) {
                        view.setBackgroundColor(Color.BLUE);
                    }
                }
                //trueだとなぜか壊れる。
                return false;
            }
        };
        return mViewBinder;
    }
}
