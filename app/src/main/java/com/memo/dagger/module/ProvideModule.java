package com.memo.dagger.module;

import com.memo.component.Sprash;
import com.memo.component.impl.SprashImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ProvideModule {
    @Provides
    Sprash provideSprash() {
        return new SprashImpl();
    }

}
