package com.memo.component.controller;

import android.widget.*;
import com.memo.component.service.MemoOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public interface ListLongClick {
    void listLongClick(ListView listView,
                       ArrayList<HashMap<String, String>> memo,
                       SimpleAdapter adapter,
                       MemoOpenHelper helper);
}
