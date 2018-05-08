package ruolan.com.uselibrary.swipeback

import android.os.Bundle
import com.trello.rxlifecycle.components.support.RxAppCompatActivity


/**
 * Created by sll on 2015/9/10 0010.
 */
abstract class BaseSwipeBackActivity : RxAppCompatActivity(), SwipeBackActivityBase {

    private var mHelper: SwipeBackActivityHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHelper = SwipeBackActivityHelper(this)
        mHelper!!.onActivityCreate()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mHelper!!.onPostCreate()
    }

//    override fun findViewById(id: Int): View? {
//        val v = super.findViewById<View>(id)
//        return if (v == null && mHelper != null) mHelper!!.findViewById(id) else v
//    }

    override fun getSwipeBackLayout(): SwipeBackLayout {
        return mHelper!!.swipeBackLayout!!
    }

    override fun setSwipeBackEnable(enable: Boolean) {
        swipeBackLayout.setEnableGesture(enable)
    }

    override fun scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this)
        swipeBackLayout.scrollToFinishActivity()
    }

    override fun finish() {
        super.finish()
    }


    override fun onResume() {
        super.onResume()
        // TODO: 2017/6/8   在这里可以定义滑动返回的方向
        // int mode = SettingPrefUtil.getSwipeBackEdgeMode(this);
        /* SwipeBackLayout mSwipeBackLayout = mHelper.getSwipeBackLayout();
        switch (mode) {
            case 0:
                mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
                break;
            case 1:
                mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_RIGHT);
                break;
            case 2:
                mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_BOTTOM);
                break;
            case 3:
                mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
                break;
        }*/
    }
}
