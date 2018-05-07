package ruolan.com.uselibrary.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>
(var context: Context) : Adapter<VH>() {

    var mItemClickListener: OnItemClickListener<T>? = null

    var mDatas: MutableList<T> = mutableListOf()


    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (mItemClickListener != null) {
                mItemClickListener!!.onItemClick(mDatas[position], position)
            }
        }
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mItemClickListener = listener
    }
}