package ruolan.com.password.utils

import android.os.Handler
import android.os.HandlerThread

class DbWorkThread(threadName:String):HandlerThread(threadName) {


    private lateinit var mWorkerHandler: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        mWorkerHandler = Handler(looper)
    }

    /**
     * 执行耗时操作
     */
    fun execute(task:Runnable){
        mWorkerHandler.post(task)
    }

}