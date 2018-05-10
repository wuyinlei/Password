package ruolan.com.password.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import ruolan.com.password.ui.activity.EditDetailActivity
import ruolan.com.uselibrary.common.BaseConstants
import ruolan.com.uselibrary.swipeback.BaseSwipeBackActivity

open class EnterClass{

    companion object {

        @SuppressLint("RestrictedApi")
/*跳转到下一个界面*/
        fun enterSecondActivity(context: Context){
            var intent = Intent(context,EditDetailActivity::class.java)
            (context as BaseSwipeBackActivity).startActivityForResult(intent,BaseConstants.EDIT_REQUEST_CODE,null)
        }

    }

}
