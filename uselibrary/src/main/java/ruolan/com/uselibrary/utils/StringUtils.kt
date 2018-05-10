package ruolan.com.uselibrary.utils

object StringUtils {

    private val SIZE_TABLE = intArrayOf(9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE)

    /**
     * 计算一个整数的大小
     *
     * @param x
     * @return
     */
    fun sizeOfInt(x: Int): Int {
        var i = 0
        while (true) {
            if (x <= SIZE_TABLE[i]) {
                return i + 1
            }
            i++
        }
    }

    /**
     * 判断字符串的每个字符是否相等
     *
     * @param str
     * @return
     */
    fun isCharEqual(str: String): Boolean {
        return str.replace(str[0], ' ').trim { it <= ' ' }.length == 0
    }

    /**
     * 确定字符串是否为数字
     *
     * @param str
     * @return
     */
    fun isNumeric(str: String): Boolean {
        var i = str.length
        while (--i >= 0) {
            if (!Character.isDigit(str[i])) {
                return false
            }
        }
        return true
    }

    /**
     * 判断字符串是否为空格、空(“)”或null。
     *
     * @param str
     * @return
     */
    fun equalsNull(str: String?): Boolean {
        val strLen: Int = 0
        if (str == null || str.length == 0 || str.equals("null", ignoreCase = true)) {
            return true
        }
        for (i in 0 until strLen) {
            if (Character.isWhitespace(str[i]) == false) {
                return false
            }
        }
        return true
    }

}
