package com.memo.component.service;

import com.memo.component.dto.SelectDataParamDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface SelectData {

    ArrayList<HashMap<String, String>> selectData(
            SelectDataParamDto selectDataParamDto);
}
