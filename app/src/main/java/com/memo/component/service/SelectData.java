package com.memo.component.service;

import android.database.sqlite.SQLiteDatabase;
import com.memo.component.dto.SelectDataParamDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface SelectData {

    ArrayList<HashMap<String, String>> selectData(
            SQLiteDatabase db);
}
