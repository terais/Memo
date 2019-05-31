package com.memo.component.common;

import android.widget.SimpleAdapter;
import com.memo.component.dto.CreateAdapterParamDto;

public interface CreateAdapter {
    SimpleAdapter createAdapter(CreateAdapterParamDto createAdapterParamDto);
}
