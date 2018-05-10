package ruolan.com.password.data.model


class AccountModel(var password: String,
                   var account: String,
                   var date: Long,
                   var phone: String,
                   var type: String,
                   var stars: Int) : BaseEntity()