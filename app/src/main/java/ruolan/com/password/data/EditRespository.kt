package ruolan.com.password.data

import ruolan.com.password.data.model.AccountModel
import javax.inject.Inject

class EditRespository @Inject constructor() {

    fun submitPassword(username: String, password: String, phoneNum: String) {

        //执行网络请求或者本地数据存储逻辑

    }

    fun saveToLocal(model: AccountModel) {


    }

}