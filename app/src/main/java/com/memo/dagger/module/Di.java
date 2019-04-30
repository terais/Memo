package com.memo.dagger.module;

import com.memo.ListActivity;
import com.memo.component.controller.FindWord;
import com.memo.component.controller.ListClick;
import com.memo.component.controller.ListLongClick;
import com.memo.component.controller.NewEntry;
import com.memo.component.logic.DataAdjust;
import com.memo.component.other.CreateAdapter;
import com.memo.component.service.Create;
import com.memo.component.service.MemoOpenHelper;
import com.memo.component.service.SelectData;
import com.memo.component.other.Sprash;
import com.memo.dagger.ApplicationComponent;
import com.memo.dagger.DaggerApplicationComponent;

public class Di {
    public static ApplicationComponent component = DaggerApplicationComponent.create();
    public static Sprash sprash = component.makeSprash();
    public static SelectData selectData = component.makeSelectData();
    public static MemoOpenHelper memoOpenHelper = component.makeMemoOpenHelper();
    public static NewEntry newEntry = component.makeNewEntry();
    public static ListClick listClick = component.makeListClick();
    public static ListLongClick listLongClick = component.makeListLongClick();
    public static FindWord findWord = component.makeFindWord();
    public static DataAdjust dataAdjust = component.makeDataAdjust();
    public static CreateAdapter createAdapter = component.makeCreateAdapter();
    public static final Create create = component.makeCreate();
}
