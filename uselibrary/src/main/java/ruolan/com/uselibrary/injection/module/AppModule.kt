package ruolan.com.uselibrary.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ruolan.com.uselibrary.common.BaseApplication
import javax.inject.Singleton


@Module
class AppModule(private val context: BaseApplication){


    @Singleton
    @Provides
    fun providesContext():Context{
        return context
    }

}