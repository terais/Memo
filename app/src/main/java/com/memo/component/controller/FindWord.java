package com.memo.component.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.memo.ListActivity;
import com.memo.R;

import java.util.ArrayList;
import java.util.HashMap;

public interface FindWord {
    void findWord(ListActivity listActivity,
                  ArrayList<HashMap<String, String>> memoList,
                  SimpleAdapter adapter,
                  SimpleAdapter.ViewBinder mViewBinder);
}
