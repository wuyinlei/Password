package ruolan.com.password.service

import android.os.Handler
import ruolan.com.password.data.AccountDatabase
import ruolan.com.password.data.model.AccountModel
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.password.utils.DbWorkThread

interface EditService {

    fun saveToLocal(accountModel: AccountModel,
                    mView: EditDetailView,
                    dbWorkThread: DbWorkThread,
                    accountDatabase: AccountDatabase,
                    mUiHandler: Handler)

    fun clear()

}