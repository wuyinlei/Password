package ruolan.com.password.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import ruolan.com.password.data.model.BaseEntity

@Entity(tableName = "account")
data class Account(@PrimaryKey(autoGenerate = true) var id: Long?,
                   @ColumnInfo(name = "account_name") var accountName: String,
                   @ColumnInfo(name = "accountPassword") var accountPassword: String,
                   @ColumnInfo(name = "updateTime") var updateTime: Long,
                   @ColumnInfo(name = "accountType") var accountType: String,
                   @ColumnInfo(name = "starts") var accountStars: Int,
                   @ColumnInfo(name = "bindPhone") var bindPhone: String
) : BaseEntity()