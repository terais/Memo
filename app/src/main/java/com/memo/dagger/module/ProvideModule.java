package com.memo.dagger.module;

import com.memo.ListActivity;
import com.memo.component.controller.FindWord;
import com.memo.component.controller.ListClick;
import com.memo.component.controller.ListLongClick;
import com.memo.component.controller.NewEntry;
import com.memo.component.controller.impl.FindWordImpl;
import com.memo.component.controller.impl.ListClickImpl;
import com.memo.component.controller.impl.ListLongClickImpl;
import com.memo.component.controller.impl.NewEntryImpl;
import com.memo.component.logic.DataAdjust;
import com.memo.component.other.CreateAdapter;
import com.memo.component.other.impl.CreateAdapterImpl;
import com.memo.component.service.Create;
import com.memo.component.service.MemoOpenHelper;
import com.memo.component.service.impl.CreateImpl;
import com.memo.component.service.impl.MemoOpenHelperImpl;
import com.memo.component.service.SelectData;
import com.memo.component.logic.impl.DataAdjustImpl;
import com.memo.component.service.impl.SelectDataImpl;
import com.memo.component.other.Sprash;
import com.memo.component.other.impl.SprashImpl;
import dagger.Module;
import dagger.Provides;
@Module
public class ProvideModule {
    private ListActivity instance = ListActivity.instance;
    @Provides
    Sprash provideSprash() {
        return new SprashImpl();
    }
    @Provides
    SelectData provideSelectData() {
        return new SelectDataImpl();
    }
    @Provides
    MemoOpenHelper provideMemoOpenHelper() {
        return new MemoOpenHelperImpl(instance);
    }
    @Provides
    NewEntry provideNewEntry() {
        return new NewEntryImpl();
    }
    @Provides
    ListLongClick provideListLongClick() {
        return new ListLongClickImpl();
    }
    @Provides
    ListClick provideListClick(){
        return new ListClickImpl();
    }
    @Provides
    FindWord provideFindWord(){
        return new FindWordImpl();
    }
    @Provides
    DataAdjust provideDataAdjust() {
        return new DataAdjustImpl();
    }
    @Provides
    CreateAdapter providCreateAdapter() {
        return new CreateAdapterImpl();
    }
    @Provides
    Create provideCreate() {
        return new CreateImpl();
    }
}
