/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ruolan.com.uselibrary.swipeback

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View

import ruolan.com.uselibrary.R


/**
 * @author Yrom
 */
class SwipeBackActivityHelper(private val mActivity: Activity) {

    var swipeBackLayout: SwipeBackLayout? = null
        private set

    fun onActivityCreate() {
        mActivity.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mActivity.window.decorView.setBackgroundDrawable(null)
        swipeBackLayout = LayoutInflater.from(mActivity).inflate(R.layout.swipeback_layout, null) as SwipeBackLayout
        swipeBackLayout!!.addSwipeListener(object : SwipeBackLayout.SwipeListener {
            override fun onScrollStateChange(state: Int, scrollPercent: Float) {}

            override fun onEdgeTouch(edgeFlag: Int) {
                Utils.convertActivityToTranslucent(mActivity)
            }

            override fun onScrollOverThreshold() {

            }
        })
    }

    fun onPostCreate() {
        swipeBackLayout!!.attachToActivity(mActivity)
    }

    fun findViewById(id: Int): View? {
        return if (swipeBackLayout != null) {
            swipeBackLayout!!.findViewById(id)
        } else null
    }
}
