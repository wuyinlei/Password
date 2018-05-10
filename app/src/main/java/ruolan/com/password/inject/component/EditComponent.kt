package ruolan.com.password.inject.component

import dagger.Component
import ruolan.com.password.ui.activity.EditDetailActivity
import ruolan.com.password.inject.module.EditModule
import ruolan.com.uselibrary.injection.PerComponentScope
import ruolan.com.uselibrary.injection.component.ActivityComponent

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(EditModule::class))
interface EditComponent {

    fun inject(activity: EditDetailActivity)

}