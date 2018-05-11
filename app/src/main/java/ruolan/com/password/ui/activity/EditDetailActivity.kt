package ruolan.com.password.ui.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_detail_layout.*
import org.jetbrains.anko.toast
import ruolan.com.password.R
import ruolan.com.password.data.model.AccountModel
import ruolan.com.password.inject.component.DaggerEditComponent
import ruolan.com.password.inject.module.EditModule
import ruolan.com.password.mvp.presenter.EditDetailPresenter
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.uselibrary.ui.activity.BaseMvpActivity

class EditDetailActivity : BaseMvpActivity<EditDetailPresenter>(), EditDetailView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_detail_layout)

    }


    override fun initComponent() {
        DaggerEditComponent.builder()
                .editModule(EditModule())
                .activityComponent(activityComponent)
                .build()
                .inject(this)

        mPresenter.mView = this

    }

    override fun initView() {

    }

    override fun initData() {
        var acount = edit_account.text.toString().trim()
        var phone = edit_phone.text.toString().trim()
        var password = edit_phone.text.toString().trim()
        var type = edit_type.text.toString().trim()

        var accout = AccountModel(acount, password, phone, type, System.currentTimeMillis(), 0)

        mPresenter.onEditDetail(accout)

    }


    override fun onEditFailure() {

    }

    override fun onEditSucc() {

    }
}
