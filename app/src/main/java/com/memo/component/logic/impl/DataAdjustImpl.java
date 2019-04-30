package com.memo.component.logic.impl;

import com.memo.component.dto.DataAdjustParamDto;
import com.memo.component.logic.DataAdjust;

import java.util.ArrayList;
import java.util.HashMap;

public class DataAdjustImpl implements DataAdjust {
    public ArrayList<HashMap<String,String>> dataAdjust(
            DataAdjustParamDto dataAdjustParamDto) {
        //データを10文字にしたものを格納するリスト
        ArrayList<HashMap<String,String>> showList = new ArrayList<>();

        for(HashMap<String,String> data : dataAdjustParamDto.getMemo()) {
            String body = data.get("body");

            if(body.length() > 10){
                // リストに表示するのは10文字まで
                body = body.substring(0, 11) + "...";
            }
            data.put("body",body);
            showList.add(data);
        }

        return showList;
    }
}
