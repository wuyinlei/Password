package ruolan.com.password.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast
import ruolan.com.password.R
import ruolan.com.password.data.Account
import ruolan.com.password.data.AccountDatabase
import ruolan.com.password.ui.adapter.MainAdapter
import ruolan.com.password.utils.DbWorkThread
import ruolan.com.password.utils.EnterClass
import ruolan.com.uselibrary.common.BaseConstants
import ruolan.com.uselibrary.ui.activity.BaseActivity

class MainActivity : BaseActivity() {


    private lateinit var mDbWorkerThread: DbWorkThread
    private var accountDatabase: AccountDatabase? = null
    private val mUiHandler = Handler()
    private lateinit var mMainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab_action.setOnClickListener {
            EnterClass.enterSecondActivity(this)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == BaseConstants.EDIT_REQUEST_CODE) {
            if (requestCode == BaseConstants.EDIT_RESULT_CODE) {
                var accout: Account = data?.getSerializableExtra(BaseConstants.EDIT_MODEL) as Account
                mMainAdapter.addData(accout)
            }
        }
    }

    override fun initData() {
        loaderLocalData()
    }

    override fun initView() {

    }

    private fun loaderLocalData() {
        val task = Runnable {
            val accountData =
                    accountDatabase?.accountDao()?.getAllAccounts()
            mUiHandler.post({
                if (accountData == null || accountData?.size == 0) {
                    toast("No data in cache..!!")
                } else {
                    bindDataWithUi(accountData)
                }
            })
        }
        mDbWorkerThread.execute(task)
    }

    private fun bindDataWithUi(account: MutableList<Account>?) {
        if (account?.size!! > 0) {
            mMainAdapter = MainAdapter(this)
            mMainAdapter.setData(account)
            main_recycler_view.layoutManager = LinearLayoutManager(this)
            main_recycler_view.adapter = mMainAdapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
