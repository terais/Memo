package com.memo.component;

import com.memo.MemoOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public interface SelectData {

    ArrayList<HashMap<String, String>> selectData(MemoOpenHelper helper);
}
