package ruolan.com.password.ui.activity

import android.os.Bundle
import org.jetbrains.anko.toast
import ruolan.com.password.R
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
    }


    override fun onEditFailure() {

    }

    override fun onEditSucc() {
        toast("成功的回调")
//        Log.d("ruolan","成功了")
    }
}
