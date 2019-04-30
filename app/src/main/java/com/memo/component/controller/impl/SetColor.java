package com.memo.component.controller.impl;

import android.graphics.Color;
import android.view.View;
import android.widget.SimpleAdapter;
import com.memo.ListActivity;

public class SetColor {

    //viewのbgカラーを変更するメソッド（いつかコンポネントとして切り出したい...）
    public SimpleAdapter.ViewBinder mViewBinder = new SimpleAdapter.ViewBinder() {
        @Override
        public boolean setViewValue(View view, Object data,
                                    String textRepresentation) {
            for(String id : ListActivity.hit) {
                view.setBackgroundColor(Color.WHITE);
                if(textRepresentation.contains(id)) {
                    view.setBackgroundColor(Color.BLUE);
                }
            }
            //trueだとなぜか壊れる。
            return false;
        }
    };
}
