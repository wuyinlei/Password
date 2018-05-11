package ruolan.com.password.mvp.presenter

import android.os.Handler
import com.google.common.base.Strings
import ruolan.com.password.data.AccountDatabase
import ruolan.com.password.data.model.AccountModel
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.password.service.impl.EditServiceImpl
import ruolan.com.password.utils.DbWorkThread
import ruolan.com.uselibrary.presenter.BasePresenter
import ruolan.com.uselibrary.utils.CheckStrength
import javax.inject.Inject

open class EditDetailPresenter @Inject constructor() : BasePresenter<EditDetailView>() {

    @Inject
    lateinit var service: EditServiceImpl

    fun onEditDetail(model: AccountModel, dbWorkThread: DbWorkThread, accountDatabase: AccountDatabase, mUiHandler: Handler) {

        checkValue(model)

        //执行逻辑
        service.saveToLocal(model,mView,dbWorkThread,accountDatabase,mUiHandler)

    }

    fun clear(){
        service.clear()
    }

    private fun checkValue(model: AccountModel): Boolean {

        if (checkAccount(model.account)){
            return false
        }

        checkPhone(model.phone)

        if (checkPasswordLevel(model.password) == -1) {
            return false
        }
        return true

    }

    private fun checkAccount(account: String): Boolean {
        if (Strings.isNullOrEmpty(account)) {
            mView.accountError("账号不能为空")
            return false
        }
        return true
    }

    private fun checkPhone(phone: String) {
        if (Strings.isNullOrEmpty(phone)) {
            mView.phoneError("手机号为空,可能会影响你的账户找回喲！！！")
        }
    }

    private fun checkPasswordLevel(password: String): Int {
        if (Strings.isNullOrEmpty(password)) {
            mView.passwordError("密码不能为空")
            return -1
        }
        return CheckStrength.checkPasswordStrength(password)
    }


}