package ruolan.com.password.service

import ruolan.com.password.data.model.AccountModel

interface EditService {

    fun saveToLocal(accountModel: AccountModel)

}