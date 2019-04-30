package com.memo.component.controller.impl;

import android.graphics.Color;
import android.view.View;
import android.widget.SimpleAdapter;
import com.memo.component.controller.SetColor;
import com.memo.component.dto.SetColorParamDto;

public class SetColorImpl implements SetColor {

    public SimpleAdapter.ViewBinder searchWord(final SetColorParamDto setColorParamDto) {
        //viewのbgカラーを変更するメソッド
        SimpleAdapter.ViewBinder mViewBinder = new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                    view.setBackgroundColor(Color.WHITE);
                    if (textRepresentation.contains(setColorParamDto.getTargetWord())) {
                        view.setBackgroundColor(Color.BLUE);
                    }
                //trueだとなぜか壊れる。
                return false;
            }
        };
        return mViewBinder;
    }
}
