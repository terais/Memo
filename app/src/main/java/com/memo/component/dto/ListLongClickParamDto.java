package com.memo.component.dto;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.memo.component.service.MemoOpenHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListLongClickParamDto {
    private ListView listView;
    private ArrayList<HashMap<String, String>> memo;
    private SimpleAdapter adapter;
    private MemoOpenHelper helper;
}
