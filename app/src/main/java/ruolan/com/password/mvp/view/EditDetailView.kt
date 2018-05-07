package ruolan.com.password.mvp.view

import ruolan.com.uselibrary.presenter.view.BaseView

interface EditDetailView :BaseView{

    /**
     * 编辑成功
     */
    fun onEditSucc()

    /**
     * 编辑失败
     */
    fun onEditFailure()



}