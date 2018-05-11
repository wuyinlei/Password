package ruolan.com.password.mvp.view

import ruolan.com.uselibrary.presenter.view.BaseView

interface EditDetailView :BaseView{

    /**
     * 编辑回调
     */
    fun onEditBack(boolean: Boolean)


    fun passwordError(string: String)

    fun accountError(string: String)

    fun phoneError(string: String)



}