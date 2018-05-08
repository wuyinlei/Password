package ruolan.com.uselibrary.injection.component

import android.app.Activity
import android.content.Context
import dagger.Component
import ruolan.com.uselibrary.injection.ActivityScope
import ruolan.com.uselibrary.injection.module.ActivityModule
import ruolan.com.uselibrary.injection.module.AppModule
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent{

    fun activity():Activity


}