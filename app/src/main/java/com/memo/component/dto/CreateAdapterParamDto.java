package com.memo.component.dto;

import com.memo.ListActivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdapterParamDto {
    private ArrayList<HashMap<String,String>> memo;
    private ListActivity instance;
}
