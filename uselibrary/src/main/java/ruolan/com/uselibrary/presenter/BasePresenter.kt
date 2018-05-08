package ruolan.com.uselibrary.presenter

import com.trello.rxlifecycle.LifecycleProvider
import ruolan.com.uselibrary.presenter.view.BaseView
import javax.inject.Inject

open class BasePresenter<T:BaseView> constructor(){


    lateinit var mView:T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>


}