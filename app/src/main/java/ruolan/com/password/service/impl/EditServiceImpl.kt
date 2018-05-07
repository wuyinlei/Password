package ruolan.com.password.service.impl

import ruolan.com.password.data.EditRespository
import ruolan.com.password.service.EditService
import javax.inject.Inject

class EditServiceImpl @Inject constructor() : EditService {

    @Inject
    lateinit var respository: EditRespository

    override fun submitPassword(username: String, password: String, phoneNum: String) {

        respository.submitPassword(username, password, phoneNum)


    }

}