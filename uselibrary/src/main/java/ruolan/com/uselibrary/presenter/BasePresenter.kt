package ruolan.com.uselibrary.presenter

import ruolan.com.uselibrary.presenter.view.BaseView

open class BasePresenter<T:BaseView> constructor(){


    lateinit var mView:T




}