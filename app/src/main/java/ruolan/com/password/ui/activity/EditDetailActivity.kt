package ruolan.com.password.ui.activity

import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_edit_detail_layout.*
import org.jetbrains.anko.toast
import ruolan.com.password.R
import ruolan.com.password.data.AccountDatabase
import ruolan.com.password.data.model.AccountModel
import ruolan.com.password.inject.component.DaggerEditComponent
import ruolan.com.password.inject.module.EditModule
import ruolan.com.password.mvp.presenter.EditDetailPresenter
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.password.utils.DbWorkThread
import ruolan.com.uselibrary.ui.activity.BaseMvpActivity

class EditDetailActivity : BaseMvpActivity<EditDetailPresenter>(), EditDetailView {

    private var mDbWorkerThread: DbWorkThread? = null
    private var accountDatabase: AccountDatabase? = null
    private val mUiHandler = Handler()

    override fun onEditBack(boolean: Boolean) {
        if (boolean) {
            toast("保存成功")
        }
    }

    override fun passwordError(string: String) {

    }

    override fun accountError(string: String) {

    }

    override fun phoneError(string: String) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_detail_layout)
        btn_save.setOnClickListener({
            saveToLocal()
        })
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
        mDbWorkerThread = DbWorkThread("saveToLocal")
        mDbWorkerThread!!.start()
        accountDatabase = AccountDatabase.getInstance(this)
    }

    private fun saveToLocal() {
        var accountName = edit_account.text.toString().trim()
        var phone = edit_phone.text.toString().trim()
        var password = edit_phone.text.toString().trim()
        var type = edit_type.text.toString().trim()

        var account = AccountModel(accountName, password, phone, type, System.currentTimeMillis(), 0)

        mPresenter.onEditDetail(account, mDbWorkerThread!!, accountDatabase!!, mUiHandler)
    }

    override fun initData() {


    }

    override fun onDestroy() {
        super.onDestroy()
        mDbWorkerThread?.quit()
        AccountDatabase.destoryInstance()
//        mPresenter.clear()
    }


}
