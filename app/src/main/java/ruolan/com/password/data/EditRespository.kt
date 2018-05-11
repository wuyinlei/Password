package ruolan.com.password.data

import android.os.Handler
import ruolan.com.password.data.model.AccountModel
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.password.utils.DbWorkThread
import ruolan.com.uselibrary.common.BaseApplication
import javax.inject.Inject

class EditRespository @Inject constructor() {


    fun saveToLocal(model: AccountModel, mView: EditDetailView, dbWorkThread: DbWorkThread, accountDatabase: AccountDatabase, uiHandler: Handler) {
        val task = Runnable {

            var account = Account()
            account.accountName = model.account
            account.accountPassword = model.password
            account.accountStars = model.stars
            account.accountType = model.type
            account.updateTime = model.date
            account.bindPhone = model.phone

            val accountData =
                    accountDatabase.accountDao().insertAccount(account)
            uiHandler.post({
                mView.onEditBack(true)
            })
        }

        dbWorkThread?.execute(task)

    }



}