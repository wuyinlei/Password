package ruolan.com.uselibrary.injection.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import ruolan.com.uselibrary.common.BaseApplication
import ruolan.com.uselibrary.injection.ActivityScope
import javax.inject.Singleton


@Module
class ActivityModule(private val activity: Activity){


    @ActivityScope
    @Provides
    fun providesActivity():Activity{
        return activity
    }

}