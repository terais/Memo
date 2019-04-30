package com.memo.component.controller.impl;

import android.graphics.Color;
import android.view.View;
import android.widget.SimpleAdapter;
import com.memo.component.controller.SetColor;
import com.memo.component.dto.SetColorParamDto;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;

public class SetColorImpl implements SetColor {

    public SimpleAdapter.ViewBinder searchWord(final SetColorParamDto setColorParamDto) {
        //viewのbgカラーを変更するメソッド
        SimpleAdapter.ViewBinder mViewBinder = new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                boolean check = textRepresentation.contains(setColorParamDto.getTargetWord());
                int setColor = BooleanUtils.toInteger(check, Color.BLUE, Color.WHITE);
                view.setBackgroundColor(setColor);
                //trueだとなぜか壊れる。
                return false;
            }
        };
        return mViewBinder;
    }
}
