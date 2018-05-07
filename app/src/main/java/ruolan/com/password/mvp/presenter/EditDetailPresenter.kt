package ruolan.com.password.mvp.presenter

import android.content.Context
import ruolan.com.password.model.PasswordModel
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.uselibrary.presenter.BasePresenter

open class EditDetailPresenter(context: Context) : BasePresenter<EditDetailView>(context) {


    fun onEditDetail(model:PasswordModel){

        mView.showLoading()

        //执行逻辑

        if(true){
            mView.onEditSucc()
        } else {
            mView.onEditFailure()
        }


    }


}