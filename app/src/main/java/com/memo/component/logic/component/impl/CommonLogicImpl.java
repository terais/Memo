package com.memo.component.logic.component.impl;

import com.memo.component.common.Const;
import com.memo.component.logic.component.CommonLogic;

/**
 * CommonLogicを実装.
 */
public class CommonLogicImpl implements CommonLogic {
    @Override
    public int displaySprash(){
        int resultCode = Const.NOMAL_CODE;
        try {
            Thread.sleep(Const.SPLASH_MILLIS_TIME);
        } catch (InterruptedException e) {
            resultCode = Const.ERROR_CODE;
        }
        return resultCode;
    }
}
