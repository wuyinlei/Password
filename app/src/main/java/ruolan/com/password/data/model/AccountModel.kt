package ruolan.com.password.data.model


class AccountModel(var account: String,
                   var password: String,
                   var phone: String,
                   var type: String,
                   var date: Long,
                   var stars: Int) : BaseEntity()