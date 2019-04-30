package com.memo.component.dto;

import android.widget.ListView;
import com.memo.ListActivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListClickParamDto {
    private ListView listView;
    private ListActivity listActivity;
    private ArrayList<HashMap<String, String>> memo;
}
