package com.memo.component.logic.impl;

import com.memo.component.dto.DataAdjustParamDto;
import com.memo.component.logic.DataAdjust;
import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class DataAdjustImpl implements DataAdjust {
    public ArrayList<HashMap<String,String>> dataAdjust(
            DataAdjustParamDto dataAdjustParamDto) {
        //データを10文字にしたものを格納するリスト
        ArrayList<HashMap<String,String>> showList = new ArrayList<>();

        for(HashMap<String,String> data : dataAdjustParamDto.getMemo()) {
            String body = data.get("body");

            int maxLength = BooleanUtils.toInteger(
                    body.length() > 10, 11, body.length());
            String putBody = BooleanUtils.toString(
                    body.length() > 10,body.substring(0, maxLength) + "...", body);
            data.put("body", putBody);
            showList.add(data);
        }

        return showList;
    }
}
