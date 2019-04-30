package com.memo.component.other;

import android.widget.SimpleAdapter;
import com.memo.component.dto.CreateAdapterParamDto;

public interface CreateAdapter {
    SimpleAdapter createAdapter(CreateAdapterParamDto createAdapterParamDto);
}
