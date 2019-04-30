package com.memo.component.controller;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TwoLineListItem;
import com.memo.ListActivity;
import com.memo.component.dto.ListClickParamDto;

public interface ListClick {
    void listClick(ListClickParamDto listClickParamDto);
}
