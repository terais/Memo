package com.memo.dagger;

import com.memo.component.controller.*;
import com.memo.component.logic.DataAdjust;
import com.memo.component.other.CreateAdapter;
import com.memo.component.service.Create;
import com.memo.component.service.MemoOpenHelper;
import com.memo.component.service.SelectData;
import com.memo.component.other.Sprash;
import com.memo.dagger.module.ProvideModule;
import dagger.Component;

@Component(modules = ProvideModule.class)
public interface ApplicationComponent {
    Sprash makeSprash();
    SelectData makeSelectData();
    MemoOpenHelper makeMemoOpenHelper();
    NewEntry makeNewEntry();
    ListLongClick makeListLongClick();
    ListClick makeListClick();
    FindWord makeFindWord();
    DataAdjust makeDataAdjust();
    CreateAdapter makeCreateAdapter();
    Create makeCreate();
    SetColor makeSetColor();
}