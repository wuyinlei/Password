package ruolan.com.uselibrary.injection.component

import android.content.Context
import dagger.Component
import ruolan.com.uselibrary.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent{

    fun context():Context

}