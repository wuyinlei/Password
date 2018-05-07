package ruolan.com.password.inject.component

import dagger.Component
import ruolan.com.password.EditDetailActivity
import ruolan.com.password.inject.module.EditModule
import ruolan.com.uselibrary.inject.PerComponentScope

@PerComponentScope
@Component(modules = arrayOf(EditModule::class))
interface EditComponent {

    fun inject(activity: EditDetailActivity)

}