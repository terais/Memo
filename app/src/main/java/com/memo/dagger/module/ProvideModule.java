package com.memo.dagger.module;

import com.memo.ListActivity;
import com.memo.MainActivity;
import com.memo.component.controller.*;
import com.memo.component.controller.component.memolist.MemoListClickController;
import com.memo.component.controller.component.memolist.impl.MemoListClickControllerImpl;
import com.memo.component.controller.impl.*;
import com.memo.component.logic.component.CommonLogic;
import com.memo.component.logic.DataAdjust;
import com.memo.component.common.CreateAdapter;
import com.memo.component.common.impl.CreateAdapterImpl;
import com.memo.component.logic.MemoListLogic;
import com.memo.component.logic.component.impl.CommonLogicImpl;
import com.memo.component.logic.impl.MemoListLogicImpl;
import com.memo.component.service.component.ConnectionDBService;
import com.memo.component.service.component.impl.ConnectionDBServiceImpl;
import com.memo.component.service.impl.MemoListServiceImpl;
import com.memo.component.service.Create;
import com.memo.component.service.MemoListService;
import com.memo.component.service.MemoOpenHelper;
import com.memo.component.service.impl.CreateImpl;
import com.memo.component.service.impl.MemoListServiceImpl;
import com.memo.component.service.impl.MemoOpenHelperImpl;
import com.memo.component.service.SelectData;
import com.memo.component.logic.impl.DataAdjustImpl;
import com.memo.component.service.impl.SelectDataImpl;
import com.memo.component.common.Sprash;
import com.memo.component.common.impl.SprashImpl;
import dagger.Module;
import dagger.Provides;

/**
 * DI代用クラス.
 * interfaceを呼ばれた際に実装クラスを実装.
 */
@Module
public class ProvideModule {
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
        return new MemoOpenHelperImpl(ListActivity.instance);
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
    ListClick provideListClick() {
        return new ListClickImpl();
    }

    @Provides
    FindWord provideFindWord() {
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
    SetColor provideSetColor() {
        return new SetColorImpl();
    }

    @Provides
    Create provideCreate() {
        return new CreateImpl();
    }

    /**
     * 共通ロジック実装クラス提供.
     * @return 共通ロジック実装クラス.
     */
    @Provides
    CommonLogic provideCommonLogic() {
        return new CommonLogicImpl();
    }
    /**
     * データベース作成実装クラス提供.
     * @return データベース作成実装クラス.
     */
    @Provides
    ConnectionDBService provideConnectionDBService() {
        return new ConnectionDBServiceImpl(MainActivity.mainActivity);
    }

    /**
     * メモリスト画面実装クラス提供.
     * @return メモリスト画面実装クラス.
     */
    @Provides
    MemoListController provideListController() {
        return new MemoListControllerImpl();
    }

    /**
     * メモリスト画面.
     * メモリストクリック実行クラス.
     * @return メモリストクリック実行実装クラス.
     */
    @Provides
    MemoListClickController provideMemoListClickController() {
        return new MemoListClickControllerImpl();
    }
    /**
     * メモリスト画面.
     * メモリストlogicクラス.
     * @return メモリストlogic実装クラス.
     */
    @Provides
    MemoListLogic provideMemoListLogic() {
        return new MemoListLogicImpl();
    }
    /**
     * メモリスト画面.
     * メモリストService
     * Ωクラス.
     * @return メモリストService実装クラス.
     */
    @Provides
    MemoListService provideMemoListService() {
        return new MemoListServiceImpl();
    }

    /**
     * メモ作成画面実装クラス提供.
     * @return メモ作成画面実装クラス.
     */
    @Provides
    MemoCreateController provideMemoCreateControllerImpl() {
        return new MemoCreateControllerImpl();
    }

}
