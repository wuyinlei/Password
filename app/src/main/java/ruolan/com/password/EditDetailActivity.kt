package ruolan.com.password

import android.os.Bundle
import org.jetbrains.anko.toast
import ruolan.com.password.model.PasswordModel
import ruolan.com.password.mvp.presenter.EditDetailPresenter
import ruolan.com.password.mvp.view.EditDetailView
import ruolan.com.uselibrary.ui.activity.BaseMvpActivity
import java.util.*

class EditDetailActivity : BaseMvpActivity<EditDetailPresenter>(),EditDetailView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_detail_layout)

        mPresenter.mView = this

        val model = PasswordModel("123","hello",Date())

        mPresenter.onEditDetail(model)
    }

    override fun onEditFailure() {

    }

    override fun onEditSucc() {
        toast("成功的回调")
//        Log.d("ruolan","成功了")
    }
}
