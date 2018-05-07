package ruolan.com.password.inject.module

import dagger.Module
import dagger.Provides
import ruolan.com.password.service.EditService


@Module
class EditModule{

    @Provides
    fun providesEditService(service: EditService):EditService{
        return service
    }

}