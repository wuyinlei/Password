package ruolan.com.uselibrary.common

import android.app.Application
import android.content.Context
import ruolan.com.uselibrary.injection.component.AppComponent
import ruolan.com.uselibrary.injection.component.DaggerAppComponent
import ruolan.com.uselibrary.injection.module.AppModule

open class BaseApplication : Application() {

     lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()

        context = this

        initAppInjection()
    }

    private fun initAppInjection() {

        appComponent =  DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

    }

    companion object {
        lateinit var context: Context
    }

}