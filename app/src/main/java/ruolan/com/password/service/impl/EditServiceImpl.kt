package ruolan.com.password.service.impl

import android.os.Handler
import ruolan.com.password.data.AccountDatabase
import ruolan.com.password.data.EditRespository
import ruolan.com.password.data.model.AccountModel
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.password.service.EditService
import ruolan.com.password.utils.DbWorkThread
import javax.inject.Inject

class EditServiceImpl @Inject constructor() : EditService {


    @Inject
    lateinit var respository: EditRespository


    override fun saveToLocal(model: AccountModel, mView: EditDetailView, dbWorkThread: DbWorkThread, accountDatabase: AccountDatabase,uiHandler: Handler) {

        respository.saveToLocal(model, mView,dbWorkThread,accountDatabase,uiHandler)

    }

    override fun clear() {

    }


}