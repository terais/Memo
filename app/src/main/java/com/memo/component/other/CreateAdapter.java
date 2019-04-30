package com.memo.component.other;


import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import com.memo.ListActivity;

public interface CreateAdapter {
    SimpleAdapter createAdapter(ArrayList<HashMap<String,String>> memoList);
}
