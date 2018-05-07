package ruolan.com.uselibrary.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor(){

    private val activityStack:Stack<Activity> = Stack()

    /*单利实现*/
    companion object {
        val instance : AppManager by lazy { AppManager() }
    }

    /**
     * 压栈
     */
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /**
     * 出栈
     */
    fun finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 当前的activity
     */
    fun currentActivity():Activity{
        return activityStack.lastElement()
    }

    fun clearActivity(){
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }


    fun exitActivity(context:Context){
        clearActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }






}