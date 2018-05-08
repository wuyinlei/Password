package ruolan.com.uselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component
import ruolan.com.uselibrary.injection.ActivityScope
import ruolan.com.uselibrary.injection.module.ActivityModule
import ruolan.com.uselibrary.injection.module.AppModule
import ruolan.com.uselibrary.injection.module.LifecycleProviderModule
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class))
interface ActivityComponent{

    fun activity():Activity

    fun lifecycleProvider():LifecycleProvider<*>

    fun context():Context


}