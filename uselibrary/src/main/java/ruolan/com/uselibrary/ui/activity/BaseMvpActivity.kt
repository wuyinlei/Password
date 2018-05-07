package ruolan.com.uselibrary.ui.activity

import org.jetbrains.anko.toast
import ruolan.com.uselibrary.presenter.BasePresenter
import ruolan.com.uselibrary.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

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

}