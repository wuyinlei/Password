package ruolan.com.password.utils

import android.content.Context
import org.jetbrains.anko.startActivity
import ruolan.com.password.EditDetailActivity

open class EnterClass{

    companion object {

        /*跳转到下一个界面*/
        fun enterSecondActivity(context: Context){
            context.startActivity<EditDetailActivity>()
        }

    }

}
