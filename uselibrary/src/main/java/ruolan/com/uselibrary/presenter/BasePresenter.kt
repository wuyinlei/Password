package ruolan.com.uselibrary.presenter

import android.content.Context
import ruolan.com.uselibrary.presenter.view.BaseView

open class BasePresenter<T:BaseView> constructor(context: Context){


    lateinit var mView:T

    var mContext: Context = context



}