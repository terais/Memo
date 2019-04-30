package com.memo.component.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface SelectData {

    ArrayList<HashMap<String, String>> selectData(MemoOpenHelper helper);
}
