package ruolan.com.uselibrary.ui.activity

import android.os.Bundle
import ruolan.com.uselibrary.common.AppManager
import ruolan.com.uselibrary.swipeback.BaseSwipeBackActivity

open class BaseActivity: BaseSwipeBackActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppManager.instance.addActivity(this)
    }


    override fun onDestroy() {
        super.onDestroy()

        AppManager.instance.finishActivity(this)
    }
}
