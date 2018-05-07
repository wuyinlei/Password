package ruolan.com.uselibrary.ext

import android.view.View

fun View.OnClickListener(method: () -> Unit): View {
    setOnClickListener { method() }
    return this
}

/**
 * visible  默认显示和隐藏(隐藏不占位置)
 */
fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * visible  是否显示
 *
 * isGone 是否需要GONE 不占位置
 */
fun View.setVisible(visible: Boolean, isGone: Boolean) {
    this.visibility = if (visible) View.VISIBLE else if (isGone) View.INVISIBLE else View.GONE
}