package com.memo.component.dto;

import android.widget.SimpleAdapter;
import com.memo.ListActivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindWordParamDto {
    private ListActivity listActivity;
    private SimpleAdapter adapter;
}
