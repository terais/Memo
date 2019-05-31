package com.memo.dagger;

import com.memo.component.controller.*;
import com.memo.component.controller.component.memolist.MemoListClickController;
import com.memo.component.logic.component.CommonLogic;
import com.memo.component.logic.DataAdjust;
import com.memo.component.common.CreateAdapter;
import com.memo.component.logic.MemoListLogic;
import com.memo.component.service.Create;
import com.memo.component.service.MemoListService;
import com.memo.component.service.MemoOpenHelper;
import com.memo.component.service.SelectData;
import com.memo.component.common.Sprash;
import com.memo.component.service.component.ConnectionDBService;
import com.memo.dagger.module.ProvideModule;
import dagger.Component;

/**
 *
 */
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
    SetColor makeSetColor();
    Create makeCreate();

    /**
     * 共通ロジッククラス生成.
     * @return 共通ロジッククラス.
     */
    CommonLogic makeCommonLogic();

    /**
     * データベース作成クラス生成.
     * @return データベース作成クラス.
     */
    ConnectionDBService makeConnectionDBService();

    /**
     * メモリスト画面クラス生成.
     * @return メモリスト画面クラス.
     */
    MemoListController makeMemoListController();
    /**
     * メモリスト画面クラス.
     * メモリスト画面クラス生成.
     * @return メモリストクリック実行クラス.
     */
    MemoListClickController makeMemoListClickController();
    /**
     * メモリスト画面.
     * メモリストlogicクラス生成.
     * @return メモリストlogic実装クラス.
     */
    MemoListLogic makeMemoListLogic();
    /**
     * メモリスト画面.
     * メモリストServiceクラス生成.
     * @return メモリストService実装クラス.
     */
    MemoListService makeMemoListService();

    /**
     * リスト作成クラス生成.
     * @return リスト作成クラス生成.
     */
    MemoCreateController makeMemoCreateController();
}