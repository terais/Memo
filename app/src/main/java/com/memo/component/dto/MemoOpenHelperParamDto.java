package com.memo.component.dto;

import com.memo.component.service.MemoOpenHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoOpenHelperParamDto {
    private MemoOpenHelper helper;
}
