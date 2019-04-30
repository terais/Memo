package com.memo.component.controller;

import android.widget.SimpleAdapter;
import com.memo.component.dto.SetColorParamDto;

public interface SetColor {
    SimpleAdapter.ViewBinder searchWord(SetColorParamDto setColorParamDto);
}
