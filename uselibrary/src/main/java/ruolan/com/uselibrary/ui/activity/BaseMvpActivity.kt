package ruolan.com.uselibrary.ui.activity

import android.os.Bundle
import org.jetbrains.anko.toast
import ruolan.com.uselibrary.common.BaseApplication
import ruolan.com.uselibrary.injection.component.ActivityComponent
import ruolan.com.uselibrary.injection.component.DaggerActivityComponent
import ruolan.com.uselibrary.injection.module.ActivityModule
import ruolan.com.uselibrary.injection.module.LifecycleProviderModule
import ruolan.com.uselibrary.presenter.BasePresenter
import ruolan.com.uselibrary.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    lateinit var activityComponent: ActivityComponent

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun onError(string: String) {
        toast(string)
    }

    override fun onError(str: Int) {
        toast(str)
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInject()
        initComponent()

    }

    abstract fun initComponent()

    private fun initActivityInject() {

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .appComponent((application as BaseApplication).appComponent)
                .build()
    }

}