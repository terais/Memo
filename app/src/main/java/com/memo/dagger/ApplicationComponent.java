package com.memo.dagger;

import com.memo.component.SelectData;
import com.memo.component.Sprash;
import com.memo.component.impl.SprashImpl;
import com.memo.dagger.module.ProvideModule;
import dagger.Component;

@Component(modules = ProvideModule.class)
public interface ApplicationComponent {
    Sprash makeSprash();
    SelectData makeSelectData();
}
