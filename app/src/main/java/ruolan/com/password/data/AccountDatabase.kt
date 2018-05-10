package ruolan.com.password.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Account::class), version = 1)
abstract class AccountDatabase : RoomDatabase() {


    abstract fun accountDao(): AccountDao

    companion object {
        private var INSTANCE: AccountDatabase? = null

        fun getInstance(context: Context): AccountDatabase? {

            if (INSTANCE == null) {
                synchronized(AccountDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AccountDatabase::class.java,
                            "account.db")
                            .build()
                }
            }

            return INSTANCE
        }

        fun destoryInstance(){
            INSTANCE = null
        }
    }

}