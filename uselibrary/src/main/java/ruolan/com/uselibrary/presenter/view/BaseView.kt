package ruolan.com.uselibrary.presenter.view

interface BaseView{

    fun showLoading()

    fun dismissLoading()

    fun onError(string: String)

    fun onError(str:Int)

}