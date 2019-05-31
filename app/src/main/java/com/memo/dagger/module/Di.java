package com.memo.dagger.module;

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
import com.memo.dagger.ApplicationComponent;
import com.memo.dagger.DaggerApplicationComponent;

/**
 * ApplicationComponentの実装部.
 * PrivudeModuleで提供される各クラスを生成.
 */
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
    public static SetColor setColor = component.makeSetColor();
    public static final Create create = component.makeCreate();

    /**
     * 共通ロジック.
     */
    public static CommonLogic commonLogic = component.makeCommonLogic();

    /**
     * メモリスト画面.
     */
    public static final MemoListController memoListController = component.makeMemoListController();
    /**
     * メモリスト画面にてリストクリック.
     */
    public static MemoListClickController memoListClickController = component.makeMemoListClickController();

    /**
     * メモリスト画面Logic.
     */
    public static MemoListLogic memoListLogic = component.makeMemoListLogic();
    /**
     * メモリスト画面Service.
     */
    public static MemoListService memoListService = component.makeMemoListService();

    /**
     * メモ作成画面.
     */
    public static final MemoCreateController memoCreateController = component.makeMemoCreateController();
}
