package com.memo.component.dto;

import android.widget.ListView;
import com.memo.ListActivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListClickParamDto {
    private ListView listView;
    private ListActivity listActivity;
}
