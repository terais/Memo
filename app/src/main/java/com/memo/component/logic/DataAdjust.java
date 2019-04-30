package com.memo.component.logic;

import com.memo.component.dto.DataAdjustParamDto;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 一覧画面に表示するのはデータの最初10文字だけ。
 */
public interface DataAdjust {
    ArrayList<HashMap<String,String>> dataAdjust(
            DataAdjustParamDto dataAdjustParamDto);
}