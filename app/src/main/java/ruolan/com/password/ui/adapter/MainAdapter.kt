package ruolan.com.password.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.account_item_layout.view.*
import ruolan.com.password.R
import ruolan.com.password.data.Account
import ruolan.com.password.data.model.AccountModel
import ruolan.com.uselibrary.common.BaseRecyclerViewAdapter

class MainAdapter(context: Context) : BaseRecyclerViewAdapter<Account, MainAdapter.MainHolder>(context) {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.account_item_layout,
                        parent,
                        false)
        return MainHolder(view)

    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        var model = mDatas[position]
        //绑定的app 名字
        holder.itemView.tv_type?.text=model.accountType
        //绑定的手机号码
        holder.itemView.tv_phone?.text=model.bindPhone
        //绑定的账号名称
        holder.itemView.tv_account?.text = model.accountName
        //密码级别
        holder.itemView.rb_star?.rating = model.accountStars.toFloat()


    }


    class MainHolder(view: View) : RecyclerView.ViewHolder(view)

}