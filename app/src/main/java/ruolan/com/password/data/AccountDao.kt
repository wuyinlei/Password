package ruolan.com.password.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE


@Dao
interface AccountDao {

    /**
     * 查询所有的账户
     */
    @Query("SELECT * from account")
    fun getAllAccounts():MutableList<Account>

    /**
     * 添加账户
     */
    @Insert(onConflict = REPLACE)
    fun insertAccount(account: Account):Int


    /**
     * 更新某个账户
     */
    @Update
    fun updateAccount(account: Account):Int


    /**
     * 删除某个账户
     */
    @Delete
    fun deleteAccunt(account:Account):Int


    /**
     * 删除多个账户
     */
    @Delete
    fun deleteAccounts(account: MutableList<Account>)


}